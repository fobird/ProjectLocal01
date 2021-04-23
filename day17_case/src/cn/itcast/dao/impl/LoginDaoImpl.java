package cn.itcast.dao.impl;

import cn.itcast.damain.User;
import cn.itcast.dao.LoginDao;
import cn.itcast.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author superLin
 * @date 2021-04-23 23:43
 */
public class LoginDaoImpl implements LoginDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public User loginUser(User user) {
        String sql = "select * from user where username=? and password=?";
        User loginUser = null;
        try {
            loginUser = jdbcTemplate.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    user.getUsername(),
                    user.getPassword());
            return loginUser;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
