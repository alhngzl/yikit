package org.alhngzl.yikit.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.alhngzl.yikit.entity.User;

@Getter
@Setter
@Builder
public class RequestCreateUser {
    private User user;
}
