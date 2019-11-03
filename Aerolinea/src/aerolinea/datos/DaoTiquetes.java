/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.datos;

import aerolinea.logica.Reservacion;
import aerolinea.logica.Tiquete;
import aerolinea.logica.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ian Rodriguez
 */
public class DaoTiquetes {

    RelDatabase db;

    public DaoTiquetes() {
        db = new RelDatabase();
    }

    public Tiquete getTiquete(String id) throws Exception {

        String sql = "select * from tiquete u where u.idReserva='%s'";
        sql = String.format(sql, id);
        ResultSet rs = db.executeQuery(sql);
        if (rs.next()) {
            return Tiquete(rs);
        } else {
            return null;
        }
    }
    public List<Tiquete> TiqueteSearchEO() {
        List<Tiquete> resultado = new ArrayList<Tiquete>();
        try {
            String sql = "select * from tiquete";
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(Tiquete(rs));
            }
        } catch (SQLException ex) {
        }
        return resultado;

    }
    public List<Tiquete> getTiquetesList(String s) {
        List<Tiquete> resultado = new ArrayList<Tiquete>();
        try {
            String sql = "select numTiquete,reserva,nombre,asiento "
                    + "from tiquete v "
                    + "inner join reservacion a on v.reserva = a.idReserva "
                    + "inner join usuario u on v.Usuario_id = u.idUsuario "
                    + "where a.idReserva like '%%%s%%'";
            sql = String.format(sql, s);
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(Tiquete(rs));
            }
        } catch (SQLException ex) {
        }
        return resultado;

    }

    

    private Tiquete Tiquete(ResultSet rs) {
        try {
            Tiquete u = new Tiquete();
            u.setNumTiquete(rs.getString("numTiquete"));
            u.setReservacion(rs.getString("reserva"));
            u.setUsuario(rs.getString("Usuario_id"));
            u.setAsiento(rs.getString("asiento"));

            return u;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
}
