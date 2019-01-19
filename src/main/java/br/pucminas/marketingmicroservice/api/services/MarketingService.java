package br.pucminas.marketingmicroservice.api.services;

import java.util.List;
import java.util.Optional;

import br.pucminas.marketingmicroservice.api.entities.Marketing;

public interface MarketingService {

	/**
	 * Retorna uma listagem de todos os anuncions existentes na base de dados.
	 * 
	 * @return List<Marketing>
	 */
	List<Marketing> findAll();

	/**
	 * Retorna as informações de um anuncio conforme identificador passado como parâmetro.
	 * 
	 * @return Optional<Marketing>
	 */
	Optional<Marketing> findById(Long marketingId);

}
