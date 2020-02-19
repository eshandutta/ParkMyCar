package com.example.parkmycar3;

public class RegisterDb {

    String username;
    String password;
    String confirmpassword;
    String mobile;
    String email;
    String id;

    public void RegisterDb(){

    }


    public RegisterDb(String username, String password, String confirmpassword, String mobile, String email,String id) {
        this.username = username;
        this.password = password;
        this.confirmpassword = confirmpassword;
        this.mobile = mobile;
        this.email = email;
        this.id=id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }
    public String getId() {
        return id;
    }



}
