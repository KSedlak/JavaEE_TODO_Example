package com.capgemini.starterkit.jee.todo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TODO")
public class TODO {

	@Id
	@Column(name = "ID")
	@javax.persistence.GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@Column(name = "DESC")
	String description;

	@Column(name = "IS_DONE")
	boolean done;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

}
