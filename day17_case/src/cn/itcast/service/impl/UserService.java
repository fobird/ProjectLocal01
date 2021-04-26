package cn.itcast.service.impl;

import cn.itcast.damain.PageBean;
import cn.itcast.damain.User;
import cn.itcast.dao.UserDao;

import java.util.List;
import java.util.Map;

/**
 * @author superLin
 * @date 2021-04-23 16:07
 */
public class UserService implements cn.itcast.service.UserService {
    private UserDao userDao = new cn.itcast.dao.impl.UserDao();

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void addUser(User user) {
        userDao.add(user);
    }

    @Override
    public void delUserById(String id) {
        userDao.delUserById(Integer.parseInt(id));
    }

    @Override
    public User findUserById(String id) {
        return userDao.findUserById(Integer.parseInt(id));
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);

    }

    @Override
    public void delUsers(String[] ids) {
        if (ids != null && ids.length > 0) {
            for (String id : ids) {
                userDao.delUserById(Integer.parseInt(id));
            }
        }
    }

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> map) {
        //将_currentPage，_rows转成int型
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        if (currentPage <= 0) {
            currentPage = 1;
        }
        if (rows <= 4) {
            rows = 5;
        }
        PageBean<User> pageBean = new PageBean<User>();
        pageBean.setCurrentPage(currentPage);
        pageBean.setRows(rows);
        //調用dao層方法，計算数据总数
        int totalCount = userDao.findTotalCount(map);
        pageBean.setTotalCount(totalCount);
        //根据数据总数totalCount跟rows,计算totalPage
        int totalPage = (totalCount % rows) == 0 ? totalCount / rows : (totalCount / rows) + 1;
        if (totalPage == 0) {
            totalPage = 1;
        }
        if (currentPage > totalPage) {
            currentPage = totalPage;
        }
        pageBean.setTotalPage(totalPage);
        //调用dao层方法，返回当前页面数据,list集合
        int start = (currentPage - 1) * rows;
        List<User> list = userDao.findUserPage(start, rows, map);
        pageBean.setList(list);
        return pageBean;
    }
}
