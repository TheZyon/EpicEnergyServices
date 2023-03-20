package com.SpringBoot_SpringSecurity.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the be_service_province database table.
 * 
 */
@Entity
@Table(name="be_service_province")
//@NamedQuery(name="BeServiceProvince.findAll", query="SELECT b FROM BeServiceProvince b")
public class BeServiceProvince implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private String sigla;

	//bi-directional many-to-one association to BeServiceComuni
	@OneToMany(mappedBy="beServiceProvince")
	private List<BeServiceComuni> beServiceComunis;

	public BeServiceProvince() {
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

	public String getSigla() {
		return this.sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public List<BeServiceComuni> getBeServiceComunis() {
		return this.beServiceComunis;
	}

	public void setBeServiceComunis(List<BeServiceComuni> beServiceComunis) {
		this.beServiceComunis = beServiceComunis;
	}

	public BeServiceComuni addBeServiceComuni(BeServiceComuni beServiceComuni) {
		getBeServiceComunis().add(beServiceComuni);
		beServiceComuni.setBeServiceProvince(this);

		return beServiceComuni;
	}

	public BeServiceComuni removeBeServiceComuni(BeServiceComuni beServiceComuni) {
		getBeServiceComunis().remove(beServiceComuni);
		beServiceComuni.setBeServiceProvince(null);

		return beServiceComuni;
	}

}