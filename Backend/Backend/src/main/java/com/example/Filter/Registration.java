package com.example.Filter;


import java.util.ArrayList;


public class Registration {
    private Long id;
    private String username;
    private String email;
    private String password;
    private ArrayList<Email> inbox;
    private ArrayList<Email> draft;
    private ArrayList<Email> sent;
    private ArrayList<Email> trash;
    private ArrayList<Email> contacts;
    private ArrayList<Email> userFolders;
    public Registration(){
        this.inbox = new ArrayList<>();  
        this.draft = new ArrayList<>();;  
        this.sent = new ArrayList<>();;  
        this.trash = new ArrayList<>();;
        this.userFolders = new ArrayList<>();;
        this.contacts = new ArrayList<>();;
    	
    }

    public ArrayList<Email> getEmails(String emailType) {
    	switch(emailType)
    	{
    	case "inbox":
    		return inbox;
		case "draft":
    		return draft;
		case "sent":
    		return sent;
		case"trash":
    		return trash;
		case"userFolders":
    		return userFolders;
		default:
    			return null;
    	}
	}

    public Registration(Long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.inbox = new ArrayList<>();  
        this.draft = new ArrayList<>();;  
        this.sent = new ArrayList<>();;  
        this.trash = new ArrayList<>();;
        this.userFolders = new ArrayList<>();;
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	public ArrayList<Email> getInbox() {
		return inbox;
	}


	public void setInbox(ArrayList<Email>inbox) {
		this.inbox = inbox;
	}


	public ArrayList<Email> getDraft() {
		return draft;
	}


	public void setDraft(ArrayList<Email>draft) {
		this.draft = draft;
	}


	public ArrayList<Email> getSent() {
		return sent;
	}


	public void setSent(ArrayList<Email> sent) {
		this.sent = sent;
	}


	public ArrayList<Email> getTrash() {
		return trash;
	}


	public void setTrash(ArrayList<Email> trash) {
		this.trash = trash;
	}


	public ArrayList<Email> getContacts() {
		return contacts;
	}


	public void setContacts(ArrayList<Email> contacts) {
		this.contacts = contacts;
	}

	public ArrayList<Email> getUserFolders() {
		return userFolders;
	}

	public void setUserFolders(ArrayList<Email> userFolders) {
		this.userFolders = userFolders;
	}


}