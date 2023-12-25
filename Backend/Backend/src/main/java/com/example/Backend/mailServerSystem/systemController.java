package com.example.Backend.mailServerSystem;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Backend.mailServerSystem.CommandDesignPattern.contact;
import com.example.Backend.mailServerSystem.CommandDesignPattern.getTheMail;
import com.example.Backend.mailServerSystem.CommandDesignPattern.inbox;
import com.example.Backend.mailServerSystem.CommandDesignPattern.mailButton;
import com.example.Backend.mailServerSystem.CommandDesignPattern.mailServerButtons;
import com.example.Backend.mailServerSystem.CommandDesignPattern.sent;
import com.example.Backend.mailServerSystem.CommandDesignPattern.trash;
import com.example.Backend.mailServerSystem.CommandDesignPattern.userMail;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class systemController {

    @GetMapping("{id}/inbox")
    public String inbox(@PathVariable("id") Long userId) {
        mailServerButtons mail = userMail.getButton(userId);
        inbox getInbox = new inbox(mail);
        mailButton onPressed = new mailButton(getInbox);
        return onPressed.press();
    }

    @GetMapping("{id}/trash")
    public String trash(@PathVariable("id") Long userId) {
        mailServerButtons mail = userMail.getButton(userId);
        trash getTrash = new trash(mail);
        mailButton onPressed = new mailButton(getTrash);
        return onPressed.press();
    }

    @GetMapping("{id}/draft")
    public String draft(@PathVariable("id") Long userId) {
        mailServerButtons mail = userMail.getButton(userId);
        inbox getDraft = new inbox(mail);
        mailButton onPressed = new mailButton(getDraft);
        return onPressed.press();
    }

    @GetMapping("{id}/sent")
    public String sentMails(@PathVariable("id") Long userId) {
        mailServerButtons mail = userMail.getButton(userId);
        sent getSent = new sent(mail);
        mailButton onPressed = new mailButton(getSent);
        return onPressed.press();
    }

     @GetMapping("{id}/contacts")
    public String contacts(@PathVariable("id") Long userId) {
        mailServerButtons mail = userMail.getButton(userId);
        contact getContact = new contact(mail);
        mailButton onPressed = new mailButton(getContact);
        return onPressed.press();
    }

    @GetMapping("{idU}/{folderName}/{idD}")
    public String mail(@PathVariable("idU") Long userId, @PathVariable("folderName")String  folderName ,@PathVariable("idD") Long dataId) {
        mailServerButtons mail = userMail.getMail(dataId, folderName, userId);
        getTheMail theMail = new getTheMail(mail);
        mailButton onPressed = new mailButton(theMail);
        return onPressed.press();
    }

    // @GetMapping("{username}/userFolders")
    // public JSONObject userFolders(@PathVariable("username") String username) {
    //     return userFolders(username);
    // }

    // @GetMapping("{username}/attachment")
    // public JSONObject viewAttachment(@PathVariable("username") String username) {
    //     return null;
    // }
    
    // @PostMapping("{username}/attachment/save")
    // public void addAttachment(@PathVariable("username") String username) {
        
    // }
    
    // @DeleteMapping("{username}/attachment/delete")
    // public void deleteAttachment(){

    // }

    
    // @PostMapping("{username}/contacts/save")
    // public void addContact(@PathVariable("username") String username) {
        
    // }
    
    // @DeleteMapping("{username}/contacts/delete")
    // public void deleteContact(){
        
    // }


    // @PostMapping("{username}/save/user")
    // public void saveJSONUser(@RequestBody user user, @PathVariable("username") String username) {
    //     try {
    //         json.createJSONSystem(json.createJSONUser(user));
    //     } catch (ParseException e) {
    //         e.printStackTrace();
    //     }
    // }

    // @PostMapping("{username}/save/email")
    // public void saveJSONUser(@RequestBody Email email, @PathVariable("username") String username) {
    //     JSONObject obj = json.createJSONEamil(email);
    //     json.addJSONEamilToUser(obj, username);
    // }


}
