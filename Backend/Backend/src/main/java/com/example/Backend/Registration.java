package com.example.Backend;

import java.util.List;

public class Registration {
    private Long id;
    private String username;
    private String email;
    private String password;
    private List<Email> inbox;
    private List<Email> draft;
    private List<Email> sent;
    private List<Email> trash;
    private List<Registration> contacts;
    public Registration(){
    	
    }

    public List<Email> getEmails(String emailType) {
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
		default:
    			return null;
    	}
	}

	public Registration(Long id, String username, String email, String password) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
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


	public List<Email> getInbox() {
		return inbox;
	}


	public void setInbox(List<Email> inbox) {
		this.inbox = inbox;
	}


	public List<Email> getDraft() {
		return draft;
	}


	public void setDraft(List<Email> draft) {
		this.draft = draft;
	}


	public List<Email> getSent() {
		return sent;
	}


	public void setSent(List<Email> sent) {
		this.sent = sent;
	}


	public List<Email> getTrash() {
		return trash;
	}


	public void setTrash(List<Email> trash) {
		this.trash = trash;
	}


	public List<Registration> getContacts() {
		return contacts;
	}


	public void setContacts(List<Registration> contacts) {
		this.contacts = contacts;
	}


}
