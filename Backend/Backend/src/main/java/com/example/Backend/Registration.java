package com.example.Backend;

import org.json.simple.JSONArray;



public class Registration {
    private Long id;
    private String username;
    private String email;
    private String password;
    private JSONArray inbox;
    private JSONArray draft;
    private JSONArray sent;
    private JSONArray trash;
    private JSONArray contacts;
    private JSONArray userFolders;
    public Registration(){
        this.inbox = new JSONArray();  
        this.draft = new JSONArray();  
        this.sent = new JSONArray();  
        this.trash = new JSONArray();
        this.userFolders = new JSONArray();
        this.contacts = new JSONArray();
    	
    }

    public JSONArray getEmails(String emailType) {
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
        this.inbox = new JSONArray();  
        this.draft = new JSONArray();  
        this.sent = new JSONArray();  
        this.trash = new JSONArray();
        this.userFolders = new JSONArray();
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


	public JSONArray getInbox() {
		return inbox;
	}


	public void setInbox(JSONArray inbox) {
		this.inbox = inbox;
	}


	public JSONArray getDraft() {
		return draft;
	}


	public void setDraft(JSONArray draft) {
		this.draft = draft;
	}


	public JSONArray getSent() {
		return sent;
	}


	public void setSent(JSONArray sent) {
		this.sent = sent;
	}


	public JSONArray getTrash() {
		return trash;
	}


	public void setTrash(JSONArray trash) {
		this.trash = trash;
	}


	public JSONArray getContacts() {
		return contacts;
	}


	public void setContacts(JSONArray contacts) {
		this.contacts = contacts;
	}

	public JSONArray getUserFolders() {
		return userFolders;
	}

	public void setUserFolders(JSONArray userFolders) {
		this.userFolders = userFolders;
	}


}
