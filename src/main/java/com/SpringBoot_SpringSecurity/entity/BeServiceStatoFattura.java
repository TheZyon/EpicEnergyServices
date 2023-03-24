package com.SpringBoot_SpringSecurity.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

import java.util.List;


/**
 * The persistent class for the be_service_stato_fattura database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name="be_service_stato_fattura")
//@NamedQuery(name="BeServiceStatoFattura.findAll", query="SELECT b FROM BeServiceStatoFattura b")
public class BeServiceStatoFattura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	@NonNull
	private String nome;


}