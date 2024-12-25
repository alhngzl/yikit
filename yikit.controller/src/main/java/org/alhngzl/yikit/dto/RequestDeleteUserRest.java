package org.alhngzl.yikit.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RequestDeleteUserRest {
    private Long userId;
    private String userUsername;
    private String userEmail;
}