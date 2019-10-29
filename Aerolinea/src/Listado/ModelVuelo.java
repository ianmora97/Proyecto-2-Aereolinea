/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listado;

import aerolinea.logica.Vuelo;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;


public class ModelVuelo extends Observable{
   List<Vuelo> vuelos;
    Vuelo filtro;

    public ModelVuelo(List<Vuelo> vuelos) {
        this.vuelos = vuelos;
        filtro=new Vuelo("","");
    }

    public ModelVuelo() {
        vuelos = new ArrayList<>();
        filtro=new Vuelo("","");
    }

  

    public void setPersonas(List<Vuelo> vuelos) {
        this.vuelos = vuelos;
        this.setChanged();
        this.notifyObservers();         
    }

    public List<Vuelo> getVuelos() {
        return vuelos;
    }

    public void setVuelos(List<Vuelo> vuelos) {
        this.vuelos = vuelos;
    }

    public Vuelo getFiltro() {
        return filtro;
    }

    public void setFiltro(Vuelo filtro) {
        this.filtro = filtro;
    }
    
    @Override
    public void addObserver(Observer o){
        super.addObserver(o);
        this.setChanged();
        this.notifyObservers();   
    }
    
}
