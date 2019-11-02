
package application.main;
import aerolinea.Application;
import aerolinea.logica.Usuario;
import aerolinea.logica.Vuelo;

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
        model.setVuelosBuscar(aerolinea.logica.ModelVuelo.instanciar().buscarTodos());
        model.setVuelosDescuento(aerolinea.logica.ModelVuelo.instanciar().buscarDescuentoList());
        
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
    public Vuelo buscarVuelos(String a, String b, String c) throws Exception{
        Vuelo result = aerolinea.logica.ModelVuelo.instanciar().buscarPor(a, b, c);
        return result;
    }
    public void buscarVuelo(String a, String b, String c) throws Exception{
        model.setVuelosBuscar(aerolinea.logica.ModelVuelo.instanciar().buscarEs(a, b, c));
    }
    public void buscarTodos() throws Exception{
        model.setVuelosBuscar(aerolinea.logica.ModelVuelo.instanciar().buscarTodos());
    }
}
