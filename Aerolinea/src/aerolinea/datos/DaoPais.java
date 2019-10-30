/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.datos;

import aerolinea.logica.Pais;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ian Rodriguez
 */
public class DaoPais {
    RelDatabase db;
    public DaoPais(){
        db= new RelDatabase();
    }

    public Pais getPais(String id) throws Exception{

        String sql="select * from pais p where p.codigoPais='%s'";
        sql = String.format(sql,id);
        ResultSet rs =  db.executeQuery(sql);
        if (rs.next()) {
            return Pais(rs);
        }
        else{
            return null;
        }
    }
    
    public void PaisDelete(Pais u) throws Exception{
        String sql="delete from pais where codigoPais='%s'";
        sql = String.format(sql,u.getCodigoPais());
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("Pais no existe");
        }
    }

    public void PaisAdd(Pais u) throws Exception{

  String sql="insert into pais (codigoPais, nombre) "+
                "values('%s','%s')";
        sql=String.format(sql, u.getCodigoPais(), u.getNombre());
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("Pais ya existe");
        }
    }

     public void PaisUpdate(Pais u) throws Exception{
        String sql="update pais set codigoPais='%s' ,contrasenna='%s'"+
                "where codigoPais='%s'";
        sql=String.format(sql, u.getCodigoPais(), u.getNombre(), 
                u.getCodigoPais());

        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("El pais no existe");
        }
    }
    
    public List<Pais> UsuarioSearch(String pais){
        List<Pais> resultado = new ArrayList<Pais>();
        try {
            String sql = "select * "+
                         "from Pais u "+
                         "where u.codigoPais like '%%%s%%'";
            sql = String.format(sql, pais);
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(Pais(rs));
            }
        } catch (SQLException ex) { }
        return resultado;

    }
    
       
    private Pais Pais(ResultSet rs){
        try {
            Pais u = new Pais();
            u.setCodigoPais(rs.getString("codigoPais"));
            u.setNombre(rs.getString("nombre"));
            return u;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
    
}
