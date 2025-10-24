package ies.enrique.tierno;

public class Main {

    private final static String ERROR_CONVERSION = "Error en la conversión.";
    private final static String EXITO_CONVERSION = "Conversión realizada con éxito.";

    public static void main(String[] args) {
        if (args.length != 2) {
            return;
        }

        String formatoOrigen = args[0];
        String formatoDestino = args[1];

        Conversor conversor = new ConversorImagenes();
        boolean exito = conversor.convertir("imagen." + formatoOrigen, "imagen." + formatoDestino);

        if (exito) {
            System.out.println(EXITO_CONVERSION);
        } else {
            System.out.println(ERROR_CONVERSION);
        }
    }
}
