package cn.itcast.dao.impl;

import cn.itcast.damain.User;
import cn.itcast.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author superLin
 * @date 2021-04-23 16:08
 */
public class UserDao implements cn.itcast.dao.UserDao {

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<User> findAll() {
        String sql = "select * from user";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
    }

    @Override
    public void add(User user) {
        String sql = "insert into user values(null,?,?,?,?,?,?,null,null)";
        jdbcTemplate.update(sql, user.getName(),
                user.getGender(),
                user.getAge(),
                user.getAddress(),
                user.getQq(),
                user.getEmail());
    }
}
