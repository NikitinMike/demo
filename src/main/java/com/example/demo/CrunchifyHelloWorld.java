package com.example.demo;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.Set;

/*
 * author: Crunchify.com
 *
 */

@RestController
public class CrunchifyHelloWorld {

    @RequestMapping("/welcome")
//    public ModelAndView helloWorld() {
    public String helloWorld() {

        String message = "<br><div style='text-align:center;'>"
                + "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
//        return "welcome";
//        return new ModelAndView("welcome", "message", message);

        try {
//---------- Connecting DataBase -------------------------//
            MongoClient mongoClient = new MongoClient("localhost", 27017);
//---------- Creating DataBase ---------------------------//
            MongoDatabase db = mongoClient.getDatabase("javatpoint");
//---------- Creating Collection -------------------------//
            MongoCollection<Document> table = db.getCollection("employee");
//---------- Creating Document ---------------------------//
            Document doc = new Document("name", "Peter John");
            doc.append("id", 12);
//----------- Inserting Data ------------------------------//
            table.insertOne(doc);
        } catch (Exception e) {
            System.out.println(e);
        }

        return message;
    }
}