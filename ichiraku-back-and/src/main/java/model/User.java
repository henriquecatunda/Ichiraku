package model;

public class User {
	 
    int id;
    String login;
    String password;
 
    public User(int id, String login, String password) {
        super();
        this.id = id;
        this.login = login;
        this.password = password;
    }
 
    @Override
    public String toString() {
        return "User [id=" + id + ", login=" + login + ", password=" + password + "]";
    }
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getLogin() {
        return login;
    }
 
    public void setLogin(String login) {
        this.login = login;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
}