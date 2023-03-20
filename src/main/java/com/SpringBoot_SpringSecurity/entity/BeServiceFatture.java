package com.SpringBoot_SpringSecurity.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the be_service_fatture database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name="be_service_fatture")
//@NamedQuery(name="BeServiceFatture.findAll", query="SELECT b FROM BeServiceFatture b")
public class BeServiceFatture implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	@NonNull
	private Integer anno;
	@NonNull
	private Timestamp data;
	@NonNull
	private BigDecimal importo;
	@NonNull
	private Integer numero;

	@ManyToOne
	@JoinColumn(name="cliente_id")
	private BeServiceClienti beServiceClienti;

	@ManyToOne
	@JoinColumn(name="stato_id")
	private BeServiceStatoFattura beServiceStatoFattura;

}