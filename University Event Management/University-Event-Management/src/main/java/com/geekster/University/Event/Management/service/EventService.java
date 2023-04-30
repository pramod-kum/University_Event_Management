package com.geekster.University.Event.Management.service;

import com.geekster.University.Event.Management.models.EventModel;
import com.geekster.University.Event.Management.repository.IEventDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
public class EventService {
    @Autowired
    IEventDao eventDao;

    public String addEventDetails(ArrayList<EventModel> eventList) {
        Iterable<EventModel> addStatus = eventDao.saveAll(eventList);
        if(addStatus != null){
            return "YES";
        }else {
            return "NO";
        }
    }

//    public String updateEventDetails(Integer id , EventModel eventDetails) {
//        boolean updateStatus = eventDao.existsById(id);
//        if(updateStatus){
//            eventDao.save(eventDetails);
//            return "YES";
//        }else {
//            return "NO";
//        }
//    }

    public void deleteEventeById(int id) {
        eventDao.deleteById(id);
    }

    public ArrayList<EventModel> allEventsByDate(LocalDate date) {
        return eventDao.findByDate(date);
    }
    @Transactional
    public void updateEventDetails(EventModel eventList){
        eventDao.updateEventAllDetaild(eventList.getEventId() , eventList.getEventName() , eventList.getLocationOfEvent() , eventList.getDate() , eventList.getStartTime() , eventList.getEndTime());
    }
}
