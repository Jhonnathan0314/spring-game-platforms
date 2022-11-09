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
import com.games.platforms.models.Sesion;
import com.games.platforms.models.SesionHasGame;
import com.games.platforms.repositories.GameRepository;
import com.games.platforms.repositories.SesionHasGameRepository;
import com.games.platforms.repositories.SesionRepository;

/**
 * @author Jonatan
 *
 */
@RestController
@RequestMapping("sesionhasgame")
@CrossOrigin("*")
public class SesionHasGameController {
	//Declaracion de variables
	@Autowired
	private SesionHasGameRepository sesionHasGameRepository;
	@Autowired
	private SesionRepository sesionRepository;
	@Autowired
	private GameRepository 	gameRepository;

	@GetMapping("")
	public List<SesionHasGame> findAll(){
		return sesionHasGameRepository.findAll();
	}

	@GetMapping("{id}")
	public SesionHasGame findById(@PathVariable int id){
		return sesionHasGameRepository.findById(id).orElse(null);
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/sesion/{idSesion}/game/{idGame}")
	public SesionHasGame create(@PathVariable int idSesion, @PathVariable int idGame, @RequestBody SesionHasGame sesionHasGame) {
		Sesion sesion = sesionRepository.findById(idSesion).orElse(null);
		Game game = gameRepository.findById(idGame).orElse(null);
		if(sesionHasGame != null && sesion != null && game != null) {
			sesionHasGame.setSesion(sesion);
			sesionHasGame.setGame(game);
			return sesionHasGameRepository.save(sesionHasGame);
		}
		return null;
	}

	@PutMapping("{id}/sesion/{idSesion}/game/{idGame}")
	public SesionHasGame update(@PathVariable int id, @PathVariable int idSesion, @PathVariable int idGame, @RequestBody SesionHasGame newSesionHasGame) {
		Sesion sesion = sesionRepository.findById(idSesion).orElse(null);
		Game game = gameRepository.findById(idGame).orElse(null);
		SesionHasGame sesionHasGame = sesionHasGameRepository.findById(id).orElse(null);
		if(sesionHasGame != null && newSesionHasGame != null && sesion != null && game != null) {
			sesionHasGame.setSesion(sesion);
			sesionHasGame.setGame(game);
			return sesionHasGameRepository.save(sesionHasGame);
		}
		return null;
	}

	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("{id}")
	public boolean deleteById(@PathVariable int id){
		SesionHasGame sesionHasGame = sesionHasGameRepository.findById(id).orElse(null);
		if(sesionHasGame != null) {
			sesionHasGameRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
