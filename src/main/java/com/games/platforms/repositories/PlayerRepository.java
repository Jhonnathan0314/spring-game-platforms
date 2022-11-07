/**
 * 
 */
package com.games.platforms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.games.platforms.models.Player;

/**
 * @author Jonatan
 *
 */
public interface PlayerRepository extends JpaRepository<Player, Integer> {

}
