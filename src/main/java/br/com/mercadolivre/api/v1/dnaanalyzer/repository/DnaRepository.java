package br.com.mercadolivre.api.v1.dnaanalyzer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mercadolivre.api.v1.dnaanalyzer.model.Dna;


@Repository
public interface DnaRepository extends JpaRepository<Dna, Long>{
	
}
