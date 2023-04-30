package com.geekster.University.Event.Management.controller;

import com.geekster.University.Event.Management.models.EventModel;
import com.geekster.University.Event.Management.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;

@RestController
public class EventController {
    @Autowired
    EventService eventService;
    @PostMapping("/addEvent")
    public String AddEvent(@RequestBody ArrayList<EventModel> eventList){
        return eventService.addEventDetails(eventList);
    }
    @PutMapping("/updateEvent")
    public void updateEvent(@RequestBody EventModel eventList){
         eventService.updateEventDetails(eventList);
    }
    @DeleteMapping("/deleteEvent/{id}")
    public void deleteEvent(@PathVariable int id){
        eventService.deleteEventeById(id);
    }
    @GetMapping("/getAllEventsByDate/{date}")
        public ArrayList<EventModel> getAllEventsByDate(@PathVariable LocalDate date){
        return eventService.allEventsByDate(date);
    }

}
