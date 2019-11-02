/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.main;

import aerolinea.logica.Vuelo;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;


public class Model extends Observable{
    List<Vuelo> vuelosDescuento;
    List<Vuelo> vuelosBuscar;
    
    Vuelo descuentofiltro;
    Vuelo buscarfiltro;

    public Model() {
        vuelosBuscar = new ArrayList<>();
        vuelosDescuento = new ArrayList<>();
        
        descuentofiltro = new Vuelo();
        buscarfiltro = new Vuelo();        
    }

    public List<Vuelo> getVuelosDescuento() {
        return vuelosDescuento;
    }

    public void setVuelosDescuento(List<Vuelo> vuelosDescuento) {
        this.vuelosDescuento = vuelosDescuento;
        this.setChanged();
        this.notifyObservers();
    }

    public List<Vuelo> getVuelosBuscar() {
        return vuelosBuscar;
    }

    public void setVuelosBuscar(List<Vuelo> vuelosBuscar) {
        this.vuelosBuscar = vuelosBuscar;
        this.setChanged();
        this.notifyObservers();
    }

    public Vuelo getDescuentofiltro() {
        return descuentofiltro;
    }

    public void setDescuentofiltro(Vuelo descuentofiltro) {
        this.descuentofiltro = descuentofiltro;
        this.setChanged();
        this.notifyObservers();
    }

    public Vuelo getBuscarfiltro() {
        return buscarfiltro;
    }

    public void setBuscarfiltro(Vuelo buscarfiltro) {
        this.buscarfiltro = buscarfiltro;
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
