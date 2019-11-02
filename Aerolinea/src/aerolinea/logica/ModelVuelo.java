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
    public int getCant() throws Exception{
        return vuelos.getCantidadRegistros();
    }
    public void agregar(Vuelo v) throws Exception {
        vuelos.VuelosAdd(v);
    }
    public Vuelo buscarPor(String a, String b, String c) throws Exception{
        Vuelo r = vuelos.buscarPorVuelo(a, b, c);
        return r;
    }
    public List<Vuelo> buscarEs(String a, String b, String c) throws Exception{
        List<Vuelo> r = vuelos.VueloSearch(a, b, c);
        return r;
    }
    public void eliminar(String a) throws Exception{
//        vuelos.AvionDelete(a);
    }
    public Vuelo consultar(String id) throws Exception {
//        Vuelo result = vuelos.getAvion(id);
        return null;
    }
    public Vuelo editar(String id) throws Exception {
//        Vuelo result = vuelos.getAvion(id);
        return null;
    }
    public void modificar(Vuelo v) throws Exception {
//        vuelos.AvionUpdate(v);
    }

    public List<Vuelo> buscar(String nombre) {
        List<Vuelo> result = vuelos.VueloSearch(nombre);
        return result;
    }
    public List<Vuelo> buscarTodos() {
        List<Vuelo> result = vuelos.VueloSearchEO();
        return result;
    }
    public List<Vuelo> buscarDescuentoList() {
        List<Vuelo> result = vuelos.VueloSearchDescuento();
        return result;
    }
    
    static ModelVuelo instancia;

    public static ModelVuelo instanciar() {
        if (instancia == null) {
            instancia = new ModelVuelo();
        }
        return instancia;
    }

}