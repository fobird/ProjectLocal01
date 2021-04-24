package cn.itcast.service;

import cn.itcast.damain.User;

import java.util.List;

/**
 * @author superLin
 * @date 2021-04-23 16:04
 * 用户业务逻辑操作
 */
public interface UserService {

    public List<User> findAll();

    void addUser(User user);

}
