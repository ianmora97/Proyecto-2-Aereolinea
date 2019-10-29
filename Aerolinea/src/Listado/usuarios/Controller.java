/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listado.usuarios;

/**
 *
 * @author Ian Rodriguez
 */
public class Controller{
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
    
    public void buscar(String id){
        
        model.getFiltro().setIdUsuario(id);
        this.refrescar();
    }
    
    public void refrescar() {
        model.setUsuarios(aerolinea.logica.ModelUsuarios.instanciar().buscar(model.getFiltro().getIdUsuario()));       
    }
    
    public void show(){
        view.setVisible(true);
    }

    public void hide(){
        view.setVisible(false);
    } 
    
}
