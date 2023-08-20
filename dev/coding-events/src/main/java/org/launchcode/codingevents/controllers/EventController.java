package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String processCreateEventsForm(@ModelAttribute Event newEvent) {
        EventData.add(newEvent);
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

    @GetMapping("edit/{eventId}")
    public String displayEditForm(Model model, @PathVariable int eventId) {
        Event eventToEdit = EventData.getById(eventId);
        model.addAttribute("event", eventToEdit);
        String title = "Edit Event " + eventToEdit.getName() + " (id=" + eventToEdit.getId() + ")";
        model.addAttribute("title",title);

        return "events/edit";
    }

    @PostMapping("edit")
    public String processEditForm(int eventId, String name, String description) {
        Event eventToEdit = EventData.getById(eventId);
        eventToEdit.setName(name);
        eventToEdit.setDescription(description);
        return "redirect:";
    }

}
