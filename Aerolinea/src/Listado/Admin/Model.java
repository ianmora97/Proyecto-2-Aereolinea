/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listado.Admin;

import aerolinea.logica.Avion;
import aerolinea.logica.Ruta;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Ian Rodriguez
 */
public class Model extends Observable{
    List<Avion> avion;
    Avion filtroAvion;
    
    List<Ruta> rutas;
    Ruta filtroRuta;
    
    public Model(List<Avion> avion) {
        this.avion = avion;
        filtroAvion = new Avion();
    }

    public Model() {
        avion = new ArrayList<>();
        filtroAvion=new Avion();
        
        rutas = new ArrayList<>();
        filtroRuta = new Ruta();
    }

    public List<Ruta> getRutas() {
        return rutas;
    }

    public void setRutas(List<Ruta> rutas) {
        this.rutas = rutas;
        this.setChanged();
        this.notifyObservers(); 
    }

    public Ruta getFiltroRuta() {
        return filtroRuta;
    }

    public void setFiltroRuta(Ruta filtroRuta) {
        this.filtroRuta = filtroRuta;
        this.setChanged();
        this.notifyObservers(); 
    }
    
    public List<Avion> getAviones() {
        return avion;
    }

    public void setAviones(List<Avion> avion) {
        this.avion = avion;
        this.setChanged();
        this.notifyObservers(); 
        
    }
   
    public Avion getFiltroAvion() {
        return filtroAvion;
    }

    public void setFiltroAvion(Avion filtro) {
        this.filtroAvion = filtro;
        this.setChanged();
        this.notifyObservers(); 
    }
    @Override
    public void addObserver(Observer o){
        super.addObserver(o);
        this.setChanged();
        this.notifyObservers();   
    }
}
