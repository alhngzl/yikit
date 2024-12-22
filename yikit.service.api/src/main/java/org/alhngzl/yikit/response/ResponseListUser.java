package org.alhngzl.yikit.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.alhngzl.yikit.entity.User;

import java.util.List;

@Getter
@Setter
@Builder
public class ResponseListUser {
    private List<User> userList;
}