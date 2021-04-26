package cn.itcast.dao.impl;

import cn.itcast.damain.User;
import cn.itcast.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    @Override
    public void delUserById(int id) {
        String sql = "delete from user where id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public User findUserById(int id) {
        String sql = "select * from user where id=?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
    }

    @Override
    public void updateUser(User user) {
        String sql = "update user set name=?,gender=?,age=?,address=?,qq=?,email=? where id=? ";
        jdbcTemplate.update(sql, user.getName(),
                user.getGender(),
                user.getAge(),
                user.getAddress(),
                user.getQq(),
                user.getEmail(), user.getId());
    }

    @Override
    public int findTotalCount(Map<String, String[]> map) {
        String sql = "select count(*) from user where 1=1 ";
        StringBuffer sb = new StringBuffer(sql);
        Set<String> conditions = map.keySet();
        List<Object> list = new ArrayList<Object>();
        for (String key : conditions) {
            if (key.equals("rows") || key.equals("currentPage")) {
                continue;
            }
            String value = map.get(key)[0];
            if (value != null && !"".equals(value)) {
                sb.append(" and " + key + " like ?");
                list.add("%" + value + "%");
            }
        }
        sql = sb.toString();
        return jdbcTemplate.queryForObject(sql, Integer.class, list.toArray());
    }

    @Override
    public List<User> findUserPage(int start, int rows, Map<String, String[]> map) {
        String sql = "select * from user where 1=1  ";
        StringBuffer sb = new StringBuffer(sql);
        Set<String> conditions = map.keySet();
        List<Object> list = new ArrayList<Object>();
        for (String key : conditions) {
            if (key.equals("rows") || key.equals("currentPage")) {
                continue;
            }
            String value = map.get(key)[0];
            if (value != null && !"".equals(value)) {
                sb.append(" and " + key + " like ?");
                list.add("%" + value + "%");
            }
        }
        sb.append(" limit ?,? ");
        list.add(start);
        list.add(rows);
        sql = sb.toString();
        List<User> user = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class), list.toArray());
        return user;
    }
}
