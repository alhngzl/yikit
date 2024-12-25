package org.alhngzl.yikit.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.alhngzl.yikit.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> listUser(User user) {
        String hql = "SELECT u FROM User u " +
                "WHERE 1 = 1 " +
                "and u.id       = COALESCE(:userId, u.id) " +
                "and u.username = COALESCE(:userName, u.username) " +
                "and u.password = COALESCE(:password, u.password) " +
                "and u.email    = COALESCE(:email, u.email) ";

        TypedQuery<User> query = entityManager.createQuery(hql, User.class);
        query.setParameter("userId",   user.getId());
        query.setParameter("userName", user.getUsername());
        query.setParameter("password", user.getPassword());
        query.setParameter("email",    user.getEmail());
        return query.getResultList();
    }
}
