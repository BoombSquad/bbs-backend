package com.labengsoftware.engsoftware.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateUserRequestDTO {

	private String name;
	private String surname;
	private String address;
	private String email;
	private String password;
	private String storeName;
	private String documentNumber;
	private String phone;
}
