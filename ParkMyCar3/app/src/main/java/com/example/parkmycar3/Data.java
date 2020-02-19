package com.example.parkmycar3;

public class Data
{
   String username;
   String password;
   String id;
    public void Data(){

    }
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getId() {
        return id;
    }
    public Data(String username, String password, String id) {
        this.username = username;
        this.password = password;
        this.id = id;
    }
}
