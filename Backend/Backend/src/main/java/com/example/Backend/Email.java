package com.example.Backend;

import java.util.ArrayList;
import java.util.List;

class Email{
    private String sender;
    private String receiver;
    private String date;
    private String importance;
    private String subject;
    private boolean attachment;
    private List<Attachment> attachments;
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getImportance() {
		return importance;
	}
	public void setImportance(String importance) {
		this.importance = importance;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
    public boolean hasAttachments() {
        return attachment;
    }
	public void setAttachment(boolean attachment) {
		this.attachment = attachment;
	}

    public List<Attachment> getAttachments() {
        return attachments;
    }
}