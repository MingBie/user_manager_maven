package com.user.manager.dao;

import com.user.manager.entity.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    User findByNameAndPassword(String name, String password);

    List<User> selectUserAll();

    void insertUser(User user);

    void deleteUserById(int id);

    User selectUserById(int id);

    void updateUserById(User user);

    List<User> findByPageUser(int start, int pageSize, Map<String, String[]> condition);

    int findTotalCount(Map<String, String[]> condition);
}
