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


	@ManyToOne
	@JoinColumn(name="comune_id")
	private BeServiceComuni beServiceComuni;

	public BeServiceIndirizzi() {
	}

	@Override
	public String toString() {
		return "BeServiceIndirizzi [id=" + id + ", cap=" + cap + ", civico=" + civico + ", localita=" + localita
				+ ", via=" + via + "]";
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
}