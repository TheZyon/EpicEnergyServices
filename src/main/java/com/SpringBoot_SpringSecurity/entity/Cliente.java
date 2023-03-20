package com.SpringBoot_SpringSecurity.entity;


import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name="clienti")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    private String ragioneSociale;
    @NonNull
    private String partitaIva;
    @NonNull
    private String email; //email azienda cliente
    @NonNull
    private Timestamp dataInserimento;
    @NonNull
    private Timestamp dataUltimoContatto;
    @NonNull
    private double fatturatoAnnuale;
    @NonNull
    private String pec;
    @NonNull
    private String telefono;
    @NonNull
    private String emailContatto; // email refernte dell'azienda cliente
    @NonNull
    private String nomeContatto;
    @NonNull
    private String cognomeContatto;
    @NonNull
    private String telefonoContatto;


    @Enumerated(EnumType.STRING)
    @NonNull
    private TipoCliente tipoCliente;

        //commentino

}
