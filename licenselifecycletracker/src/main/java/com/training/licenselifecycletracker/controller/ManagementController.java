package com.training.licenselifecycletracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.licenselifecycletracker.entities.LifecycleEvent;
import com.training.licenselifecycletracker.entities.Software;
import com.training.licenselifecycletracker.service.LifecycleeventService;

@RestController
@RequestMapping("/management")
public class ManagementController {
	
	
	@Autowired
    private LifecycleeventService lifecycleeventService;
	
	
	 // Endpoints for Management actions
	
	
	 @GetMapping("/management/lifecycle/{relatedId}")
	 
	    public ResponseEntity<?> viewLifecycleEvents() {
	       
	            List<LifecycleEvent> lifecycleevents = (List<LifecycleEvent>) lifecycleeventService.viewLifecycleEvents().getBody();
	            return ResponseEntity.ok(lifecycleevents);
	        
	    }
	
	 @GetMapping("/management/reports/{assetId}")
	 public void generateLifecycleReports(@PathVariable int assetId) {
	     // Call corresponding service method
	 }

}