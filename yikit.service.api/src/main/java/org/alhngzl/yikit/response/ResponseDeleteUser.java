package org.alhngzl.yikit.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.alhngzl.yikit.entity.User;

@Getter
@Setter
@Builder
@ToString
public class ResponseDeleteUser {
    private User user;
}