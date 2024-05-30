package com.training.licenselifecycletracker.repositories;

import org.springframework.data.repository.CrudRepository;

import com.training.licenselifecycletracker.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}