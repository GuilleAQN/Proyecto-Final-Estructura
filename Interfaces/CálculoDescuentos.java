package Interfaces;

import java.util.ArrayList;

public interface CálculoDescuentos {

    ArrayList<Double> porcentajeISR = new ArrayList<Double>() {{
    add(0.15);
    add(0.20);
    add(0.25);
    }};
    double porcentajeSRS = 0.0304;
    double porcentajeAFP = 0.0287;

    double cálculoISR(double salarioBruto);
    double cálculoAFP(double salarioBruto);
    double cálculoSRS(double salarioBruto);

}