package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.*;
//Controllers relay messages between data (model) and views in
// an MVC application
@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {
    // Handles request at path /hello/Spring
    @GetMapping("Spring")
    public String hello() {
        return "Hello, Spring!";
    }

    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    //Handles requests of the form /hello/hi?firstName=LaunchCode?friend=Amit
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hi")
    public String helloNameQueryParam(@RequestParam String firstName,@RequestParam String friend) {
        return "Hello, " + firstName + " " + friend + "!";
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hiWorld")
    public String helloLangQueryParam(@RequestParam String firstName,@RequestParam String language) {
        return createMessage(firstName, language);
    }

    public static String createMessage(String n, String l) {
        String greeting = "";

        if (l.equals("English")) {
            greeting = "Hello";
        } else if (l.equals("French")) {
            greeting = "Bonjour";
        } else if (l.equals("German")) {
            greeting = "Auf Weidersehn";
        } else if (l.equals("Spanish")) {
            greeting = "Hola";
        } else if (l.equals("Italian")) {
            greeting = "Bonjourno";
        }
        return greeting + " " + n + "!";
    }

    //Handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloName(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    //Handles form requests that route to the helloNameQueryParam above
    //When the form method is get I see context hello/hi?firstName=Minerva
    //..in the address bar. If it is POST then hello/hi only
    @GetMapping("formFriend")
    public String helloFormName() {
        return "<html>" +
                "<body>" +
                "<form action='hi', method='post'>" +
                "<input type='text' name='firstName'>" +
                "<input type='text', name='friend'>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    @GetMapping("formLang")
    public String helloFormNameLang() {
        return "<html>" +
                "<body>" +
                "<form action='hiWorld', method='post'>" +
                "<input type='text' name='firstName'>" +
                "<label for=\"language-select\">Choose a language:</label>" +
                "<select name=\"language\" id=\"language-select\">\n" +
                "  <option value=\"\">--Please choose an option--</option>\n" +
                "  <option value=\"English\">English</option>\n" +
                "  <option value=\"French\">French</option>\n" +
                "  <option value=\"German\">German</option>\n" +
                "  <option value=\"Spanish\">Spanish</option>\n" +
                "  <option value=\"Italian\">Italian</option>\n" +
                "</select>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    @GetMapping("form")
    public String helloTl() {
        return "form";
    }
}
