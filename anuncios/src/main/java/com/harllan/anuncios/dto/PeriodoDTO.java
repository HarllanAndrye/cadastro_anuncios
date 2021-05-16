package com.harllan.anuncios.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PeriodoDTO {
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date de;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ate;

}
