package cn.itcast.service;

import cn.itcast.damain.User;

import java.util.List;

/**
 * @author superLin
 * @date 2021-04-23 16:04
 * 用户业务逻辑操作
 */
public interface UserService {

    /**
     * 查詢返回所有用户信息
     *
     * @return
     */
    public List<User> findAll();

    /**
     * 增加用户信息
     *
     * @param user 根据前台传回信息构建得用户user
     */
    void addUser(User user);

    /**
     * 根據用戶id刪除數據庫裏用戶信息
     *
     * @param id
     */
    void delUserById(String id);
}
