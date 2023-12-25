package com.example.Backend;


public class Request {
    private String userId ;
    private String sortingKeyword;
    private String emailType;

    public Request() {
    }

    public Request(String userId, String sortingKeyword,String emailType) {
        this.userId = userId;
        this.sortingKeyword = sortingKeyword;
        this.emailType=emailType;
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

	public String getEmailType() {
		return emailType;
	}

	public void setEmailType(String emailType) {
		this.emailType = emailType;
	}
    
}

