package cn.itcast.web.test;

import cn.itcast.web.Bean.User;
import cn.itcast.web.dao.UserDao;
import org.junit.Test;

/**
 * @author superLin
 * @date 2021-04-15 17:00
 */
public class testLogin {
    @Test
    public void test() {
        User user = new User();
        user.setUsername("superbaby");
        user.setPassword("1231111");
        UserDao userDao = new UserDao();
        User loginu = userDao.login(user);
        System.out.println("loginu = " + loginu);
    }
}
