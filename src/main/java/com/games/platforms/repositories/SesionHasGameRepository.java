/**
 * 
 */
package com.games.platforms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.games.platforms.models.SesionHasGame;

/**
 * @author Jonatan
 *
 */
public interface SesionHasGameRepository extends JpaRepository<SesionHasGame, Integer> {

}
