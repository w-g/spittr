package spittr.service;

import spittr.entity.Spitter;

/**
 * spitter repository
 * @author V4TOR
 *
 */
public interface SpitterService {

	/**
	 * save spitter
	 * @param spitter
	 */
	void save(Spitter spitter);
	
	/**
	 * find a spitter by username
	 * @param username
	 * @return a spitter
	 */
	Spitter findByUsername(String username);
}
