/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.datos;

import aerolinea.logica.Ciudad;
import aerolinea.logica.Pais;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ian Rodriguez
 */
public class DaoCiudad {

    RelDatabase db;

    public DaoCiudad() {
        db = new RelDatabase();
    }

    public Ciudad getCiudad(String id) throws Exception {

        String sql = "select * from ciudad p where p.codigoCiudad='%s'";
        sql = String.format(sql, id);
        ResultSet rs = db.executeQuery(sql);
        if (rs.next()) {
            return Ciudad(rs);
        } else {
            return null;
        }
    }

    public void CiudadDelete(Ciudad u) throws Exception {
        String sql = "delete from ciudad where codigoCiudad='%s'";
        sql = String.format(sql, u.getCodigoCiudad());
        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("Ciudad no existe");
        }
    }

    public void CiudadAdd(Ciudad u) throws Exception {

        String sql = "insert into ciudad (codigoCiudad, nombre,Pais_codigo) "
                + "values('%s','%s','%s')";
        sql = String.format(sql, u.getCodigoCiudad(), u.getNombre(), u.getPais());
        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("Ciudad ya existe");
        }
    }

    public void CiudadUpdate(Ciudad u) throws Exception {
        String sql = "update ciudad set codigoCiudad='%s' ,nombre='%s'"
                + "where Pais_codigo='%s'";
        sql = String.format(sql, u.getCodigoCiudad(), u.getNombre(),
                u.getPais());

        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("La ciudad no existe");
        }
    }

    public List<Ciudad> CiudadSearch(String ciudad) {
        List<Ciudad> resultado = new ArrayList<Ciudad>();
        try {
            String sql = "select * "
                    + "from ciudad u "
                    + "where u.codigoCiudad like '%%%s%%'";
            sql = String.format(sql, ciudad);
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(Ciudad(rs));
            }
        } catch (SQLException ex) {
        }
        return resultado;

    }

    private Ciudad Ciudad(ResultSet rs) {
        try {
            Ciudad u = new Ciudad();
            u.setCodigoCiudad(rs.getString("codigoPais"));
            u.setNombre(rs.getString("nombre"));
            u.setPais(rs.getString("Pais_codigo"));
            return u;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
    
    /*----------------------DAO PAIS--------------------------*/
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
    
    public List<Pais> PaisSearch(String pais){
        List<Pais> resultado = new ArrayList<Pais>();
        try {
            String sql = "select * "+
                         "from pais u "+
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
