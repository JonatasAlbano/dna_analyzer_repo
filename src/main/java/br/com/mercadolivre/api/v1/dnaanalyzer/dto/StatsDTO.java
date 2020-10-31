package br.com.mercadolivre.api.v1.dnaanalyzer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "Stats", description = "Response of stats endpoint")
public class StatsDTO {
	
	@JsonProperty("count_mutant_dna")
	@Getter
	@Setter
	private Long countMutantDna;
	
	@JsonProperty("count_human_dna")
	@Getter
	@Setter
	private Long countHumanDna;
	
	@Getter
	@Setter
	private float ratio;

}
