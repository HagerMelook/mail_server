// package com.example.Filter;

// import java.util.ArrayList;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;

// @CrossOrigin
// @RestControlle
// public class SearchController {
// @Autowired
// @GetMapping(path = "{Emails}/{text}/search")
// public ArrayList<Email> Search(@PathVariable("text") String text,@PathVariable("Emails") ArrayList<Email>emails) {
//     SearchDemo searchDemo = new SearchDemo();
//     emails = searchDemo.search_text(emails,text);
//     return emails;
// }
// }
