package spittr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spittr.service.SpitterService;
import spittr.entity.Spitter;
import spittr.repository.SpitterRepository;

/**
 * spitter service implement
 * @author V4TOR
 *
 */
@Service
public class SpitterServiceImpl implements SpitterService {

	private SpitterRepository spitterRepository;
	
	@Autowired
	public SpitterServiceImpl(SpitterRepository spitterRepository) {
		this.spitterRepository = spitterRepository;
	}
	
	@Override
	public void save(Spitter spitter) {
		spitterRepository.createSpitter(spitter);
	}

	@Override
	public Spitter findByUsername(String username) {
		return spitterRepository.getSpitterByUsername(username);
	}
}
