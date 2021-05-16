package com.harllan.anuncios.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RelatorioDTO {
	
	private Long idAnuncio;
	private String nomeAnuncio;
	private String nomeCliente;
	private Double totalInvestido;
	private Integer maxVisualizacoes;
	private Integer maxCliques;
	private Integer maxCompartilhamentos;

}
