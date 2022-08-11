package com.example.bikerental.service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import com.example.bikerental.model.BikeModel;
import com.example.bikerental.repository.BikeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class BikeService {

    @Autowired
	private BikeRepository bikeRepository;
	
//fetch all bikes
	public ResponseEntity<List<BikeModel>> getAllBikes() {
		try {
			if(bikeRepository.findAll().isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			else {
				return new ResponseEntity<>(bikeRepository.findAll() , HttpStatus.OK);
			}
		}
		catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
//adding new bikes
	public ResponseEntity<?> addBikes(BikeModel bike) {
		try {
			if(bikeRepository.existsByBikeNumber(bike.getBikeNumber())) {
				 return new ResponseEntity<>(HttpStatus.CONFLICT);
			}
			else
			   return new ResponseEntity<>(bikeRepository.save(bike),HttpStatus.OK);
		}
		catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }	
	}
//edit bikes
	public ResponseEntity<?> updateBike(Long id, BikeModel bike) {
		try {
            if(bikeRepository.findById(id).isPresent()) {
                BikeModel editBike=bikeRepository.getReferenceById(id);
                editBike.setBikeNumber(bike.getBikeNumber());
                editBike.setBrandName(bike.getBrandName());
                editBike.setModelName(bike.getModelName());
                editBike.setPickUpLocation(bike.getPickUpLocation());
                editBike.setRentAmount(bike.getRentAmount());
                editBike.setAvailability(bike.getAvailability());
    //			editBike.setBikeImage(bike.getBikeImage());
                editBike.setBikeImage(bike.getBikeImage());
                editBike.setDescription(bike.getDescription());
                return new ResponseEntity<>(bikeRepository.save(editBike), HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
		}
		catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }	
	}

//delete bike by id
	public ResponseEntity<?> deleteBikeById(long id) {
		try {
		if(bikeRepository.findById(id).isPresent()) {
			bikeRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		}
		catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }		
    }

	public ResponseEntity<BikeModel> getBikeById(long id) {
		try {
			if(bikeRepository.findById(id).isPresent()) {	
				return new ResponseEntity<>(bikeRepository.getReferenceById(id),HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		catch (Exception e) {
			    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }	
    }
}
