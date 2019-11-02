/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea;

public class Application {

    public static Listado.usuarios.Controller Listado_Usuarios_Controller;
    public static Listado.registro.Controller Registro_Controller;
    public static application.Controller Login_Controller;
    public static application.main.Controller MainApp_Controller;
    public static Listado.Admin.Controller Admin_Controller;
    public static aerolinea.presentacion.perfil.Controller Perfil_Controller;

    public static void main(String[] args) {

        Listado.usuarios.View vistaUsuario = new Listado.usuarios.View();
        Listado.usuarios.Model modeloUsuario = new Listado.usuarios.Model();
        Listado.usuarios.Controller controllerUsuario = new Listado.usuarios.Controller(modeloUsuario, vistaUsuario);
        Listado_Usuarios_Controller = controllerUsuario;

        Listado.registro.View vistaRegistro = new Listado.registro.View();
        Listado.registro.Model modeloRegistro = new Listado.registro.Model();
        Listado.registro.Controller controllerRegistro = new Listado.registro.Controller(modeloRegistro, vistaRegistro);
        Registro_Controller = controllerRegistro;

        Listado.Admin.View viewAdmin = new Listado.Admin.View();
        Listado.Admin.Model modelAdmin = new Listado.Admin.Model();
        Listado.Admin.Controller controlAdmin = new Listado.Admin.Controller(modelAdmin, viewAdmin);
        Admin_Controller = controlAdmin;

        application.Model modelo3 = new application.Model();
        application.View vista3 = new application.View();
        application.Controller controladora3 = new application.Controller(modelo3, vista3);
        Login_Controller = controladora3;
        
        aerolinea.presentacion.perfil.Model modelo5 = new aerolinea.presentacion.perfil.Model();
        aerolinea.presentacion.perfil.View view5 = new aerolinea.presentacion.perfil.View();
        aerolinea.presentacion.perfil.Controller controller5 = new aerolinea.presentacion.perfil.Controller(modelo5, view5);
        Perfil_Controller = controller5;
        
        application.main.Model modelo4 = new application.main.Model();
        application.main.View vista4 = new application.main.View();
        application.main.Controller controladora4 = new application.main.Controller(modelo4, vista4);

    }

}
