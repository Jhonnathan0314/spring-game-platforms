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
@Table(name = "player")
public class Player {
	//Declaracion de variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPlayer;
	private String username;
	private int totalScore;
	
	//Metodo constructor
	public Player(String username, int totalScore) {
		super();
		this.username = username;
		this.totalScore = totalScore;
	}
	
	public Player() {
		
	}

	//Get y set
	public int getIdPlayer() {
		return idPlayer;
	}

	public void setIdPlayer(int idPlayer) {
		this.idPlayer = idPlayer;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
}
