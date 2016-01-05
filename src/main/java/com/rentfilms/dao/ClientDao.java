package com.rentfilms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.rentfilms.model.Client;

@Service
public interface ClientDao extends JpaRepository<Client,Integer>{
    @Query(value = "SELECT * FROM client",nativeQuery=true)
	public List<Client>allMyClients();
    @Query(value = "SELECT * FROM client WHERE rut=?1",nativeQuery=true)
    public Client findByRut(String rut);
    @Query(value = "SELECT * FROM client WHERE first_name=?1 AND last_name=?2",nativeQuery=true)
    public Client findByNameAndLastName(String name , String lastname);
    @Query(value = "SELECT * FROM rent_movie",nativeQuery=true)
	public List<Object>allMyRents();
    /*
    @Query(value = "SELECT * FROM books inner join author on books.author_id=author.author_id",nativeQuery = true)
   public List<Book> getListBooks();
   @Query(value = "SELECT * FROM author inner join books on author.author_id=books.author_id WHERE author.name = ?1",nativeQuery = true)
   public List<Book>getListByAuthor(String authorName);
   */
}
