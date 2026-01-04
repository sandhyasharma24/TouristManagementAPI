package com.sandhya.touristManagementAPI.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sandhya.touristManagementAPI.Exception.TouristNotFoundException;
import com.sandhya.touristManagementAPI.model.Tourist;
import com.sandhya.touristManagementAPI.service.ITourist;

@RestController
public class TouristAPI {
	@Autowired
	private ITourist service;
	
	@PostMapping("/regTourist")
	public ResponseEntity<String> registerTourist(@RequestBody Tourist tourist) {
		return new ResponseEntity<>(service.RegTourist(tourist),HttpStatus.CREATED);
	}
	
	@GetMapping("/getTourist/{id}")
	public ResponseEntity<Tourist> getTouristById(@PathVariable Integer id) throws TouristNotFoundException{
		Tourist saved = service.findTouristById(id);
		return new ResponseEntity<Tourist>(saved,HttpStatus.OK);
	}
	
	@GetMapping("/getTouristInfo")
	public ResponseEntity<List<Tourist>> getAllTouristInfo() {
	        List<Tourist> tour = service.fetchAllTouristInfo();
	        return new ResponseEntity<>(tour, HttpStatus.OK);
	}
	
	@PutMapping("/updateTourist")
	public ResponseEntity<String> updateTouristInfo(@RequestBody() Tourist tourist) {
	        String tour = service.updateTouristInfo(tourist);
	        return new ResponseEntity<>(tour, HttpStatus.OK);
	}
	
	@PatchMapping("/updateTouristBudget/{id}/{budget}")
	public ResponseEntity<String> updateTouristBudget(@PathVariable() Integer id,@PathVariable() Integer budget){
			String tour=service.updateTouristBudget(id, budget);
			return new ResponseEntity<String>(tour,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteTourist/{id}")
	public ResponseEntity<String> updateTouristBudget(@PathVariable() Integer id){
			String tour=service.deleteTourist(id);
			return new ResponseEntity<String>(tour,HttpStatus.OK);
	}
	


	

}
