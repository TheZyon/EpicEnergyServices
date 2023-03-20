package com.SpringBoot_SpringSecurity.entity;

import jakarta.persistence.*;

import java.io.Serializable;

import java.util.List;


/**
 * The persistent class for the be_service_stato_fattura database table.
 * 
 */
@Entity
@Table(name="be_service_stato_fattura")
//@NamedQuery(name="BeServiceStatoFattura.findAll", query="SELECT b FROM BeServiceStatoFattura b")
public class BeServiceStatoFattura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	private String nome;

	//bi-directional many-to-one association to BeServiceFatture
	@OneToMany(mappedBy="beServiceStatoFattura")
	private List<BeServiceFatture> beServiceFattures;

	public BeServiceStatoFattura() {
	}
	

	@Override
	public String toString() {
		return "BeServiceStatoFattura [id=" + id + ", nome=" + nome + "]";
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

	public List<BeServiceFatture> getBeServiceFattures() {
		return this.beServiceFattures;
	}

	public void setBeServiceFattures(List<BeServiceFatture> beServiceFattures) {
		this.beServiceFattures = beServiceFattures;
	}

	public BeServiceFatture addBeServiceFatture(BeServiceFatture beServiceFatture) {
		getBeServiceFattures().add(beServiceFatture);
		beServiceFatture.setBeServiceStatoFattura(this);

		return beServiceFatture;
	}

	public BeServiceFatture removeBeServiceFatture(BeServiceFatture beServiceFatture) {
		getBeServiceFattures().remove(beServiceFatture);
		beServiceFatture.setBeServiceStatoFattura(null);

		return beServiceFatture;
	}

}