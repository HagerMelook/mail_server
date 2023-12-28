package com.example.Filter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class FilterDemo {
    private static final String JsonFile = "users.json";
    boolean flag = false;
    List<Registration> user_data = new ArrayList<>();
    Registration user_id = new Registration();
    ArrayList<Email> cat_emails = new ArrayList<>();
    public List<Registration> readUsersFromJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(JsonFile);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        return objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, Registration.class));
    }
    public  HashMap <String,ArrayList<Email>> Filter_Due_Id_Sender(Long id,String category) throws IOException{
        if(flag == false){
            user_data = readUsersFromJson();
            user_id = new Registration();
            for(Registration user: user_data){
                if(user.getId()==id){
                    user_id = user;
                }
            }
            cat_emails = new ArrayList<>();
        
        if(category!=null){
            for(Object cat_email:  user_id.getEmails(category)){
                cat_emails.add((Email)cat_email);
            }
        }
        else{
            for(Object cat_email:  user_id.getEmails("inbox")){
                cat_emails.add((Email)cat_email);
            }
            for(Object cat_email:  user_id.getEmails("draft")){
                cat_emails.add((Email)cat_email);
            }
            for(Object cat_email:  user_id.getEmails("sent")){
                cat_emails.add((Email)cat_email);
            }
            for(Object cat_email:  user_id.getEmails("trash")){
                cat_emails.add((Email)cat_email);
            }
            for(Object cat_email:  user_id.getEmails("userFolders")){
                cat_emails.add((Email)cat_email);
            }
        }
    }
        HashMap <String,ArrayList<Email>> senderEmailFilter = new HashMap<String,ArrayList<Email>>();
        senderFilter senderFilter = new senderFilter();
        senderEmailFilter = senderFilter.emailFilter(cat_emails);
        return senderEmailFilter;
    }
    public HashMap <String,ArrayList<Email>> Filter_Due_Id_Receiver(Long id,String category) throws IOException{
        if(flag == false){
            user_data = readUsersFromJson();
            user_id = new Registration();
            for(Registration user: user_data){
                if(user.getId()==id){
                    user_id = user;
                }
            }
            cat_emails = new ArrayList<>();
        
        if(category!=null){
            for(Object cat_email:  user_id.getEmails(category)){
                cat_emails.add((Email)cat_email);
            }
        }
        else{
            for(Object cat_email:  user_id.getEmails("inbox")){
                cat_emails.add((Email)cat_email);
            }
            for(Object cat_email:  user_id.getEmails("draft")){
                cat_emails.add((Email)cat_email);
            }
            for(Object cat_email:  user_id.getEmails("sent")){
                cat_emails.add((Email)cat_email);
            }
            for(Object cat_email:  user_id.getEmails("trash")){
                cat_emails.add((Email)cat_email);
            }
            for(Object cat_email:  user_id.getEmails("userFolders")){
                cat_emails.add((Email)cat_email);
            }
        }
    }
        HashMap <String,ArrayList<Email>> receiverEmailFilter = new HashMap<String,ArrayList<Email>>();
        receiverFilter receiverFilter = new receiverFilter();
        receiverEmailFilter = receiverFilter.emailFilter(cat_emails);
        return receiverEmailFilter;
    }
        public HashMap <String,ArrayList<Email>> Filter_Due_Id_Subject(Long id,String category) throws IOException{
        if(flag == false){
            user_data = readUsersFromJson();
            user_id = new Registration();
            for(Registration user: user_data){
                if(user.getId()==id){
                    user_id = user;
                }
            }
            cat_emails = new ArrayList<>();
        
        if(category!=null){
            for(Object cat_email:  user_id.getEmails(category)){
                cat_emails.add((Email)cat_email);
            }
        }
        else{
            for(Object cat_email:  user_id.getEmails("inbox")){
                cat_emails.add((Email)cat_email);
            }
            for(Object cat_email:  user_id.getEmails("draft")){
                cat_emails.add((Email)cat_email);
            }
            for(Object cat_email:  user_id.getEmails("sent")){
                cat_emails.add((Email)cat_email);
            }
            for(Object cat_email:  user_id.getEmails("trash")){
                cat_emails.add((Email)cat_email);
            }
            for(Object cat_email:  user_id.getEmails("userFolders")){
                cat_emails.add((Email)cat_email);
            }
        }
    }
        HashMap <String,ArrayList<Email>> subjectEmailFilter = new HashMap<String,ArrayList<Email>>();
        subjectFilter subjectFilter = new subjectFilter();
        subjectEmailFilter = subjectFilter.emailFilter(cat_emails);
        return subjectEmailFilter;
    }
    public ArrayList<Email> search_text(ArrayList<Email> emails,String text){
        ArrayList<Email> new_email = new ArrayList<>();
        for(Email email: emails){
            if(email.getSender().contains(text)){
                new_email.add(email);
                continue;
            }
            if(email.getReceiver().contains(text)){
                                new_email.add(email);
                continue;
            }
            if(email.getDate().contains(text)){
                                new_email.add(email);
                continue;
            }
            if(email.getSubject().contains(text)){
                                new_email.add(email);
                continue;
            }
            //if(emails.isEmpty()) break;
        }
        return new_email;
    }
    public static void main(String[] args) throws IOException  {
    }
}