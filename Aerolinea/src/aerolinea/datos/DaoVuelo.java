package aerolinea.datos;

import aerolinea.logica.Vuelo;
import aerolinea.logica.Avion;
import aerolinea.logica.Horario;
import aerolinea.logica.Ruta;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import aerolinea.logica.Vuelo;

public class DaoVuelo {

    RelDatabase db;

    public DaoVuelo() {
        db = new RelDatabase();
    }

    public Vuelo getVuelos(String id) throws Exception {

        String sql = "select "
                + "ruta, ciudadDestino, ciudadOrigen, fecha, "
                + "horaSalida,horaLlegada,duracion, precio, numPasajeros, "
                + "marca, modelo, anno   "
                + "from vuelo v "
                + "inner join avion a on v.avion = a.idTipoAvion "
                + "inner join ruta r on v.ruta = r.codigoRuta "
                + "inner join horario h on v.horario = h.idhorario"
                + "where v.idvuelo = '%s' ";
        sql = String.format(sql, id);
        ResultSet rs = db.executeQuery(sql);
        if (rs.next()) {
            return Vuelo(rs);
        } else {
            throw new Exception("Vuelo no Existe");
        }
    }
    public void VuelosAdd(Vuelo u) throws Exception {

        String sql = "insert into vuelo value('%s','%s','%s','%s') ";
        sql = String.format(sql, u.getIdVuelo(), u.getAvion().getIdTipoAvion(),
                u.getRuta().getCodigoRuta(), u.getHorario().getIdHorario());
        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("Vuelo ya existe");
        }
    }
    public int getCantidadRegistros() throws Exception{
        String sql = "select count(*) from vuelo";
        int count = db.executeUpdate(sql);
        if(count == 0){
            return 0;
        }
        return count;
    }
    
    public List<Vuelo> VueloSearch(String s) {
        List<Vuelo> resultado = new ArrayList<Vuelo>();
        try {
            String sql = "select "
                + "idvuelo, ruta, ciudadDestino, ciudadOrigen, fecha, "
                + "horaSalida,horaLlegada,duracion, precio, numPasajeros, "
                + "marca, modelo, anno "
                + "from vuelo v "
                + "inner join avion a on v.avion = a.idTipoAvion "
                + "inner join ruta r on v.ruta = r.codigoRuta "
                + "inner join horario h on v.horario = h.idhorario"
                + "where v.idvuelo = '%%%s%%' ";
            sql = String.format(sql, s);
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(Vuelo(rs));
            }
        } catch (SQLException ex) {
        }
        return resultado;

    }
    public List<Vuelo> VueloSearchEO() {
        List<Vuelo> resultado = new ArrayList<Vuelo>();
        try {
            String sql = "select "
                + "idvuelo, ruta, ciudadDestino, ciudadOrigen, fecha, "
                + "horaSalida,horaLlegada,duracion, precio, numPasajeros, "
                + "marca, modelo, anno "
                + "from vuelo v "
                + "inner join avion a on v.avion = a.idTipoAvion "
                + "inner join ruta r on v.ruta = r.codigoRuta "
                + "inner join horario h on v.horario = h.idhorario";
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(Vuelo(rs));
            }
        } catch (SQLException ex) {
        }
        return resultado;

    }
    private Vuelo Vuelo(ResultSet rs) {
        try {
            Vuelo u = new Vuelo();
            u.setIdVuelo(rs.getString("idvuelo"));
            u.setAvion(Avion(rs));
            u.setHorario(Horario(rs));
            u.setRuta(Ruta(rs));
            return u;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
    private Avion Avion(ResultSet rs) {
        try {
            Avion u = new Avion();
            u.setIdTipoAvion("");
            u.setNumPasajeros(rs.getInt("numPasajeros"));
            u.setFilas(0);
            u.setAsientos(0);
            u.setModelo(rs.getString("modelo"));
            u.setMarca(rs.getString("marca"));
            u.setAnno(rs.getString("anno"));

            return u;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
    private Horario Horario(ResultSet rs) {
        try {
            Horario u = new Horario();
            u.setIdHorario("");
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
    private Ruta Ruta(ResultSet rs) {
        try {
            Ruta u = new Ruta();
            u.setCodigoRuta(rs.getString("ruta"));
            u.setCiudadDestino(rs.getString("ciudadDestino"));
            u.setCiudadOrigen(rs.getString("ciudadOrigen"));
            return u;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
}
