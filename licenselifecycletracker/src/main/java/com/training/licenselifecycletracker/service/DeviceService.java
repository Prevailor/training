package com.training.licenselifecycletracker.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.training.licenselifecycletracker.entities.Device;
import com.training.licenselifecycletracker.repositories.DeviceRepository;

@Service
public interface DeviceService {

	//Create
	public Device addDevice(Device device);
	//Retrieve
	public Device getDeviceById(Integer deviceId);
	
	public Device getDeviceByName(String deviceName);
	
	public List<Device> getDeviceByStatus(String status);
	
	public List<Device> getDeviceByDeviceType(String deviceType);
	
	public List<Device> getDeviceByPurchaseDate(Date purchaseDate);
	
	public List<Device> getDeviceByExpirationDate(Date expirationDate);
	
	public List<Device> getDeviceByEndOfSupportDate(Date endOfSupportDate);
	
	public ResponseEntity<List<Device>> viewDevices();
	
	//Delete
	public String deleteDeviceById(Integer deviceId);
	
	//Update
	public Device updateDevice(Device device);
}