/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.datos;

import aerolinea.logica.Ruta;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ian Rodriguez
 */
public class DaoRutas {

    RelDatabase db;

    public DaoRutas() {
        db = new RelDatabase();
    }

    public Ruta getRuta(String id) throws Exception {

        String sql = "select * from ruta u where u.codigoRuta='%s'";
        sql = String.format(sql, id);
        ResultSet rs = db.executeQuery(sql);
        if (rs.next()) {
            return Ruta(rs);
        } else {
            return null;
        }
    }

    public void RutaDelete(String u) throws Exception {
        String sql = "delete from ruta where codigoRuta='%s'";
        sql = String.format(sql, u);
        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("Ruta no existe");
        }
    }

    public void RutaAdd(Ruta u) throws Exception {

        String sql = "insert into ruta (codigoRuta, ciudadDestino, ciudadOrigen) "
                + "values('%s','%s','%s')";
        sql = String.format(sql, u.getCodigoRuta(), u.getCiudadDestino(),
                u.getCiudadOrigen());
        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("Ruta ya existe");
        }
    }

    public void RutaUpdate(Ruta u) throws Exception {
        String sql = "update ruta set codigoRuta='%s' ,ciudadDestino='%s', ciudadOrigen='%s' "
                + "where codigoRuta='%s'";
        sql = String.format(sql, u.getCodigoRuta(), u.getCiudadDestino(),
                u.getCiudadOrigen(), u.getCodigoRuta());

        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("La ruta no existe");
        }
    }

    public List<Ruta> RutaSearch(String ruta) {
        List<Ruta> resultado = new ArrayList<Ruta>();
        try {
            String sql = "select * "
                    + "from ruta u "
                    + "where u.codigoRuta like '%%%s%%'";
            sql = String.format(sql, ruta);
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(Ruta(rs));
            }
        } catch (SQLException ex) {
        }
        return resultado;

    }

    public List<Ruta> UsuarioSearchEO() {
        List<Ruta> resultado = new ArrayList<Ruta>();
        try {
            String sql = "select * "
                    + "from ruta ";
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(Ruta(rs));
            }
        } catch (SQLException ex) {
        }
        return resultado;

    }

    private Ruta Ruta(ResultSet rs) {
        try {
            Ruta u = new Ruta();
            u.setCodigoRuta(rs.getString("codigoRuta"));
            u.setCiudadDestino(rs.getString("ciudadDestino"));
            u.setCiudadOrigen(rs.getString("ciudadOrigen"));
            return u;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
}
