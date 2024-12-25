package org.alhngzl.yikit.util;

public class KafkaMessage {
    private KafkaMessage() {throw new IllegalStateException(KafkaMessage.class.getName());}

    public static final String SEND_TO_KAFKA = "Messsage send to Kafka";
}
