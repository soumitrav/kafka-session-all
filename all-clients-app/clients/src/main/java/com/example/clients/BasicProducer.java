package com.example.clients;


import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.ListSerializer;
import org.apache.kafka.common.serialization.Serdes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasicProducer {

    private static final Logger log = LoggerFactory.getLogger(BasicProducer.class);
    private static final String LISTS_TOPIC = "lists_test";

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9072,localhost:9082,localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ListSerializer.class);
        props.put(CommonClientConfigs.DEFAULT_LIST_VALUE_SERDE_TYPE_CLASS, ArrayList.class);
        props.put(CommonClientConfigs.DEFAULT_LIST_VALUE_SERDE_INNER_CLASS, Serdes.StringSerde.class);

        props.put("batch.size", "10");
        // no matter what happens, write all pending messages
        // every 2 seconds
        props.put("linger.ms", "2000");

        props.put("acks", "1");

        KafkaProducer<Integer, List<String>> producer = new KafkaProducer<>(props);

        Thread shutdownHook = new Thread(producer::close);
        Runtime.getRuntime().addShutdownHook(shutdownHook);

        int key = 0;
        while(true) {
            List<String> value = generateList(key);

            ProducerRecord<Integer, List<String>> producerRecord = 
            new ProducerRecord<>(LISTS_TOPIC, key, value);

            log.info("Sending message {} : {}", key, value);
            producer.send(producerRecord);
            key++;
            Thread.sleep(1000);
        }
    }

    public static List<String> generateList(Integer i) {
        return IntStream.range(0, i)
        .skip(i > 10 ? i - 10 : 0)
        .mapToObj(obj -> String.valueOf(obj))
        .limit(10)
        .collect(Collectors.toList());
    }
}
