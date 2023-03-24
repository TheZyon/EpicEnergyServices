package com.SpringBoot_SpringSecurity.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

import java.util.List;


/**
 * The persistent class for the be_service_comuni database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name="be_service_comuni")

public class BeServiceComuni implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	@NonNull
	private String nome;

	//many-to-one association to BeServiceProvince
	@NonNull
	@ManyToOne
	@JoinColumn(name="provincia_id")
	private BeServiceProvince beServiceProvince;

}