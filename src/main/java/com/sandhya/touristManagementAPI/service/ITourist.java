package com.sandhya.touristManagementAPI.service;

import java.util.List;

import com.sandhya.touristManagementAPI.Exception.TouristNotFoundException;
import com.sandhya.touristManagementAPI.model.Tourist;

public interface ITourist {
	String RegTourist(Tourist tourist);
	Tourist findTouristById(Integer Id) throws TouristNotFoundException;
	List<Tourist> fetchAllTouristInfo();
	String updateTouristInfo(Tourist tourist);
	String updateTouristBudget(Integer id,Integer budget);
<<<<<<< HEAD
	String deleteTourist(Integer id);
=======
>>>>>>> branch 'master' of https://github.com/sandhyasharma24/TouristManagementAPI.git
}
