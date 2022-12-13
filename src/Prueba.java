import Interfaces.CálculoDescuentos;

public class Prueba implements CálculoDescuentos {


    @Override
    public double cálculoISR(double salarioBruto) {
        double salarioDescuento = salarioBruto - cálculoAFP(salarioBruto) - cálculoSRS(salarioBruto);
        double salarioDescuentoAnual = salarioDescuento * 12;
        if(salarioDescuentoAnual >= 416220.01 && salarioDescuentoAnual <= 624329.00){
            double excedente = salarioDescuentoAnual - 416220.01;
            double excendenteTotal = excedente * PORCENTAJE_ISR.get(0);
            return excendenteTotal / 12;
        } if (salarioDescuentoAnual >= 624329.01 && salarioDescuentoAnual <= 867123.00) {
            double excedente = salarioDescuentoAnual - 624329.01;
            double excendenteTotal = (excedente * PORCENTAJE_ISR.get(1)) + 31216.00;
            return excendenteTotal / 12;
        }if (salarioDescuentoAnual >= 867123.01){
            double excedente = salarioDescuentoAnual - 867123.01;
            double excendenteTotal = (excedente * PORCENTAJE_ISR.get(2)) + 79776.00;
            return excendenteTotal / 12;
        }
        return 0;
    }

    @Override
    public double cálculoAFP(double salarioBruto) {
        return salarioBruto * PORCENTAJE_AFP;
    }

    @Override
    public double cálculoSRS(double salarioBruto) {
        return salarioBruto * PORCENTAJE_SRS;
    }

    public static void main(String[] args) {
        double salarioBruto = 65000.00;
        Prueba test = new Prueba();
        System.out.println((double)Math.round(test.cálculoAFP(salarioBruto) * 100d) / 100);
        System.out.println((double)Math.round(test.cálculoSRS(salarioBruto)* 100d) / 100);
        System.out.println((double)Math.round(test.cálculoISR(salarioBruto)* 100d) / 100);;
    }

}