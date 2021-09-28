package com.labengsoftware.engsoftware.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateSneakerRequestDTO {

	private String uid;
	private String name;
	private String model;
	private String colour;
	private String condition;
	private String size;
	private String price;
	private String brand;

}
