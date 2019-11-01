/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import aerolinea.datos.DaoVuelo;

public class ModelVuelo {

    DaoVuelo vuelos;

    public ModelVuelo() {
       vuelos = new DaoVuelo();
    }

//    public void agregar(Vuelo v) throws Exception {
//        vuelos.VueloAdd(v);
//    }
//
//    public Vuelo consultar(String id) throws Exception {
//        Vuelo result = vuelos.VueloGet(id);
//        return result;
//    }
//
//    public void modificar(Vuelo v) throws Exception {
//        vuelos.VueloUpdate(v);
//    }
//
//    public List<Vuelo> buscar(String nombre) {
//        List<Vuelo> result = vuelos.VueloSearch(nombre);
//        return result;
//    }
//
//    public List<Ciudad> ciudadBuscar(String nombre){
//    return vuelos.CiudadSearch(nombre);
//} 

    
    static ModelVuelo instancia;

    public static ModelVuelo instanciar() {
        if (instancia == null) {
            instancia = new ModelVuelo();
        }
        return instancia;
    }

}