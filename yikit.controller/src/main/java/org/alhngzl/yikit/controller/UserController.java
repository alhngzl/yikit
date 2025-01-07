package org.alhngzl.yikit.controller;

import org.alhngzl.yikit.dto.KafkaEMailObject;
import org.alhngzl.yikit.dto.RequestCreateUserRest;
import org.alhngzl.yikit.dto.RequestDeleteUserRest;
import org.alhngzl.yikit.dto.RequestListUserRest;
import org.alhngzl.yikit.dto.ResponseCreateUserRest;
import org.alhngzl.yikit.dto.ResponseDeleteUserRest;
import org.alhngzl.yikit.dto.ResponseListUserRest;
import org.alhngzl.yikit.entity.User;
import org.alhngzl.yikit.request.RequestCreateUser;
import org.alhngzl.yikit.request.RequestDeleteUser;
import org.alhngzl.yikit.request.RequestListUser;
import org.alhngzl.yikit.response.ResponseCreateUser;
import org.alhngzl.yikit.response.ResponseDeleteUser;
import org.alhngzl.yikit.response.ResponseListUser;
import org.alhngzl.yikit.service.KafkaProducerService;
import org.alhngzl.yikit.service.api.UserService;
import org.alhngzl.yikit.util.ConstantsUtil;
import org.alhngzl.yikit.util.KafkaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userController")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(
            UserService userService
    ) {
        this.userService = userService;
    }

    @PostMapping("/listUser")
    public ResponseListUserRest getListUser(
            @RequestBody RequestListUserRest requestListUserRest
    ) {
        RequestListUser requestListUser = RequestListUser.builder()
                .user(User.builder()
                        .id(requestListUserRest.getUserId())
                        .username(requestListUserRest.getUserUsername())
                        .email(requestListUserRest.getUserEmail())
                        .build())
                .build();
        ResponseListUser responseListUser = userService.listUser(requestListUser);

        return ResponseListUserRest.builder()
                .userList(responseListUser.getUserList())
                .build();
    }

    @PutMapping("/createUser")
    public ResponseCreateUserRest putCreateUser(
            @RequestBody RequestCreateUserRest requestCreateUserRest
    ) {
        RequestCreateUser requestCreateUser = RequestCreateUser.builder()
                .user(User.builder()
                        .username(requestCreateUserRest.getUserUsername())
                        .password(requestCreateUserRest.getUserPassword())
                        .email(requestCreateUserRest.getUserEmail())
                        .build())
                .build();
        ResponseCreateUser responseCreateUser = userService.createUser(requestCreateUser);

        return ResponseCreateUserRest.builder()
                .user(responseCreateUser.getUser())
                .build();
    }

    @DeleteMapping("/deleteUser")
    public ResponseDeleteUserRest deleteDeleteUser(
            @RequestBody RequestDeleteUserRest requestDeleteUserRest
    ) {
        RequestDeleteUser requestDeleteUser = RequestDeleteUser.builder()
                .user(User.builder()
                        .id(requestDeleteUserRest.getUserId())
                        .username(requestDeleteUserRest.getUserUsername())
                        .email(requestDeleteUserRest.getUserEmail())
                        .build())
                .build();
        ResponseDeleteUser responseDeleteUser = userService.deleteUser(requestDeleteUser);

        return ResponseDeleteUserRest.builder()
                .user(responseDeleteUser.getUser())
                .build();
    }
}
