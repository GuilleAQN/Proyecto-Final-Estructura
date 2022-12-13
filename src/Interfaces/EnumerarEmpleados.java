package Interfaces;

import java.sql.SQLException;

/**
 * Interface aplicada a la Clase "VolanteDePago", que posee el metodo para contar los empleados.
 * @author: Omar Aquino
 * @since: 04/12/2022
 */

public interface EnumerarEmpleados {

    int contarEmpleados() throws SQLException;
}// Cierre de la Interface