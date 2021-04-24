package cn.itcast.service.impl;

import cn.itcast.damain.User;
import cn.itcast.dao.UserDao;

import java.util.List;

/**
 * @author superLin
 * @date 2021-04-23 16:07
 */
public class UserService implements cn.itcast.service.UserService {
    private UserDao userDao = new cn.itcast.dao.impl.UserDao();

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void addUser(User user) {
        userDao.add(user);
    }
}
