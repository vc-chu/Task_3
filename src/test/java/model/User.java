package model;

import java.util.UUID;

public class User {

    private String email;
    private String password;
    private String name;
    private String accessToken;

    public User(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public static User random() {
        String unique = UUID.randomUUID().toString().substring(0, 8);
        return new User("user" + unique + "@test.ru", "password" + unique, "User" + unique);
    }

    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getName() { return name; }
    public String getAccessToken() { return accessToken; }
    public void setAccessToken(String accessToken) { this.accessToken = accessToken; }
}