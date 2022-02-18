package com.nftforme.urjc.objetos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.lang.NonNull;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", length = 100, unique = true)
	private Long id;
	
	@Column(name = "user", length = 100)
	private String user;
	
	public Cliente(String user) {
		this.user = user;
	}
	
	public Cliente() {
		
	}
	
	public String getUser() {
		return user;
	}	
	
	public Long getId() {
		return id;
	}
}
