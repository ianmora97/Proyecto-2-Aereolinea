/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion;

import aerolinea.logica.Ciudad;
import aerolinea.logica.Vuelo;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Gaby
 */
public class ModelVuelo extends Observable{
      Vuelo v;
      List<Ciudad> ciudades; 
      

    public Vuelo getVuelo() {
        return v;
    }

    public void setVuelo(Vuelo v) {
        this.v = v;
        this.setChanged();
        this.notifyObservers();
    }

    public ModelVuelo() {
        v = new Vuelo("","");
         ciudades=new ArrayList<>();
    }

    public List<Ciudad> getCiudades() {
        return ciudades;
    }

    public void setCiudades(List<Ciudad> ciudades) {
        
        this.ciudades = ciudades;
    }
    
    @Override
    public void addObserver(Observer o)
    {
        super.addObserver(o);
        this.setChanged();
        this.notifyObservers();
    } 
}
