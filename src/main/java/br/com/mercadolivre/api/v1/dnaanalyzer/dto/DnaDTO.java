package br.com.mercadolivre.api.v1.dnaanalyzer.dto;

import io.swagger.annotations.ApiModel;
import lombok.Getter;

@ApiModel(value = "Dna", description = "Dna used to testing in DNA Analyzer API")
public class DnaDTO {

	@Getter
	private String[] dna;

}
