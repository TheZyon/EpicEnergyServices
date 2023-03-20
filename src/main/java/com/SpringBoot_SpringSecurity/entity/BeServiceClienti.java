package com.SpringBoot_SpringSecurity.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the be_service_clienti database table.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name="be_service_clienti")
//@NamedQuery(name="BeServiceClienti.findAll", query="SELECT b FROM BeServiceClienti b")
public class BeServiceClienti implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	@NonNull
	@Column(name="cognome_contatto")
	private String cognomeContatto;
	@NonNull
	@Column(name="data_inserimento")
	private Timestamp dataInserimento;
	@NonNull
	@Column(name="data_ultimo_contatto")
	private Timestamp dataUltimoContatto;
	@NonNull
	private String email;
	@NonNull
	@Column(name="email_contatto")
	private String emailContatto;
	@NonNull
	@Column(name="fatturato_annuale")
	private BigDecimal fatturatoAnnuale;
	@NonNull
	@Column(name="nome_contatto")
	private String nomeContatto;
	@NonNull
	@Column(name="partita_iva")
	private String partitaIva;
	@NonNull
	private String pec;

	@NonNull
	@Column(name="ragione_sociale")
	private String ragioneSociale;
	@NonNull
	private String telefono;
	@NonNull
	@Column(name="telefono_contatto")
	private String telefonoContatto;
	@NonNull
	@Column(name="tipo_cliente")
	private String tipoCliente;

	//bi-directional many-to-one association to BeServiceIndirizzi
	@NonNull
	@ManyToOne
	@JoinColumn(name="indirizzo_sede_legale_id")
	private BeServiceIndirizzi beServiceIndirizzi1;

}