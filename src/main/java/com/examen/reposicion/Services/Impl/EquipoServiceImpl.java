package com.examen.reposicion.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.reposicion.Models.Equipo;
import com.examen.reposicion.Repositories.EquipoRepository;
import com.examen.reposicion.Services.EquipoService;

@Service
public class EquipoServiceImpl implements EquipoService {
    
    @Autowired
    private EquipoRepository equipoRepository;

    @Override
    public String eliminarEquipo(int codigoEquipo){
        Equipo equipo = this.equipoRepository.findById(codigoEquipo).get();
        if(equipo != null){
            this.equipoRepository.delete(equipo);
            return "Se ha eliminado el equipo con ID: " + codigoEquipo;
        }
        return "No se ha encontrado el equipo con ID: " + codigoEquipo;
    }

    @Override
    public Equipo buscarEquipo(int codigoEquipo){
        Equipo equipo = this.equipoRepository.findById(codigoEquipo).get();
        if(equipo != null){
            return equipo;
        }
        return null;
    }

    @Override
    public Equipo crearEquipo(Equipo equipo){
        return this.equipoRepository.save(equipo);
    }
}
