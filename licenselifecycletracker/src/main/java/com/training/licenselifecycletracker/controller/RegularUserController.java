package com.training.licenselifecycletracker.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
@RequestMapping("/regularuser")
public class RegularUserController {
	
	@Autowired
    private DeviceService deviceService;
	
	@Autowired
    private SoftwareService softwareService;
	
	@Autowired
    private LifecycleeventService lifecycleeventService;
	
	@Autowired
    private UserService userService;
	
	
	// Retrieve for Device
	
	
	@GetMapping("/getalldevices")
    public ResponseEntity<?> viewDevices() {
       
            List<Device> devices = (List<Device>) deviceService.viewDevices().getBody();
            return ResponseEntity.ok(devices);
        
    }
	
	@GetMapping("/getdevice")
	public Device getDevice(@RequestParam("id") Integer deviceId)  {
		return  deviceService.getDeviceById(deviceId);
		
	}
	
	
	@GetMapping("/getdevicebyname")
	public ResponseEntity<Device> getMovieByName(@RequestParam("mname") String deviceName){
		Device device = deviceService.getDeviceByName(deviceName);
		return new ResponseEntity<>(device, HttpStatus.FOUND);
	}
	
//	@GetMapping("/getdevicebystatus")
//	public ResponseEntity<Device> getMovieByStatus(@RequestParam("mname") String status){
//	  Device device = deviceService.getDeviceByStatus(status);
//		return new ResponseEntity<>(device, HttpStatus.FOUND);
//	}
	
	@GetMapping("/getdevicesbystatus")
	public ResponseEntity<List<Device>> getDevicesByStatus(@RequestParam("status") String status) {
	    List<Device> devices = deviceService.getDeviceByStatus(status);
	    if (devices != null && !devices.isEmpty()) {
	        return new ResponseEntity<>(devices, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@GetMapping("/getdevicesbydevicetype")
	public ResponseEntity<List<Device>> getDevicesByDeviceType(@RequestParam("deviceType") String deviceType) {
	    List<Device> devices = deviceService.getDeviceByDeviceType(deviceType);
	    if (devices != null && !devices.isEmpty()) {
	        return new ResponseEntity<>(devices, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@GetMapping("/getdevicesbypurchasedate")
	public ResponseEntity<List<Device>> getDevicesByPurchaseDate(@RequestParam("purchaseDate") Date purchaseDate) {
	    List<Device> devices = deviceService.getDeviceByPurchaseDate(purchaseDate);
	    if (devices != null && !devices.isEmpty()) {
	        return new ResponseEntity<>(devices, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@GetMapping("/getdevicesbyexpirationdate")
	public ResponseEntity<List<Device>> getDevicesByExpirationDate(@RequestParam("expirationDate") Date expirationDate) {
	    List<Device> devices = deviceService.getDeviceByExpirationDate(expirationDate);
	    if (devices != null && !devices.isEmpty()) {
	        return new ResponseEntity<>(devices, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@GetMapping("/getdevicesbyendofsupportdate")
	public ResponseEntity<List<Device>> getDevicesByEndOfSupportDate(@RequestParam("endOfSupportDate") Date endOfSupportDate) {
	    List<Device> devices = deviceService.getDeviceByEndOfSupportDate(endOfSupportDate);
	    if (devices != null && !devices.isEmpty()) {
	        return new ResponseEntity<>(devices, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	// Retrieve for Software
	
	
	@GetMapping("/getallsoftwares")
    public ResponseEntity<?> viewSoftwares() {
       
            List<Software> softwares = (List<Software>) softwareService.viewSoftwares().getBody();
            return ResponseEntity.ok(softwares);
        
    }
	
	@GetMapping("/getsoftware")
	public Software getSoftware(@RequestParam("id") Integer softwareId)  {
		return  softwareService.getSoftwareById(softwareId);
		
	}
	
	@GetMapping("/getsoftwarebyname")
	public ResponseEntity<Software> getSoftwareByName(@RequestParam("mname") String softwareName){
		Software software = softwareService.getSoftwareByName(softwareName);
		return new ResponseEntity<>(software, HttpStatus.FOUND);
	}
	
	@GetMapping("/getsoftwarebystatus")
	public ResponseEntity<List<Software>> getSoftwareByStatus(@RequestParam("status") String status) {
	    List<Software> softwares = softwareService.getSoftwareByStatus(status);
	    if (softwares != null && !softwares.isEmpty()) {
	        return new ResponseEntity<>(softwares, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@GetMapping("/getsoftwarebylicensekey")
	public ResponseEntity<List<Software>> getSoftwareByLicenseKey(@RequestParam("licenseKey") String licenseKey) {
	    List<Software> software = softwareService.getSoftwareByLicenseKey(licenseKey);
	    if (software != null && !software.isEmpty()) {
	        return new ResponseEntity<>(software, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@GetMapping("/getsoftwarebypurchasedate")
	public ResponseEntity<List<Software>> getSoftwareByPurchaseDate(@RequestParam("purchaseDate") Date purchaseDate) {
	    List<Software> software = softwareService.getSoftwareByPurchaseDate(purchaseDate);
	    if (software != null && !software.isEmpty()) {
	        return new ResponseEntity<>(software, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@GetMapping("/getsoftwarebyexpirationdate")
	public ResponseEntity<List<Software>> getSoftwareByExpirationDate(@RequestParam("expirationDate") Date expirationDate) {
	    List<Software> software = softwareService.getSoftwareByExpirationDate(expirationDate);
	    if (software != null && !software.isEmpty()) {
	        return new ResponseEntity<>(software, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@GetMapping("/getsoftwarebyendofsupportdate")
	public ResponseEntity<List<Software>> getSoftwareByEndOfSupportDate(@RequestParam("supportEndDate") Date supportEndDate) {
	    List<Software> software = softwareService.getSoftwareBySupportEndDate(supportEndDate);
	    if (software!= null && !software.isEmpty()) {
	        return new ResponseEntity<>(software, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	
	//Retriev for LifeCycleEvent
	
	@GetMapping("/getlifecycleevent")
	public LifecycleEvent getLifeCycleEvent(@RequestParam("id") Integer eventId)  {
		return  lifecycleeventService.getLifeCycleEventById(eventId);
		
	}
	
	@GetMapping("/getLifeCycleEventByEventType")
    public ResponseEntity<List<LifecycleEvent>> getLifeCycleEventByEventType(@RequestParam String eventType) {
        List<LifecycleEvent> events = lifecycleeventService.getLifeCycleEventByEventType(eventType);
        if (events != null && !events.isEmpty()) {
            return ResponseEntity.ok(events);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
	@GetMapping("/getLifeCycleEventByEventDate")
    public ResponseEntity<List<LifecycleEvent>> getLifeCycleEventByEventDate(@RequestParam Date eventDate) {
        List<LifecycleEvent> events = lifecycleeventService.getLifeCycleEventByEventDate(eventDate);
        if (events != null && !events.isEmpty()) {
            return ResponseEntity.ok(events);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getLifeCycleEventByDescription")
    public ResponseEntity<List<LifecycleEvent>> getLifeCycleEventByDescription(@RequestParam String description) {
        List<LifecycleEvent> events = lifecycleeventService.getLifeCycleEventByDescription(description);
        if (events != null && !events.isEmpty()) {
            return ResponseEntity.ok(events);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/getLifeCycleEventByCategory")
    public ResponseEntity<List<LifecycleEvent>> getLifeCycleEventByCategory(@RequestParam String category) {
        List<LifecycleEvent> events = lifecycleeventService.getLifeCycleEventByCategory(category);
        if (events != null && !events.isEmpty()) {
            return ResponseEntity.ok(events);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //  user
    
    @GetMapping("getuserbyid")
    public ResponseEntity<User> getUserById(@PathVariable Integer userId) {
        User user = userService.getUserById(userId);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return null;
        }
    }
    
    }

	
	
	

	

