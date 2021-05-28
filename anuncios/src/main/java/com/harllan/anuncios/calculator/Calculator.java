package com.harllan.anuncios.calculator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.harllan.anuncios.dto.DatePeriodDTO;
import com.harllan.anuncios.dto.RelatorioDTO;
import com.harllan.anuncios.entities.Anuncio;
import com.harllan.anuncios.repository.AnuncioRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor(onConstructor = @__(@Autowired))
public class Calculator {
	
	private final AnuncioRepository anuncioRepository;
	
	/**
     * Método que retorna o relatório referente aos anúncios, informando: 
     * 		valor total investido, quantidade máxima de visualizações, 
     * 		quantidade máxima de cliques, quantidade máxima de compartilhamentos. 
     * 
     * @return List<RelatorioDTO>
     */
	public List<RelatorioDTO> report()  {
		List<Anuncio> anuncios = anuncioRepository.findAll();
		
		return generateReport(anuncios);
    }
	
	/**
     * Método que retorna o relatório por período referente a data de início dos anúncios, informando: 
     * 		valor total investido, quantidade máxima de visualizações, 
     * 		quantidade máxima de cliques, quantidade máxima de compartilhamentos. 
     * 
     * @param DatePeriodDTO period
     * 
     * @return List<RelatorioDTO>
     */
	public List<RelatorioDTO> reportByPeriod(DatePeriodDTO period) {
		// A consulta retorna o(s) anúncio(s) quem tem a data de início dentro do período informado.
		List<Anuncio> anuncios = anuncioRepository.findByDatePeriod(period.getStart(), period.getEnd());
		
		return generateReport(anuncios);
	}
	
	
	/**
     * Método que retorna o relatório dos anúncios. 
     * 
     * @param List<Anuncio> anuncios
     * 
     * @return List<RelatorioDTO>
     */
	private List<RelatorioDTO> generateReport(List<Anuncio> anuncios) {
		List<RelatorioDTO> relatorio = new ArrayList<>();
        
        for (Anuncio anuncio : anuncios) {
        	Integer days = qtdDays(anuncio.getDataInicio(), anuncio.getDataTermino());
        	
        	// Quantidade de visualizações de acordo com o valor inicial investido em um dia.
        	Integer qtdVisualizacoesInicial = (int) Math.round(anuncio.getInvestimentoPorDia() * 30);
            
            Integer qtdVisualizacoesParaCompartilhar = qtdVisualizacoesInicial;
            Integer totalNovasVisualizacoes = 0;
            Integer qtdCliques = 0;
            Integer qtdCompartilhamentos = 0;
            int contadorCompartilhamento = 0;
            
            // O mesmo anúncio é compartilhado no máximo 4 vezes em sequência.
            while (contadorCompartilhamento < 4) {
            	Integer cliques = clique(qtdVisualizacoesParaCompartilhar);
            	qtdCliques += cliques;
            	
            	Integer compartilhamentos = compartilhamento(cliques);
            	qtdCompartilhamentos += compartilhamentos;
            	
            	//Integer novasVisualizacoes = alcanceDoAnuncio(qtdVisualizacoesParaCompartilhar);
            	Integer novasVisualizacoes = novasVisualizacoes(compartilhamentos);
            	
            	qtdVisualizacoesParaCompartilhar = novasVisualizacoes;
                totalNovasVisualizacoes += novasVisualizacoes;
                contadorCompartilhamento++;
            }
            
            Integer projecao = totalNovasVisualizacoes + qtdVisualizacoesInicial;
            Integer qtdMaxVisualizacoes = days * projecao;
            
            Double totalInvestido = anuncio.getInvestimentoPorDia() * days;
            
            RelatorioDTO rel = new RelatorioDTO();
            rel.setIdAnuncio(anuncio.getId());
            rel.setNomeAnuncio(anuncio.getName());
            rel.setNomeCliente(anuncio.getClientName());
            rel.setTotalInvestido(totalInvestido);
            rel.setMaxVisualizacoes(qtdMaxVisualizacoes);
            rel.setMaxCliques(qtdCliques * days);
            rel.setMaxCompartilhamentos(qtdCompartilhamentos * days);
            rel.setStartDate(anuncio.getDataInicio());
            rel.setEndDate(anuncio.getDataTermino());
            
            relatorio.add(rel);
		}
        
        return relatorio;
	}
	
	
	/**
     * Método que retorna a quantidade de dias entre uma data inicial e uma data final. 
     * 
     * @param start
     * @param end
     * @return Integer
     */
	private Integer qtdDays(Date start, Date end) {
        long diffEmMil = Math.abs(end.getTime() - start.getTime());
        
        int days = (int) (diffEmMil / (1000 * 60 * 60 * 24));
        
        return days+1;
    }
	
	/**
     * Método que retorna a quantidade de novas visualizações de acordo com os cliques e compartilhamentos referentes as visualizações anteriores do anúncio. 
     * 
     * @param qtdVisualizacoesInicial
     * @return Integer
     */
	private Integer alcanceDoAnuncio(Integer qtdVisualizacoesInicial) {
        Long cliques = Math.round(qtdVisualizacoesInicial * 0.12);
        Long compartilhamentos = Math.round(cliques * 0.15);
        Integer novasVisualizacoes = Math.round(compartilhamentos * 40);
        
        return novasVisualizacoes;
	}
	
	/**
     * Método que retorna a quantidade de visualizações do anúncio. 
     * 
     * @param qtdVisualizacao
     * @return Integer
     */
	private Integer clique(Integer qtdVisualizacao){
        return (int) Math.round(qtdVisualizacao * 0.12);
    }

	/**
     * Método que retorna a quantidade de cliques no anúncio. 
     * 
     * @param qtdClique
     * @return Integer
     */
    private Integer compartilhamento(Integer qtdClique){
        return (int) Math.round(qtdClique * 0.15);
    }
    
    /**
     * Método que retorna a quantidade de compartilhamentos. 
     * 
     * @param qtdCompartilhamento
     * @return Integer
     */
    private Integer novasVisualizacoes(Integer qtdCompartilhamento) {
    	Integer novasVisualizacoes = Math.round(qtdCompartilhamento * 40);
        return novasVisualizacoes;
    }

}
