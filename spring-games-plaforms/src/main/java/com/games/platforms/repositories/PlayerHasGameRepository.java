/**
 * 
 */
package com.games.platforms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.games.platforms.models.PlayerHasGame;

/**
 * @author Jonatan
 *
 */
public interface PlayerHasGameRepository extends JpaRepository<PlayerHasGame, Integer> {

}
