package com.labengsoftware.engsoftware.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Setter;


@Setter
@Entity
@Table
public class Users {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Type(type="org.hibernate.type.PostgresUUIDType")
	@Column(nullable = false , name = "user_id", columnDefinition = "uuid")
	private UUID id;

	@Column(nullable = false , name = "user_name")
	private String name;

	@Column(nullable = false , name = "user_pass")
	private String password;
	
	@Column(nullable = false , name = "user_surname")
	private String surname;
	
	@Column(nullable = false , name = "user_phone")
	private String phone;
	
	@Column(nullable = false , name = "user_email")
	private String email;
	
	@Column(nullable = false , name = "user_address")
	private String address;
	
	@Column(name = "user_storeName")
	private String storeName;
	
	@Column(nullable = false , name = "user_documentNumber")
	private String documentNumber;
	
	@Column(nullable = false , name = "user_status")
	private String status;

	@Column(nullable = false , name = "created_at")
	private String createdAt;
	
	@Column(name = "updated_at")
	private String updatedAt;	

	@Column(name = "deleted_at")
	private String deletedAt;
	
	public UUID getId() {
		return id;
	}


}
