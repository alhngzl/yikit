package org.alhngzl.yikit.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.alhngzl.yikit.entity.User;

import java.util.List;

@Getter
@Setter
@Builder
public class UserDTO {
    private Long userId;
    private String userUsername;
    private String userPassword;
    private List<User> userList;
    private User user;
}
