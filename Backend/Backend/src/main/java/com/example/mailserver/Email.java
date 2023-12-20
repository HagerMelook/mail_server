package com.example.mailserver;
public class Email {
    private String sendername;
    private String receivername;
    private String text;
    private String email;
    private String subject;

    public Email(String sendername, String receivername, String text, String email, String subject) {
        this.sendername = sendername;
        this.receivername = receivername;
        this.text = text;
        this.email = email;
        this.subject = subject;
    }

    public String getSendername() {
        return sendername;
    }

    public void setSendername(String sendername) {
        this.sendername = sendername;
    }

    public String getReceivername() {
        return receivername;
    }

    public void setReceivername(String receivername) {
        this.receivername = receivername;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
