package cl.mochasoft.model;

/**
 *
 * @author Jorge A
 */
public class StaffDespedido {

    private String id;
    private String nombre;

    public StaffDespedido(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public StaffDespedido() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Staff{" + "id=" + id + ", nombre=" + nombre + '}';
    }

}
