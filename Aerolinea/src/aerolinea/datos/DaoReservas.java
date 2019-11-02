/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.datos;

import aerolinea.logica.Reservacion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ian Rodriguez
 */
public class DaoReservas {
    RelDatabase db;
    
    public DaoReservas(){
        db = new RelDatabase();
    }
    public Reservacion getReservacion(String id) throws Exception {

        String sql = "select * from reservacion u where u.idReserva='%s'";
        sql = String.format(sql, id);
        ResultSet rs = db.executeQuery(sql);
        if (rs.next()) {
            return Reservacion(rs);
        } else {
            return null;
        }
    }

    public void ReservacionDelete(String u) throws Exception {
        String sql = "delete from reservacion u where u.idReserva='%s'";
        sql = String.format(sql, u);
        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("Reservacion no existe");
        }
    }

    public void ReservacionAdd(Reservacion u) throws Exception {

        String sql = "insert into reservacion (idReserva, vuelo, asiento, "
                + "Pago_id) "
                + "values('%s','%s','%s','%s')";
        sql = String.format(sql,u.getIdReserva(), u.getVuelo(), u.getAsiento(),
                u.getPago_id());
        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("La Reservacion ya existe");
        }
    }

    public void ReservacionUpdate(Reservacion u) throws Exception {
        String sql = "update reservacion set idReserva = '%s', vuelo='%s' "
                + ",asiento='%s', Pago_id='%s',"
                + " where idReserva='%s'";
        sql = String.format(sql,u.getIdReserva(), u.getVuelo(), u.getAsiento(),
                u.getPago_id());

        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("La reserva no existe");
        }
    }

    public List<Reservacion> ReservacionSearch(String horario) {
        List<Reservacion> resultado = new ArrayList<>();
        try {
            String sql = "select * "
                    + "from reservacion u "
                    + "where u.idReserva like '%%%s%%'";
            sql = String.format(sql, horario);
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(Reservacion(rs));
            }
        } catch (SQLException ex) {
        }
        return resultado;

    }
    
    public List<Reservacion> ReservacionSearchEO() {
        List<Reservacion> resultado = new ArrayList<Reservacion>();
        try {
            String sql = "select * "
                    + "from reservacion ";
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(Reservacion(rs));
            }
        } catch (SQLException ex) {
        }
        return resultado;

    }

    private Reservacion Reservacion(ResultSet rs) {
        try {
            Reservacion u = new Reservacion();
            u.setIdReserva(rs.getString("idReserva"));
            u.setVuelo(rs.getString("vuelo"));
            u.setAsiento(rs.getString("asiento"));
            u.setPago_id(rs.getString("Pago_id"));
            return u;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
}
