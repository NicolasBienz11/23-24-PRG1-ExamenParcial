public class Edificio {
    public static void main(String[] args) {
        final String VENTANA_CERRADA_APAGADA = ":[|]:";
        final String VENTANA_CERRADA_PRENDIDA = ":[|]:";
        final String VENTANA_ABIERTA_APAGADA = ":[º]:";
        final String VENTANA_ABIERTA_PRENDIDA = ":[*]:";

        int horas = 24;
        int dias = 7
        int totalLucesEncendidas = 0;
        double promedioLucesEncendidas;
        boolean caeRayo = false;
        boolean mantenimiento = false;

        for (int hora = 1; hora <= horas; hora++) {
            System.out.println("Hora " + hora + ":");

            if (!rayoCayo && Math.random() < 0.2) {
                rayoCayo = true;
            }

            if (!mantenimiento && Math.random() < 0.05) {
                mantenimiento = true;
            }

            String[][] edificio = generarEdificio();
            totalLucesEncendidas += contarLucesEncendidas(edificio);

            imprimirEdificio(edificio);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Total de luces encendidas: " + totalLucesEncendidas);
    }


    static void printCeiling() {
        final String TIP = "     ".repeat(3) + "__/\\__";
        final String HEADER = "|####|";
        final String ANTENNA = "  |  ";
        final String ROOF = "=".repeat(36);

        System.out.println(TIP);
        System.out.println(ANTENNA.repeat(3) + HEADER + ANTENNA.repeat(3));
        System.out.println(ROOF);
    }

    private static String[][] generarEdificio() {
        int filas = 7;
        int columnas = 6;

        String[][] edificio = new String[filas][columnas];

        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {


        int probLuz = (int) (Math.random() * 100);
        int probVentana = (int) (Math.random() * 100);

            if (probVentana > 70) {
                edificio[fila][columna] += "[|]";
            } else {
                if (probLuz < 60) {
                    edificio[fila][columna] += "[*]";
                } else {
                    edificio[fila][columna] += "[º]";
                }
            }
    }

        return edificio;
    }

    private static void imprimirEdificio(String[][] edificio) {
        for (int fila = 0; fila < edificio.length; fila++) {
            for (int columna = 0; columna < edificio[0].length; columna++) {
                System.out.print(edificio[fila][columna] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int contarLucesEncendidas(String[][] edificio) {
        int contador = 0;
        for (String[] fila : edificio) {
            for (String ventana : fila) {
                if (ventana.contains("[*]")) {
                    contador++;
                }
            }
        }
        return contador;
    }
}




    static void printBasement() {
        System.out.println("""
                :[       ]::::|      |::::[       ]:
                ------------------------------------
                     ==========================
                   ==============================
                 ==================================
                """);
    }
}
