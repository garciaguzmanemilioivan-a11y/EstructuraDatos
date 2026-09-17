public class Main {

    public static void main(String[] args) {
        Nodo<String> head = new Nodo("Al", new Nodo("B", new Nodo("C", new Nodo("De", new Nodo("Mc", new Nodo("Zi", null))))));
        Nodo<String> cursor = head;

        System.out.println("Imprirmir todo el Nodo:");
        imprimirNodo(cursor);

        System.out.println("\nImprimir el primer dato del Nodo: [" + cursor.getDato()+"]\n");

        String ref = "Zi";
        while(!cursor.getDato().equals(ref)){
            cursor = cursor.getSiguiente();

        }
        System.out.println("Imprimir el estado completo del ultimo nodo: ["+cursor.getDato()+"] ["+cursor.getSiguiente()+"]\n");
        cursor = head;

        String ref2 = "De";
        while(!cursor.getDato().equals(ref2)){
            cursor = cursor.getSiguiente();

        }
        cursor.setSiguiente(new Nodo("Fe", cursor.getSiguiente()));
        cursor = head;
        System.out.println("Imprimir el nuevo nodo Fe: ");
        imprimirNodo(cursor);

        while(!cursor.getDato().equals(ref)) {
            cursor = cursor.getSiguiente();

        }
        cursor.setSiguiente(new Nodo("Zz", cursor.getSiguiente()));
        cursor = head;
        System.out.println("\nImprimir el nuevo nodo al final Zz: ");
        imprimirNodo(cursor);

        head = new Nodo("Aa", head);
        System.out.println("\nImprimir el nuevo nodo al principio Aa:");
        imprimirNodo(head);

    }

    public static void imprimirNodo(Nodo<String> head) {
        Nodo<String> actual = head;
        while(actual != null) {
            System.out.println("[" + actual.getDato() + "]");
            actual = actual.getSiguiente();

        }

    }

}