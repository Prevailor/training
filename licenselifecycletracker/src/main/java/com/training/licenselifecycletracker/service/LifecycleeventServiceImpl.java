package com.training.licenselifecycletracker.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.training.licenselifecycletracker.entities.Device;
import com.training.licenselifecycletracker.entities.LifecycleEvent;
import com.training.licenselifecycletracker.repositories.LifecycleEventRepository;

@Service
public class LifecycleeventServiceImpl implements LifecycleeventService {
	
	@Autowired
    LifecycleEventRepository repo;

	@Override
	public LifecycleEvent addLifeCycleEvent(LifecycleEvent lifecycleevent) {
		return repo.save(lifecycleevent);
	}

	@Override
	public  LifecycleEvent getLifeCycleEventById(Integer eventId) {
		Optional<LifecycleEvent> lifecycleevent = repo.findById(eventId);
		if(lifecycleevent.isPresent()) {
			
			return lifecycleevent.get();
		}else {
		     return null;
		}
	
	}
	@Override
	public List<LifecycleEvent> getLifeCycleEventByEventType(String eventType) {
		 List<LifecycleEvent> lifecycleevent = (List<LifecycleEvent>) repo.findByEventType(eventType);
	        if(lifecycleevent.isEmpty()) {
	        	return null;
	        }
	        return lifecycleevent;
		
	}

	@Override
	public List<LifecycleEvent> getLifeCycleEventByEventDate(Date eventDate) {
		List<LifecycleEvent> lifecycleevent = (List<LifecycleEvent>) repo.findByEventDate(eventDate);
        if(lifecycleevent.isEmpty()) {
        	return null;
        }
        return lifecycleevent;
	}

	@Override
	public List<LifecycleEvent> getLifeCycleEventByDescription(String description) {
		List<LifecycleEvent> lifecycleevent = (List<LifecycleEvent>) repo.findByDescription(description);
        if(lifecycleevent.isEmpty()) {
        	return null;
        }
        return lifecycleevent;
	}

	@Override
	public String deleteLifeCycleEventById(Integer eventId) {
		Optional<LifecycleEvent> lifecycleevent = repo.findById(eventId);
		if (lifecycleevent.isPresent()) {
			repo.deleteById(eventId);
			return "LifecycleEvent with Id " + eventId + " deleted successfully";
		} else {
			return "LifecycleEvent with LifecycleEventId " + eventId + " doesn't exists";
		}
	}

	@Override
	public LifecycleEvent updateLifeCycleEvent(LifecycleEvent lifecycleevent) {
		Optional<LifecycleEvent> lifecycleevents = repo.findById(lifecycleevent.getEventId());
		if (lifecycleevents.isPresent()) {
			return repo.save(lifecycleevent);
		} else {
			return null;
		}
	}

	@Override
	public List<LifecycleEvent> getLifeCycleEventByCategory(String category) {
		List<LifecycleEvent> lifecycleevent = (List<LifecycleEvent>) repo.findByCategory(category);
        if(lifecycleevent.isEmpty()) {
        	return null;
        }
        return lifecycleevent;
	}
	
	@Override
    public ResponseEntity<List<LifecycleEvent>> viewLifecycleEvents()  {
        List<LifecycleEvent> lifecycleevents = (List<LifecycleEvent>) repo.findAll();
        if (lifecycleevents.isEmpty()) {
           return null;
        }
        return ResponseEntity.ok(lifecycleevents);
    }

}
