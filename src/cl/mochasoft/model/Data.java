package cl.mochasoft.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jorge A
 */
public class Data {

    private Conexion con;
    private String query;
    private ResultSet rs;

    public Data() throws ClassNotFoundException, SQLException {
        con = new Conexion("bd_compania_juegos");
    }

    public void createStaff(String nombre) throws SQLException {
        query = "INSERT INTO staff VALUES(NEWID(), '" + nombre + "');";
        con.ejecutar(query);
        con.close();
    }

    public void deleteStaff(String id_staff) throws SQLException {
        query = "EXEC eliminarStaff '" + id_staff + "' ;";
        con.ejecutar(query);
        con.close();
    }

    public void createGenero(String nombre) throws SQLException {
        query = "INSERT INTO staff VALUES(NEWID(), '" + nombre + "');";
        con.ejecutar(query);
        con.close();
    }

    public void createPlataforma(String n_plataforma, String n_compania) throws SQLException {
        query = "EXEC crearPlataforma '" + n_plataforma + "' , '" + n_compania + "' ;";
        con.ejecutar(query);
        con.close();
    }

    public void createEngine(String n_engine, String n_compania) throws SQLException {
        query = "EXEC crearEngine '" + n_engine + "' , '" + n_compania + "' ;";
        con.ejecutar(query);
        con.close();
    }

    public List<Juego> viewJuegos() throws SQLException {
        query = "SELECT * FROM juego;";
        List<Juego> juegos = new ArrayList<>();
        rs = con.ejecutarSelect(query);
        Juego jue;
        while (rs.next()) {
            jue = new Juego();
            jue.setId(rs.getString(1));
            jue.setTitulo(rs.getString(2));
            jue.setFk_genero(rs.getString(3));
            jue.setAnio_release(rs.getString(4));
            jue.setFk_plataforma(rs.getString(5));
            jue.setFk_engine(rs.getString(6));
            jue.setUnidades(rs.getLong(7));
            jue.setVersion(rs.getFloat(8));
            juegos.add(jue);
        }
        con.close();
        return juegos;
    }

    public int getCantJuego(String anio) throws SQLException {
        query = "SELECT dbo.juegos_py ('" + anio + "');";
        rs = con.ejecutarSelect(query);

        int resultado = 0;

        if (rs.next()) {
            resultado = rs.getInt(1);
        }

        con.close();
        return resultado;
    }

    public List<Staff> viewStaff() throws SQLException {
        query = "SELECT * FROM staff;";
        List<Staff> personal = new ArrayList<>();
        rs = con.ejecutarSelect(query);
        Staff per;
        while (rs.next()) {
            per = new Staff();
            per.setId(rs.getString(1));
            per.setNombre(rs.getString(2));

            personal.add(per);
        }
        con.close();
        return personal;
    }

    public List<StaffDespedido> viewStaffDespedido() throws SQLException {
        query = "SELECT * FROM staffDespedido;";
        List<StaffDespedido> personal = new ArrayList<>();
        rs = con.ejecutarSelect(query);
        StaffDespedido per;
        while (rs.next()) {
            per = new StaffDespedido();
            per.setId(rs.getString(1));
            per.setNombre(rs.getString(2));

            personal.add(per);
        }
        con.close();
        return personal;
    }

}
