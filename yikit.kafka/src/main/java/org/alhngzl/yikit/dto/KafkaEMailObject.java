package org.alhngzl.yikit.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class KafkaEMailObject {
    private String mailFrom;
    private String mailTo;
    private String mailSubject;
    private String mailBody;
}
