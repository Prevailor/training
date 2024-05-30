package com.training.licenselifecycletracker.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.licenselifecycletracker.entities.Device;
import com.training.licenselifecycletracker.entities.Software;
import com.training.licenselifecycletracker.service.DeviceService;
import com.training.licenselifecycletracker.service.SoftwareService;


@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private DeviceService deviceService;
    
    @Autowired
    private SoftwareService softwareService;

    // Create Devices
    
    @PostMapping("/addDevices")
    
    public ResponseEntity<Device> addDevice(@RequestBody Device device) {
        Device devices = deviceService.addDevice(device);
        return ResponseEntity.ok(devices);
    }
    
    
    //Update Device
    
    @PutMapping("/updateDevices")
    public Device updateDevice(@RequestBody Device device) {
    	return deviceService.updateDevice(device);
        
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
}
