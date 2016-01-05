package com.rentfilms.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "JoinTableEmployeeEntity")
@Table(name = "Client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLIENT_ID", unique = true, nullable = false)
    private Integer id;
 
    @Column(name = "RUT", unique = false, nullable = false, length = 100)
    private String rut;
 
    @Column(name = "FIRST_NAME", unique = false, nullable = false, length = 100)
    private String firstName;
 
    @Column(name = "LAST_NAME", unique = false, nullable = false, length = 100)
    private String lastName;
    
    @Column(name = "EMAIL", unique = false, nullable = false, length = 100)
    private String email;
    
   
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="RENT_MOVIE", joinColumns={@JoinColumn(name="CLIENT_ID", referencedColumnName="CLIENT_ID")}
    , inverseJoinColumns={@JoinColumn(name="MOVIE_ID", referencedColumnName="MOVIE_ID")})
    @Autowired
    private List<Movie> myrents ;
 
    public Client(String rut,String firstName,String lastName,String email){
    	this.rut=rut;
    	this.email=email;
    	this.firstName=firstName;
    	this.lastName=lastName;
    }
  
}
