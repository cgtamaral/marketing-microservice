package br.pucminas.marketingmicroservice.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.pucminas.marketingmicroservice.api.entities.Marketing;

public interface MarketingRepository extends JpaRepository<Marketing, Long>
{

}
