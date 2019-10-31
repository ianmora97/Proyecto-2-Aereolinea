
package application.main;
import aerolinea.Application;
import aerolinea.logica.Usuario;

/**
 *
 * @author Ian Rodriguez
 */
public class Controller {
        
    Model model;
    View view;
    
    public Controller(Model m, View v)
    {
        this.model = m;
        this.view = v;
        view.setModel(model);
        view.setControladora(this);
        view.setVisible(true);
    }
    
    public void loginShow(){
        Application.Login_Controller.show();
    }
    public void adminShow(){
        Application.Admin_Controller.show();
    }
    public Usuario consultar(String id) throws Exception{
        return aerolinea.logica.ModelUsuarios.instanciar().consultar(id);
    }
   
}
