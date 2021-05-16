package com.harllan.anuncios.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harllan.anuncios.calculator.Calculator;
import com.harllan.anuncios.dto.RelatorioDTO;
import com.harllan.anuncios.entities.Anuncio;
import com.harllan.anuncios.exception.AnuncioAlreadyRegisteredException;
import com.harllan.anuncios.exception.AnuncioNotFoundException;
import com.harllan.anuncios.repository.AnuncioRepository;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AnuncioService {

	private final AnuncioRepository anuncioRepository;
	
	private void verifyIfIsAlreadyRegistered(String name) throws AnuncioAlreadyRegisteredException {
        Optional<Anuncio> optSavedAnuncio = anuncioRepository.findByName(name);
        if (optSavedAnuncio.isPresent()) {
            throw new AnuncioAlreadyRegisteredException(name);
        }
    }
	
	private Anuncio verifyIfExists(Long id) throws AnuncioNotFoundException {
        return anuncioRepository.findById(id)
                .orElseThrow(() -> new AnuncioNotFoundException(id));
    }
	
	public Anuncio createAnuncio(Anuncio anuncio) throws AnuncioAlreadyRegisteredException {
		verifyIfIsAlreadyRegistered(anuncio.getName());
        Anuncio savedAnuncio = anuncioRepository.save(anuncio);
        return savedAnuncio;
	}

	public List<Anuncio> listAll() {
		return anuncioRepository.findAll()
                .stream()
                .collect(Collectors.toList());
	}

	public Anuncio modifyAnuncio(Long id, Anuncio anuncio) throws AnuncioNotFoundException {
		Anuncio anuncioFound = verifyIfExists(id);

		anuncioFound.setName(anuncio.getName());
		anuncioFound.setClientName(anuncio.getClientName());
		anuncioFound.setDataInicio(anuncio.getDataInicio());
		anuncioFound.setDataTermino(anuncio.getDataTermino());
		anuncioFound.setInvestimentoPorDia(anuncio.getInvestimentoPorDia());
		
		Anuncio savedAnuncio = anuncioRepository.save(anuncioFound);

        return savedAnuncio;
	}

	public void deleteById(Long id) throws AnuncioNotFoundException {
		verifyIfExists(id);
		anuncioRepository.deleteById(id);
	}

	public Anuncio findById(Long id) throws AnuncioNotFoundException {
		Anuncio anuncioFound = anuncioRepository.findById(id)
                .orElseThrow(() -> new AnuncioNotFoundException(id));

		return anuncioFound;
	}

	public List<RelatorioDTO> generateReport() {
		Calculator c = new Calculator(anuncioRepository);
		return c.report();
	}

}
