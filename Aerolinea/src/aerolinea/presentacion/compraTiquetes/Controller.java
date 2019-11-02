/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.compraTiquetes;

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
    }
    public void leerDatos(){
        model.setVuelos(aerolinea.logica.ModelVuelo.instanciar().buscarTodos());
    }
    public void show(){
        this.view.setVisible(true);
    }
}
