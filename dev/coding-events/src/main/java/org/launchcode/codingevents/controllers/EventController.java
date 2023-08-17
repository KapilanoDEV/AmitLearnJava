package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

    private static List<String> events = new ArrayList<>();

    // lives at /events/display
    @GetMapping("display")
    public String displayAllEvents(Model model) {
     //   List<String> events = new ArrayList<>();

//        events.add("Anti-Trump Demo");
//        events.add("Anti-LGBTQ Demo");
//        events.add("Anti-OIL Demo");
//        events.add("Chiswick Car boot Sale");

        model.addAttribute("eventList",events);
        return "events/index";
    }

    // lives at /events/create
    @GetMapping("create")
    public String renderCreateEventForm() {
        return "events/create";
    }

    // lives at /events/create
    @PostMapping("create")
    public String createEvent(@RequestParam String eventName) {
        events.add(eventName);
        return "redirect:/events/display";
    }
}
