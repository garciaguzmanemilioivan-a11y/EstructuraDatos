import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<List<String>> tabla = CargarTabla.cargarCSV("TablaDatos.csv");

        System.out.println("=== TABLA DE DATOS CARGADA ===");
        CargarTabla.mostrarTabla(tabla);

        // Ejecuta los requisitos
        Preguntas.diferenciaSeguidoresTwitter(tabla);

        System.out.println("\n--- CONSULTA DE VISUALIZACIONES EN YOUTUBE ---");
        System.out.print("Ingrese el primer mes (ej. ENERO): ");
        String mes1 = scanner.nextLine();
        System.out.print("Ingrese el segundo mes (ej. JUNIO): ");
        String mes2 = scanner.nextLine();
        Preguntas.diferenciaVisualizacionesYouTube(tabla, mes1, mes2);

        Preguntas.promedioCrecimientoFBAndTW(tabla);
        Preguntas.promedioMeGustaTodasRedes(tabla);

        scanner.close();
    }
}