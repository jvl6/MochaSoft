package cl.mochasoft.model;

/**
 *
 * @author Jorge A
 */
public class Juego {

    private String id;
    private String titulo;
    private String fk_genero;
    private String anio_release;
    private String fk_plataforma;
    private String fk_engine;
    private long unidades;
    private float version;

    public Juego(String id, String titulo, String fk_genero, String anio_release, String fk_plataforma, String fk_engine, long unidades, float version) {
        this.id = id;
        this.titulo = titulo;
        this.fk_genero = fk_genero;
        this.anio_release = anio_release;
        this.fk_plataforma = fk_plataforma;
        this.fk_engine = fk_engine;
        this.unidades = unidades;
        this.version = version;
    }

    public Juego() {
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFk_genero() {
        return fk_genero;
    }

    public void setFk_genero(String fk_genero) {
        this.fk_genero = fk_genero;
    }

    public String getAnio_release() {
        return anio_release;
    }

    public void setAnio_release(String anio_release) {
        this.anio_release = anio_release;
    }

    public String getFk_plataforma() {
        return fk_plataforma;
    }

    public void setFk_plataforma(String fk_plataforma) {
        this.fk_plataforma = fk_plataforma;
    }

    public String getFk_engine() {
        return fk_engine;
    }

    public void setFk_engine(String fk_engine) {
        this.fk_engine = fk_engine;
    }

    public long getUnidades() {
        return unidades;
    }

    public void setUnidades(long unidades) {
        this.unidades = unidades;
    }

    public float getVersion() {
        return version;
    }

    public void setVersion(float version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Juego{" + "id=" + id + ", titulo=" + titulo + ", fk_genero=" + fk_genero + ", anio_release=" + anio_release + ", fk_plataforma=" + fk_plataforma + ", fk_engine=" + fk_engine + ", unidades=" + unidades + ", version=" + version + '}';
    }

}
