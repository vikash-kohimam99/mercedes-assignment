package com.mercedes.fuleeventdriver.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.sun.istack.NotNull;

@Entity
public class Role {
	
	@Id
	@GeneratedValue
	private Long id;
	@NotNull
	private String name;
	
	@OneToMany(targetEntity = User.class, mappedBy = "role", fetch = FetchType.LAZY,
			cascade = CascadeType.ALL)
	private Set<User> users;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
}
