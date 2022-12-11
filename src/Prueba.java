import Entidades.VolanteDePago;
import Interfaces.CálculoDescuentos;
import Entidades.Empleado;

public class Prueba implements CálculoDescuentos {



    @Override
    public double cálculoISR(double salarioBruto) {
        double salarioDescuento = salarioBruto - cálculoAFP(salarioBruto) - cálculoSRS(salarioBruto);
        double salarioDescuentoAnual = salarioDescuento * 12;
        if(salarioDescuentoAnual >= 416220.01 && salarioDescuentoAnual <= 624329.00){
            double excedente = salarioDescuentoAnual - 416220.01;
            double excendenteTotal = excedente * porcentajeISR.get(0);
            return excendenteTotal / 12;
        } if (salarioDescuentoAnual >= 624329.01 && salarioDescuentoAnual <= 867123.00) {
            double excedente = salarioDescuentoAnual - 624329.01;
            double excendenteTotal = (excedente * porcentajeISR.get(1)) + 31216.00;
            return excendenteTotal / 12;
        }if (salarioDescuentoAnual >= 867123.01){
            double excedente = salarioDescuentoAnual - 867123.01;
            double excendenteTotal = (excedente * porcentajeISR.get(2)) + 79776.00;
            return excendenteTotal / 12;
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

    public static void main(String[] args) {
        double salarioBruto = 65000.00;
        Prueba test = new Prueba();
        System.out.println((double)Math.round(test.cálculoAFP(salarioBruto) * 100d) / 100);
        System.out.println((double)Math.round(test.cálculoSRS(salarioBruto)* 100d) / 100);
        System.out.println((double)Math.round(test.cálculoISR(salarioBruto)* 100d) / 100);
        Empleado e1 = new Empleado("002431","Omar Guillermo","00-1213144-0","Los ALamos");
        Empleado e2 = new Empleado("002432","Jose Dilone","00-1213144-1","Un lugar");
        Empleado e3 = new Empleado("002433","Leandro Gonzalez","00-1213144-2","Rep. de Colombia");
        VolanteDePago v1 = new VolanteDePago();
        System.out.println(e1);
    }

}