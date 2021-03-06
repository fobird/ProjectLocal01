package cn.itcast.damain;

/**
 * @author superLin
 * @date 2021-04-23 16:04
 * id int primary key auto_increment,
 * name varchar(20) not null,
 * gender varchar(5),
 * age int,
 * address varchar(32),
 * qq	varchar(20),
 * email varchar(50)
 */
public class User {
    private int id;
    private int age;
    private String name;
    private String gender;
    private String address;
    private String qq;
    private String email;
    private String username;
    private String password;

    public User() {
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


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(int id, int age, String name, String gender, String address, String qq, String email, String username, String password) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.qq = qq;
        this.email = email;
        this.username = username;
        this.password = password;
    }
}
