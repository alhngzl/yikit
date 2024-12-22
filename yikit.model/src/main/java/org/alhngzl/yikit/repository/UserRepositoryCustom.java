package org.alhngzl.yikit.repository;

import org.alhngzl.yikit.entity.User;

import java.util.List;

public interface UserRepositoryCustom {
    List<User> listUser(User user);
}