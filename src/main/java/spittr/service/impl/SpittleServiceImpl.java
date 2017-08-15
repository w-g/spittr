package spittr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spittr.service.SpittleService;
import spittr.entity.Spittle;
import spittr.repository.SpittleRepository;

/**
 * spittle repository implement
 * @author V4TOR
 *
 */
@Service
public class SpittleServiceImpl implements SpittleService {

	private SpittleRepository spittleRepository;
	
	@Autowired
	public SpittleServiceImpl(SpittleRepository spittleRepository) {
		this.spittleRepository = spittleRepository;
	}
	
	@Override
	public Spittle save(Spittle spittle) {
		return spittleRepository.createSpittle(spittle);
	}

	@Override
	public Spittle findOne(long spittleId) {
		return spittleRepository.getSpittle(spittleId);
	}
	
	@Override
 	public List<Spittle> findSpittles(long max, int count) {
		return spittleRepository.getManySpittles(max, count);
	}
}
