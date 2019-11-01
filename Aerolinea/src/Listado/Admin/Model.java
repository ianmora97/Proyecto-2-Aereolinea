/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listado.Admin;

import aerolinea.logica.Avion;
import aerolinea.logica.Horario;
import aerolinea.logica.Ruta;
import aerolinea.logica.Vuelo;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Ian Rodriguez
 */
public class Model extends Observable {

    List<Avion> avion;
    Avion filtroAvion;

    List<Ruta> rutas;
    Ruta filtroRuta;

    List<Horario> horarios;
    Horario filtroHorario;
    
    List<Vuelo> vuelos;
    Vuelo filtrVuelo;

    
    public Model(List<Avion> avion) {
        this.avion = avion;
        filtroAvion = new Avion();
    }

    public Model() {
        avion = new ArrayList<>();
        filtroAvion = new Avion();

        rutas = new ArrayList<>();
        filtroRuta = new Ruta();

        horarios = new ArrayList<>();
        filtroHorario = new Horario();
        
        vuelos = new ArrayList<>();
        filtrVuelo = new Vuelo();
    }

    
    public void setFiltrVuelo(Vuelo filtrVuelo) {
        this.filtrVuelo = filtrVuelo;
        this.setChanged();
        this.notifyObservers();
    }
     public void setVuelos(List<Vuelo> vuelos) {
        this.vuelos = vuelos;
        this.setChanged();
        this.notifyObservers();
    }
    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
        this.setChanged();
        this.notifyObservers();
    }
    public void setRutas(List<Ruta> rutas) {
        this.rutas = rutas;
        this.setChanged();
        this.notifyObservers();
    }
    public void setFiltroRuta(Ruta filtroRuta) {
        this.filtroRuta = filtroRuta;
        this.setChanged();
        this.notifyObservers();
    }
    public void setFiltroAvion(Avion filtro) {
        this.filtroAvion = filtro;
        this.setChanged();
        this.notifyObservers();
    }
    public void setAviones(List<Avion> avion) {
        this.avion = avion;
        this.setChanged();
        this.notifyObservers();
    }
    public void setFiltroHorario(Horario filtroHorario) {
        this.filtroHorario = filtroHorario;
        this.setChanged();
        this.notifyObservers();
    }

    public List<Ruta> getRutas() {
        return rutas;
    }
    public Horario getFiltroHorario() {
        return filtroHorario;
    }
    public Ruta getFiltroRuta() {
        return filtroRuta;
    }
    public List<Avion> getAviones() {
        return avion;
    }
    public Avion getFiltroAvion() {
        return filtroAvion;
    }
    public List<Vuelo> getVuelos() {
        return vuelos;
    }
    public Vuelo getFiltrVuelo() {
        return filtrVuelo;
    }
    public List<Horario> getHorarios() {
        return horarios;
    }
    @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
        this.setChanged();
        this.notifyObservers();
    }
}
