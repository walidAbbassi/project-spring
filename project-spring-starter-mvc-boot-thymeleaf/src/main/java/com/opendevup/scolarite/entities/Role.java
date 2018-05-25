/**
* @author  Walid Abbassi
*/
package com.opendevup.scolarite.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//This tells Hibernate to make a table out of this class
@Entity
@Table(name = "role")
public class Role {
	
	// ------------------------
	// PRIVATE FIELDS
	// ------------------------
	
	// An autogenerated id (unique for each role in the db)
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="role_id")
	private int id;
	@Column(name="role")
	private String role;
	
	// ------------------------
	// PUBLIC METHODS
	// ------------------------
	
	// constructor For JPA
	public Role() {
		super();
	}
	
	// constructor using Field
	public Role(String role) {
		super();
		this.role = role;
	}
	
	// Getter and setter methods
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	
}// class Role