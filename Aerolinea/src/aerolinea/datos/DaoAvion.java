/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.datos;

import aerolinea.logica.Avion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ian Rodriguez
 */
public class DaoAvion {

    RelDatabase db;

    public DaoAvion() {
        db = new RelDatabase();
    }

    public Avion getAvion(String id) throws Exception {

        String sql = "select * from avion u where u.idTipoAvion='%s'";
        sql = String.format(sql, id);
        ResultSet rs = db.executeQuery(sql);
        if (rs.next()) {
            return Avion(rs);
        } else {
            return null;
        }
    }

    public void AvionDelete(String u) throws Exception {
        String sql = "delete from avion where idTipoAvion='%s'";
        sql = String.format(sql, u);
        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("Avion no existe");
        }
    }

    public void AvionAdd(Avion u) throws Exception {

        String sql = "insert into avion (idTipoAvion, numPasajeros, filas, asientos, "
                + "modelo, marca, anno) "
                + "values('%s','%s','%s','%s','%s','%s','%s')";
        sql = String.format(sql, u.getIdTipoAvion(), u.getNumPasajeros(),
                u.getFilas(), u.getAsientos(), u.getModelo(), u.getMarca(),
                u.getAnno());
        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("Avion ya existe");
        }
    }

    public void AvionUpdate(Avion u) throws Exception {
        String sql = "update avion set idTipoAvion='%s' ,numPasajeros='%s', filas='%s', asientos='%s', "
                + "modelo='%s', marca='%s', anno='%s' "
                + "where idTipoAvion='%s'";
        sql = String.format(sql, u.getIdTipoAvion(), u.getNumPasajeros(),
                u.getFilas(), u.getAsientos(), u.getModelo(), u.getMarca(),
                u.getAnno(), u.getIdTipoAvion());

        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("El Avion no existe");
        }
    }

    public List<Avion> AvionSearch(String avion) {
        List<Avion> resultado = new ArrayList<Avion>();
        try {
            String sql = "select * "
                    + "from avion u "
                    + "where u.idTipoAvion like '%%%s%%'";
            sql = String.format(sql, avion);
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(Avion(rs));
            }
        } catch (SQLException ex) {
        }
        return resultado;

    }
    
    public List<Avion> AvionSearchEO() {
        List<Avion> resultado = new ArrayList<Avion>();
        try {
            String sql = "select * "
                    + "from avion ";
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(Avion(rs));
            }
        } catch (SQLException ex) {
        }
        return resultado;

    }

    private Avion Avion(ResultSet rs) {
        try {
            Avion u = new Avion();
            u.setIdTipoAvion(rs.getString("idTipoAvion"));
            u.setNumPasajeros(rs.getInt("numPasajeros"));
            u.setFilas(rs.getInt("filas"));
            u.setAsientos(rs.getInt("asientos"));
            u.setModelo(rs.getString("modelo"));
            u.setMarca(rs.getString("marca"));
            u.setAnno(rs.getString("anno"));

            return u;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
}
