/**
 * 
 */
package com.games.platforms.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Jonatan
 *
 */
@Entity
@Table(name = "sesion_has_game")
public class SesionHasGame {
	//Declaracion de variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSesionHasGame;
	
	@OneToOne
	@JoinColumn(name = "id_sesion")
	private Sesion sesion;
	
	@OneToOne
	@JoinColumn(name = "id_game")
	private Game game;

	//Metodo constructor
	public SesionHasGame(Sesion sesion, Game game) {
		super();
		this.sesion = sesion;
		this.game = game;
	}
	
	public SesionHasGame() {
		
	}

	//Get y set
	public int getIdSesionHasGame() {
		return idSesionHasGame;
	}

	public void setIdSesionHasGame(int idSesionHasGame) {
		this.idSesionHasGame = idSesionHasGame;
	}

	public Sesion getSesion() {
		return sesion;
	}

	public void setSesion(Sesion sesion) {
		this.sesion = sesion;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
}
