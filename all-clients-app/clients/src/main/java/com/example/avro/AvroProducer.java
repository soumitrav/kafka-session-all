package com.example.avro;


import com.example.avro.weather.City;
import com.example.avro.weather.CityInfo;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import io.confluent.kafka.serializers.KafkaAvroSerializerConfig;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AvroProducer {
    private static final Logger LOG = LoggerFactory.getLogger(AvroProducer.class);
    private static final String CITY_INFO_TOPIC = "city-info-topic-avro";

    public static void main(String[] args) throws Exception {

        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9072,localhost:9082,localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);

        //props.put("batch.size", "10");
        // no matter what happens, write all pending messages
        // every 2 seconds
        //props.put("linger.ms", "2000");

        //props.put("acks", "1");

        //Idemotent Properties
        final String CITY = "BLR";

        props.put("enable.idempotence", true);
        props.put("acks", "all");
        props.put("retries", 10);
        props.put("max.in.flight.requests.per.connection", 5);
        props.put(KafkaAvroSerializerConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");
        KafkaProducer<City, CityInfo> producer = new KafkaProducer<>(props);

        Thread shutdownHook = new Thread(producer::close);
        Runtime.getRuntime().addShutdownHook(shutdownHook);
        while(true) {
            City key = City.newBuilder()
                    .setCity(CITY)
                    .build();

            CityInfo citiInfo = CityInfo.newBuilder().setCity(CITY).setMaxTempp(39).
                    setIsMetro(false).setPopulation("10M").setMinTempp(10).setTransport("metro,bus,train").build();

            LOG.info("Sending to Kafka on the " + CITY_INFO_TOPIC + " topic the following message: \n" + CITY + " : " + citiInfo);

            ProducerRecord<City, CityInfo> producerRecord =
                    new ProducerRecord<>(CITY_INFO_TOPIC, key, citiInfo);
            producer.send(producerRecord);
            Thread.sleep(1000);
        }
    }

}
