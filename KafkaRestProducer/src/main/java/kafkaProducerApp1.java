import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class kafkaProducerApp1 {
    public static void main(String []args){
        Properties producerProperties = new Properties();
        producerProperties.put("bootstrap.servers", "localhost:9092"); // Kafka broker addresses
        producerProperties.put("key.serializer", StringSerializer.class.getName());
        producerProperties.put("value.serializer", StringSerializer.class.getName());

        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(producerProperties);

        for(int i=0; i<=100; i++) {
            ProducerRecord<String, String> record = new ProducerRecord<>("inputTopic-1",
                    "text"+i, "my id "+i);
            producer.send(record);
        }
        producer.flush();
        producer.close();


    }
}
