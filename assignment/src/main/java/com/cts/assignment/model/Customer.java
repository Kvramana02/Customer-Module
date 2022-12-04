package com.cts.assignment.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
	
	@Id
	private Long id;
	@NotBlank
	private String firstName;
	@NotBlank
	private String lastName;
	private int age;
	private String currentAddress;
	

}
