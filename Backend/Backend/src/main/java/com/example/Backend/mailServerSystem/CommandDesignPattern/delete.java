package com.example.Backend.mailServerSystem.CommandDesignPattern;

public class delete implements command{
    mailServerButtons delete;

    public delete(mailServerButtons delete) {
        this.delete = delete;
    }

    public String execute(){
        return delete.deleteEmail();
    }
    
}
