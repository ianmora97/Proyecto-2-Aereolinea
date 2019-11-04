/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.datos;

import aerolinea.logica.MetodoPago;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ian Rodriguez
 */
public class DaoMetodoPago {
     RelDatabase db;
    
    public DaoMetodoPago(){
        db = new RelDatabase();
    }
    public MetodoPago getMetodoPago(String id) throws Exception {

        String sql = "select * from metodopago u where u.idMetodo='%s'";
        sql = String.format(sql, id);
        ResultSet rs = db.executeQuery(sql);
        if (rs.next()) {
            return MetodoPago(rs);
        } else {
            return null;
        }
    }

    public void MetodoPagoDelete(String u) throws Exception {
        String sql = "delete from metodopago u where u.idMetodo='%s'";
        sql = String.format(sql, u);
        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("El metodo de pago no existe");
        }
    }

    public void MetodoPagoAdd(MetodoPago u) throws Exception {

        String sql = "insert into metodopago values('%s','%s','%s','%s','%s','%s')";
        sql = String.format(sql,u.getId(), u.getCardNum(), u.getVemc(),
                u.getVcc(), u.getHolder(), u.getCorreoP());
        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("Metodo de pago ya existe");
        }
    }

    public void MetodoPagoUpdate(MetodoPago u) throws Exception {
        String sql = "update metodopago set idMetodo = '%s', cardNum='%s' "
                + ",vencimiento='%s', vcc='%s',"
                + " holder='%s', correoP='%s'"
                + " where idMetodo='%s'";
        sql = String.format(sql,u.getId(), u.getCardNum(), u.getVemc(),
                u.getVcc(), u.getHolder(), u.getCorreoP(), u.getId());

        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("El Metodo de pago no existe");
        }
    }

    public List<MetodoPago> MetodoPagoSearch(String horario) {
        List<MetodoPago> resultado = new ArrayList<>();
        try {
            String sql = "select * "
                    + "from metodopago u "
                    + "where u.idMetodo like '%%%s%%'";
            sql = String.format(sql, horario);
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(MetodoPago(rs));
            }
        } catch (SQLException ex) {
        }
        return resultado;

    }
    
    public List<MetodoPago> MetodoPagoSearchEO() {
        List<MetodoPago> resultado = new ArrayList<>();
        try {
            String sql = "select * "
                    + "from metodopago ";
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(MetodoPago(rs));
            }
        } catch (SQLException ex) {
        }
        return resultado;

    }

    private MetodoPago MetodoPago(ResultSet rs) {
        try {
            MetodoPago u = new MetodoPago();
            u.setId(rs.getString("idMetodo"));
            u.setCardNum(rs.getString("cardNum"));
            u.setVemc(rs.getString("vencimiento"));
            u.setVcc(rs.getString("vcc"));
            u.setHolder(rs.getString("holder"));
            u.setCorreoP(rs.getString("correoP"));

            return u;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
}
