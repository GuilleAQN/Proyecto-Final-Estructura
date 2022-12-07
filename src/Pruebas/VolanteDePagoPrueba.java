package Pruebas;

import org.junit.jupiter.api.Assertions;
import Entidades.VolanteDePago;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class VolanteDePagoPrueba {

    VolanteDePago volanteDePago = new VolanteDePago();

    @Test
    @DisplayName("Prueba de Cálculo de ISR (Impuesto sobre la Renta)")
    void prueba1() {
        Assertions.assertEquals(4427.55,volanteDePago.cálculoISR(65000));
    }

    @Test
    @DisplayName("Prueba de Cálculo de AFP (Aseguradora de Fondo de Pensiones)")
    void prueba2() {
        Assertions.assertEquals(1865.5,volanteDePago.cálculoAFP(65000));
    }

    @Test
    @DisplayName("Prueba de Cálculo de SRS (Servicio Regional de Salud)")
    void prueba3() {
        Assertions.assertEquals(1976,volanteDePago.cálculoSRS(65000));
    }
}