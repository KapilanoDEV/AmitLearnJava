package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("events/")
public class EventController {


    // lives at /events/
    @GetMapping
    public String displayAllEvents(Model model) {

        model.addAttribute("eventList",EventData.getAll());
        return "events/index";
    }

    // lives at /events/create
    @GetMapping("create")
    public String renderCreateEventForm() {
        return "events/create";
    }

    // lives at /events/create
    @PostMapping("create")
    public String processCreateEventsForm(@RequestParam String eventName,@RequestParam String eventDescription) {
        EventData.add(new Event(eventName,eventDescription));
        return "redirect:";
    }
    
    // handler method that just displays the form
    // Model passes data into the template
    @GetMapping("delete")
    public String displayDeleteEventForm(Model model) {
    	model.addAttribute("title", "Delete Events");
    	model.addAttribute("events", EventData.getAll());
    	return "events/delete";
    }
    
    @PostMapping("delete")
    public String processDeleteEventsForm(@RequestParam(required = false) int[] eventIds) {
    	
    	if (eventIds != null) {
            for (int id : eventIds) {
                EventData.remove(id);
            }
        }
    	
    	return "redirect:";
    }
}
