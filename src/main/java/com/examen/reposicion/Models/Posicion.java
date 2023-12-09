package com.examen.reposicion.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "posiciones")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Posicion {
    
   @Id
   private int codigoEquipo;
   
   @OneToOne
   @MapsId
   @JoinColumn(name = "codigoequipo")
   @JsonIgnore
   private Equipo equipo;

   @Column(name = "empates")
   private int empates;

   @Column(name = "ganados")
   private int ganados;

   @Column(name = "perdidos")
   private int perdidos;

   @Column(name = "golesfavor")
   private int golesFavor;

   @Column(name = "golescontra")
   private int golesContra;

   @Column(name = "puntos")
   private int puntos;

}

