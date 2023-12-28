package com.example.Backend.mailServerSystem;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Backend.Email;
import com.example.Backend.mailServerSystem.CommandDesignPattern.DeleteEmailInFolder;
import com.example.Backend.mailServerSystem.CommandDesignPattern.DeleteFolder;
import com.example.Backend.mailServerSystem.CommandDesignPattern.contact;
import com.example.Backend.mailServerSystem.CommandDesignPattern.delete;
import com.example.Backend.mailServerSystem.CommandDesignPattern.draft;
import com.example.Backend.mailServerSystem.CommandDesignPattern.getAllUserFolders;
import com.example.Backend.mailServerSystem.CommandDesignPattern.getFolder;
import com.example.Backend.mailServerSystem.CommandDesignPattern.getTheMail;
import com.example.Backend.mailServerSystem.CommandDesignPattern.inbox;
import com.example.Backend.mailServerSystem.CommandDesignPattern.mailButton;
import com.example.Backend.mailServerSystem.CommandDesignPattern.mailInUserFolder;
import com.example.Backend.mailServerSystem.CommandDesignPattern.mailServerButtons;
import com.example.Backend.mailServerSystem.CommandDesignPattern.sent;
import com.example.Backend.mailServerSystem.CommandDesignPattern.trash;
import com.example.Backend.mailServerSystem.CommandDesignPattern.userMail;
import com.example.Backend.mailServerSystem.CommandDesignPattern.userName;
import com.example.Backend.mailServerSystem.FacadeDesignPattern.Contact;
import com.example.Backend.mailServerSystem.FacadeDesignPattern.ContactCreatorFacade;
import com.example.Backend.mailServerSystem.FacadeDesignPattern.MailCreatorFacade;
import com.example.Backend.mailServerSystem.FacadeDesignPattern.createUserFolderFacade;

import java.util.Queue;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin
@RestController
public class systemController {

    @GetMapping("{id}")
    public String user(@PathVariable("id") Long userId) {
        mailServerButtons user = userMail.getButton(userId);
        userName name = new userName(user);
        mailButton onPressed = new mailButton(name);
        return onPressed.press();
    }

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
        draft getDraft = new draft(mail);
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
        mailServerButtons contact = userMail.getButton(userId);
        contact getContact = new contact(contact);
        mailButton onPressed = new mailButton(getContact);
        return onPressed.press();
    }

    @GetMapping("{id}/userFolders")
    public String userFolders(@PathVariable("id") Long userId) {
        mailServerButtons folders = userMail.getButton(userId);
        getAllUserFolders getFolders = new getAllUserFolders(folders);
        mailButton onPressed = new mailButton(getFolders);
        return onPressed.press();
    }

    @GetMapping("{idU}/{folderName}/{idD}")
    public String mail(@PathVariable("idU") Long userId, @PathVariable("folderName") String folderName,
            @PathVariable("idD") Long dataId) {
        mailServerButtons mail = userMail.getMail(dataId, folderName, userId);
        getTheMail theMail = new getTheMail(mail);
        mailButton onPressed = new mailButton(theMail);
        return onPressed.press();
    }

    @GetMapping("{idU}/userFolders/{folderName}")
    public String Folder(@PathVariable("idU") Long userId, @PathVariable("folderName") String folderName) {
        mailServerButtons folder = userMail.userFolders(userId, folderName);
        getFolder theFolder = new getFolder(folder);
        mailButton onPressed = new mailButton(theFolder);
        return onPressed.press();
    }

    @GetMapping("{idU}/userFolders/{folderName}/{emailId}")
    public String EmaiInFolder(@PathVariable("idU") Long userId, @PathVariable("folderName") String folderName,
            @PathVariable("emailId") Long idE) {
        mailServerButtons folder = userMail.getMail(idE, folderName, userId);
        mailInUserFolder theMail = new mailInUserFolder(folder);
        mailButton onPressed = new mailButton(theMail);
        return onPressed.press();
    }

    @PostMapping("{idU}/userFolders/create/{folderName}")
    public void addAttachment(@PathVariable("folderName") String folderName, @PathVariable("idU") Long idU) {
        createUserFolderFacade folder = new createUserFolderFacade(idU, folderName);
        folder.create();
    }

    @PostMapping("{idU}/createEmail/save")
    public void createEamil(@RequestBody Email email, @PathVariable("idU") Long idU) {
        MailCreatorFacade mail = new MailCreatorFacade(email, idU, "draft");
        mail.create();
    }

    @PostMapping("{idU}/createEmail/send")
    public void sendEamil(@RequestBody Email email, @PathVariable("idU") Long idU) {
        MailCreatorFacade mail = new MailCreatorFacade(email, idU, "sent");
        mail.create();
    }

    @PostMapping("{id}/contacts/add")
    public void addContactInfo(@PathVariable("id") Long userId, @RequestBody Contact body) {
        ContactCreatorFacade contact = new ContactCreatorFacade(userId, body);
        contact.create();
    }

    @DeleteMapping("{idU}/{folder}/delete")
    public void deleteMail(@RequestBody Queue<Long> idQ, @PathVariable("folder") String folderName,
            @PathVariable("idU") Long idU) {
        while (!idQ.isEmpty()) {
            System.out.println(idQ.size());
            mailServerButtons delete = userMail.getMail(idQ.remove(), folderName, idU);
            delete deleteMail = new delete(delete);
            mailButton onPressed = new mailButton(deleteMail);
            onPressed.press();
        }
    }

    @DeleteMapping("{idU}/userFolders/{folderName}/delete")
    public String deleteFolder(@PathVariable("folderName") String folderName, @PathVariable("idU") Long idU) {
        mailServerButtons delete = userMail.userFolders(idU, folderName);
        DeleteFolder deleteFolder = new DeleteFolder(delete);
        mailButton onPressed = new mailButton(deleteFolder);
        return onPressed.press();
    }

    @DeleteMapping("{idU}/userFolders/{folderName}/deleteEmail")
    public void deleteMailInFolder(@RequestBody Queue<Long> idQ, @PathVariable("folderName") String folderName,
            @PathVariable("idU") Long idU) {
        while (!idQ.isEmpty()) {
            mailServerButtons delete = userMail.getMail(idQ.remove(), folderName, idU);
            DeleteEmailInFolder deleteMail = new DeleteEmailInFolder(delete);
            mailButton onPressed = new mailButton(deleteMail);
            onPressed.press();
        }
    }

    // @GetMapping("{username}/userFolders")
    // public JSONObject userFolders(@PathVariable("username") String username) {
    // return userFolders(username);
    // }

    // @GetMapping("{username}/attachment")
    // public JSONObject viewAttachment(@PathVariable("username") String username) {
    // return null;
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
    // public void saveJSONUser(@RequestBody user user, @PathVariable("username")
    // String username) {
    // try {
    // json.createJSONSystem(json.createJSONUser(user));
    // } catch (ParseException e) {
    // e.printStackTrace();
    // }
    // }

    // @PostMapping("{username}/save/email")
    // public void saveJSONUser(@RequestBody Email email, @PathVariable("username")
    // String username) {
    // JSONObject obj = json.createJSONEamil(email);
    // json.addJSONEamilToUser(obj, username);
    // }

}
