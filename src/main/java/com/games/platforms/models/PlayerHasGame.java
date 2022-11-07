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
@Table(name = "player_has_game")
public class PlayerHasGame {
	//Declaracion de variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPlayerHasGame;
	private int score;
	@OneToOne
	@JoinColumn(name = "id_player")
	private Player player;
	@OneToOne
	@JoinColumn(name = "id_game")
	private Game game;
	
	//Metodo constructor
	public PlayerHasGame(int score, Player player, Game game) {
		super();
		this.score = score;
		this.player = player;
		this.game = game;
	}
	
	public PlayerHasGame() {
		
	}

	//Get y set
	public int getIdPlayerHasGame() {
		return idPlayerHasGame;
	}

	public void setIdPlayerHasGame(int idPlayerHasGame) {
		this.idPlayerHasGame = idPlayerHasGame;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
}
