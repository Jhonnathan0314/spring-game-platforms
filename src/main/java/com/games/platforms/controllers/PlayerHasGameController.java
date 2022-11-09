/**
 * 
 */
package com.games.platforms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.games.platforms.models.Game;
import com.games.platforms.models.Player;
import com.games.platforms.models.PlayerHasGame;
import com.games.platforms.repositories.GameRepository;
import com.games.platforms.repositories.PlayerHasGameRepository;
import com.games.platforms.repositories.PlayerRepository;

/**
 * @author Jonatan
 *
 */
@RestController
@RequestMapping("playerhasgame")
@CrossOrigin("*")
public class PlayerHasGameController {
	//Declaracion de variables
	@Autowired
	private PlayerHasGameRepository playerHasGameRepository;
	@Autowired
	private PlayerRepository playerRepository;
	@Autowired
	private GameRepository 	gameRepository;

	@GetMapping("")
	public List<PlayerHasGame> findAll(){
		return playerHasGameRepository.findAll();
	}

	@GetMapping("{id}")
	public PlayerHasGame findAll(@PathVariable int id){
		return playerHasGameRepository.findById(id).orElse(null);
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/player/{idPlayer}/game/{idGame}")
	public PlayerHasGame create(@PathVariable int idPlayer, @PathVariable int idGame, @RequestBody PlayerHasGame playerHasGame) {
		Player player = playerRepository.findById(idPlayer).orElse(null);
		Game game = gameRepository.findById(idGame).orElse(null);
		if(playerHasGame != null && player != null && game != null) {
			player.setTotalScore(player.getTotalScore() + playerHasGame.getScore());
			playerRepository.save(player);
			playerHasGame.setPlayer(player);
			playerHasGame.setGame(game);
			return playerHasGameRepository.save(playerHasGame);
		}
		return null;
	}

	@PutMapping("{id}/player/{idPlayer}/game/{idGame}")
	public PlayerHasGame update(@PathVariable int id, @PathVariable int idPlayer, @PathVariable int idGame, @RequestBody PlayerHasGame newPlayerHasGame) {
		Player player = playerRepository.findById(idPlayer).orElse(null);
		Game game = gameRepository.findById(idGame).orElse(null);
		PlayerHasGame playerHasGame = playerHasGameRepository.findById(id).orElse(null);
		if(playerHasGame != null && newPlayerHasGame != null && player != null && game != null) {
			player.setTotalScore(player.getTotalScore() - playerHasGame.getScore() + newPlayerHasGame.getScore());
			playerRepository.save(player);
			playerHasGame.setPlayer(player);
			playerHasGame.setGame(game);
			playerHasGame.setScore(newPlayerHasGame.getScore());
			return playerHasGameRepository.save(playerHasGame);
		}
		return null;
	}

	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("{id}")
	public boolean deleteById(@PathVariable int id){
		PlayerHasGame playerHasGame = playerHasGameRepository.findById(id).orElse(null);
		if(playerHasGame != null) {
			Player player = playerHasGame.getPlayer();
			player.setTotalScore(player.getTotalScore() - playerHasGame.getScore());
			playerRepository.save(player);
			playerHasGameRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
