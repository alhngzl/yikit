package org.alhngzl.yikit.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RequestCreateUserRest {
    private String userUsername;
    private String userPassword;
}