package com.csoft.payone.auth.user;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;
;

@Entity
public class ApplicationUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    transient  private String password;
	private String address;
    private String mobileNumber;
    private String landphoneNumber;
    private String logoUrl;
    private String paypalKey;
    private String firstName;
    private String lastName;
    private String email;
	private String businessName;
	@ManyToMany (cascade= CascadeType.ALL)
	@JoinTable(
			name = "users_roles",
			joinColumns = @JoinColumn(
			name = "user_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(
			name = "role_id", referencedColumnName = "id")
			)
	private List<Role> roles;

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
	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	 public List<Role> getRoles() {
	        return roles;
	    }

	    public void setRoles(final List<Role> roles) {
	        this.roles = roles;
	    }

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ApplicationUser that = (ApplicationUser) o;
		return Objects.equals(username, that.username) &&
				Objects.equals(firstName, that.firstName) &&
				Objects.equals(lastName, that.lastName) &&
				Objects.equals(email, that.email);
	}

	@Override
	public int hashCode() {

		return Objects.hash(username, firstName, lastName, email);
	}
	/*
	@Override
	public String toString() {
		return "{" +
				"id:" + id +
				", username:'" + username + '\'' +
				", mobileNumber:'" + mobileNumber + '\'' +
				", firstName:'" + firstName + '\'' +
				", lastName:'" + lastName + '\'' +
				", email:'" + email + '\'' +
				", businessName:'" + businessName + '\'' +
				",roles=" + roles +
				'}';
	}
*/
	@Override
	public String toString() {
		return new StringBuilder()
				.append("{")
				.append("id:"+id)
				.append(",username:"+username)
				.append(",mobileNumber:"+mobileNumber)
				.append(",firstName:"+firstName)
				.append(",lastName:"+lastName)
				.append(",email:"+email)
				.append(",businessName:"+lastName)
				.append(",roles:"+roles)
				.append("}")
				.toString();
	}

}
