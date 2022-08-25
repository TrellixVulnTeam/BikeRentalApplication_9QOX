package com.example.bikerental.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.bikerental.model.AdminModel;
import com.example.bikerental.model.Booking;
import com.example.bikerental.model.CustomerModel;
import com.example.bikerental.model.RenterModel;
import com.example.bikerental.repository.AdminRepository;
import com.example.bikerental.repository.BookingRepository;
import com.example.bikerental.repository.CustomerRepository;
import com.example.bikerental.repository.RenterRepository;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private RenterRepository renterRepository;
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private CustomerRepository customerRepository;

    

    public ResponseEntity<?> saveBookingHistory(Long id,Booking data) {
        System.out.println("this id : "+id);
        Booking booking = new Booking(data.getTotalAmount(),data.getBookingDate(),data.getEndDate(),data.getRenterName(),data.getCustomerName());
        booking.setCustomer(new CustomerModel(id));

        RenterModel renter=renterRepository.findByUserName(data.getRenterName());
        System.out.println(renter.toString());
        booking.setRenter(new RenterModel(renter.getId()));
        updateEarnings(renter.getId(),data.getTotalAmount());

        return new ResponseEntity<>(bookingRepository.save(booking),HttpStatus.OK);
    }

    public void updateEarnings(Long id,double amount) {
        RenterModel renter=renterRepository.getReferenceById(id);
        renter.setEarnings(renter.getEarnings()+amount);
        renterRepository.save(renter);

        AdminModel admin=adminRepository.getReferenceById((long) 1);
        System.out.println(admin.toString());
        admin.setEarnings(admin.getEarnings()+(amount * 0.1));
        System.out.println(admin.toString());
        adminRepository.save(admin);
    }

    //========================get All customer booking=======================
    public ResponseEntity<List<Booking>> getAllBookings(){
        try {
			if(bookingRepository.findAll().isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			else
			{
				return new ResponseEntity<>(bookingRepository.findAll(),HttpStatus.OK);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}  
       
    } 

    //========================get customer booking=======================
    public ResponseEntity<List<Booking>> getCustomerBooking(Long id){
        try {
           
            // System.out.println(bookingRepository.findByCustomer(id));
			if(customerRepository.findById(id).isPresent()) {
               
                List<Booking> bookings=bookingRepository.findAll();
                System.out.println(bookings.toString());

				return new ResponseEntity<>(HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}  
       
    }
    
    
}