package com.example.bikerental.model;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Renter")
public class RenterModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "email")
    private String email;
    @Column(name = "password", columnDefinition = "TEXT")
    private String password;
    @Column(name = "mobileNumber")
    private String mobileNumber;
    @Column(name = "userName")
    private String userName;
    @Column(name = "gender")
    private String gender;
    @Column(name = "userRole")
    private String userRole;
    @Column(name = "image", columnDefinition = "TEXT")
    private String image;
    @Column(name = "address")
    private String address;
    @Column(name = "earnings", columnDefinition = "integer default 0")
    private int earnings;
    @Column(name = "isActive")
    private String isActive;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "renter_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    private Set<BikeModel> bike = new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "renter_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    private Set<Booking> booking = new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "renter_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    private Set<Comments> newComment = new HashSet<>();
    

    public Long getId() {
            return id;
        }

    public void setId(Long id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getEarnings() {
        return earnings;
    }

   public void setEarnings(int earnings) {
        this.earnings = earnings;
    }
    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }
    public Set<BikeModel> getBike() {
        return bike;
        }
        
    public void setBike(Set<BikeModel> bike) {
    this.bike = bike;
    }
    public Set<Booking> getBooking() {
        return booking;
    }

    public void setBooking(Set<Booking> booking) {
        this.booking = booking;
    }

    public Set<Comments> getNewComment() {
        return newComment;
    }

    public void setNewComment(Set<Comments> newComment) {
        this.newComment = newComment;
    }
    
    public RenterModel() {
    }

    public RenterModel(Long id, String email, String password, String mobileNumber, String userName, String gender,
    String userRole, String image, String address, int earnings, String isActive, Set<BikeModel> bike,Set<Booking> booking,Set<Comments> newComment) {
   
    this.id = id;
    this.email = email;
    this.password = password;
    this.mobileNumber = mobileNumber;
    this.userName = userName;
    this.gender = gender;
    this.userRole = userRole;
    this.image = image;
    this.address = address;
    this.earnings = earnings;
    this.isActive = isActive;
    this.bike = bike;
    this.booking =booking;
    this.newComment = newComment;
    }

    @Override
    public String toString() {
        return "RenterModel [address=" + address + ", bike=" + bike + ", earnings=" + earnings + ", email=" + email
                + ", gender=" + gender + ", id=" + id + ", image=" + image + ", isActive=" + isActive
                + ", mobileNumber=" + mobileNumber + ", password=" + password + ", userName=" + userName + ", userRole="
                + userRole + "]";
    }

   

    

   

   
   

   

   
   
}