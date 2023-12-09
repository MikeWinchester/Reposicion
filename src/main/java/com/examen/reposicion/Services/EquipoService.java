package com.examen.reposicion.Services;

import com.examen.reposicion.Models.Equipo;

public interface EquipoService {
    
    public String eliminarEquipo(int codigoEquipo);

    public Equipo buscarEquipo(int codigoEquipo);

    public Equipo crearEquipo(Equipo equipo);
    
}
