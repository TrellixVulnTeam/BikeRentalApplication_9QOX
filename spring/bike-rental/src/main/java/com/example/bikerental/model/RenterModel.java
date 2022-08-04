package com.example.bikerental.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

    public RenterModel(Long id, String email, String password, String mobileNumber, String userName, String gender,
        String userRole, String image, String address, int earnings) {
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
}

    public RenterModel() {
    }
    

    

    
    
}