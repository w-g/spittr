package spittr.service;

import java.util.List;

import spittr.entity.Spittle;

/**
 * spittle repository
 * @author V4TOR
 *
 */
public interface SpittleService {
	
	/**
	 * save spittle
	 * @param spittle
	 * @return
	 */
	Spittle save(Spittle spittle);
	
	/**
	 * find one spittle
	 * @param spittleId
	 * @return
	 */
	Spittle findOne(long spittleId);
	
	/**
	 * find many spittles
	 * @param maxSpittleId max spittle id
	 * @param count result list count
	 * @return spittle list
	 */
	List<Spittle> findSpittles(long maxSpittleId, int count);
}