package com.example.Backend.mailServerSystem.CommandDesignPattern;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class mailServerAccess implements mailServerButtons {

    private JSONArray usersArray;
    private Long userId;
    private Long mailId;
    private String folderName;

    public mailServerAccess() {
    }

    public mailServerAccess(Long mailId, String folderName, Long userId) {
        this.mailId = mailId;
        this.folderName = folderName;
        this.userId = userId;
    }

    public mailServerAccess(Long userId, String folderName) {
        this.userId = userId;
        this.folderName = folderName;
    }

    public mailServerAccess(Long userId) {
        this.userId = userId;
    }

    private void setUsersArray() {
        usersArray = readJSONSystem();
    }

    public void addJSONEamilToUser(JSONObject email, Long userId, String userFolder) {
        setUsersArray();
        for (int i = 0; i < usersArray.size(); i++) {
            JSONObject obj = (JSONObject) usersArray.get(i);
            if (obj.get("id").equals(userId)) {
                JSONArray folder = (JSONArray) obj.get(userFolder);
                email.put("id", folder.size() + 1);
                folder.add(email);
                // obj.put(folderName, folder);
                break;
            }
        }
        updateJSON(usersArray);
    }

    public JSONArray readJSONSystem() {
        File file = new File(
                "C:\\Users\\noura\\OneDrive\\Desktop\\mailServer\\mail_server\\Backend\\Backend\\users.json");
        JSONParser jp = new JSONParser();
        JSONArray array;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            if (file.length() == 0) {
                array = new JSONArray();
            } else {
                array = (JSONArray) jp.parse(br);
            }
            br.close();
            return array;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void updateJSON(JSONArray obj) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(
                "C:\\Users\\noura\\OneDrive\\Desktop\\mailServer\\mail_server\\Backend\\Backend\\users.json"))) {
            bw.write(obj.toJSONString());
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getData(String folderName) {
        setUsersArray();
        for (int i = 0; i < usersArray.size(); i++) {
            JSONObject obj = (JSONObject) usersArray.get(i);
            if (obj.get("id").equals(userId)) {
                JSONArray Mails = (JSONArray) obj.get(folderName);
                return Mails.toJSONString();
            }
        }
        return null;
    }

    public String getMail() {
        setUsersArray();
        for (int i = 0; i < usersArray.size(); i++) {
            JSONObject obj = (JSONObject) usersArray.get(i);
            if (obj.get("id").equals(userId)) {
                JSONArray Mails = (JSONArray) obj.get(folderName);
                for (int j = 0; j < Mails.size(); j++) {
                    JSONObject theMail = (JSONObject) Mails.get(j);
                    if (theMail.get("id").equals(mailId))
                        return theMail.toJSONString();
                }
            }
        }
        return null;
    }

    public void createFolder() {
        setUsersArray();
        for (int i = 0; i < usersArray.size(); i++) {
            JSONObject obj = (JSONObject) usersArray.get(i);
            if (obj.get("id").equals(userId)) {
                JSONArray userFolders = (JSONArray) obj.get("userFolders");
                JSONArray arr = new JSONArray();
                JSONObject tmp = new JSONObject();
                tmp.put(folderName, arr);
                userFolders.add(tmp);
                updateJSON(usersArray);
                break;
            }
        }
    }

    public String getUserFolder() {
        setUsersArray();
        for (int i = 0; i < usersArray.size(); i++) {
            JSONObject obj = (JSONObject) usersArray.get(i);
            if (obj.get("id").equals(userId)) {
                JSONArray folders = (JSONArray) obj.get("userFolders");
                for (int k = 0; k < folders.size(); k++) {
                    JSONObject obj2 = (JSONObject) folders.get(k);
                    if (obj2.get(folderName) != null) {
                        return obj2.get(folderName).toString();
                    }
                }
            }
        }
        return null;
    }

    public String getEmailInUserFolder() {
        JSONParser pa = new JSONParser();
        try {
            JSONArray arrEmail = (JSONArray) pa.parse(getUserFolder());
            for (int i = 0; i < arrEmail.size(); i++) {
                JSONObject obj = (JSONObject) arrEmail.get(i);
                if (obj.get("id").equals(mailId)) {
                    return obj.toJSONString();
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String deleteEmail() {
        setUsersArray();
        for (int i = 0; i < usersArray.size(); i++) {
            JSONObject obj = (JSONObject) usersArray.get(i);
            if (obj.get("id").equals(userId)) {
                JSONArray folder = (JSONArray) obj.get(folderName);
                for (int k = 0; k < folder.size(); k++) {
                    JSONObject tmp = (JSONObject) folder.get(k);
                    if (tmp.get("id").equals(mailId)) {
                        folder.remove(tmp);
                        updateIDs(folder);
                        updateJSON(usersArray);
                        if (!folderName.equals("trash"))
                            addJSONEamilToUser(tmp, userId, "trash");
                        return "Deleted successfully! :D";
                    }
                }
            }
        }
        return "not deleted :'(";
    }

    public String deleteFolder() {
        setUsersArray();
        for (int i = 0; i < usersArray.size(); i++) {
            JSONObject obj = (JSONObject) usersArray.get(i);
            if (obj.get("id").equals(userId)) {
                JSONArray folder = (JSONArray) obj.get("userFolders");
                for (int k = 0; k < folder.size(); k++) {
                    JSONObject tmp = (JSONObject) folder.get(k);
                    if (tmp.get(folderName) != null) {
                        folder.remove(tmp);
                        updateJSON(usersArray);
                        addJSONEamilToUser(tmp, userId, "trash");
                        return "Deleted successfully! :D";
                    }
                }
            }
        }
        return "not deleted :'(";
    }

    public String deleteEmailInFolder() {
        setUsersArray();
        for (int i = 0; i < usersArray.size(); i++) {
            JSONObject obj = (JSONObject) usersArray.get(i);
            if (obj.get("id").equals(userId)) {
                JSONArray folder = (JSONArray) obj.get("userFolders");
                for (int k = 0; k < folder.size(); k++) {
                    JSONObject tmp = (JSONObject) folder.get(k);
                    if (tmp.get(folderName) != null) {
                        JSONArray arrEmail = (JSONArray) tmp.get(folderName);
                        for (int j = 0; j < arrEmail.size(); j++) {
                            JSONObject obj2 = (JSONObject) arrEmail.get(j);
                            if (obj2.get("id").equals(mailId)) {
                                arrEmail.remove(obj2);
                                updateIDs(arrEmail);
                                updateJSON(usersArray);
                                addJSONEamilToUser(obj2, userId, "trash");
                                return "Deleted successfully! :D";
                            }
                        }
                    }
                }
            }
        }
        return "not deleted :'(";
        
    }

    private void updateIDs(JSONArray folder) {
        for (int i = 0; i < folder.size(); i++) {
            JSONObject tmp = (JSONObject) folder.get(i);
            tmp.put("id", i + 1);
        }
    }
}
