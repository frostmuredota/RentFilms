package com.rentfilms.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "JoinTableAccountEntity")
@Table(name = "MOVIE", uniqueConstraints = { @UniqueConstraint(columnNames = "MOVIE_ID") })
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MOVIE_ID", unique = true, nullable = false)
	private Integer id;

	@Column(name = "NAMEMOVIE", unique = true, nullable = false, length = 100)
	private String nameMovie;

	@Column(name = "DURATION", unique = false, nullable = false, length = 100)
	private int duration;
	
   
	public Movie(String nameMovie, int duration) {
      this.nameMovie=nameMovie;
      this.duration=duration;
	}
}