package org.alhngzl.yikit.service;

import org.alhngzl.yikit.util.ConstantsUtil;
import org.alhngzl.yikit.util.KafkaUtil;
import org.alhngzl.yikit.util.LoggerUtil;
import org.alhngzl.yikit.util.Util;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducerService {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String topic, Object object){
        String objectJson = Util.objectToJson(object).replace(ConstantsUtil.Char.ASCI_EQUALS, ConstantsUtil.Char.EQUAL);
        this.kafkaTemplate.send(topic, objectJson);
        LoggerUtil.printInfo(KafkaUtil.createSendLog(topic, objectJson));
    }
}
