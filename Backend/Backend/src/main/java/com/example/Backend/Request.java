package com.example.Backend;


public class Request {
    private String userId ;
    private String sortingKeyword;

    public Request() {
    }

    public Request(String userId, String sortingKeyword) {
        this.userId = userId;
        this.sortingKeyword = sortingKeyword;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSortingKeyword() {
        return sortingKeyword;
    }

    public void setSortingKeyword(String sortingKeyword) {
        this.sortingKeyword = sortingKeyword;
    }
}
