package Pruebas; //importando paquete pruebas (carpeta de codigo)

import org.junit.jupiter.api.Assertions; //importando assertions de las pruebas
import Entidades.VolanteDePago; //importando el paquete de volante de pago en la carpeta entidades

import org.junit.jupiter.api.DisplayName; //importanto los displayName de las pruebas
import org.junit.jupiter.api.Test; //importando el Api test

class VolanteDePagoPrueba { 

    VolanteDePago volanteDePago = new VolanteDePago();

    @Test //test 1
    @DisplayName("Prueba de Cálculo de ISR (Impuesto sobre la Renta)")
    void prueba1() {
        Assertions.assertEquals(4427.55,volanteDePago.cálculoISR(65000));
    }

    @Test //test 2
    @DisplayName("Prueba de Cálculo de AFP (Aseguradora de Fondo de Pensiones)")
    void prueba2() {
        Assertions.assertEquals(1865.5,volanteDePago.cálculoAFP(65000));
    }

    @Test //test 3
    @DisplayName("Prueba de Cálculo de SRS (Servicio Regional de Salud)")
    void prueba3() {
        Assertions.assertEquals(1976,volanteDePago.cálculoSRS(65000));
    }
}
