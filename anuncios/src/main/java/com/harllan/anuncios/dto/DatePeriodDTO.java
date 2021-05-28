package com.harllan.anuncios.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DatePeriodDTO {
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date start;
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date end;

}
