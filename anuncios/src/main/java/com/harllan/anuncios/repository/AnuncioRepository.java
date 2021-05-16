package com.harllan.anuncios.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.harllan.anuncios.entities.Anuncio;



public interface AnuncioRepository extends JpaRepository<Anuncio, Long> {

	Optional<Anuncio> findByName(String name);
	
	Optional<Anuncio> findByDataInicioBetween(Date start, Date end);
	Optional<Anuncio> findByDataTerminoBetween(Date start, Date end);
	
	@Query("select u from Anuncio u where (:startDate between u.dataInicio and u.dataTermino) OR (:endDate between u.dataInicio and u.dataTermino)")
	List<Anuncio> findByDatePeriod(@Param("startDate") Date start, @Param("endDate") Date end);
}
