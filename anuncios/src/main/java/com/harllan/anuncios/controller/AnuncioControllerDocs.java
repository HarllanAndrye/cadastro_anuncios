package com.harllan.anuncios.controller;

import java.util.List;

import com.harllan.anuncios.dto.RelatorioDTO;
import com.harllan.anuncios.entities.Anuncio;
import com.harllan.anuncios.exception.AnuncioAlreadyRegisteredException;
import com.harllan.anuncios.exception.AnuncioNotFoundException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("Gerenciamento de anúncios")
public interface AnuncioControllerDocs {
	
	@ApiOperation(value = "Retorna uma lista de anúncios registrados no sistema.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Lista de anúncios registrados no sistema."),
    })
    public List<Anuncio> getAnuncios();
	
	@ApiOperation(value = "Retorna um anúncio encontrado pelo ID.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso caso anúncio encontrado."),
            @ApiResponse(code = 404, message = "Anúncio cujo ID não foi encontrado.")
    })
    public Anuncio getAnuncio(Long id) throws AnuncioNotFoundException;
	
	@ApiOperation(value = "Retorna uma lista dos relatórios dos anúncios registrados no sistema.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Relatório de anúncios registrados no sistema."),
    })
    public List<RelatorioDTO> getRelatorio();
	
	@ApiOperation(value = "Cadastro de anúncio")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Sucesso caso anúncio criado no banco de dados."),
            @ApiResponse(code = 400, message = "Algum dado/informação não foi passado corretamente ou está faltando ser enviado.")
    })
    public Anuncio createAnuncio(Anuncio anuncio) throws AnuncioAlreadyRegisteredException;
	
	@ApiOperation(value = "Atualiza as informações do anúncio")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Atualização efetuada com sucesso."),
            @ApiResponse(code = 404, message = "Anúncio não foi encontrado.")
    })
    public Anuncio updateAnuncio(Long id, Anuncio anuncio) throws AnuncioNotFoundException;
	
	@ApiOperation(value = "Delete a beer found by a given valid Id")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Anúncio excluído com sucesso."),
            @ApiResponse(code = 404, message = "Anúncio não foi encontrado.")
    })
    public void deleteById(Long id) throws AnuncioNotFoundException;

}
