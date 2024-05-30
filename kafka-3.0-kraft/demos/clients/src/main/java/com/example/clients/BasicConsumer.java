package com.example.clients;



import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.ListDeserializer;
import org.apache.kafka.common.serialization.Serdes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasicConsumer {

    private static final Logger log = LoggerFactory.getLogger(BasicConsumer.class);
    private static final String LISTS_TOPIC = "lists";

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9072,localhost:9082,localhost:9092");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, IntegerDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ListDeserializer.class);
        props.put(CommonClientConfigs.DEFAULT_LIST_VALUE_SERDE_TYPE_CLASS, ArrayList.class);
        props.put(CommonClientConfigs.DEFAULT_LIST_VALUE_SERDE_INNER_CLASS, Serdes.StringSerde.class);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "list.consumer");

        KafkaConsumer<Integer, List<String>> consumer = new KafkaConsumer<>(props);

        Thread haltedHook = new Thread(consumer::close);
        Runtime.getRuntime().addShutdownHook(haltedHook);

        consumer.subscribe(Collections.singletonList(LISTS_TOPIC));

        while (true) {
            ConsumerRecords<Integer, List<String>> records = consumer.poll(Duration.ofMillis(100));
            records.forEach(record -> log.info("{} : {}", record.key(), record.value()));
        }
    }
}
