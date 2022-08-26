package com.example.bikerental.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.bikerental.model.BikeModel;
import com.example.bikerental.model.Booking;
import com.example.bikerental.model.Comments;
import com.example.bikerental.model.CustomerModel;
import com.example.bikerental.model.Payment;
import com.example.bikerental.repository.BikeRepository;
import com.example.bikerental.repository.BookingRepository;
import com.example.bikerental.repository.CommentRepository;
import com.example.bikerental.repository.CustomerRepository;
import com.example.bikerental.repository.PaymentRepository;



@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

    @Autowired
    private BikeRepository bikeRepository;

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private CommentRepository commentRepository;
	
	//To fetch all Customers
	public ResponseEntity<List<BikeModel>> getCustomerBike()   
	{  
		try {
			if(bikeRepository.findAll().isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			else
			{
				return new ResponseEntity<>(bikeRepository.findAll(),HttpStatus.OK);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}  
	}  
 
    //  delete customer
	public ResponseEntity<?> delete(Long id)   
	{  
		try {
			if(customerRepository.findById(id).isPresent()) {
				customerRepository.deleteById(id);
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
	  
    // update customer
	public ResponseEntity<?> update(Long id, CustomerModel customer) {
		try {
			if (customerRepository.findById(id).isPresent()) {
				CustomerModel edit = customerRepository.getReferenceById(id);
				edit.setAddress(customer.getAddress());
				edit.setUserName(customer.getUserName());
				edit.setMobileNumber(customer.getMobileNumber());
				edit.setGender(customer.getGender());
                edit.setImage(customer.getImage());
				return new ResponseEntity<>(customerRepository.save(edit), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

    //get customer by id
    public ResponseEntity<?> getCustomerById(Long id) {
        try{
            if (customerRepository.findById(id).isPresent()) {
                return new ResponseEntity<>(customerRepository.getReferenceById(id),HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
          
	public ResponseEntity<Payment> validatePayment(Payment payment) {
		Payment p = paymentRepository.findByCardNumber(payment.getCardNumber());
		if (p==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			if(p.getCardNumber() == payment.getCardNumber() && p.getCardType().equals(payment.getCardType()) &&
				p.getExpiryMM() == payment.getExpiryMM() &&	p.getExpiryYY() == payment.getExpiryYY() &&	
				p.getName().equals(payment.getName()) && p.getCvv() == payment.getCvv()){
					return new ResponseEntity<>(HttpStatus.OK);
			}
			else {
				
				return new ResponseEntity<>(HttpStatus.FORBIDDEN);
			}
		}
	}
	

	
  
}
