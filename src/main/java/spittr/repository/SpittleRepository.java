package spittr.repository;

import java.util.List;

import spittr.entity.Spittle;

/**
 * spittle repository
 * @author V4TOR
 *
 */
public interface SpittleRepository {

	/**
	 * create one spittle
	 * @param spittle
	 */
	Spittle createSpittle(Spittle spittle);
	
	/**
	 * get one spittle by primary key
	 * @param spittleId
	 * @return
	 */
	Spittle getSpittle(long spittleId);
	
	/**
	 * get many spittles
	 * @param maxSpittleId
	 * @param count
	 * @return
	 */
	List<Spittle> getManySpittles(long maxSpittleId, int count);
}
