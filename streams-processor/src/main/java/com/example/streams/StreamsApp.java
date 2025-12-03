package com.example.streams;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.TimeWindows;

import java.time.Duration;

public class StreamsApp {
    public static void main(String[] args) {
        var props = new java.util.Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "payment-streams");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:29092");
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());

        StreamsBuilder builder = new StreamsBuilder();
        KStream<String, String> payments = builder.stream("dbserver.public.payment");

//        payments.groupByKey()
//                .windowedBy(TimeWindows.of(Duration.ofMinutes(1)))
//                .count()
//                .toStream()
//                .peek((k,v) -> System.out.println("Processed " + v + " payments in window: " + k))
//                .to("payments-summary");

        payments.to("payments-summary");
        KafkaStreams streams = new KafkaStreams(builder.build(), props);
        streams.start();
    }
}
