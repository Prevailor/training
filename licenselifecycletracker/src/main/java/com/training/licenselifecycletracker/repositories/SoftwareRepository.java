package com.training.licenselifecycletracker.repositories;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.training.licenselifecycletracker.entities.Software;
import com.training.licenselifecycletracker.entities.Software;

@Repository
public interface SoftwareRepository extends CrudRepository<Software, Integer> {
	public Software findBySoftwareName(String softwareName);
	public List<Software> findByStatus(String status);
	public List<Software> findByLicenseKey(String licenseKey);
	public List<Software> findByPurchaseDate(Date purchaseDate);
	public List<Software> findByExpirationDate(Date expirationDate);
	public List<Software> findBySupportEndDate(Date supportEndDate);
	
}