package com.SpringBoot_SpringSecurity.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the be_service_province database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name="be_service_province")
//@NamedQuery(name="BeServiceProvince.findAll", query="SELECT b FROM BeServiceProvince b")
public class BeServiceProvince implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	@NonNull
	private String nome;

	@NonNull
	private String sigla;

}