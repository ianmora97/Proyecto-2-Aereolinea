/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.logica;

import aerolinea.datos.DaoReservas;
import java.util.List;

/**
 *
 * @author Ian Rodriguez
 */
public class ModelReservacion {
    DaoReservas reservas;

    public ModelReservacion() {
        reservas = new DaoReservas();
    }
     public void agregar(Reservacion h) throws Exception{
        reservas.ReservacionAdd(h);
    }
    public void eliminar(String h) throws Exception{
        reservas.ReservacionDelete(h);
    }
    public Reservacion consultar(String h) throws Exception{
        Reservacion result = reservas.getReservacion(h);
        return result;
    }
    public Reservacion editar(String h) throws Exception{
        Reservacion result = reservas.getReservacion(h);
        return result;
    }
    public void modificar(Reservacion h) throws Exception{
        reservas.ReservacionUpdate(h);
    }
    public List<Reservacion> buscar(String nombre) {
        List<Reservacion> result = reservas.ReservacionSearch(nombre);
        return result;
    }
    public List<Reservacion> buscarTodos() {
        List<Reservacion> result = reservas.ReservacionSearchEO();
        return result;
    }
    static ModelReservacion instancia;

    public static ModelReservacion instanciar() {
        if (instancia == null) {
            instancia = new ModelReservacion();
        }
        return instancia;
    }
}
