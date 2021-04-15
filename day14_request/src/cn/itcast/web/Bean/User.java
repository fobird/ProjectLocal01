package cn.itcast.web.Bean;

/**
 * @author superLin
 * @date 2021-04-15 16:25
 */
public class User {

    /**
     * 用户id
     */
    private int id;
    /**
     * 用戶登陆名
     */
    private String username;

    /**
     * 用户登陆密码
     */
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
