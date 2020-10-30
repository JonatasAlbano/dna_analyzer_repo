package br.com.mercadolivre.api.v1.dnaanalyzer.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "dna")
public class Dna {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter
	@Setter
	private Long id;
	
	@Column(unique = true, length = 200)
	@Getter
	@Setter
	private String dna;
	
	@Getter
	@Setter
	private boolean simian;

}
