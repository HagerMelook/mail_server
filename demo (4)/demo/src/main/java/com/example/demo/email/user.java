package com.example.demo.email;



public class user {

    
    private Long id;
    private String username;
    private String email;
    
   

    public user(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }
    public user(String username, String email) {
        this.username = username;
        this.email = email;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    
}
