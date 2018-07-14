package com.csoft.payone.auth.user;

public enum Roles {
    ADMIN("ADMIN"),
	USER("USER");
	private String role;
	Roles(String status)
	{
		this.role=role;
	}
    public String getValue() 
    { 
    	return role; 
    }
}