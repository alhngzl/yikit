package org.alhngzl.yikit.service.api;

import org.alhngzl.yikit.request.RequestCreateUser;
import org.alhngzl.yikit.request.RequestDeleteUser;
import org.alhngzl.yikit.request.RequestListUser;
import org.alhngzl.yikit.response.ResponseCreateUser;
import org.alhngzl.yikit.response.ResponseDeleteUser;
import org.alhngzl.yikit.response.ResponseListUser;

public interface UserService {
    ResponseCreateUser createUser(RequestCreateUser requestCreateUser);
    ResponseDeleteUser deleteUser(RequestDeleteUser requestDeleteUser);
    ResponseListUser listUser(RequestListUser requestListUser);
}