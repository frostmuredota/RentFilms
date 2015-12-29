package com.rentfilms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Actor {
	@Id
    @Column(name = "ACTOR_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int actorId; 
	private String name;
	private String lastName;
	
}
