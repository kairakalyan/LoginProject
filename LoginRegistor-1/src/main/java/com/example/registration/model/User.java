package com.example.registration.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // Indicates that this class is a JPA entity
public class User {

    @Id // Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generate the primary key value
    private Long id; // Add an ID field

    private String fname;
    private String email;
    private String passwd;

    // Getters and Setters
    public Long getId() {
        return id; // Getter for ID
    }

    public void setId(Long id) {
        this.id = id; // Setter for ID
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", fname=" + fname + ", email=" + email + ", passwd=" + passwd + "]";
	}

    
 
}

