package spittr.repository.mybatis;

import spittr.entity.Spitter;
import spittr.repository.SpitterRepository;
import spittr.repository.mybatis.mapper.SpitterMapper;

public class SpitterRepositoryImpl implements SpitterRepository {

	private SpitterMapper spitterMapper;

	public SpitterRepositoryImpl(SpitterMapper spitterMapper) {
		this.spitterMapper = spitterMapper;
	}
	
	@Override
	public void createSpitter(Spitter spitter) {
		spitterMapper.insertSpitter(spitter);
	}

	@Override
	public Spitter getSpitterByUsername(String username) {
		return spitterMapper.getSpitter(username);
	}
}
