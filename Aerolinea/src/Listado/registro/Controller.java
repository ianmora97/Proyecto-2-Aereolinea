/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listado.registro;

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
    public void insertar() throws Exception{
       aerolinea.logica.ModelUsuarios.instanciar().agregar(model.filtro);
       
    }
    public void show(){
        view.setVisible(true);
    }
    
}
