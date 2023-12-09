package com.examen.reposicion.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "equipos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigoequipo")
    private int codigoEquipo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "ataque")
    private double ataque;

    @Column(name = "defensa")
    private double defensa;
}
