package com.example.Filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController

public class FilterController {
    @Autowired
FilterDemo filterDemo;
public FilterController() {
    this.filterDemo = new FilterDemo();
}
@GetMapping(path = "/{id}/sender/{category}/filter")
public HashMap<String,ArrayList<Email>> Filter_sender_cat(@PathVariable("id") Long id,@PathVariable("category") String category) throws IOException {
    HashMap <String,ArrayList<Email>> senderEmailFilter = new HashMap<String,ArrayList<Email>>();
    senderEmailFilter = filterDemo.Filter_Due_Id_Sender(id,category);
    return senderEmailFilter;
}
@GetMapping("{id}/receiver/{category}/filter")
public HashMap <String,ArrayList<Email>> Filter_receiver_cat(@PathVariable("id") Long id,@PathVariable("category") String category) throws IOException {
    HashMap <String,ArrayList<Email>> receiverEmailFilter = new HashMap<String,ArrayList<Email>>();
    receiverEmailFilter = filterDemo.Filter_Due_Id_Receiver(id,category);
    return receiverEmailFilter;
}
@GetMapping("{id}/subject/{category}/filter")
public HashMap <String,ArrayList<Email>> Filter_subject_cat(@PathVariable("id") Long id,@PathVariable("category") String category) throws IOException {
    HashMap <String,ArrayList<Email>> subjectEmailFilter = new HashMap<String,ArrayList<Email>>();
    subjectEmailFilter = filterDemo.Filter_Due_Id_Subject(id,category);
    return subjectEmailFilter;
}
@GetMapping(path = "/{id}/sender/subject/{category}/filter")
public HashMap <String,ArrayList<Email>> Filter_sender_subject_cat(@PathVariable("id") Long id,@PathVariable("category") String category) throws IOException {
    HashMap <String,ArrayList<Email>> senderEmailFilter = new HashMap<String,ArrayList<Email>>();
    senderEmailFilter = filterDemo.Filter_Due_Id_Subject(id,category);
    filterDemo.flag = true;
    ArrayList<Email> emails = new ArrayList<>();
    for(ArrayList<Email> email: senderEmailFilter.values())
        emails.addAll(email);
    filterDemo.cat_emails = emails;
    senderEmailFilter = filterDemo.Filter_Due_Id_Sender(id,category);
            filterDemo.flag = false;
    return senderEmailFilter;
}
@GetMapping("{id}/receiver/subject/{category}/filter")
public HashMap <String,ArrayList<Email>> Filter_receiver_subject_cat(@PathVariable("id") Long id,@PathVariable("category") String category) throws IOException {
    HashMap <String,ArrayList<Email>> receiverEmailFilter = new HashMap<String,ArrayList<Email>>();
    receiverEmailFilter = filterDemo.Filter_Due_Id_Subject(id,category);
    ArrayList<Email> emails = new ArrayList<>();
    filterDemo.flag = true;
    for(ArrayList<Email> email: receiverEmailFilter.values())
        emails.addAll(email);
    filterDemo.cat_emails = emails;
    receiverEmailFilter = filterDemo.Filter_Due_Id_Receiver(id,category);
            filterDemo.flag = false;
    return receiverEmailFilter;
}
@GetMapping("{id}/subject/sender/{category}/filter")
public HashMap <String,ArrayList<Email>> Filter_subject_sender_cat(@PathVariable("id") Long id,@PathVariable("category") String category) throws IOException {
    HashMap <String,ArrayList<Email>> subjectEmailFilter = new HashMap<String,ArrayList<Email>>();
    subjectEmailFilter = filterDemo.Filter_Due_Id_Sender(id,category);
    filterDemo.flag = true;
    ArrayList<Email> emails = new ArrayList<>();
    for(ArrayList<Email> email: subjectEmailFilter.values())
        emails.addAll(email);
    filterDemo.cat_emails = emails;
    subjectEmailFilter = filterDemo.Filter_Due_Id_Subject(id,category);
            filterDemo.flag = false;
    return subjectEmailFilter;
}
@GetMapping("{id}/receiver/sender/{category}/filter")
public HashMap <String,ArrayList<Email>> Filter_receiver_sender_cat(@PathVariable("id") Long id,@PathVariable("category") String category) throws IOException {
    HashMap <String,ArrayList<Email>> receiverEmailFilter = new HashMap<String,ArrayList<Email>>();
    receiverEmailFilter = filterDemo.Filter_Due_Id_Sender(id,category);
    filterDemo.flag = true;
    ArrayList<Email> emails = new ArrayList<>();
    for(ArrayList<Email> email: receiverEmailFilter.values())
        emails.addAll(email);
    filterDemo.cat_emails = emails;
    receiverEmailFilter = filterDemo.Filter_Due_Id_Receiver(id,category);
            filterDemo.flag = false;
    return receiverEmailFilter;
}
@GetMapping("{id}/subject/receiver/{category}/filter")
public HashMap <String,ArrayList<Email>> Filter_subject_receiver_cat(@PathVariable("id") Long id,@PathVariable("category") String category) throws IOException {
    HashMap <String,ArrayList<Email>> subjectEmailFilter = new HashMap<String,ArrayList<Email>>();
    subjectEmailFilter = filterDemo.Filter_Due_Id_Receiver(id,category);
    filterDemo.flag = true;
    ArrayList<Email> emails = new ArrayList<>();
    for(ArrayList<Email> email: subjectEmailFilter.values())
        emails.addAll(email);
    filterDemo.cat_emails = emails;
    subjectEmailFilter = filterDemo.Filter_Due_Id_Subject(id,category);
            filterDemo.flag = false;
    return subjectEmailFilter;
}
@GetMapping("{id}/sender/receiver/{category}/filter")
public HashMap <String,ArrayList<Email>> Filter_sender_receiver_cat(@PathVariable("id") Long id,@PathVariable("category") String category) throws IOException {
    HashMap <String,ArrayList<Email>> senderEmailFilter = new HashMap<String,ArrayList<Email>>();
    senderEmailFilter = filterDemo.Filter_Due_Id_Receiver(id,category);
    filterDemo.flag = true;
    ArrayList<Email> emails = new ArrayList<>();
    for(ArrayList<Email> email: senderEmailFilter.values())
        emails.addAll(email);
    filterDemo.cat_emails = emails;
    senderEmailFilter = filterDemo.Filter_Due_Id_Sender(id,category);
            filterDemo.flag = false;
    return senderEmailFilter;
}
@GetMapping(path = "/{id}/receiver/sender/subject/{category}/filter")
public HashMap <String,ArrayList<Email>> Filter_Receiver_sender_subject_cat(@PathVariable("id") Long id,@PathVariable("category") String category) throws IOException {
    HashMap <String,ArrayList<Email>> senderEmailFilter = new HashMap<String,ArrayList<Email>>();
    senderEmailFilter = filterDemo.Filter_Due_Id_Subject(id,category);
    filterDemo.flag = true;
    ArrayList<Email> emails = new ArrayList<>();
    for(ArrayList<Email> email: senderEmailFilter.values())
        emails.addAll(email);
    filterDemo.cat_emails = emails;
    senderEmailFilter = filterDemo.Filter_Due_Id_Sender(id,category);
    emails = new ArrayList<>();
    for(ArrayList<Email> email: senderEmailFilter.values())
        emails.addAll(email);
    filterDemo.cat_emails = emails;
    senderEmailFilter = filterDemo.Filter_Due_Id_Receiver(id,category);
            filterDemo.flag = false;
    return senderEmailFilter;
}
@GetMapping("{id}/sender/receiver/subject/{category}/filter")
public HashMap <String,ArrayList<Email>> Filter_Sender_receiver_subject_cat(@PathVariable("id") Long id,@PathVariable("category") String category) throws IOException {
    HashMap <String,ArrayList<Email>> receiverEmailFilter = new HashMap<String,ArrayList<Email>>();
    receiverEmailFilter = filterDemo.Filter_Due_Id_Subject(id,category);
    filterDemo.flag = true;
    ArrayList<Email> emails = new ArrayList<>();
    for(ArrayList<Email> email: receiverEmailFilter.values())
        emails.addAll(email);
    filterDemo.cat_emails = emails;
    receiverEmailFilter = filterDemo.Filter_Due_Id_Receiver(id,category);
    emails = new ArrayList<>();
    for(ArrayList<Email> email: receiverEmailFilter.values())
        emails.addAll(email);
    filterDemo.cat_emails = emails;
    receiverEmailFilter = filterDemo.Filter_Due_Id_Sender(id,category);
            filterDemo.flag = false;
    return receiverEmailFilter;
}
@GetMapping("{id}/receiver/subject/sender/{category}/filter")
public HashMap <String,ArrayList<Email>> Filter_Receiver_subject_sender_cat(@PathVariable("id") Long id,@PathVariable("category") String category) throws IOException {
    HashMap <String,ArrayList<Email>> subjectEmailFilter = new HashMap<String,ArrayList<Email>>();
    subjectEmailFilter = filterDemo.Filter_Due_Id_Sender(id,category);
    filterDemo.flag = true;
    ArrayList<Email> emails = new ArrayList<>();
    for(ArrayList<Email> email: subjectEmailFilter.values())
        emails.addAll(email);
    filterDemo.cat_emails = emails;
    subjectEmailFilter = filterDemo.Filter_Due_Id_Subject(id,category);
        emails = new ArrayList<>();
    for(ArrayList<Email> email: subjectEmailFilter.values())
        emails.addAll(email);
    filterDemo.cat_emails = emails;
    subjectEmailFilter = filterDemo.Filter_Due_Id_Receiver(id,category);
            filterDemo.flag = false;
    return subjectEmailFilter;
}
@GetMapping("{id}/subject/receiver/sender/{category}/filter")
public HashMap <String,ArrayList<Email>> Filter_Subject_receiver_sender_cat(@PathVariable("id") Long id,@PathVariable("category") String category) throws IOException {
    HashMap <String,ArrayList<Email>> receiverEmailFilter = new HashMap<String,ArrayList<Email>>();
    receiverEmailFilter = filterDemo.Filter_Due_Id_Sender(id,category);
    filterDemo.flag = true;
    ArrayList<Email> emails = new ArrayList<>();
    for(ArrayList<Email> email: receiverEmailFilter.values())
        emails.addAll(email);
    filterDemo.cat_emails = emails;
    receiverEmailFilter = filterDemo.Filter_Due_Id_Receiver(id,category);
    emails = new ArrayList<>();
    for(ArrayList<Email> email: receiverEmailFilter.values())
        emails.addAll(email);
    filterDemo.cat_emails = emails;
    receiverEmailFilter = filterDemo.Filter_Due_Id_Subject(id,category);
            filterDemo.flag = false;
    return receiverEmailFilter;
} 
@GetMapping("{id}/sender/subject/receiver/{category}/filter")
public HashMap <String,ArrayList<Email>> Filter_Sender_subject_receiver_cat(@PathVariable("id") Long id,@PathVariable("category") String category) throws IOException {
    HashMap <String,ArrayList<Email>> subjectEmailFilter = new HashMap<String,ArrayList<Email>>();
    subjectEmailFilter = filterDemo.Filter_Due_Id_Receiver(id,category);
    filterDemo.flag = true;
    ArrayList<Email> emails = new ArrayList<>();
    for(ArrayList<Email> email: subjectEmailFilter.values())
        emails.addAll(email);
    filterDemo.cat_emails = emails;
    subjectEmailFilter = filterDemo.Filter_Due_Id_Subject(id,category);
    emails = new ArrayList<>();
    for(ArrayList<Email> email: subjectEmailFilter.values())
        emails.addAll(email);
    filterDemo.cat_emails = emails;
    subjectEmailFilter = filterDemo.Filter_Due_Id_Sender(id,category);
            filterDemo.flag = false;
    return subjectEmailFilter;
}
@GetMapping("{id}/subject/sender/receiver/{category}/filter")
public HashMap <String,ArrayList<Email>> Filter_Subject_sender_receiver_cat(@PathVariable("id") Long id,@PathVariable("category") String category) throws IOException {
    HashMap <String,ArrayList<Email>> senderEmailFilter = new HashMap<String,ArrayList<Email>>();
    senderEmailFilter = filterDemo.Filter_Due_Id_Receiver(id,category);
    filterDemo.flag = true;
    ArrayList<Email> emails = new ArrayList<>();
    for(ArrayList<Email> email: senderEmailFilter.values())
        emails.addAll(email);
    filterDemo.cat_emails = emails;
    senderEmailFilter = filterDemo.Filter_Due_Id_Sender(id,category);
    emails = new ArrayList<>();
    for(ArrayList<Email> email: senderEmailFilter.values())
        emails.addAll(email);
    filterDemo.cat_emails = emails;
    senderEmailFilter = filterDemo.Filter_Due_Id_Subject(id,category);
        filterDemo.flag = false;
    return senderEmailFilter;
}
@GetMapping(path = "{Emails}/{text}/search")
public ArrayList<Email> Search(@PathVariable("text") String text,@PathVariable("Emails") ArrayList<Email> emails) {
    // emails = new ArrayList<>();
    // Email email = new Email();
    // email.setSender("nouran");
    // email.setReceiver("h");
    // email.setDate("a");
    // email.setSubject("a");
    // emails.add(email);
    emails = filterDemo.search_text(emails,text);
    return emails;
}
}
