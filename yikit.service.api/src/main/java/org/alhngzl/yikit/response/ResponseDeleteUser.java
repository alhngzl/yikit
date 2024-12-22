package org.alhngzl.yikit.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.alhngzl.yikit.entity.User;

@Getter
@Setter
@Builder
public class ResponseDeleteUser {
    private User user;
}