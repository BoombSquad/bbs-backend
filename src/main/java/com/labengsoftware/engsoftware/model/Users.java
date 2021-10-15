package com.labengsoftware.engsoftware.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Setter;


@Setter
@Entity
@Table(name="Users")
public class Users {
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(nullable = false , name = "user_id", unique = true)
	private String id;

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
	
	@Column(name = "user_storename")
	private String storeName;
	
	@Column(nullable = false , name = "user_documentnumber")
	private String documentNumber;
	
	@Column(nullable = false , name = "user_status")
	private String status;

	@Column(nullable = false , name = "created_at")
	private String createdAt;
	
	@Column(name = "updated_at")
	private String updatedAt;	

	@Column(name = "deleted_at")
	private String deletedAt;
	
	public String getId() {
		return id;
	}


}
