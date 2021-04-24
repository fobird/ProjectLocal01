package cn.itcast.dao;

import cn.itcast.damain.User;

import java.util.List;

/**
 * @author superLin
 * @date 2021-04-23 16:07
 * 用戶跟數據庫交互
 */
public interface UserDao {
    /**
     * 查询返回所有得用户信息
     * @return
     */
    public List<User> findAll();

    /**
     * 增加用户信息
     * @param user 根据前台传回信息构建得用户user
     */
    void add(User user);

    /**
     * 根據用戶id刪除數據庫裏用戶信息
     * @param id
     */
    void delUserById(int id);

}
