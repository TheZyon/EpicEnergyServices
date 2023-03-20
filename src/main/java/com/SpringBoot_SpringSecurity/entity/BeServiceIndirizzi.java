package com.SpringBoot_SpringSecurity.entity;

import jakarta.persistence.*;

import java.io.Serializable;

import java.util.List;


/**
 * The persistent class for the be_service_indirizzi database table.
 * 
 */
@Entity
@Table(name="be_service_indirizzi")
//@NamedQuery(name="BeServiceIndirizzi.findAll", query="SELECT b FROM BeServiceIndirizzi b")
public class BeServiceIndirizzi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	private String cap;

	private String civico;

	private String localita;

	private String via;

	//bi-directional many-to-one association to BeServiceClienti
	@OneToMany(mappedBy="beServiceIndirizzi1")
	private List<BeServiceClienti> beServiceClientis1;

	//bi-directional many-to-one association to BeServiceClienti
	@OneToMany(mappedBy="beServiceIndirizzi2")
	private List<BeServiceClienti> beServiceClientis2;

	//bi-directional many-to-one association to BeServiceComuni
	@ManyToOne
	@JoinColumn(name="comune_id")
	private BeServiceComuni beServiceComuni;

	public BeServiceIndirizzi() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCap() {
		return this.cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getCivico() {
		return this.civico;
	}

	public void setCivico(String civico) {
		this.civico = civico;
	}

	public String getLocalita() {
		return this.localita;
	}

	public void setLocalita(String localita) {
		this.localita = localita;
	}

	public String getVia() {
		return this.via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public List<BeServiceClienti> getBeServiceClientis1() {
		return this.beServiceClientis1;
	}

	public void setBeServiceClientis1(List<BeServiceClienti> beServiceClientis1) {
		this.beServiceClientis1 = beServiceClientis1;
	}

	public BeServiceClienti addBeServiceClientis1(BeServiceClienti beServiceClientis1) {
		getBeServiceClientis1().add(beServiceClientis1);
		beServiceClientis1.setBeServiceIndirizzi1(this);

		return beServiceClientis1;
	}

	public BeServiceClienti removeBeServiceClientis1(BeServiceClienti beServiceClientis1) {
		getBeServiceClientis1().remove(beServiceClientis1);
		beServiceClientis1.setBeServiceIndirizzi1(null);

		return beServiceClientis1;
	}

	public List<BeServiceClienti> getBeServiceClientis2() {
		return this.beServiceClientis2;
	}

	public void setBeServiceClientis2(List<BeServiceClienti> beServiceClientis2) {
		this.beServiceClientis2 = beServiceClientis2;
	}

	public BeServiceClienti addBeServiceClientis2(BeServiceClienti beServiceClientis2) {
		getBeServiceClientis2().add(beServiceClientis2);
		beServiceClientis2.setBeServiceIndirizzi2(this);

		return beServiceClientis2;
	}

	public BeServiceClienti removeBeServiceClientis2(BeServiceClienti beServiceClientis2) {
		getBeServiceClientis2().remove(beServiceClientis2);
		beServiceClientis2.setBeServiceIndirizzi2(null);

		return beServiceClientis2;
	}

	public BeServiceComuni getBeServiceComuni() {
		return this.beServiceComuni;
	}

	public void setBeServiceComuni(BeServiceComuni beServiceComuni) {
		this.beServiceComuni = beServiceComuni;
	}

}