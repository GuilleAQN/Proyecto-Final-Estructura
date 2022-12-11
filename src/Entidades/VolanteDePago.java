package Entidades;

import Interfaces.CálculoDescuentos;
import Interfaces.EnumerarEmpleados;

public class VolanteDePago implements CálculoDescuentos, EnumerarEmpleados {

    @Override
    public double cálculoISR(double salarioBruto) {
        double salarioDescuento = salarioBruto - cálculoAFP(salarioBruto) - cálculoSRS(salarioBruto);
        double salarioDescuentoAnual = salarioDescuento * 12;
        if (salarioDescuentoAnual >= 416220.01 && salarioDescuentoAnual <= 624329.00){
            double excedente = salarioDescuentoAnual - 416220.01;
            double excendenteTotal = excedente * porcentajeISR.get(0);
            double descuentoAplicado = excendenteTotal / 12;
            return (double)Math.round(descuentoAplicado * 100d) / 100;
        }if (salarioDescuentoAnual >= 624329.01 && salarioDescuentoAnual <= 867123.00){
            double excedente = salarioDescuentoAnual - 624329.01;
            double excendenteTotal = (excedente * porcentajeISR.get(1)) + 31216.00;
            double descuentoAplicado = excendenteTotal / 12;
            return (double)Math.round(descuentoAplicado * 100d) / 100;
        }if (salarioDescuentoAnual >= 867123.01){
            double excedente = salarioDescuentoAnual - 867123.01;
            double excendenteTotal = (excedente * porcentajeISR.get(2)) + 79776.00;
            double descuentoAplicado = excendenteTotal / 12;
            return (double)Math.round(descuentoAplicado * 100d) / 100;
        }
        return 0;
    }

    @Override
    public double cálculoAFP(double salarioBruto) {
        return salarioBruto * porcentajeAFP;
    }

    @Override
    public double cálculoSRS(double salarioBruto) {
        return salarioBruto * porcentajeSRS;
    }

    @Override
    public int contarEmpleados() {
        // Usar select count(*)
        //  from medicamentos; para contar la cantidad de empleados.
        return 0;
    }
}