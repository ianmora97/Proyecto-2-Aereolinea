/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listado.Admin;

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
        leerDatos();
        view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
    
    public void buscarAvion(String id){
        model.getFiltro().setIdTipoAvion(id);
        this.refrescar();
    }
    
    public void refrescar() {
        model.setAviones(aerolinea.logica.ModelAviones.instanciar().buscar(model.getFiltro().getIdTipoAvion()));   
        
    }
    public void leerDatos(){
        model.setAviones(aerolinea.logica.ModelAviones.instanciar().buscarTodos());
    }
    
    public void editar(int row) throws Exception{
        aerolinea.logica.ModelAviones.instanciar().editar(model.getFiltro().getIdTipoAvion());
   
    }
    public void show(){
        view.setVisible(true);
    }

    public void hide(){
        view.setVisible(false);
    } 
}
