package cn.itcast.service.impl;

import cn.itcast.damain.User;
import cn.itcast.dao.LoginDao;
import cn.itcast.dao.impl.LoginDaoImpl;
import cn.itcast.service.LoginService;

/**
 * @author superLin
 * @date 2021-04-23 23:42
 */
public class LoginServiceImpl implements LoginService {
    private LoginDao loginDao=new LoginDaoImpl();

    @Override
    public User loginUser(User user) {
        return loginDao.loginUser(user);
    }
}
