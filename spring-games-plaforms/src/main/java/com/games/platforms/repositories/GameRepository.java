/**
 * 
 */
package com.games.platforms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.games.platforms.models.Game;

/**
 * @author Jonatan
 *
 */
public interface GameRepository extends JpaRepository<Game, Integer> {
	
}
