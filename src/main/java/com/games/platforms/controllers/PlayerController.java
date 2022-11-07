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

import com.games.platforms.models.Player;
import com.games.platforms.repositories.PlayerRepository;

/**
 * @author Jonatan
 *
 */
@RestController
@RequestMapping("player")
@CrossOrigin("*")
public class PlayerController {
	//Declaracion de variables
	@Autowired
	private PlayerRepository playerRepository;
	
	@GetMapping("")
	public List<Player> findAll(){
		return playerRepository.findAll();
	}
	
	@GetMapping("{id}")
	public Player findAll(@PathVariable int id){
		return playerRepository.findById(id).orElse(null);
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("")
	public Player create(@RequestBody Player player) {
		if(player != null) {
			playerRepository.save(player);
		}
		return null;
	}
	
	@PutMapping("{id}")
	public Player create(@PathVariable int id, @RequestBody Player newPlayer) {
		Player player = playerRepository.findById(id).orElse(null);
		if(player != null && newPlayer != null) {
			player.setUsername(newPlayer.getUsername());
			player.setTotalScore(newPlayer.getTotalScore());
			playerRepository.save(player);
		}
		return null;
	}
	
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("{id}")
	public boolean deleteById(@PathVariable int id){
		Player player = playerRepository.findById(id).orElse(null);
		if(player != null) {
			playerRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
