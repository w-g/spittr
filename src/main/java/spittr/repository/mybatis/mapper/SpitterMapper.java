package spittr.repository.mybatis.mapper;

import spittr.entity.Spitter;

/**
 * spitter mappers
 * @author V4TOR
 *
 */
public interface SpitterMapper {
	
	/**
	 * insert spitter
	 * @param spitter
	 */
	void insertSpitter(Spitter spitter);
	
	/**
	 * get one spitter
	 * @param spitterId
	 * @return
	 */
	Spitter getSpitter(String username);
}
