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

import com.games.platforms.models.Sesion;
import com.games.platforms.repositories.SesionRepository;

/**
 * @author Jonatan
 *
 */
@RestController
@RequestMapping("sesion")
@CrossOrigin("*")
public class SesionController {
	//Declaracion de variables
	@Autowired
	private SesionRepository sesionRepository;
	
	@GetMapping("")
	public List<Sesion> findAll(){
		return sesionRepository.findAll();
	}

	@GetMapping("{id}")
	public Sesion findById(@PathVariable int id){
		return sesionRepository.findById(id).orElse(null);
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("")
	public Sesion create(@RequestBody Sesion sesion) {
		if(sesion != null) {
			sesionRepository.save(sesion);
		}
		return null;
	}

	@PutMapping("{id}")
	public Sesion update(@PathVariable int id, @RequestBody Sesion newSesion) {
		Sesion sesion = sesionRepository.findById(id).orElse(null);
		if(sesion != null && newSesion != null) {
			sesion.setCoordinator(newSesion.getCoordinator());
			sesionRepository.save(sesion);
		}
		return null;
	}

	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("{id}")
	public boolean deleteById(@PathVariable int id){
		Sesion sesion = sesionRepository.findById(id).orElse(null);
		if(sesion != null) {
			sesionRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
