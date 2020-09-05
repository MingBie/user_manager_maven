package com.user.manager.service;

import com.user.manager.entity.User;
import com.user.manager.utils.LoginException;
import com.user.manager.utils.PageBean;

import java.util.List;
import java.util.Map;

public interface UserService {
    User login(User user) throws LoginException;

    List<User> findAll();

    void insertUser(User user);

    void deleteUserById(int id);

    User findUserById(int id);

    void updateUserById(User user);
    
    void deleteSelectUser(String[] ids);

    PageBean<User> findByPageUser(String currentPage, String pageSize, Map<String, String[]> condition);
}
