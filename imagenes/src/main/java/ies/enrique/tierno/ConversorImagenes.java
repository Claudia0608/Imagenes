package ies.enrique.tierno;

import java.io.IOException;

public class ConversorImagenes implements Conversor {

    private final static String ERROR_EJECUCION = "Error al ejecutar el comando de conversión.";

    @Override
    public boolean convertir(String rutaOrigen, String rutaDestino) {
        String comando = "convert " + rutaOrigen + " " + rutaDestino;
        try {
            Process proceso = Runtime.getRuntime().exec(comando);
            int resultado = proceso.waitFor();
            return resultado == 0;
        } catch (IOException | InterruptedException e) {
            System.out.println(ERROR_EJECUCION + e.getMessage());
            return false;

        }

    }
}
