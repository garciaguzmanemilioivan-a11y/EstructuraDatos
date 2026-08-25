import java.util.List;

public class Preguntas {

    public static void diferenciaSeguidoresTwitter(List<List<String>> tabla) {
        int filaTwitter = CargarTabla.buscarFila(tabla, "TWITTER", "SEGUIDORES (FOLLOWERS)");
        int colEnero = CargarTabla.buscarColumnaMes(tabla, "ENERO");
        int colJunio = CargarTabla.buscarColumnaMes(tabla, "JUNIO");

        if (filaTwitter != -1 && colEnero != -1 && colJunio != -1) {
            double enero = CargarTabla.obtenerValorNumerico(tabla, filaTwitter, colEnero);
            double junio = CargarTabla.obtenerValorNumerico(tabla, filaTwitter, colJunio);
            double diferencia = junio - enero;

            System.out.println("\n--- DIFERENCIA DE SEGUIDORES EN TWITTER ---");
            System.out.println("Enero: " + (long) enero);
            System.out.println("Junio: " + (long) junio);
            System.out.println("Diferencia (Junio - Enero): " + (long) diferencia + " seguidores.");
        }
    }

    public static void diferenciaVisualizacionesYouTube(List<List<String>> tabla, String mesInicio, String mesFin) {
        int filaYT = CargarTabla.buscarFila(tabla, "YOUTUBE", "VISUALIZACIONES");
        int colInicio = CargarTabla.buscarColumnaMes(tabla, mesInicio);
        int colFin = CargarTabla.buscarColumnaMes(tabla, mesFin);

        if (filaYT == -1) {
            System.out.println("No se encontró el concepto de Visualizaciones en YouTube.");
            return;
        }
        if (colInicio == -1 || colFin == -1) {
            System.out.println("Uno o ambos meses ingresados no son válidos.");
            return;
        }

        double valInicio = CargarTabla.obtenerValorNumerico(tabla, filaYT, colInicio);
        double valFin = CargarTabla.obtenerValorNumerico(tabla, filaYT, colFin);
        double diferencia = valFin - valInicio;

        System.out.println("\n--- DIFERENCIA DE VISUALIZACIONES EN YOUTUBE ---");
        System.out.println(mesInicio.toUpperCase() + ": " + (long) valInicio);
        System.out.println(mesFin.toUpperCase() + ": " + (long) valFin);
        System.out.println("Diferencia (" + mesFin + " - " + mesInicio + "): " + (long) diferencia + " visualizaciones.");
    }

    public static void promedioCrecimientoFBAndTW(List<List<String>> tabla) {
        int filaCrecFB = CargarTabla.buscarFila(tabla, "FACEBOOK", "CRECIMIENTO (seguidores)");
        int filaCrecTW = CargarTabla.buscarFila(tabla, "TWITTER", "CRECIMIENTO DE FOLLOWERS");

        int colEnero = CargarTabla.buscarColumnaMes(tabla, "ENERO");
        int colJunio = CargarTabla.buscarColumnaMes(tabla, "JUNIO");

        double sumaFB = 0, sumaTW = 0;
        int mesesContados = 0;

        for (int c = colEnero; c <= colJunio; c++) {
            sumaFB += CargarTabla.obtenerValorNumerico(tabla, filaCrecFB, c);
            sumaTW += CargarTabla.obtenerValorNumerico(tabla, filaCrecTW, c);
            mesesContados++;
        }

        double promFB = sumaFB / mesesContados;
        double promTW = sumaTW / mesesContados;

        System.out.println("\n--- PROMEDIO DE CRECIMIENTO (ENERO - JUNIO) ---");
        System.out.printf("Facebook (Promedio mensual): %.2f seguidores%n", promFB);
        System.out.printf("Twitter (Promedio mensual):  %.2f seguidores%n", promTW);
    }
    
    public static void promedioMeGustaTodasRedes(List<List<String>> tabla) {
        int filaLikesFB = CargarTabla.buscarFila(tabla, "FACEBOOK", "ME GUSTA EN PUBLICACIONES");
        int filaLikesTW = CargarTabla.buscarFila(tabla, "TWITTER", "ME GUSTA");
        int filaLikesYT = CargarTabla.buscarFila(tabla, "YOUTUBE", "ME GUSTA");

        int colEnero = CargarTabla.buscarColumnaMes(tabla, "ENERO");
        int colDiciembre = CargarTabla.buscarColumnaMes(tabla, "DICIEMBRE");
        int totalMeses = (colDiciembre - colEnero) + 1;

        double sumaFB = 0, sumaTW = 0, sumaYT = 0;

        for (int c = colEnero; c <= colDiciembre; c++) {
            sumaFB += CargarTabla.obtenerValorNumerico(tabla, filaLikesFB, c);
            sumaTW += CargarTabla.obtenerValorNumerico(tabla, filaLikesTW, c);
            sumaYT += CargarTabla.obtenerValorNumerico(tabla, filaLikesYT, c);
        }

        System.out.println("\n--- PROMEDIO ANUAL DE 'ME GUSTA' ---");
        System.out.printf("Facebook: %.2f likes/mes%n", (sumaFB / totalMeses));
        System.out.printf("Twitter:  %.2f likes/mes%n", (sumaTW / totalMeses));
        System.out.printf("YouTube:  %.2f likes/mes%n", (sumaYT / totalMeses));
    }
}