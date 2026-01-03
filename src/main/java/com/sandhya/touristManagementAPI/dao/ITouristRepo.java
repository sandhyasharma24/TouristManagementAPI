package com.sandhya.touristManagementAPI.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sandhya.touristManagementAPI.model.Tourist;

public interface ITouristRepo extends JpaRepository<Tourist,Integer> {

}
