package cl.mochasoft.model;

import java.sql.ResultSet;
import java.sql.SQLException;

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

}
