import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class KafkaConsumerApp {

    public static void main(String []args){
        Properties consumerProps = new Properties();
        consumerProps.put("bootstrap.servers", "localhost:9092"); // Kafka broker addresses
        consumerProps.put("group.id", "my-consumer-group"); // Consumer group ID
        consumerProps.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        consumerProps.put("value.deserializer", "org.apache.kafka.common.serialization.LongDeserializer");
        consumerProps.put("auto.offset.reset", "earliest"); // Start reading from the beginning of the topic

        KafkaConsumer<String, Long> consumer = new KafkaConsumer<>(consumerProps);
        consumer.subscribe(Collections.singletonList("outputTopicStream"));

        while (true) {
            ConsumerRecords<String, Long> records = consumer.poll(Duration.ofMillis(100));
            for (ConsumerRecord<String, Long> record : records) {
                System.out.println("Received message: " + record.key()+"-->" +record.value());
            }
        }


    }
}
