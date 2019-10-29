
package aerolinea.datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import aerolinea.logica.Usuario;


public class DaoUsuario {
    RelDatabase db;
    public DaoUsuario(){
        db= new RelDatabase();
    }

    public Usuario getUsuario(String id) throws Exception{

        String sql="select * from usuario u where u.idUsuario='%s'";
        sql = String.format(sql,id);
        ResultSet rs =  db.executeQuery(sql);
        if (rs.next()) {
            return Usuario(rs);
        }
        else{
            throw new Exception ("Usuario no Existe");
        }
    }
    
    public void UsuarioDelete(Usuario u) throws Exception{
        String sql="delete from usuario where idUsuario='%s'";
        sql = String.format(sql,u.getIdUsuario());
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("Usuario no existe");
        }
    }

    public void UsuarioAdd(Usuario u) throws Exception{

  String sql="insert into usuario (idUsuario, contrasenna, nombre, apellidos, "
          + "correo, fechaNacimiento, direccion, telefonoTrabajo, celular) "+
                "values('%s','%s','%s','%s','%s','%s','%s','%s','%s')";
        sql=String.format(sql, u.getIdUsuario(), u.getContrasenna(), 
                u.getNombre(), u.getApellidos() ,u.getCorreo(),u.getFechaNacimiento(),
                u.getDireccion(),u.getTelefonoTrabajo(),u.getCelular());
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("Usuario ya existe");
        }
    }

    public void UsuarioUpdate(Usuario u) throws Exception{
        String sql="update usuario set idUsuario='%s', contrasenna='%s', "
                + "nombre='%s', apellidos='%s', correo='%s', "
                + "fechaNacimiento='%s' ,direccion='%s', "
                + "telefonoTrabajo='%s' ,celular='%s' "
                + "where idUsuario='%s'";
        sql=String.format(sql,u.);
        
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("Usuario no existe");
        }
    }
    
    public List<Vuelo> VueloSearch(String dia){//preguntar
        List<Vuelo> resultado = new ArrayList<Vuelo>();
        try {
            String sql="select * "+
                    "from vuelo v inner join Ciudad e on v.Ciudad_codigo=e.codigo "+
                    "where v.dia like '%%%s%%'";
            sql=String.format(sql,dia);
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(Vuelo(rs));
            }
        } catch (SQLException ex) { }
        return resultado;

    }
         public List<Ciudad> CiudadSearch(String nombre){
        List<Ciudad> resultado = new ArrayList<Ciudad>();
      try {
            String sql="select * "+
                     "from  Ciudad";
            
            sql=String.format(sql,nombre);
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                
                resultado.add(Ciudad(rs));
            }
        } catch (SQLException ex) {
           System.out.println("NO SE PUDO CARGAR ESTADO");
        }
        return resultado;
    }
  
//       public Ciudad CiudadGet(String codigo) throws Exception{
//    String sql="select* "+
//                     "from  Ciudad e  ";
//
//        sql = String.format(sql,codigo);
//        ResultSet rs =  db.executeQuery(sql);
//        if (rs.next()) {
//            return Ciudad(rs);
//        }
//        else{
//            throw new Exception ("Ciudad  no Existe");
//        }
//    }
//            private Pais Pais(ResultSet rs){
//        try {
//            Pais p= new Pais();
//            p.setCodigoPais(rs.getString("codigoPais"));
//            p.setNombre(rs.getString("nombre"));
//   return p;
//        } catch (SQLException ex) {
//            return null;
//        }
//    }
//            
//       private Ciudad Ciudad(ResultSet rs){
//        try {
//            Ciudad c= new Ciudad();
//            c.setCodigoCiudad(rs.getString("codigoCiudad"));
//   c.setNombre(rs.getString("nombre"));
//   c.setPais(Pais(rs));
//   return c;
//        } catch (SQLException ex) {
//            return null;
//        }
//    }
       
    private Usuario Usuario(ResultSet rs){
        try {
            Usuario u = new Usuario();
            u.setIdUsuario(rs.getString("idUsuario"));
            u.setContrasenna(rs.getString("contrasenna"));
            u.setNombre(rs.getString("nombre"));
            u.setApellidos(rs.getString("apellidos"));
            u.setCorreo(rs.getString("correo"));
            u.setFechaNacimiento(rs.getString("fechaNacimiento"));
            u.setDireccion(rs.getString("dirreccion"));
            u.setTelefonoTrabajo(rs.getString("telefonoTrbajo"));
            u.setCelular(rs.getString("celular"));
            return u;
        } catch (SQLException ex) {
            return null;
        }
    }
    public  List<Ciudad> llenarCombo(){
     List<Ciudad> resultado = new ArrayList<Ciudad>();
      try {
            String sql="select * "+
                     "from  Ciudad";
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                
                resultado.add(Ciudad(rs));
            }
        } catch (SQLException ex) {
           System.out.println("NO SE PUDO CARGAR CIUDAD");
        }
        return resultado;
    }
  
   public  void close(){
    }
}
