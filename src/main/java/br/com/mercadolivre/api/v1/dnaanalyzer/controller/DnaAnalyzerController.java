package br.com.mercadolivre.api.v1.dnaanalyzer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.mercadolivre.api.v1.dnaanalyzer.dto.DnaDTO;
import br.com.mercadolivre.api.v1.dnaanalyzer.dto.StatsDTO;
import br.com.mercadolivre.api.v1.dnaanalyzer.service.DnaAnalyzerService;
import br.com.mercadolivre.api.v1.dnaanalyzer.utils.MatrixUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("DNA Analyzer API")
@RestController
public class DnaAnalyzerController {
	
	@Autowired
	DnaAnalyzerService dnaAnalyzerService;

	@ApiOperation(value="Return whether it is human or simian based on the inputed DNA")
	@PostMapping("/simian")
	public ResponseEntity<String> simian(@RequestBody DnaDTO dna) {
		
		if(dna.getDna() != null) {
			
			if(MatrixUtils.isAValidMatrix(dna.getDna())) {
				boolean isSimian = dnaAnalyzerService.isSimian(dna.getDna());
				dnaAnalyzerService.saveDnaInfo(dna, isSimian);
				
				if(isSimian) {
					return new ResponseEntity<String>("Simian",HttpStatus.OK);
				} else {
					return new ResponseEntity<String>("Human",HttpStatus.FORBIDDEN);
				}
			} else 
				return new ResponseEntity<String>("Invalid DNA",HttpStatus.BAD_REQUEST);
		} else 
			return new ResponseEntity<String>("Invalid DNA",HttpStatus.BAD_REQUEST);
	}
	
	@ApiOperation(value="Return status about testing")
	@GetMapping("/stats")
	public StatsDTO stats() {
		return dnaAnalyzerService.getStats();
	}
}
