package Entidades;
/**
 * Clase con los métodos para manipular la tabla "Volantes" capaz de Generar y Editar volantes, además
 * de mostrar un volante que se busque. Ademas de implementar los metodos de las Interfaces
 * @author Omar Aquino
 * @since 04/12/2022
 */

// Interfaces importadas
import Interfaces.CálculoDescuentos;
import Interfaces.EnumerarEmpleados;
import ControlDeDatos.Conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VolanteDePago implements CálculoDescuentos, EnumerarEmpleados {

    /**
     * Metodo que calcula el descuento del ISR.
     * @param salarioBruto El parámetro es el salario bruto del Empleado
     */
    @Override
    public double cálculoISR(double salarioBruto) {
        double salarioDescuento = salarioBruto - cálculoAFP(salarioBruto) - cálculoSRS(salarioBruto); // Salario con descuento de AFP y SRS
        double salarioDescuentoAnual = salarioDescuento * 12; // Calculo del salario anual
        if (salarioDescuentoAnual >= 416220.01 && salarioDescuentoAnual <= 624329.00){ // Si el salario anual cumple estas condiciones
            double excedente = salarioDescuentoAnual - 416220.01; // Se le resta 416,220.01 al salario anual
            double excendenteTotal = excedente * porcentajeISR.get(0); // Se multiplica el resultado de esta resta por el porcentaje que se aplica, en este caso 15%
            double descuentoAplicado = excendenteTotal / 12; // Se obtiene en descuento mensual
            return (double)Math.round(descuentoAplicado * 100d) / 100; // Se devuelve el dato con los decimales redondeados
        }if (salarioDescuentoAnual >= 624329.01 && salarioDescuentoAnual <= 867123.00){ // Si el salario anual cumple estas condiciones
            double excedente = salarioDescuentoAnual - 624329.01; // Se le resta 624,329.01 al salario anual
            double excendenteTotal = (excedente * porcentajeISR.get(1)) + 31216.00; // Se multiplica el resultado de esta resta por el porcentaje que se aplica, en este caso 20%; y se le suma 31,216.00
            double descuentoAplicado = excendenteTotal / 12; // Se obtiene en descuento mensual
            return (double)Math.round(descuentoAplicado * 100d) / 100; // Se devuelve el dato con los decimales redondeados
        }if (salarioDescuentoAnual >= 867123.01){ // Si el salario anual cumple esta condición
            double excedente = salarioDescuentoAnual - 867123.01; // Se le resta 867,123.01 al salario anual
            double excendenteTotal = (excedente * porcentajeISR.get(2)) + 79776.00; // Se multiplica el resultado de esta resta por el porcentaje que se aplica, en este caso 25%; y se le suma 79,776.00
            double descuentoAplicado = excendenteTotal / 12; // Se obtiene en descuento mensual
            return (double)Math.round(descuentoAplicado * 100d) / 100; // Se devuelve el dato con los decimales redondeados
        }
        return 0; // En caso de que no cumpla ninguna de estas condiciones se devuelve este valor
    }// Cierre de Metodo
    /**
     * @return Devuelve el valor del ISR en base al salario
     */

    /**
     * Metodo que calcula el descuento de la AFP.
     * @param salarioBruto El parámetro es el salario bruto del Empleado
     */
    @Override
    public double cálculoAFP(double salarioBruto) {
        return salarioBruto * porcentajeAFP;
    }
    /**
     * @return Devuelve el valor del AFP en base al salario
     */

    /**
     * Metodo que calcula el descuento de el SRS.
     * @param salarioBruto El parámetro es el salario bruto del Empleado
     */
    @Override
    public double cálculoSRS(double salarioBruto) {
        return salarioBruto * porcentajeSRS;
    }
    /**
     * @return Devuelve el valor del SRS en base al salario
     */

    /**
     * Metodo que calcula la cantidad de Empleados.
     */
    @Override
    public int contarEmpleados() {
        Conexion conexion = new Conexion();
        try {
            String stmt = "SELECT COUNT(*) AS cantidad FROM empleados";
            PreparedStatement ps = conexion.conectar().prepareStatement(stmt);
            ResultSet rs = ps.executeQuery();
            return rs.getInt("cantidad");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // Usar select cantidad(*)
        //  from medicamentos; para contar la cantidad de empleados.
    }
    /**
     * @return Devuelve el valor de la cantidad de empleado registrados
     */

    public static void main(String[] args) {
        VolanteDePago volanteDePago = new VolanteDePago();
        System.out.println(volanteDePago.contarEmpleados());
    }

}// Cierre de Clase