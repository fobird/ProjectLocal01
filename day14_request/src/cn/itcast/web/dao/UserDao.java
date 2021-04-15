package cn.itcast.web.dao;

import cn.itcast.web.Bean.User;
import cn.itcast.web.utils.JDBCutils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author superLin
 * @date 2021-04-15 16:25
 */
public class UserDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCutils.getDataSource());

    public User login(User user) {
        try {
            String sql = "select * from user where username=? and password=?";
            return jdbcTemplate.queryForObject(sql,
                    new BeanPropertyRowMapper<>(User.class), user.getUsername(), user.getPassword());
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
