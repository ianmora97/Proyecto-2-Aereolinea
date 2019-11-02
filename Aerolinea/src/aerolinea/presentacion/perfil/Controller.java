/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.perfil;

import aerolinea.logica.Usuario;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

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
        view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        view.setTitle("Perfil");
        model.setReservas(aerolinea.logica.ModelReservacion.instanciar().buscarTodos());
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }
    public void show() {
        view.setVisible(true);
    }

    public void hide() {
        view.setVisible(false);
    }
    /*-------------------Metodos----------------------*/
    public void modificarUsuarios(Usuario u) throws Exception{
        aerolinea.logica.ModelUsuarios.instanciar().modificar(u);
    }
}
