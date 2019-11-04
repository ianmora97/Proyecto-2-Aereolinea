/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.logica;

import aerolinea.datos.DaoMetodoPago;
import java.util.List;

/**
 *
 * @author Ian Rodriguez
 */
public class ModelMetodoPago {
    DaoMetodoPago metodoPago;
    
    
    public ModelMetodoPago(){
        metodoPago = new DaoMetodoPago();
    }
    public void agregar(MetodoPago t) throws Exception{
        metodoPago.MetodoPagoAdd(t);
    }
    public MetodoPago consultar(String id) throws Exception {
        MetodoPago result = metodoPago.getMetodoPago(id);
        return result;
    }
    public List<MetodoPago> buscarTodos() {
        List<MetodoPago> result = metodoPago.MetodoPagoSearchEO();
        return result;
    }
    public List<MetodoPago> buscar(String s) {
        List<MetodoPago> result = metodoPago.MetodoPagoSearch(s);
        return result;
    }
    static ModelMetodoPago instancia;

    public static ModelMetodoPago instanciar() {
        if (instancia == null) {
            instancia = new ModelMetodoPago();
        }
        return instancia;
    }
}
