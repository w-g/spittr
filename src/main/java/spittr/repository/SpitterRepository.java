package spittr.repository;

import spittr.entity.Spitter;

/**
 * spitter repository interface
 * @author V4TOR
 *
 */
public interface SpitterRepository {

	/**
	 * create spitter
	 * @param spitter
	 */
	void createSpitter(Spitter spitter);
	
	/**
	 * get one spitter by username
	 * @param username
	 */
	Spitter getSpitterByUsername(String username);
}
