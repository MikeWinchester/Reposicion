package com.examen.reposicion.Services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.reposicion.Models.Posicion;
import com.examen.reposicion.Repositories.PosicionRepository;
import com.examen.reposicion.Services.PosicionService;

@Service
public class PosicionServiceImpl implements PosicionService{
    
    @Autowired
    private PosicionRepository posicionRepository;

    @Override
    public List<Posicion> obtenerTabla(){
        return this.posicionRepository.findAll();
    }
}
