package com.SpringBoot_SpringSecurity.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

import java.util.List;


/**
 * The persistent class for the be_service_indirizzi database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name="be_service_indirizzi")
//@NamedQuery(name="BeServiceIndirizzi.findAll", query="SELECT b FROM BeServiceIndirizzi b")
public class BeServiceIndirizzi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	@NonNull
	private String cap;
	@NonNull
	private String civico;

	@NonNull
	private String localita;
	@NonNull
	private String via;

	@NonNull
	@ManyToOne
	@JoinColumn(name="comune_id")
	private BeServiceComuni beServiceComuni;



}