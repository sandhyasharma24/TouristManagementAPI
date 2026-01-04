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

	@Override
	public String updateTouristInfo(Tourist tourist) {
		Optional<Tourist> tour = repo.findById(tourist.getId());
		if(tour.isPresent()) {
			repo.save(tourist);
			return "tourist info is update with id "+tourist.getId();
			}
		else {
			throw new TouristNotFoundException("Tourist could not be found to be updated");
		}
	}

	@Override
	public String updateTouristBudget(Integer id, Integer budget) {
		Optional<Tourist> optional = repo.findById(id);
		if(optional.isPresent()) {
			Tourist tourist = optional.get();
			tourist.setBudget(budget);
			repo.save(tourist);
			return "Tourist budget Info Updated successfully";
		}
		else {
			throw new TouristNotFoundException("Tourist could not be found to be updated");
		}
		
	}

}
