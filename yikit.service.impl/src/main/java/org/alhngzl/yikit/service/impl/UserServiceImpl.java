package org.alhngzl.yikit.service.impl;

import jakarta.persistence.EntityManager;
import org.alhngzl.yikit.entity.User;
import org.alhngzl.yikit.repository.UserRepository;
import org.alhngzl.yikit.request.RequestCreateUser;
import org.alhngzl.yikit.request.RequestDeleteUser;
import org.alhngzl.yikit.request.RequestListUser;
import org.alhngzl.yikit.response.ResponseCreateUser;
import org.alhngzl.yikit.response.ResponseDeleteUser;
import org.alhngzl.yikit.response.ResponseListUser;
import org.alhngzl.yikit.service.api.UserService;
import org.alhngzl.yikit.util.Util;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    EntityManager entityManager;
    UserRepository userRepository;

    public UserServiceImpl(EntityManager entityManager,
                           UserRepository userRepository){
        this.entityManager = entityManager;
        this.userRepository = userRepository;
    }

    @Override
    public ResponseCreateUser createUser(RequestCreateUser requestCreateUser) {
        User user = userRepository.save(requestCreateUser.getUser());
        return ResponseCreateUser
                .builder()
                .user(user)
                .build();
    }

    @Override
    public ResponseDeleteUser deleteUser(RequestDeleteUser requestDeleteUser) {
        if(Util.isNull(requestDeleteUser.getUser()))
            userRepository.deleteAll();
        else
            userRepository.delete(requestDeleteUser.getUser());

        return ResponseDeleteUser
                .builder()
                .user(requestDeleteUser.getUser())
                .build();
    }

    @Override
    public ResponseListUser listUser(RequestListUser requestListUser) {
        List<User> userList = userRepository.listUser(requestListUser.getUser());
        return ResponseListUser
                .builder()
                .userList(userList)
                .build();
    }
}