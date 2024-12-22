package org.alhngzl.yikit.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.alhngzl.yikit.entity.User;

@Getter
@Setter
@Builder
public class ResponseCreateUserRest {
    private User user;
}