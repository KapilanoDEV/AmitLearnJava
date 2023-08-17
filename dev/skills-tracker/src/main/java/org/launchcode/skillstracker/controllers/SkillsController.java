package org.launchcode.skillstracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//Controllers relay messages between data (model) and views in
// an MVC application
@Controller
@ResponseBody
public class SkillsController {

    @GetMapping
    public String skills() {
        return "<html>" +
                "<body>" +
                "<h1>Skills Tracker</h1>" +
                "<h2>We have a few skills we would like to learn. Here is the list!</h2>" +
                "<ol>" +
                "<li>Java</li>" +
                "<li>JavaScript</li>" +
                "<li>Python</li>" +
                "</body>" +
                "</html>";
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hi")
    public String helloLangQueryParam(@RequestParam String Name, @RequestParam String language1, @RequestParam String language2, @RequestParam String language3) {
        //return createMessage(Name, language);
        return Name + "<br><ol><li>" + language1 + "</li>" + "<li>" + language2 + "</li>" +  "<li>" + language3 + "</li></ol>";

    }

//    public static String createMessage(String n, String l) {
//        String proglang = "";
//
//        if (l.equals("English")) {
//            greeting = "Hello";
//        } else if (l.equals("French")) {
//            greeting = "Bonjour";
//        } else if (l.equals("German")) {
//            greeting = "Auf Weidersehn";
//        } else if (l.equals("Spanish")) {
//            greeting = "Hola";
//        } else if (l.equals("Italian")) {
//            greeting = "Bonjourno";
//        }
//        return greeting + " " + n + "!";
//    }

    @GetMapping("form")
    public String skillsFormName() {
        return "<html>" +
                "<body>" +
                "<form action='hi', method='post'>" +
                "<label for=\"name\">Name: </label>" +
                "<input type='text' id=\"name\" name='Name'><br>" +
                "<label for=\"language-select\">My favorite language:</label>" +
                "<select name=\"language1\" id=\"language-select\">\n" +
                "  <option value=\"\">--Please choose an option--</option>\n" +
                "  <option value=\"Java\">Java</option>\n" +
                "  <option value=\"JavaScript\">JavaScript</option>\n" +
                "  <option value=\"Python\">Python</option>\n" +
                "</select>\n" + "<br>" +
                "<label for=\"language-select\">My second favorite language:</label>" +
                "<select name=\"language2\" id=\"language-select\">\n" +
                "  <option value=\"\">--Please choose an option--</option>\n" +
                "  <option value=\"Java\">Java</option>\n" +
                "  <option value=\"JavaScript\">JavaScript</option>\n" +
                "  <option value=\"Python\">Python</option>\n" +
                "</select>\n" + "<br>" +
                "<label for=\"language-select\">My third favorite language:</label>" +
                "<select name=\"language3\" id=\"language-select\">\n" +
                "  <option value=\"\">--Please choose an option--</option>\n" +
                "  <option value=\"Java\">Java</option>\n" +
                "  <option value=\"JavaScript\">JavaScript</option>\n" +
                "  <option value=\"Python\">Python</option>\n" +
                "</select>\n" + "<br>" +
                "<input type='submit' value='Submit'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }
}
