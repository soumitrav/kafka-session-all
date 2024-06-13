package com.example.json;

import com.example.avro.AvroProducer;
import com.example.avro.weather.City;
import com.example.avro.weather.CityInfo;
import com.example.json.model.Key;
import com.example.json.model.Value;
import com.fasterxml.jackson.databind.JsonSerializer;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import io.confluent.kafka.serializers.KafkaAvroSerializerConfig;
import io.confluent.kafka.serializers.KafkaJsonSerializer;
import io.confluent.kafka.serializers.json.KafkaJsonSchemaDeserializer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class JsonProducer {

    public static final String JSON_TOPIC = "json-topic";
    private static final Logger LOG = LoggerFactory.getLogger(AvroProducer.class);

    public static void main(String []args) throws InterruptedException {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9072,localhost:9082,localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, KafkaJsonSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaJsonSerializer.class);

        //props.put("batch.size", "10");
        // no matter what happens, write all pending messages
        // every 2 seconds
        //props.put("linger.ms", "2000");

        //props.put("acks", "1");

        //Idemotent Properties

        props.put("enable.idempotence", true);
        props.put("acks", "all");
        props.put("retries", 10);
        props.put("max.in.flight.requests.per.connection", 5);
        props.put(KafkaAvroSerializerConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");
        KafkaProducer<Key, Value> producer = new KafkaProducer<>(props);

        int i = 0;

        while(true) {
            Key key = new Key();
            key.setId(Integer.toString(i));

            Value value = new Value();
            value.setKey(key);
            value.setEmployeeName("some-name"+i);
            value.setLocation("location-"+i);
            LOG.info("Sending to Kafka on the " + JSON_TOPIC + " topic the following message: \n" + key + " : " + value);
            producer.send(new ProducerRecord<>(JSON_TOPIC,key, value));
            Thread.sleep(1000);
            i++;
        }
    }
}
