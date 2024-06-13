package com.example.json;

import com.example.avro.AvroConsumerSR;
import com.example.avro.weather.City;
import com.example.avro.weather.CityInfo;
import com.example.json.model.Key;
import com.example.json.model.Value;
import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig;
import io.confluent.kafka.serializers.KafkaJsonDeserializer;
import io.confluent.kafka.serializers.json.KafkaJsonSchemaDeserializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class JsonConsumer {
    private static final Logger LOG = LoggerFactory.getLogger(AvroConsumerSR.class);
    public static final String JSON_TOPIC = "json-topic";
    public static void main(String[] args) throws IOException {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "json.consumer.sr");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, KafkaJsonDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaJsonDeserializer.class);

        KafkaConsumer<Key, Value> consumer = new KafkaConsumer<>(props);

        Thread shutdownHook = new Thread(consumer::close);
        Runtime.getRuntime().addShutdownHook(shutdownHook);

        consumer.subscribe(Collections.singletonList(JSON_TOPIC));

        while(true) {
            ConsumerRecords<Key, Value> records = consumer.poll(Duration.ofMillis(100));

            for(ConsumerRecord<Key, Value> record : records) {
                LOG.info("Consumed message: \n" + record.key() + " : " + record.value());
            }
        }
    }
}
