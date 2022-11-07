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
import com.games.platforms.repositories.GameRepository;

/**
 * @author Jonatan
 *
 */
@RestController
@RequestMapping("game")
@CrossOrigin("*")
public class GameController {
	//Declaracion de variables
	@Autowired
	private GameRepository gameRepository;

	@GetMapping("")
	public List<Game> findAll(){
		return gameRepository.findAll();
	}

	@GetMapping("{id}")
	public Game findAll(@PathVariable int id){
		return gameRepository.findById(id).orElse(null);
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("")
	public Game create(@RequestBody Game game) {
		if(game != null) {
			gameRepository.save(game);
		}
		return null;
	}

	@PutMapping("{id}")
	public Game create(@PathVariable int id, @RequestBody Game newGame) {
		Game game = gameRepository.findById(id).orElse(null);
		if(game != null && newGame != null) {
			game.setName(newGame.getName());
			gameRepository.save(game);
		}
		return null;
	}

	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("{id}")
	public boolean deleteById(@PathVariable int id){
		Game game = gameRepository.findById(id).orElse(null);
		if(game != null) {
			gameRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
