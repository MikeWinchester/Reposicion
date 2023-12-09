package com.examen.reposicion.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.examen.reposicion.Services.Impl.PartidoServiceImpl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/partidos")
public class PartidoController {

    @Autowired
    private PartidoServiceImpl partidoServiceImpl;

    @GetMapping("/simular")
    public String simularPartidos(){
        return this.partidoServiceImpl.simularPartido();
    }
}
