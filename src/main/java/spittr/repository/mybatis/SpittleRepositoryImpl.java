package spittr.repository.mybatis;

import java.util.List;

import spittr.Spittle;
import spittr.repository.SpittleRepository;
import spittr.repository.mybatis.mapper.SpittleMapper;

public class SpittleRepositoryImpl implements SpittleRepository {

	private SpittleMapper spittleMapper;
	
	public SpittleRepositoryImpl(SpittleMapper spittleMapper) {
		this.spittleMapper= spittleMapper;
	}
	
	@Override
	public Spittle createSpittle(Spittle spittle) {
		return null;
	}

	@Override
	public Spittle getSpittle(long spittleId) {
		return spittleMapper.getSpittle(spittleId);
	}

	@Override
	public List<Spittle> getManySpittles(long maxSpittleId, int count) {
		return spittleMapper.getSpittles(maxSpittleId, count);
	}

}
