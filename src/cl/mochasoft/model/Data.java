package cl.mochasoft.model;

import com.sun.javafx.scene.control.skin.VirtualFlow;
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
        con = new Conexion("bd_mochasoft");
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
        query = "INSERT INTO genero VALUES(NEWID(), '" + nombre + "');";
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

    public void createJuego(String titulo, String genero, String anio, String plataforma, String engine, String unidades, String version) throws SQLException {
        query = "EXEC crearJuego '" + titulo + "','" + genero + "','" + anio + "','" + plataforma + "','" + engine + "'," + unidades + "," + version + ";";
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

    public List<Genero> viewGenero() throws SQLException {
        query = "SELECT * FROM genero;";
        List<Genero> gen = new ArrayList<>();
        rs = con.ejecutarSelect(query);
        Genero g;

        while (rs.next()) {
            g = new Genero();
            g.setId(rs.getString(1));
            g.setNombre(rs.getString(2));
            gen.add(g);
        }

        con.close();
        return gen;
    }

    public List<Plataforma> viewPlataforma() throws SQLException {
        query = "SELECT * FROM plataforma;";
        List<Plataforma> plat = new ArrayList<>();
        rs = con.ejecutarSelect(query);
        Plataforma p;

        while (rs.next()) {
            p = new Plataforma();
            p.setId(rs.getString(1));
            p.setNombre(rs.getString(2));
            plat.add(p);
        }

        con.close();
        return plat;
    }

    public List<Engine> viewEngine() throws SQLException {
        query = "SELECT * FROM engine;";
        List<Engine> en = new ArrayList<>();
        rs = con.ejecutarSelect(query);
        Engine e;

        while (rs.next()) {
            e = new Engine();
            e.setId(rs.getString(1));
            e.setNombre(rs.getString(2));
            en.add(e);
        }

        con.close();
        return en;
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
        query = "SELECT * FROM staff_despedido;";
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

    public CompaniaPlataforma encontrarCompaniaPlataforma(String plataforma) throws SQLException {
        query = "SELECT * FROM compania_plataforma WHERE nombre = '" + plataforma + "';";
        rs = con.ejecutarSelect(query);

        CompaniaPlataforma comp = null;
        while (rs.next()) {
            comp = new CompaniaPlataforma();
            comp.setId(rs.getString(1));
            comp.setNombre(rs.getString(2));
        }

        con.close();
        return comp;
    }

    public CompaniaEngine encontrarCompaniaEngine(String engine) throws SQLException {
        query = "SELECT * FROM compania_engine WHERE nombre = '" + engine + "';";
        rs = con.ejecutarSelect(query);

        CompaniaEngine comp = null;
        while (rs.next()) {
            comp = new CompaniaEngine();
            comp.setId(rs.getString(1));
            comp.setNombre(rs.getString(2));
        }

        con.close();
        return comp;
    }

    public int existeStaff(String nombre) throws SQLException {
        query = "SELECT COUNT(*) FROM staff WHERE nombre = '" + nombre + "'";
        rs = con.ejecutarSelect(query);

        int resultado = 0;

        if (rs.next()) {
            resultado = rs.getInt(1);
        }

        con.close();
        return resultado;
    }

    public Staff getStaffId(String nombre) throws SQLException {
        query = "SELECT id FROM staff WHERE nombre = '" + nombre + "'";
        rs = con.ejecutarSelect(query);
        Staff per = null;

        while (rs.next()) {
            per = new Staff();
            per.setId(rs.getString(1));
        }

        con.close();
        return per;
    }

    public List<CursorTopStaff> viewTopStaff(String anio) throws SQLException {
        query = "EXEC informe_desarrollador_top '" + anio + "' ;";
        List<CursorTopStaff> top = new ArrayList<>();
        rs = con.ejecutarSelect(query);
        CursorTopStaff cts;

        while (rs.next()) {
            cts = new CursorTopStaff();
            cts.setNombre(rs.getString(1));
            cts.setCantJuegos(rs.getInt(2));
            top.add(cts);
        }

        con.close();
        return top;
    }

}
