import java.io.File;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import ies.enrique.tierno.Conversor;
import ies.enrique.tierno.ConversorImagenes;

public class testConvertir {

    private static final String IMAGEN_ORIGEN = "src/test/resources/Origen.png";
    private static final String IMAGEN_DESTINO = "src/test/resources/imagen_convertida.jpg";
    private static final String IMAGEN_NO_EXISTE = "src/test/resources/no_existe.jpg";

    @Test
    void testConvertir_Exito() {
        Conversor conversor = new ConversorImagenes();
        boolean resultado = conversor.convertir(IMAGEN_ORIGEN, IMAGEN_DESTINO);
        assertTrue(resultado);

        File archivoDestino = new File(IMAGEN_DESTINO);
        assertTrue(archivoDestino.exists());

    }

    @Test
    void testConvertir_ArchivoNoExiste() {
        Conversor conversor = new ConversorImagenes();
        boolean resultado = conversor.convertir(IMAGEN_NO_EXISTE, IMAGEN_DESTINO);
        assertFalse(resultado);
    }

    @Test
    void testConvertir_ErrorComando() {
        Conversor conversor = new ConversorImagenes() {
            @Override
            public boolean convertir(String rutaOrigen, String rutaDestino) {
                final String COMANDO_INVALIDO = "comando_invalido";
                try {
                    Process proceso = Runtime.getRuntime().exec(COMANDO_INVALIDO);
                    int resultado = proceso.waitFor();
                    return resultado == 0;
                } catch (Exception e) {
                    return false;
                }
            }
        };
        boolean resultado = conversor.convertir(IMAGEN_ORIGEN, IMAGEN_DESTINO);
        assertFalse(resultado);
    }
}