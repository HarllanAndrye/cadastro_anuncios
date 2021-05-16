package com.harllan.anuncios.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AnuncioAlreadyRegisteredException extends Exception {
	
	public AnuncioAlreadyRegisteredException(String anuncioNome) {
        super(String.format("Anuncio %s já está cadastrado no sistema.", anuncioNome));
    }

}
