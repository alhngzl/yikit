package org.alhngzl.yikit.service.impl;

import jakarta.persistence.EntityManager;
import org.alhngzl.yikit.dto.KafkaEMailObject;
import org.alhngzl.yikit.entity.User;
import org.alhngzl.yikit.repository.UserRepository;
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
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    EntityManager entityManager;
    UserRepository userRepository;
    KafkaProducerService kafkaProducerService;

    public UserServiceImpl(EntityManager entityManager,
                           UserRepository userRepository,
                           KafkaProducerService kafkaProducerService){
        this.entityManager = entityManager;
        this.userRepository = userRepository;
        this.kafkaProducerService = kafkaProducerService;
    }

    @Override
    public ResponseCreateUser createUser(RequestCreateUser requestCreateUser) {
        User user = userRepository.save(requestCreateUser.getUser());

        KafkaEMailObject kafkaEMailObject = KafkaEMailObject.builder()
                .mailTo(ConstantsUtil.EmailDefinition.CreateUser.MAIL_TO)
                .mailFrom(ConstantsUtil.EmailDefinition.CreateUser.MAIL_FROM)
                .mailSubject(ConstantsUtil.EmailDefinition.CreateUser.MAIL_SUBJECT)
                .mailBody(ConstantsUtil.EmailDefinition.CreateUser.MAIL_BODY + user.toString())
                .build();
        kafkaProducerService.send(KafkaUtil.Topics.TOPIC_EMAIL, kafkaEMailObject);

        return ResponseCreateUser
                .builder()
                .user(user)
                .build();
    }

    @Override
    public ResponseDeleteUser deleteUser(RequestDeleteUser requestDeleteUser) {
        List<User> userList = userRepository.listUser(requestDeleteUser.getUser());
        userRepository.deleteAll(userList);

        KafkaEMailObject kafkaEMailObject = KafkaEMailObject.builder()
                .mailTo(ConstantsUtil.EmailDefinition.DeleteUser.MAIL_TO)
                .mailFrom(ConstantsUtil.EmailDefinition.DeleteUser.MAIL_FROM)
                .mailSubject(ConstantsUtil.EmailDefinition.DeleteUser.MAIL_SUBJECT)
                .mailBody(ConstantsUtil.EmailDefinition.DeleteUser.MAIL_BODY + userList.toString())
                .build();
        kafkaProducerService.send(KafkaUtil.Topics.TOPIC_EMAIL, kafkaEMailObject);

        return ResponseDeleteUser
                .builder()
                .user(requestDeleteUser.getUser())
                .build();
    }

    @Override
    public ResponseListUser listUser(RequestListUser requestListUser) {
        List<User> userList = userRepository.listUser(requestListUser.getUser());

        KafkaEMailObject kafkaEMailObject = KafkaEMailObject.builder()
                .mailTo(ConstantsUtil.EmailDefinition.ListUser.MAIL_TO)
                .mailFrom(ConstantsUtil.EmailDefinition.ListUser.MAIL_FROM)
                .mailSubject(ConstantsUtil.EmailDefinition.ListUser.MAIL_SUBJECT)
                .mailBody(ConstantsUtil.EmailDefinition.ListUser.MAIL_BODY + userList.toString())
                .build();
        kafkaProducerService.send(KafkaUtil.Topics.TOPIC_EMAIL, kafkaEMailObject);

        return ResponseListUser
                .builder()
                .userList(userList)
                .build();
    }
}