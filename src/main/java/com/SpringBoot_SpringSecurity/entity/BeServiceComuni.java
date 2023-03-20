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
//@NamedQuery(name="BeServiceComuni.findAll", query="SELECT b FROM BeServiceComuni b")
public class BeServiceComuni implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	private String nome;

	//bi-directional many-to-one association to BeServiceProvince
	@ManyToOne
	@JoinColumn(name="provincia_id")
	private BeServiceProvince beServiceProvince;

	//bi-directional many-to-one association to BeServiceIndirizzi
	@OneToMany(mappedBy="beServiceComuni")
	private List<BeServiceIndirizzi> beServiceIndirizzis;

	public BeServiceComuni() {
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

	public List<BeServiceIndirizzi> getBeServiceIndirizzis() {
		return this.beServiceIndirizzis;
	}

	public void setBeServiceIndirizzis(List<BeServiceIndirizzi> beServiceIndirizzis) {
		this.beServiceIndirizzis = beServiceIndirizzis;
	}

	public BeServiceIndirizzi addBeServiceIndirizzi(BeServiceIndirizzi beServiceIndirizzi) {
		getBeServiceIndirizzis().add(beServiceIndirizzi);
		beServiceIndirizzi.setBeServiceComuni(this);

		return beServiceIndirizzi;
	}

	public BeServiceIndirizzi removeBeServiceIndirizzi(BeServiceIndirizzi beServiceIndirizzi) {
		getBeServiceIndirizzis().remove(beServiceIndirizzi);
		beServiceIndirizzi.setBeServiceComuni(null);

		return beServiceIndirizzi;
	}

}