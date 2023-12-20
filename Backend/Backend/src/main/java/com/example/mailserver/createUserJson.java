//         package com.example.mailserver;
        
//         import java.io.FileWriter;
//         import java.io.IOException;
        
//         import org.springframework.boot.configurationprocessor.json.JSONObject;
        
//         import ch.qos.logback.core.FileAppender;
        
//         public class createUserJson {
//             FileWriter fw1;
//             FileAppender fw;
//             public createUserJson(Email email,String path) throws IOException {
//                 this.fw1 = new FileWriter(path);
//                         JSONObject jsonf = new JSONObject();
//                 try {
//                     fw1= new FileWriter(path);
//                     jsonf.put("senderName", email.getSendername());
//                     jsonf.put("receiverName", email.getReceivername());
//                     jsonf.put("email", email.getEmail());
//                     jsonf.put("text", email.getText());
//                     jsonf.put("subject", email.getSubject());
//                     fw1.write(jsonf.toString());
//                     System.out.println("json file is created" + jsonf);
//                 } catch (Exception e) {
//                     e.printStackTrace();
//             }
//         }
                
//     public void createUserJSON(Email email, String path) {
//         JSONObject jsonf = new JSONObject();
//         try {
//             fw= new FileAppender();
//             jsonf.put("senderName", email.getSendername());
//             jsonf.put("receiverName", email.getReceivername());
//             jsonf.put("email", email.getEmail());
//             jsonf.put("text", email.getText());
//             jsonf.put("subject", email.getSubject());
//             fw.doAppend(jsonf.toString());
//             System.out.println("json file is created" + jsonf);
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }
//     public void closeFile() throws IOException{
//         this.fw1.close();
//     }
// }
