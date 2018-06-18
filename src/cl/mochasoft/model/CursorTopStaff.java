package cl.mochasoft.model;

/**
 *
 * @author Jorge A
 */
public class CursorTopStaff {

    private String nombre;
    private int cantJuegos;

    public CursorTopStaff(String nombre, int cantJuegos) {
        this.nombre = nombre;
        this.cantJuegos = cantJuegos;
    }

    public CursorTopStaff() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantJuegos() {
        return cantJuegos;
    }

    public void setCantJuegos(int cantJuegos) {
        this.cantJuegos = cantJuegos;
    }

}
