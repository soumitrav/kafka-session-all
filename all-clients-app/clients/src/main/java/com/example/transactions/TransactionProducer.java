package com.example.transactions;


import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TransactionProducer {

    private static final Logger log = LoggerFactory.getLogger(TransactionProducer.class);
    private static final String LISTS_TOPIC = "demo_transaction";

    public static void main(String[] args) throws Exception {

        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9072,localhost:9082,localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

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
        props.put("transactional.id", "my-transactional-id");

        KafkaProducer<String, String> producer = new KafkaProducer<>(props);

        producer.initTransactions();

        Thread shutdownHook = new Thread(producer::close);
        Runtime.getRuntime().addShutdownHook(shutdownHook);

        int key = 0;
        List<String> value = new ArrayList<>();

        while(true) {
            //List<String> value = new ArrayList<>();//generateList(key);
            log.info("Sending message {} : {}", key, key);
            ProducerRecord<String, String> producerRecord =
                    new ProducerRecord<>(LISTS_TOPIC, Integer.toString(key), Integer.toString(key));

            producer.beginTransaction();

            producer.send(producerRecord);
            //logic to commit or abort transaction
            if(key%2 == 0) {
                producer.commitTransaction();
            } else {
                producer.abortTransaction();
            }
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
