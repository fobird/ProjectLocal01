package cn.itcast.dao;

import cn.itcast.damain.User;

import java.util.List;

/**
 * @author superLin
 * @date 2021-04-23 16:07
 * 用戶跟數據庫交互
 */
public interface UserDao {
    public List<User> findAll();
}
