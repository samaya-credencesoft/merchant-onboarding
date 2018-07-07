package com.csoft.payone.auth.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ApplicationUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
	private String address;
    private String mobileNumber;
    private String landphoneNumber;
    private String logoUrl;
    private String paypalKey;
    private String firstName;
    private String lastName;
    private String email;
    
    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getAddress() {
  		return address;
  	}

  	public void setAddress(String address) {
  		this.address = address;
  	}

  	public String getMobileNumber() {
  		return mobileNumber;
  	}

  	public void setMobileNumber(String mobileNumber) {
  		this.mobileNumber = mobileNumber;
  	}

  	public String getLandphoneNumber() {
  		return landphoneNumber;
  	}

  	public void setLandphoneNumber(String landphoneNumber) {
  		this.landphoneNumber = landphoneNumber;
  	}

  	public String getLogoUrl() {
  		return logoUrl;
  	}

  	public void setLogoUrl(String logoUrl) {
  		this.logoUrl = logoUrl;
  	}

  	public String getPaypalKey() {
  		return paypalKey;
  	}

  	public void setPaypalKey(String paypalKey) {
  		this.paypalKey = paypalKey;
  	}

  	public String getFirstName() {
  		return firstName;
  	}

  	public void setFirstName(String firstName) {
  		this.firstName = firstName;
  	}

  	public String getLastName() {
  		return lastName;
  	}

  	public void setLastName(String lastName) {
  		this.lastName = lastName;
  	}

  	public String getEmail() {
  		return email;
  	}

  	public void setEmail(String email) {
  		this.email = email;
  	}

  	public void setId(long id) {
  		this.id = id;
  	}
    
}