package com.harllan.anuncios.entities;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

//import org.springframework.data.annotation.Id;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Anuncio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String clientName;

	@Column(nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataInicio;

	@Column(nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataTermino;

	@Column(nullable = false)
	private Double investimentoPorDia;
	
}
