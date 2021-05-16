package com.harllan.anuncios.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class AnuncioNotFoundException extends Exception {
	
	public AnuncioNotFoundException(String anuncioNome) {
        super(String.format("Anuncio %s não encontrado.", anuncioNome));
    }

    public AnuncioNotFoundException(Long id) {
        super(String.format("Anuncio com id %s não encontrado.", id));
    }

}
