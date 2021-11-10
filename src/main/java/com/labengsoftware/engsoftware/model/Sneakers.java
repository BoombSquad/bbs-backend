package com.labengsoftware.engsoftware.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name="sneakers")
public class Sneakers {
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(nullable = false , name = "sneakers_code", unique = true)
	private String id;
	
	@Column(nullable = false , name = "user_id")
	private String uid;
	
	@Column(nullable = false , name = "sneakers_name")
	private String name;
	
	@Column(nullable = false , name = "sneakers_price")
	private String price;
	
	@Column(nullable = false , name = "sneakers_model")
	private String model;
	
	@Column(nullable = false , name = "sneakers_colour")
	private String colour;
	
	@Column(nullable = false , name = "sneakers_brand")
	private String brand;
	
	@Column(nullable = false , name = "sneakers_status")
	private String status;
	
	@Column(nullable = false , name = "sneakers_size")
	private String size;
	
	@Column(nullable = false , name = "sneakers_cond")
	private String condition;
	
	@Column(nullable = false , name = "created_at")
	private String createdAt;
	
	@Column(name = "updated_at")
	private String updatedAt;
	
	@Column(name = "selled_at")
	private String selledAt;

	@Column(name = "deleted_at")
	private String deletedAt;

}
