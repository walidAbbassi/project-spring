/**
* @author  Walid Abbassi
*/
package com.opendevup.scolarite.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Transient;

//This tells Hibernate to make a table out of this class
@Entity
@Table(name = "user")
public class User {

	// ------------------------
	// PRIVATE FIELDS
	// ------------------------
	
	// An autogenerated id (unique for each user in the db)
	@Id //JPA
	@GeneratedValue(strategy = GenerationType.AUTO) //JPA
	@Column(name = "user_id")
	private int id;
	@Column(name = "username")
	@Size(min = 5)
	@NotEmpty
	private String username;
	@Column(name = "password")
	@Size(min = 5)
	@NotEmpty
	@Transient
	private String password;
	@Column(name = "name")
	@NotEmpty
	private String name;
	@Column(name = "last_name")
	@NotEmpty
	private String lastName;
	@Column(name = "email")
	@Email
	@NotEmpty
	private String email;
	@Column(name = "active")
	private int active;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;

	// ------------------------
	// PUBLIC METHODS
	// ------------------------
	
	// constructor For JPA
	public User() {
		super();
	}
	
	// constructor using Field
	public User(@Size(min = 5) @NotEmpty String username, @Size(min = 5) @NotEmpty String password,
			@NotEmpty String name, @NotEmpty String lastName, @Email @NotEmpty String email, int active,
			Set<Role> roles) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.active = active;
		this.roles = roles;
	}


	// Getter and setter methods
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}// class User