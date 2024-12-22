package org.alhngzl.yikit.controller;

import org.alhngzl.yikit.dto.UserDTO;
import org.alhngzl.yikit.entity.User;
import org.alhngzl.yikit.request.RequestCreateUser;
import org.alhngzl.yikit.request.RequestListUser;
import org.alhngzl.yikit.response.ResponseCreateUser;
import org.alhngzl.yikit.response.ResponseListUser;
import org.alhngzl.yikit.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/listUser")
    public UserDTO getListUser(
            @RequestBody UserDTO userDTO
    ) {
        RequestListUser requestListUser = RequestListUser.builder()
                .user(User.builder()
                        .id(userDTO.getUserId())
                        .username(userDTO.getUserUsername())
                        .password(userDTO.getUserPassword())
                        .build())
                .build();
        ResponseListUser responseListUser = userService.listUser(requestListUser);
        userDTO.setUserList(responseListUser.getUserList());
        return userDTO;
    }

    @PutMapping("/createUser")
    public UserDTO putCreateUser(
            @RequestBody UserDTO userDTO
    ) {
        RequestCreateUser requestCreateUser = RequestCreateUser.builder()
                .user(User.builder()
                        .username(userDTO.getUserUsername())
                        .password(userDTO.getUserPassword())
                        .build())
                .build();
        ResponseCreateUser responseCreateUser = userService.createUser(requestCreateUser);
        userDTO.setUser(responseCreateUser.getUser());
        return userDTO;
    }
}
