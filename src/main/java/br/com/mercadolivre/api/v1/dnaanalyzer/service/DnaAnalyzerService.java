package br.com.mercadolivre.api.v1.dnaanalyzer.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.mercadolivre.api.v1.dnaanalyzer.dto.DnaDTO;
import br.com.mercadolivre.api.v1.dnaanalyzer.dto.StatsDTO;
import br.com.mercadolivre.api.v1.dnaanalyzer.model.Dna;
import br.com.mercadolivre.api.v1.dnaanalyzer.repository.DnaRepository;
import br.com.mercadolivre.api.v1.dnaanalyzer.utils.MatrixUtils;

@Service
public class DnaAnalyzerService {
	
	@Autowired
	private DnaRepository dnaRepository;

	public boolean isSimian(String[] dna) {
		return MatrixUtils.hasAnySequenceInMatrix(dna);
	}
	
	
	public void saveDnaInfo(DnaDTO dna, boolean isSimian) {
		Dna dnaModel = new Dna();
		dnaModel.setDna(Arrays.toString(dna.getDna()));
		dnaModel.setSimian(isSimian);
		
		try {
			dnaRepository.save(dnaModel);
		} catch (DataIntegrityViolationException e) {
			e.printStackTrace();
		}
	}
	
	public StatsDTO getStats() {
		List<Dna> dnaList = dnaRepository.findAll();
		long simians = dnaList.stream().filter(d -> d.isSimian()).count();
		long humans = dnaList.stream().filter(d -> !d.isSimian()).count();
		float ratio = (float) simians / humans;
		
		StatsDTO statsDTO = new StatsDTO();
		statsDTO.setCountMutantDna(simians);
		statsDTO.setCountHumanDna(humans);
		statsDTO.setRatio(ratio);
		return statsDTO;
	}
	
}
