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
import java.util.logging.Level;
import java.util.logging.Logger;

public class VolanteDePago implements CálculoDescuentos, EnumerarEmpleados {

    Conexion conexion = new Conexion();

    /**
     * Metodo que genera un Volante relacionado con el codigo un empleado.
     * @param titulo Titulo que tendra el volante
     * @param descripcion Cuerpo del Volante, compuesto por detalles, sueldo bruto y sus descuentos, ademas del del sueldo neto
     * @param codigo_empleado Código del empleado con el se relaciona
     */
    public void generarVolante(String titulo, String descripcion, int codigo_empleado){
        String stmt = "INSERT INTO volante (titulo, descripcion, codigo_empleado) VALUES (?, ?, ?)";

        try {
            PreparedStatement ps = conexion.conectar().prepareStatement(stmt);
            ps.setString(1,titulo);
            ps.setString(2,descripcion);
            ps.setInt(3,codigo_empleado);

            ps.executeUpdate();//se ejecuta la actualizacion en la base de datos

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE,null,ex);

        } finally {
            try {
                if (conexion != null) {
                    conexion.conectar().close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
    } // Cierre de metodo

    /**
     * Metodo que edita un Volante relacionado con el codigo un empleado.
     * @param titulo Titulo que tendra el volante
     * @param descripcion Cuerpo del Volante, compuesto por detalles, sueldo bruto y sus descuentos, ademas del del sueldo neto
     * @param id_volante Código del volante del empleado a editar
     */
    public void editarVolante(String titulo, String descripcion, int id_volante){
        String stmt = "UPDATE volante SET titulo = ?, descripcion = ? WHERE id_volante = ?;";

        try {
            PreparedStatement ps = conexion.conectar().prepareStatement(stmt);
            ps.setString(1,titulo);
            ps.setString(2,descripcion);
            ps.setInt(3,id_volante);

            ps.executeUpdate();//se ejecuta la actualizacion en la base de datos

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE,null,ex);

        } finally {
            try {
                if (conexion != null) {
                    conexion.conectar().close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
    }// Cierre de metodo

    /**
     * Metodo que enseña los datos de un Volante relacionado con el codigo un empleado.
     * @param id_volante Código del volante del empleado a ver
     */
    public String mostrarVolante(int id_volante){
        String resultado = "";
        String stmt = "SELECT * FROM volante WHERE id_volante = " + id_volante;

        try {
            PreparedStatement ps = conexion.conectar().prepareStatement(stmt);

            ResultSet rs = ps.executeQuery();

            resultado = "Nº de Volante: " + rs.getString(1) + "\nTitulo: " + rs.getString(2)
            + "\nDescripción: " + rs.getString(3) + "\nCódigo del Empleado: " + rs.getString(4)
            + "\nFecha de Pago: " + rs.getString(5);

        } catch (SQLException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE,null,ex);

        } finally {
            try {
                if (conexion != null) {
                    conexion.conectar().close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
        return resultado;
    }// Cierre de metodo
    /**
     * @return Devuelve los datos del Volante seleccionado
     */

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
            double excendenteTotal = excedente * PORCENTAJE_ISR.get(0); // Se multiplica el resultado de esta resta por el porcentaje que se aplica, en este caso 15%
            double descuentoAplicado = excendenteTotal / 12; // Se obtiene en descuento mensual
            return (double)Math.round(descuentoAplicado * 100d) / 100; // Se devuelve el dato con los decimales redondeados
        }if (salarioDescuentoAnual >= 624329.01 && salarioDescuentoAnual <= 867123.00){ // Si el salario anual cumple estas condiciones
            double excedente = salarioDescuentoAnual - 624329.01; // Se le resta 624,329.01 al salario anual
            double excendenteTotal = (excedente * PORCENTAJE_ISR.get(1)) + 31216.00; // Se multiplica el resultado de esta resta por el porcentaje que se aplica, en este caso 20%; y se le suma 31,216.00
            double descuentoAplicado = excendenteTotal / 12; // Se obtiene en descuento mensual
            return (double)Math.round(descuentoAplicado * 100d) / 100; // Se devuelve el dato con los decimales redondeados
        }if (salarioDescuentoAnual >= 867123.01){ // Si el salario anual cumple esta condición
            double excedente = salarioDescuentoAnual - 867123.01; // Se le resta 867,123.01 al salario anual
            double excendenteTotal = (excedente * PORCENTAJE_ISR.get(2)) + 79776.00; // Se multiplica el resultado de esta resta por el porcentaje que se aplica, en este caso 25%; y se le suma 79,776.00
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
        return salarioBruto * PORCENTAJE_AFP;
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
        return salarioBruto * PORCENTAJE_SRS;
    }
    /**
     * @return Devuelve el valor del SRS en base al salario
     */

    /**
     * Metodo que calcula la cantidad de Empleados.
     */
    @Override
    public int contarEmpleados() {
        try {
            String stmt = "SELECT COUNT(*) AS cantidad FROM empleados";
            PreparedStatement ps = conexion.conectar().prepareStatement(stmt);
            ResultSet rs = ps.executeQuery();
            return rs.getInt("cantidad");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }// Cierre de metodo
    /**
     * @return Devuelve el valor de la cantidad de empleado registrados
     */


    public static void main(String[] args) { // Prueba
        VolanteDePago volanteDePago = new VolanteDePago();
        volanteDePago.generarVolante("Pago","Saco de Dinero",10103);

//        volanteDePago.editarVolante("Mi Pago","Dinero pero feo!",11);
//        System.out.println(volanteDePago.mostrarVolante(1));
    }

}// Cierre de Clase