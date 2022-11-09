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
import com.games.platforms.models.Sesion;
import com.games.platforms.repositories.PlayerRepository;
import com.games.platforms.repositories.SesionRepository;

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
	@Autowired
	private SesionRepository sesionRepository;
	
	@GetMapping("")
	public List<Player> findAll(){
		return playerRepository.findAll();
	}
	
	@GetMapping("{id}")
	public Player findById(@PathVariable int id){
		return playerRepository.findById(id).orElse(null);
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("sesion/{idSesion}")
	public Player create(@RequestBody Player player, @PathVariable int idSesion) {
		Sesion sesion = sesionRepository.findById(idSesion).orElse(null);
		if(player != null && sesion != null) {
			player.setSesion(sesion);
			return playerRepository.save(player);
		}
		return null;
	}
	
	@PutMapping("{id}/sesion/{idSesion}")
	public Player update(@PathVariable int id, @PathVariable int idSesion, @RequestBody Player newPlayer) {
		Player player = playerRepository.findById(id).orElse(null);
		Sesion sesion = sesionRepository.findById(idSesion).orElse(null);
		if(player != null && newPlayer != null && sesion != null) {
			player.setUsername(newPlayer.getUsername());
			player.setSesion(sesion);
			return playerRepository.save(player);
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
