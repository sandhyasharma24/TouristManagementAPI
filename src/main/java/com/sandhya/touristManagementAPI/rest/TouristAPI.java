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
	    try {
	        List<Tourist> tour = service.fetchAllTouristInfo();
	        return new ResponseEntity<>(tour, HttpStatus.OK);
	    } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }
	}
	
	@PutMapping("/updateTourist")
	public ResponseEntity<String> updateTouristInfo(@RequestBody() Tourist tourist) {
	    try {
	        String tour = service.updateTouristInfo(tourist);
	        return new ResponseEntity<>(tour, HttpStatus.OK);
	    } catch (Exception e) {
	        return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
	    }
	}
	
	@PatchMapping("/updateTouristBudget/{id}/{budget}")
	public ResponseEntity<String> updateTouristBudget(@PathVariable() Integer id,@PathVariable() Integer budget){
		try {
			String tour=service.updateTouristBudget(id, budget);
			return new ResponseEntity<String>(tour,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/deleteTourist/{id}")
	public ResponseEntity<String> updateTouristBudget(@PathVariable() Integer id){
		try {
			String tour=service.deleteTourist(id);
			return new ResponseEntity<String>(tour,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	

		@PutMapping("/updateTourist")
	public ResponseEntity<String> updateTouristInfo(@RequestBody() Tourist tourist) {
	    try {
	        String tour = service.updateTouristInfo(tourist);
	        return new ResponseEntity<>(tour, HttpStatus.OK);
	    } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }
	}
	
	@PatchMapping("/updateTouristBudget/{id}/{budget}")
	public ResponseEntity<String> updateTouristBudget(@PathVariable() Integer id,@PathVariable() Integer budget){
		try {
			String tour=service.updateTouristBudget(id, budget);
			return new ResponseEntity<String>(tour,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}

	

}
