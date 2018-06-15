package cl.mochasoft.model;

/**
 *
 * @author Jorge A
 */
public class Juego {

    private int id;
    private String titulo;
    private int fk_genero;
    private String anio;
    private int fk_plataforma;
    private int fk_engine;

    public Juego(int id, String titulo, int fk_genero, String anio, int fk_plataforma, int fk_engine) {
        this.id = id;
        this.titulo = titulo;
        this.fk_genero = fk_genero;
        this.anio = anio;
        this.fk_plataforma = fk_plataforma;
        this.fk_engine = fk_engine;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getFk_genero() {
        return fk_genero;
    }

    public void setFk_genero(int fk_genero) {
        this.fk_genero = fk_genero;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public int getFk_plataforma() {
        return fk_plataforma;
    }

    public void setFk_plataforma(int fk_plataforma) {
        this.fk_plataforma = fk_plataforma;
    }

    public int getFk_engine() {
        return fk_engine;
    }

    public void setFk_engine(int fk_engine) {
        this.fk_engine = fk_engine;
    }

    @Override
    public String toString() {
        return "Juego{" + "id=" + id + ", titulo=" + titulo + ", fk_genero=" + fk_genero + ", anio=" + anio + ", fk_plataforma=" + fk_plataforma + ", fk_engine=" + fk_engine + '}';
    }

}
