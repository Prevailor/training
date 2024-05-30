package com.training.licenselifecycletracker.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.licenselifecycletracker.entities.Device;
import com.training.licenselifecycletracker.entities.LifecycleEvent;
import com.training.licenselifecycletracker.entities.Software;
import com.training.licenselifecycletracker.entities.User;
import com.training.licenselifecycletracker.service.DeviceService;
import com.training.licenselifecycletracker.service.LifecycleeventService;
import com.training.licenselifecycletracker.service.SoftwareService;
import com.training.licenselifecycletracker.service.UserService;


@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private DeviceService deviceService;
    
    @Autowired
    private SoftwareService softwareService;
    
    @Autowired
    private LifecycleeventService lifecycleeventService;
    
    @Autowired
    private UserService userService;
	

    // Create Devices
    
    @PostMapping("/addDevices")
    
    public ResponseEntity<Device> addDevice(@RequestBody Device device) {
        Device devices = deviceService.addDevice(device);
        return ResponseEntity.ok(devices);
    }
    
    @GetMapping("/devices")
    public ResponseEntity<?> viewDevices() {
        
            List<Device> devices = (List<Device>) deviceService.viewDevices().getBody();
            return ResponseEntity.ok(devices);
        
    }
    
    //Update Device
    
    @PutMapping("/updateDevices")
    public Device updateDevice(@RequestBody Device device) {
    	return deviceService.updateDevice(device);
        
    }
    
    //delete device
    
    @PostMapping("deletedevice")
    public ResponseEntity<String> deleteDeviceById(@PathVariable Integer deviceId) {
        String result = deviceService.deleteDeviceById(deviceId);
        if (result != null) {
            return ResponseEntity.ok(result);
        } else {
            return null;
        }
    }
    
    
    // Create Software
    
    @PostMapping("/addsoftwares")
    
    public ResponseEntity<Software> addSoftware(@RequestBody Software software) {
        Software softwares = softwareService.addSoftware(software);
        return ResponseEntity.ok(softwares);
    }

     //Update Software

      @PutMapping("/updateSoftware")
      public Software updateSoftware(@RequestBody Software software) {
	    return softwareService.updateSoftware(software);
    
      }
      
      // delete software
      
      @PostMapping("delete/software/{softwareId}")
      public ResponseEntity<String> deleteSoftwareById(@PathVariable Integer softwareId) {
          String result = softwareService.deleteSoftwareById(softwareId);
          if (result != null) {
              return ResponseEntity.ok(result);
          } else {
              return ResponseEntity.notFound().build();
          }
      }
      
      
   // Create LifecycleEvent
      
      @PostMapping("/addLifecycleEvent")
      
      public ResponseEntity<LifecycleEvent> addLifecycleEvent(@RequestBody LifecycleEvent lifecycleevent) {
    	  LifecycleEvent lifecycleevents = lifecycleeventService.addLifeCycleEvent(lifecycleevent);
          return ResponseEntity.ok(lifecycleevents);
      }
      
      
      // delete life cycle event
      @PostMapping("/deleteLifeCycleEvent/{eventId}")
      public ResponseEntity<String> deleteLifeCycleEventById(@PathVariable Integer eventId) {
          String result = lifecycleeventService.deleteLifeCycleEventById(eventId);
          if (result != null) {
              return ResponseEntity.ok(result);
          } else {
              return null;
          }
   }
      
      
      
      // user
      
      
      @PostMapping("/add")
      public ResponseEntity<User> addUser(@RequestBody User user) {
          User addedUser = userService.addUser(user);
          return ResponseEntity.ok(addedUser);
      }

      @GetMapping("getuserbyid")
      public ResponseEntity<User> getUserById(@PathVariable Integer userId) {
          User user = userService.getUserById(userId);
          if (user != null) {
              return ResponseEntity.ok(user);
          } else {
              return null;
          }
      }

      @PostMapping("deleteuser")
      public ResponseEntity<String> deleteUserById(@PathVariable Integer userId) {
          String result = userService.deleteUserById(userId);
          if (result != null) {
              return ResponseEntity.ok(result);
          } else {
              return null;
          }
      }

      @PutMapping("/update")
      public ResponseEntity<User> updateUser(@RequestBody User user) {
          User updatedUser = userService.updateUser(user);
          if (updatedUser != null) {
              return ResponseEntity.ok(updatedUser);
          } else {
              return null;
          }
      }
}
