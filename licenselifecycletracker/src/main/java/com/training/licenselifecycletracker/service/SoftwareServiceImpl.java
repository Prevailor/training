package com.training.licenselifecycletracker.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.licenselifecycletracker.entities.Device;
import com.training.licenselifecycletracker.entities.Software;
import com.training.licenselifecycletracker.entities.Software;
import com.training.licenselifecycletracker.repositories.SoftwareRepository;
@Service
public class SoftwareServiceImpl implements SoftwareService{
	
	@Autowired
    SoftwareRepository repo;

	@Override
	public Software addSoftware(Software software) {
		return repo.save(software);
	}

	@Override
	public Software getSoftwareById(Integer softwareId) {
         Optional<Software> software = repo.findById(softwareId);
			if(software.isPresent()) {
				
				return software.get();
			}else {
			     return null;
			}
		
	}

	

	

	
	public Software getSoftwareByName(String softwareName)  {
		Software software= repo.findBySoftwareName(softwareName);
		if(software != null) {		
			return software;
		}else {
			
			return null;
		}
	}

	public List<Software> getSoftwareByStatus(String status) {
        List<Software> software = (List<Software>) repo.findByStatus(status);
        if(software.isEmpty()) {
        	return null;
        }
        return software;
    }
	
	@Override
	public Software updateSoftware(Software software) {
		Optional<Software> softwares = repo.findById(software.getSoftwareId());
		if (softwares.isPresent()) {
			return repo.save(software);
		} else {
			return null;
		}
	}

	

	@Override
	public String deleteSoftwareById(Integer softwareId) {
		Optional<Software> person = repo.findById(softwareId);
		if (person.isPresent()) {
			repo.deleteById(softwareId);
			return "Software with Id " + softwareId + " deleted successfully";
		} else {
			return "Software with softwareId " + softwareId + " doesn't exists";
		}
	}
	
	@Override
	public List<Software> getSoftwareByLicenseKey(String licenseKey) {
		 List<Software> software = (List<Software>) repo.findByLicenseKey(licenseKey);
	        if(software.isEmpty()) {
	        	return null;
	        }
	        return software;
		
	}

	@Override
	public List<Software> getSoftwareByPurchaseDate(Date purchaseDate) {
		List<Software> software = (List<Software>) repo.findByPurchaseDate(purchaseDate);
        if(software.isEmpty()) {
        	return null;
        }
        return software;
	}

	@Override
	public List<Software> getSoftwareByExpirationDate(Date expirationDate) {
		List<Software> software = (List<Software>) repo.findByExpirationDate(expirationDate);
        if(software.isEmpty()) {
        	return null;
        }
        return software;
	}

	@Override
	public List<Software> getSoftwareBySupportEndDate(Date supportEndDate) {
		List<Software> software = (List<Software>) repo.findBySupportEndDate(supportEndDate);
        if(software.isEmpty()) {
        	return null;
        }
        return software;
	}

	
	
	
}
