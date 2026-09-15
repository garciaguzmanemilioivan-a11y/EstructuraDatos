import java.util.Set;

public class Crafteo {
    private String nombre;
    Set<String> receta;

    public Crafteo(String nombre, Set<String> receta) {
        this.receta = receta;
        this.nombre = nombre;
    }

    public Set<String> getReceta() {
        return receta;
    }

    public String getNombre() {
        return nombre;
    }
}