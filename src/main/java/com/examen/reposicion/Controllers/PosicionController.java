package com.examen.reposicion.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.examen.reposicion.Models.Posicion;
import com.examen.reposicion.Services.Impl.PosicionServiceImpl;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/posiciones")
public class PosicionController {

    @Autowired
    private PosicionServiceImpl posicionServiceImpl;
    
    @GetMapping("/tabla")
    public List<Posicion> obtenerTabla(){
        return this.posicionServiceImpl.obtenerTabla();
    }
}
