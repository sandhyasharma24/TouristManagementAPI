package com.sandhya.touristManagementAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandhya.touristManagementAPI.Exception.TouristNotFoundException;
import com.sandhya.touristManagementAPI.dao.ITouristRepo;
import com.sandhya.touristManagementAPI.model.Tourist;
@Service
public class TouristImplementation implements ITourist {
	
	@Autowired
	private ITouristRepo repo;

	@Override
	public String RegTourist(Tourist tourist) {
	Tourist tour = repo.save(tourist);
	return "Tourist info registered with id " +tour.getId();
	}

	@Override
	public Tourist findTouristById(Integer Id) throws TouristNotFoundException {
		Optional<Tourist> tour = repo.findById(Id);
		return tour.orElseThrow(()->new TouristNotFoundException("tourist with this id was not found"));
	}

	@Override
	public List<Tourist> fetchAllTouristInfo() {
		List<Tourist> list = repo.findAll();
		return list;
	}

}
