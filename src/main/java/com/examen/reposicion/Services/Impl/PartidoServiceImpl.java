package com.examen.reposicion.Services.Impl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.reposicion.Models.Equipo;
import com.examen.reposicion.Models.Posicion;
import com.examen.reposicion.Repositories.EquipoRepository;
import com.examen.reposicion.Repositories.PosicionRepository;
import com.examen.reposicion.Services.PartidoService;

@Service
public class PartidoServiceImpl implements PartidoService{
    
    @Autowired
    private EquipoRepository equipoRepository;

    @Autowired
    private PosicionRepository posicionRepository;

    public String simularPartido() {
        List<Equipo> equipos = this.equipoRepository.findAll();

        if (equipos.size() < 6) {
            for(int i=0; i<(6-(equipos.size()+1)); i++){
                Random random = new Random();
                Equipo nuevoEquipo = new Equipo();
                nuevoEquipo.setNombre("Equipo Nuevo " + i);
                nuevoEquipo.setAtaque(random.nextDouble()*100.0);
                nuevoEquipo.setDefensa(random.nextDouble()*100.0);
                this.equipoRepository.save(nuevoEquipo);
            }
            
            for(int i=0; i<(equipos.size()*2);i++){
                emparejarEquipos(equipos.get(i), equipos.get(i+1));
                if(i>equipos.size()){
                    i = 0;
                };
                return emparejarEquipos(equipos.get(i), equipos.get(i+1));
            }

        }
    }

    public String emparejarEquipos(Equipo equipo1, Equipo equipo2){
        Posicion posicionEquipo1 = new Posicion();
        Posicion posicionEquipo2 = new Posicion();
        Random random = new Random();

        int golesEquipo1 = random.nextInt(10);
        int golesEquipo2 = random.nextInt(10);
        for(int i=0; i<2;i++){
            if(golesEquipo1 > golesEquipo2){
                posicionEquipo1.setGanados(posicionEquipo1.getGanados()+1);
                posicionEquipo1.setGolesFavor(golesEquipo1);
                posicionEquipo1.setPuntos(posicionEquipo1.getPuntos()+3);
                this.posicionRepository.save(posicionEquipo1);
                return equipo1.getNombre() + "ha ganado.";
            }else if(golesEquipo2 > golesEquipo1){
                posicionEquipo2.setGanados(posicionEquipo2.getGanados()+1);
                posicionEquipo2.setGolesFavor(golesEquipo2);
                posicionEquipo2.setPuntos(posicionEquipo2.getPuntos()+3);
                this.posicionRepository.save(posicionEquipo2);
                return equipo2.getNombre() + "ha ganado.";
            }else if(golesEquipo1 == golesEquipo2){
                posicionEquipo1.setEmpates(posicionEquipo1.getEmpates()+1);
                posicionEquipo2.setEmpates(posicionEquipo2.getEmpates()+1);
                posicionEquipo1.setPuntos(posicionEquipo1.getPuntos()+2);
                posicionEquipo2.setPuntos(posicionEquipo2.getPuntos()+1);
                this.posicionRepository.save(posicionEquipo1);
                this.posicionRepository.save(posicionEquipo2);
                return "Empate";
            }
        }
        return "No se realizo el partido";
    }
}
