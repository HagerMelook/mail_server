package com.example.Backend.mailServerSystem.CommandDesignPattern;

public class userName implements command{
    mailServerButtons name;

    public userName(mailServerButtons name) {
        this.name = name;
    }

    public String execute(){
        return name.getUserName();
    }
}
