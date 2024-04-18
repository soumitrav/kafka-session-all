import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Produced;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Properties;

public class KafkaStreamApp {
    public static void main(String []args) throws IOException, InterruptedException {
        String inputTopic = "inputTopic_Stream"; // Name of your Kafka topic
        Properties streamsConfiguration = new Properties();
        streamsConfiguration.put(StreamsConfig.APPLICATION_ID_CONFIG, "wordcount-live-test");
        streamsConfiguration.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092"); // URL to your Kafka instance
        streamsConfiguration.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        streamsConfiguration.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        streamsConfiguration.put(StreamsConfig.STATE_DIR_CONFIG, Files.createTempDirectory("kafka-streams").toAbsolutePath().toString());

        StreamsBuilder builder = new StreamsBuilder();
        KStream<String, String> inputStream = builder.stream(inputTopic);

        KTable<String, Long> wordCounts = inputStream
                .flatMapValues(value -> Arrays.asList(value.toLowerCase().split("\\W+")))
                .groupBy((key, word) -> word)
                .count();
        //KTable<String, String> stringStringKTable = inputStream.filter((key, val) -> key.length() > 5).toTable();

        //wordCounts.toStream().foreach((word, count) -> System.out.println("Word: " + word + ", Count: " + count));

        String outputTopic = "outputTopicStream";
        wordCounts.toStream()
                .to(outputTopic, Produced.with(Serdes.String(), Serdes.Long()));

        String outputTopicSelected = "outputTopicStreamSelected";
        //stringStringKTable.toStream()
        //        .to(outputTopicSelected, Produced.with(Serdes.String(), Serdes.String()));

        Topology topology = builder.build();
        KafkaStreams streams = new KafkaStreams(topology, streamsConfiguration);
        streams.start();

        Thread.sleep(300000*10);
        streams.close();
    }
}
