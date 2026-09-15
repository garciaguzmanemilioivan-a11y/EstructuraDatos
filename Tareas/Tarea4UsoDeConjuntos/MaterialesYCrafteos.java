import java.util.HashSet;
import java.util.Set;

public class MaterialesYCrafteos {
    Set<String> materialesND = new HashSet<>();
    Set<Crafteo> crafteosND = new HashSet<>();
    Set<String> inventario = new HashSet<>();

    public void materialesNoD() {
        materialesND.add("Tablon de Madera");
        materialesND.add("Piedra");
        materialesND.add("Palo de Madera");
        materialesND.add("Hierro");
        materialesND.add("Tronco de Madera");
        materialesND.add("Carbon");
        materialesND.add("Diamante");
        materialesND.add("Obsidiana");
        materialesND.add("Libro");
    }

    public void crafteosNoD() {
        Set<String> elementos1 = new HashSet<>();
        elementos1.add("Tronco de Madera");
        Crafteo tablonMadera = new Crafteo("Tablon de Madera", elementos1);
        crafteosND.add(tablonMadera);

        Set<String> elementos2 = new HashSet<>();
        elementos2.add("Tablon de Madera");
        Crafteo palo = new Crafteo("Palo de Madera", elementos2);
        crafteosND.add(palo);

        Set<String> elementos3 = new HashSet<>();
        elementos3.add("Palo de Madera");
        elementos3.add("Hierro");
        Crafteo picoHierro = new Crafteo("Pico de Hierro", elementos3);
        crafteosND.add(picoHierro);

        Set<String> elementos4 = new HashSet<>();
        elementos4.add("Carbon");
        elementos4.add("Palo de Madera");
        Crafteo antorcha = new Crafteo("Antorcha", elementos4);
        crafteosND.add(antorcha);

        Set<String> elementos5 = new HashSet<>();
        elementos5.add("Palo de Madera");
        elementos5.add("Carbon");
        elementos5.add("Tablon de Madera");
        Crafteo fogata = new Crafteo("Fogata", elementos5);
        crafteosND.add(fogata);

        Set<String> elementos6 = new HashSet<>();
        elementos6.add("Diamante");
        elementos6.add("Obsidiana");
        elementos6.add("Libro");
        Crafteo mesaEncantamiento = new Crafteo("Mesa de Encantamientos", elementos6);
        crafteosND.add(mesaEncantamiento);

    }

    public void agregarMaterial () {
        inventario.add("Diamante");
        inventario.add("Obsidiana");
        inventario.add("Libro");
        inventario.add("Tablon de Madera");
    }

    public Set<String> getMaterialesND() {
        return materialesND;
    }

    public Set<Crafteo> getCrafteosND() {
        return crafteosND;
    }

}
