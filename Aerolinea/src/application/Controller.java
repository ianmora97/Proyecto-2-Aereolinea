
package application;
import aerolinea.Application;
import aerolinea.datos.DaoUsuario;
import aerolinea.logica.Usuario;
import java.util.List;

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
    public void personasEdicionShow(){
       Application.Edicion_Controlador.show();
    }
    public void personasListadoShow()
    {
        Application.Listado_Controlador.show();
    }
    public void usuariosListadoShow(){
        Application.Listado_Usuarios_Controller.show();
    }
    public Usuario consultar(String id) throws Exception{
        return aerolinea.logica.ModelUsuarios.instanciar().consultar(id);
    }
    public void registrarShow(){
        Application.Registro_Controller.show();
    }
}
