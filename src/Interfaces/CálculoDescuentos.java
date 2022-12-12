package Interfaces;
/**
 * Interface aplicada a la Clase "VolanteDePago", que posee las constantes de porcentaje de cálculo de los
 * descuentos y los métodos a implementar de esto mismo.
 * @author: Omar Aquino
 * @since: 04/12/2022
 */

// Clases importadas
import java.util.ArrayList;

public interface CálculoDescuentos {

    /* Variable "ArrayList" que posee los valores de porcentaje de descuento del Impuesto Sobre la Renta,segun
    el salario anual con descuentos aplicado.
    */
    ArrayList<Double> PORCENTAJE_ISR = new ArrayList<Double>() {{
    add(0.15);
    add(0.20);
    add(0.25);
    }};
    // Variable "double" que posee el valor del descuento del Servicio Nacional de Salud.
    double PORCENTAJE_SRS = 0.0304;
    // Variable "double" que posee el valor del descuento de la Asociación de Fonde de Pensiones.
    double PORCENTAJE_AFP = 0.0287;

    double cálculoISR(double salarioBruto);
    double cálculoAFP(double salarioBruto);
    double cálculoSRS(double salarioBruto);

}// Cierre de la Interface