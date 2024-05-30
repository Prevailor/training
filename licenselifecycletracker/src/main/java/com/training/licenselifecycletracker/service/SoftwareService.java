package com.training.licenselifecycletracker.service;


import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.training.licenselifecycletracker.entities.Device;
import com.training.licenselifecycletracker.entities.Software;
import com.training.licenselifecycletracker.entities.Software;

public interface SoftwareService {
	
	//Create
		public Software addSoftware(Software software);
		//Retrieve
		public Software getSoftwareById(Integer softwareId);
		
		public Software getSoftwareByName(String softwareName);
		
		public List<Software> getSoftwareByStatus(String status);
		
		public List<Software> getSoftwareByLicenseKey(String licenseKey);
		
		public List<Software> getSoftwareByPurchaseDate(Date purchaseDate);
		
		public List<Software> getSoftwareByExpirationDate(Date expirationDate);
		
		public List<Software> getSoftwareBySupportEndDate(Date supportEndDate);
		
		public ResponseEntity<List<Software>> viewSoftwares();

		
		//Delete
		public String deleteSoftwareById(Integer softwareId);
		
		//Update
		public Software updateSoftware(Software software);
		
}
