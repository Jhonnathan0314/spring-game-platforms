/**
 * 
 */
package com.games.platforms.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Jonatan
 *
 */
@Entity
@Table(name = "sesion")
public class Sesion {
	//Declaracion de variables
	@Id
	private int id_sesion;
	private String coordinator;
	
	//Metodo constructor
	public Sesion(String coordinator) {
		super();
		this.coordinator = coordinator;
	}
	
	public Sesion() {
		
	}

	//Get y set
	public int getId_sesion() {
		return id_sesion;
	}

	public void setId_sesion(int id_sesion) {
		this.id_sesion = id_sesion;
	}

	public String getCoordinator() {
		return coordinator;
	}

	public void setCoordinator(String coordinator) {
		this.coordinator = coordinator;
	}
}
