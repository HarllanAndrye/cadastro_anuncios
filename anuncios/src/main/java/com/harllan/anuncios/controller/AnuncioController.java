package com.harllan.anuncios.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.harllan.anuncios.dto.DatePeriodDTO;
import com.harllan.anuncios.dto.RelatorioDTO;
import com.harllan.anuncios.entities.Anuncio;
import com.harllan.anuncios.exception.AnuncioAlreadyRegisteredException;
import com.harllan.anuncios.exception.AnuncioNotFoundException;
import com.harllan.anuncios.service.AnuncioService;

import lombok.AllArgsConstructor;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/anuncios")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AnuncioController implements AnuncioControllerDocs {
	
	private final AnuncioService anuncioService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Anuncio> getAnuncios() {
        return anuncioService.listAll();
    }
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Anuncio getAnuncio(@PathVariable Long id) throws AnuncioNotFoundException {
        return anuncioService.findById(id);
    }
	
	@GetMapping(value = "/relatorios", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RelatorioDTO> getRelatorio() {
		return anuncioService.generateReport();
    }
	
	@PostMapping(value = "/reports/date", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RelatorioDTO> getReportByDate(@Valid @RequestBody DatePeriodDTO period) {
		return anuncioService.generateReportByPeriod(period);
    }
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "http://localhost:4200")
    @ResponseStatus(HttpStatus.CREATED)
    public Anuncio createAnuncio(@RequestBody Anuncio anuncio) throws AnuncioAlreadyRegisteredException {
        return anuncioService.createAnuncio(anuncio);
    }
	
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Anuncio updateAnuncio(@PathVariable Long id, @RequestBody Anuncio anuncio) throws AnuncioNotFoundException {
        return anuncioService.modifyAnuncio(id, anuncio);
    }
	
	@DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws AnuncioNotFoundException {
		anuncioService.deleteById(id);
    }

}
