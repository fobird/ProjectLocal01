package cn.itcast.service;

import cn.itcast.damain.User;

/**
 * @author superLin
 * @date 2021-04-23 23:41
 * 用户登陆
 */
public interface LoginService {
    /**
     * 用戶登錄 用户登陆功能，返回null登陆失败，返回！null登陆成功
     * @param user 根据前台信息创建热对象
     * @return
     */
    public User loginUser(User user);
}
