package spittr.repository.mybatis.mapper;

import java.util.List;

import spittr.Spittle;

public interface SpittleMapper {

	/**
	 * get one spittle
	 * @param spittleId
	 * @return
	 */
	Spittle getSpittle(double spittleId);
	
	/**
	 * get many spittles
	 * @param maxSpittleId
	 * @param count
	 * @return
	 */
	List<Spittle> getSpittles(long maxSpittleId, int count);
}
