package com.example.wits_vuvuzela_app;

public class UserProfile {
    private String User_fName;
    private String User_lName;
    private String User_username;
    private String User_email;
    private String User_password;

    public UserProfile() {

    }

    public String getUser_fName() {
        return User_fName;
    }

    public void setUser_fName(String user_fName) {
        this.User_fName = user_fName;
    }

    public String getUser_lName() {
        return User_lName;
    }

    public void setUser_lName(String user_lName) {
        User_lName = user_lName;
    }

    public String getUser_username() {
        return User_username;
    }

    public void setUser_username(String user_username) {
        User_username = user_username;
    }

    public String getUser_email() {
        return User_email;
    }

    public void setUser_email(String user_email) {
        User_email = user_email;
    }

    public String getUser_password() {
        return User_password;
    }

    public void setUser_password(String user_password) {
        User_password = user_password;
    }
}