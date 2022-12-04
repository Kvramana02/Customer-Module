package com.cts.assignment.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cts.assignment.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	@Query("select u from Customer u where (:firstName is null or u.firstName = :firstName)"
		      +" and (:lastName is null or u.lastName = :lastName)")
	List<Customer> searchByFirstAndOrLastName(@Param("firstName") String firstName,
            @Param("lastName") String lastName);

}
