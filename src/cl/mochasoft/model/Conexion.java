package cl.mochasoft.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Jorge A
 */
public class Conexion {

    private Connection con;
    private Statement sen;
    private ResultSet rs;

    public Conexion() {
    }

    public Conexion(String bd) throws ClassNotFoundException, SQLException {
        String protocolo = "jdbc:sqlserver://";
        String database = "database=" + bd;
        String security = "integratedSecurity=true"; // Usa las credenciales de windows

        String url = protocolo + ";" + database + ";" + security + ";";

        // jdbc:sqlserver://;database=bd_compania_juegos;integratedSecurity=true;
        System.out.println(url);

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        con = DriverManager.getConnection(url);
    }

    public static void main(String[] args) {
        try {
            Conexion c = new Conexion("bd_compania_juegos");
            System.out.println("Todo OK");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // INSERT, UPDATE, DELETE, DROP
    public void ejecutar(String query) throws SQLException {
        System.out.println(query);
        sen = con.createStatement();
        sen.executeUpdate(query);
        close();
    }

    // Todas las consultas que retornen resultados.
    public ResultSet ejecutarSelect(String query) throws SQLException {
        System.out.println(query);
        sen = con.createStatement();
        rs = sen.executeQuery(query);
        return rs;
    }

    public void close() throws SQLException {
        sen.close();
    }
}
