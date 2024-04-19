import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.Scanner;

public class kafkaProducerApp {
    public static void main(String []args){
        String inputTopic = "streams-input-topic";

        Properties producerProperties = new Properties();
        producerProperties.put("bootstrap.servers", "localhost:9092"); // Kafka broker addresses
        producerProperties.put("key.serializer", StringSerializer.class.getName());
        producerProperties.put("value.serializer", StringSerializer.class.getName());

        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(producerProperties);

        Scanner s  = new Scanner(System.in);
        int i = 0;
        while(i < 100) {
            String input = s.nextLine();
            ProducerRecord<String, String> record = new ProducerRecord<>(inputTopic,
                    input, input);
            producer.send(record);
        }
        producer.flush();
        producer.close();
    }
}
