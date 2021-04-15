package cn.itcast.web.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author superLin
 * @date 2021-04-15 16:37
 */
public class JDBCutils {

    private static DataSource dataSource;


    static {
        try {
            Properties properties = new Properties();
            InputStream input = JDBCutils.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(input);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取数据库连接池对象
     */
    public static DataSource getDataSource() {
        return dataSource;
    }

    /***
     * 获取Connection对象
     */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

}
