/**
 * 
 */
package com.games.platforms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.games.platforms.models.Sesion;

/**
 * @author Jonatan
 *
 */
public interface SesionRepository extends JpaRepository<Sesion, Integer> {

}
