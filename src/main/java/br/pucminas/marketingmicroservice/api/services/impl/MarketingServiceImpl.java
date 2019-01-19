package br.pucminas.marketingmicroservice.api.services.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.pucminas.marketingmicroservice.api.entities.Marketing;
import br.pucminas.marketingmicroservice.api.repositories.MarketingRepository;
import br.pucminas.marketingmicroservice.api.services.MarketingService;

@Service
public class MarketingServiceImpl implements MarketingService{

	private static final Logger log = LoggerFactory.getLogger(MarketingServiceImpl.class);
	
	@Autowired
	MarketingRepository marketingRepository;
	
	@Override
	public List<Marketing> findAll() {
		log.info("Buscando todos os anuncios da base! {}");
		return marketingRepository.findAll();
	}

	@Override
	public Optional<Marketing> findById(Long marketingId) {
		log.info("Buscando anuncio: {}" + marketingId);
		return marketingRepository.findById(marketingId);
	}

}
