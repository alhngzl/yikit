package org.alhngzl.yikit.util;

public class KafkaUtil {
    private KafkaUtil() {throw new IllegalStateException(KafkaUtil.class.getName());}

    public static class Topics{
        private Topics() {throw new IllegalStateException(Topics.class.getName());}

        public static final String TOPIC_EMAIL = "topic-email";
    }

    public static String createSendLog(String topicName, String object){
        return KafkaMessage.SEND_TO_KAFKA
                + ConstantsUtil.Char.COLON
                + topicName
                + ConstantsUtil.Char.COLON
                + object;
    }
}
