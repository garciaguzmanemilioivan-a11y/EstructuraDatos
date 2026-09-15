public class Main {
    public static void main(String[] args) {
        MaterialesYCrafteos Juego = new MaterialesYCrafteos();
        Juego.crafteosNoD();
        Juego.materialesNoD();
        Juego.agregarMaterial();
        System.out.println(Juego.materialesND);

        Jugador Steve = new Jugador();
        Steve.conseguirMateriales(Juego.inventario);
        Steve.conseguirCrafteos(Juego.crafteosND);
        for(Crafteo c : Steve.crafteosJ) {
            System.out.println(c.getNombre()+ " Los materiales necesarios para craftear son: " +c.getReceta());

        }

    }
}