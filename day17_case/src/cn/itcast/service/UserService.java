package cn.itcast.service;

import cn.itcast.damain.PageBean;
import cn.itcast.damain.User;

import java.util.List;
import java.util.Map;

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

    /**
     * 根據用戶id查询數據庫裏对应得用戶信息
     *
     * @param id
     * @return
     */
    User findUserById(String id);

    /**
     * 修改用户信息
     * @param user 修改后的用戶信息
     */
    void updateUser(User user);

    /**
     * 批量删除用户信息
     * @param ids
     */
    void delUsers(String[] ids);

    /**
     * 返回page对象，实现分页功能
     * @param currentPage 当前页码
     * @param rows 每页展示行数
     * @param map
     * @return
     */
    PageBean<User> findUserByPage(String currentPage, String rows, Map<String, String[]> map);
}
