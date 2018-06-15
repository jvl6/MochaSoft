package cl.mochasoft.model;

/**
 *
 * @author Jorge A
 */
public class JuegoStaff {

    private int id;
    private int fk_juego;
    private int fk_staff;
    private String rol;

    public JuegoStaff(int id, int fk_juego, int fk_staff, String rol) {
        this.id = id;
        this.fk_juego = fk_juego;
        this.fk_staff = fk_staff;
        this.rol = rol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFk_juego() {
        return fk_juego;
    }

    public void setFk_juego(int fk_juego) {
        this.fk_juego = fk_juego;
    }

    public int getFk_staff() {
        return fk_staff;
    }

    public void setFk_staff(int fk_staff) {
        this.fk_staff = fk_staff;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "JuegoStaff{" + "id=" + id + ", fk_juego=" + fk_juego + ", fk_staff=" + fk_staff + ", rol=" + rol + '}';
    }

}
