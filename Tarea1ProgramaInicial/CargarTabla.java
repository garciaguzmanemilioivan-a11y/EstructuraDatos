import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CargarTabla {

    public static List<List<String>> cargarCSV(String RutaArchivo) {
        List<List<String>> tabla = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/emiiv/Downloads/TablaDatos.csv"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.replace("\r", "");
                tabla.add(parsearLineaCSV(linea));
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

        return tabla;
    }

    private static List<String> parsearLineaCSV(String linea) {
        List<String> columnas = new ArrayList<>();
        StringBuilder celdaActual = new StringBuilder();
        boolean dentroDeComillas = false;

        for (char c : linea.toCharArray()) {
            if (c == '"') {
                dentroDeComillas = !dentroDeComillas;
            } else if (c == ',' && !dentroDeComillas) {
                columnas.add(celdaActual.toString().trim());
                celdaActual.setLength(0);
            } else {
                celdaActual.append(c);
            }
        }
        columnas.add(celdaActual.toString().trim());
        return columnas;
    }

    public static void mostrarTabla(List<List<String>> tabla) {
        for (List<String> fila : tabla) {
            for (String celda : fila) {
                System.out.printf("%-40s", celda);
            }
            System.out.println();
        }
    }

    public static int buscarFila(List<List<String>> tabla, String redSocial, String concepto) {
        for (int i = 0; i < tabla.size(); i++) {
            List<String> fila = tabla.get(i);
            if (fila.get(0).equalsIgnoreCase(redSocial) && fila.get(1).equalsIgnoreCase(concepto)) {
                return i;
            }
        }
        return -1;
    }

    public static int buscarColumnaMes(List<List<String>> tabla, String mes) {
        List<String> encabezado = tabla.get(0);
        for (int j = 0; j < encabezado.size(); j++) {
            if (encabezado.get(j).equalsIgnoreCase(mes)) {
                return j;
            }
        }
        return -1;
    }

    public static double obtenerValorNumerico(List<List<String>> tabla, int fila, int columna) {
        String texto = tabla.get(fila).get(columna).replace("%", "").trim();
        try {
            return Double.parseDouble(texto);
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
}