/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.compraTiquetes;

import aerolinea.logica.MetodoPago;
import aerolinea.logica.Reservacion;
import aerolinea.logica.Tiquete;

/**
 *
 * @author Ian Rodriguez
 */
public class Controller {
    Model model;
    View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        view.setModelo(model);
        view.setControlador(this);
        model.setVuelos(aerolinea.logica.ModelVuelo.instanciar().buscarTodos());
        view.getCardHolderTextField().setText(model.nombreUser);
    }
    public void agregar(Reservacion reservacion, Tiquete tiquete, MetodoPago metodoPago) throws Exception{
        aerolinea.logica.ModelReservacion.instanciar().agregar(reservacion);
        aerolinea.logica.ModelTiquetes.instanciar().agregar(tiquete);
        aerolinea.logica.ModelMetodoPago.instanciar().agregar(metodoPago);
    }
    public Model getModel(){
        return model;
    }
    
    public void leerDatos(){
        model.setVuelos(aerolinea.logica.ModelVuelo.instanciar().buscarTodos());
    }
    public void show(){
        this.view.setVisible(true);
    }
}
