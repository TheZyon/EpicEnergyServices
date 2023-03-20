package com.SpringBoot_SpringSecurity.entity;

import jakarta.persistence.*;

import java.io.Serializable;

import java.util.List;


/**
 * The persistent class for the be_service_comuni database table.
 * 
 */
@Entity
@Table(name="be_service_comuni")

public class BeServiceComuni implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	private String nome;

	//many-to-one association to BeServiceProvince
	@ManyToOne
	@JoinColumn(name="provincia_id")
	private BeServiceProvince beServiceProvince;

	public BeServiceComuni() {
	}
	

	@Override
	public String toString() {
		return "BeServiceComuni [id=" + id + ", nome=" + nome + " ]";
	}


	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BeServiceProvince getBeServiceProvince() {
		return this.beServiceProvince;
	}

	public void setBeServiceProvince(BeServiceProvince beServiceProvince) {
		this.beServiceProvince = beServiceProvince;
	}


}