package aerolinea.datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import aerolinea.logica.Ciudad;
import aerolinea.logica.Pais;
import aerolinea.logica.Vuelo;

public class DaoVuelo {

    RelDatabase db;

    public DaoVuelo() {
        db = new RelDatabase();
    }

    public Vuelo VueloGet(String id) throws Exception {

        String sql = "select * "
                + "from vuelo p inner join Ciudad e on p.Estado_codigo=e.codigo "
                + "where p.idVuelo='%s'";
        sql = String.format(sql, id);
        ResultSet rs = db.executeQuery(sql);
        if (rs.next()) {
            return Vuelo(rs);
        } else {
            throw new Exception("Vuelo no Existe");
        }
    }

    public void VueloDelete(Vuelo v) throws Exception {
        String sql = "delete from vuelo where idVuelo='%s'";
        sql = String.format(sql, v.getIdVuelo());
        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("Vuelo no existe");
        }
    }

    public void VueloAdd(Vuelo v) throws Exception {

        String sql = "insert into Persona (idVuelo, dia, Ciudad_origen, Ciudad_destino) "
                + "values('%s','%s','%s','%s')";
        sql = String.format(sql, v.getIdVuelo(), v.getDia(), v.getOrigen().getCodigoCiudad(), v.getDestino().getCodigoCiudad());
        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("Vuelo ya existe");
        }
    }

    public void VueloUpdate(Vuelo v) throws Exception {
        String sql = "update vuelo set dia='%s' "
                + "where idVuelo='%s'";
        sql = String.format(sql, v.getDia(), v.getOrigen(), v.getDestino());

        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("Vuelo no existe");
        }
    }

    public List<Vuelo> VueloSearch(String dia) {//preguntar
        List<Vuelo> resultado = new ArrayList<Vuelo>();
        try {
            String sql = "select * "
                    + "from vuelo v inner join Ciudad e on v.Ciudad_codigo=e.codigo "
                    + "where v.dia like '%%%s%%'";
            sql = String.format(sql, dia);
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(Vuelo(rs));
            }
        } catch (SQLException ex) {
        }
        return resultado;

    }

    public List<Ciudad> CiudadSearch(String nombre) {
        List<Ciudad> resultado = new ArrayList<Ciudad>();
        try {
            String sql = "select * "
                    + "from  Ciudad";

            sql = String.format(sql, nombre);
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {

                resultado.add(Ciudad(rs));
            }
        } catch (SQLException ex) {
            System.out.println("NO SE PUDO CARGAR ESTADO");
        }
        return resultado;
    }

    public Ciudad CiudadGet(String codigo) throws Exception {
        String sql = "select* "
                + "from  Ciudad e  ";

        sql = String.format(sql, codigo);
        ResultSet rs = db.executeQuery(sql);
        if (rs.next()) {
            return Ciudad(rs);
        } else {
            throw new Exception("Ciudad  no Existe");
        }
    }

    private Pais Pais(ResultSet rs) {
        try {
            Pais p = new Pais();
            p.setCodigoPais(rs.getString("codigoPais"));
            p.setNombre(rs.getString("nombre"));
            return p;
        } catch (SQLException ex) {
            return null;
        }
    }

    private Ciudad Ciudad(ResultSet rs) {
        try {
            Ciudad c = new Ciudad();
            c.setCodigoCiudad(rs.getString("codigoCiudad"));
            c.setNombre(rs.getString("nombre"));
            c.setPais(rs.getString("Pais_codigo"));
            return c;
        } catch (SQLException ex) {
            return null;
        }
    }

    private Vuelo Vuelo(ResultSet rs) {
        try {
            Vuelo v = new Vuelo();
            v.setIdVuelo(rs.getString("id"));
            v.setDia(rs.getString("dia"));
            v.setOrigen(Ciudad(rs));
            v.setDestino(Ciudad(rs));
            return v;
        } catch (SQLException ex) {
            return null;
        }
    }

    public List<Ciudad> llenarCombo() {
        List<Ciudad> resultado = new ArrayList<Ciudad>();
        try {
            String sql = "select * "
                    + "from  Ciudad";
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {

                resultado.add(Ciudad(rs));
            }
        } catch (SQLException ex) {
            System.out.println("NO SE PUDO CARGAR CIUDAD");
        }
        return resultado;
    }

    public void close() {
    }
}
