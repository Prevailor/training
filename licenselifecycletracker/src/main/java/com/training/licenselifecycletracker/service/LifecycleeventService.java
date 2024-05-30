package com.training.licenselifecycletracker.service;

import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.training.licenselifecycletracker.entities.Device;
import com.training.licenselifecycletracker.entities.LifecycleEvent;

public interface LifecycleeventService {
	
	//Create
		public LifecycleEvent addLifeCycleEvent(LifecycleEvent lifecycleevent);
		//Retrieve
		public LifecycleEvent getLifeCycleEventById(Integer eventId);
		
		public List<LifecycleEvent> getLifeCycleEventByEventType(String eventType);
		
	
		public List<LifecycleEvent> getLifeCycleEventByEventDate(Date eventDate);
		
		public List<LifecycleEvent> getLifeCycleEventByDescription(String description);
		
		public List<LifecycleEvent> getLifeCycleEventByCategory(String category);
		
		public ResponseEntity<List<LifecycleEvent>> viewLifecycleEvents();
		

		
		//Delete
		public String deleteLifeCycleEventById(Integer eventId);
		
		//Update
		public LifecycleEvent updateLifeCycleEvent(LifecycleEvent lifecycleevent);


}
