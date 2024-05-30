package com.training.licenselifecycletracker.repositories;

import org.springframework.data.repository.CrudRepository;

import com.training.licenselifecycletracker.entities.LifecycleEvent;

public interface LifecycleEventRepository extends CrudRepository<LifecycleEvent, Integer> {
}