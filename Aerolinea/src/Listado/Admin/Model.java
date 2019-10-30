/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listado.Admin;

import aerolinea.logica.Avion;
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
    Avion filtro;
    
    public Model(List<Avion> avion) {
        this.avion = avion;
        filtro = new Avion();
    }

    public Model() {
        avion = new ArrayList<>();
        filtro=new Avion();
    }

    public List<Avion> getAviones() {
        return avion;
    }

    public void setAviones(List<Avion> avion) {
        this.avion = avion;
        this.setChanged();
        this.notifyObservers(); 
        
    }
   
    public Avion getFiltro() {
        return filtro;
    }

    public void setFiltro(Avion filtro) {
        this.filtro = filtro;
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
