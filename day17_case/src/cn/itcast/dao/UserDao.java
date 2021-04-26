package cn.itcast.dao;

import cn.itcast.damain.User;

import java.util.List;
import java.util.Map;

/**
 * @author superLin
 * @date 2021-04-23 16:07
 * 用戶跟數據庫交互
 */
public interface UserDao {
    /**
     * 查询返回所有得用户信息
     *
     * @return
     */
    public List<User> findAll();

    /**
     * 增加用户信息
     *
     * @param user 根据前台传回信息构建得用户user
     */
    void add(User user);

    /**
     * 根據用戶id刪除數據庫裏用戶信息
     *
     * @param id
     */
    void delUserById(int id);

    /**
     * 根據用戶id查询數據庫裏对应得用戶信息
     *
     * @param id
     * @return
     */
    User findUserById(int id);

    /**
     * 修改用户信息
     * @param user
     */
    void updateUser(User user);

    /**
     * 計算数据库里用户总数
     * @return
     * @param map
     */
    int findTotalCount(Map<String, String[]> map);

    /**
     * 返回页面需要的user集合，List形式
     * @param currentPage
     * @param rows
     * @param map
     * @return
     */
    List<User> findUserPage(int currentPage, int rows, Map<String, String[]> map);
}
