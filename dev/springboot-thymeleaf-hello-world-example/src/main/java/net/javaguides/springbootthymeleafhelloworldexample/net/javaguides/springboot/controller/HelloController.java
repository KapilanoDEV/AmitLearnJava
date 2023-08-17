package net.javaguides.springbootthymeleafhelloworldexample.net.javaguides.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    @GetMapping({"form"})
    public String hello() {
        return "form";

    }

    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
    public String hello(@RequestParam String name, Model model) {
        String thegreeting = "Hello, " + name + "!";
        model.addAttribute("greeting", thegreeting);
        return "hello";
    }

    @GetMapping("hello/{name}")
    public String helloPath(@PathVariable String name, Model model) {
        String thegreeting = "Hello, " + name + "!";
        model.addAttribute("greeting", thegreeting);
        return "hello";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model) {
        List<String> people = new ArrayList<>();
        people.add("Plutarch");
        people.add("Minerva");
        people.add("Lucretia");

        model.addAttribute("names", people);
        return "hello-list";
    }
}
