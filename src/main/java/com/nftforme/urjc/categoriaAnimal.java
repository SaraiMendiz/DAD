package com.nftforme.urjc;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity

public class categoriaAnimal{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", length = 100)
	private int id;
	@Column(name = "nombre", length = 100, unique = true)
	private String nombre;
	@Column(name = "precio", length = 100)
	private float precio;
	@Column(name = "autor", length = 100)
	private String autor;
	@Column(name = "compado", length = 100)
	private boolean comprado;
	@Column(name = "categoria", length = 100)
	private String categoria;
	@Column(name = "hash", length = 100)
	private String codigoHash;
	
	static int generador_id = 0;
	
	
	
	public categoriaAnimal(String nombre, float precio, String autor, String categoria) {
		
		this.nombre = nombre;
		this.precio = precio;
		this.id= generador_id++;
		this.comprado = false;
		this.autor = autor;
		this.categoria=categoria;
		
		
        try {
        	MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.reset();
			digest.update(nombre.getBytes("utf8"));
			String sha1 = String.format("%040x", new BigInteger(1, digest.digest()));
			this.codigoHash=sha1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	
	public categoriaAnimal() {}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre(){
		return nombre;
	}
	public void setPrecio(float precio){
		this.precio = precio;
	}
	public float getPrecio() {
		return precio;
	}
	public void setID(int ID) {
		this.id = ID;
	}
	public int getID() {
		return id;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getAutor(){
		return autor;
	}
	public void setComprado(boolean comprado) {
		this.comprado = comprado;
	}
	public Boolean getComprado() {
		return comprado;
	}
	public String getCategoria() {
		return categoria;
	}
	
}
