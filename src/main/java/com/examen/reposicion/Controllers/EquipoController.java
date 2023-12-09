package com.examen.reposicion.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.examen.reposicion.Models.Equipo;
import com.examen.reposicion.Services.Impl.EquipoServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/equipos")
public class EquipoController {

    @Autowired
    private EquipoServiceImpl equipoServiceImpl; 
    
    @DeleteMapping("/eliminar")
    public String eliminarEquipo(@RequestParam(name = "codigoEquipo")int codigoEquipo){
        return this.equipoServiceImpl.eliminarEquipo(codigoEquipo);
    }

    @GetMapping("/obtener")
    public Equipo buscarEquipo(@RequestParam(name = "codigoEquipo")int codigoEquipo){
        return this.equipoServiceImpl.buscarEquipo(codigoEquipo);
    }

    @PostMapping("/crear")
    public Equipo buscarEquipo(@RequestBody Equipo equipo){
        return this.equipoServiceImpl.crearEquipo(equipo);
    }

}
