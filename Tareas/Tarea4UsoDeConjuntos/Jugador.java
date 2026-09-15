import java.util.HashSet;
import java.util.Set;

public class Jugador {
    Set<Crafteo> crafteosJ = new HashSet();
    Set<String> materialesD = new HashSet();

    public void conseguirMateriales(Set<String> MaterialesND) {
        for(String M : MaterialesND) {
            materialesD.add(M);

        }

    }

    public void conseguirCrafteos (Set<Crafteo> CrafteosND) {
        for(Crafteo C : CrafteosND) {
            if(materialesD.containsAll(C.getReceta()) == true) {
                crafteosJ.add(C);

            }

        }

    }

}
