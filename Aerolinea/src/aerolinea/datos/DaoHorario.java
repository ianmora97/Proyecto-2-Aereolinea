/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.datos;

import aerolinea.logica.Horario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ian Rodriguez
 */
public class DaoHorario {
    RelDatabase db;
    
    public DaoHorario(){
        db = new RelDatabase();
    }
    public Horario getHorario(String id) throws Exception {

        String sql = "select * from horario u where u.idHorario='%s'";
        sql = String.format(sql, id);
        ResultSet rs = db.executeQuery(sql);
        if (rs.next()) {
            return Horario(rs);
        } else {
            return null;
        }
    }

    public void HorarioDelete(String u) throws Exception {
        String sql = "delete from horario u where u.idHorario='%s'";
        sql = String.format(sql, u);
        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("Horario no existe");
        }
    }

    public void HorarioAdd(Horario u) throws Exception {

        String sql = "insert into horario (idHorario, duracion, fecha, horaLlegada, horaSalida, "
                + "precio) "
                + "values('%s','%s','%s','%s','%s','%s')";
        sql = String.format(sql,u.getIdHorario(), u.getDuracion(), u.getFecha(),
                u.getHoraLlegada(), u.getHoraSalida(), u.getPrecio());
        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("Horario ya existe");
        }
    }

    public void HorarioUpdate(Horario u) throws Exception {
        String sql = "update horario set idHorario = '%s', duracion='%s' ,fecha='%s', horaLLegada='%s',"
                + " horaSalida='%s', precio='%s'"
                + " where idHorario='%s'";
        sql = String.format(sql,u.getIdHorario(), u.getDuracion(), u.getFecha(),
                u.getHoraLlegada(), u.getHoraSalida(), u.getPrecio(), u.getIdHorario());

        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("El Horario no existe");
        }
    }

    public List<Horario> HorarioSearch(String horario) {
        List<Horario> resultado = new ArrayList<>();
        try {
            String sql = "select * "
                    + "from horario u "
                    + "where u.idHorario like '%%%s%%'";
            sql = String.format(sql, horario);
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(Horario(rs));
            }
        } catch (SQLException ex) {
        }
        return resultado;

    }
    
    public List<Horario> HorarioSearchEO() {
        List<Horario> resultado = new ArrayList<Horario>();
        try {
            String sql = "select * "
                    + "from horario ";
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(Horario(rs));
            }
        } catch (SQLException ex) {
        }
        return resultado;

    }

    private Horario Horario(ResultSet rs) {
        try {
            Horario u = new Horario();
            u.setIdHorario(rs.getString("idHorario"));
            u.setDuracion(rs.getString("duracion"));
            u.setFecha(rs.getString("fecha"));
            u.setHoraLlegada(rs.getString("horaLlegada"));
            u.setHoraSalida(rs.getString("horaSalida"));
            u.setPrecio(rs.getString("precio"));

            return u;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
}
