package Interfaz;

/**
 * Clase con los métodos para acceder a los metodos de "Empleados" y "Volante".
 * @author: Omar Aquino y Leandro Gonzalez
 * @since: 04/12/2022
 */

// Interfaces Importadas
import Entidades.Empleado;
import Entidades.EmpleadoTiempoCompleto;
import Entidades.VolanteDePago;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {

    Empleado empleado = new Empleado();
    EmpleadoTiempoCompleto empleadoTiempoCompleto = new EmpleadoTiempoCompleto();
    VolanteDePago volanteDePago = new VolanteDePago();
    Scanner scanner = new Scanner(System.in);

    Map<String, String> opciones = new HashMap<String, String>(){{
        put("1","Introducir Empleado");
        put("2","Eliminar Empleado");
        put("3","Modificar Empleado");
        put("4","Mostrar Empleados");
        put("5","Generar Volante");
        put("6","Editar Volante");
        put("7","Mostrar Volante");
        put("8","Finalizar Programa");
    }};

    /**
     * Metodo para introducir por terminal los datos de un nuevo empleado a la Base de Datos.
     */
    public void introducirEmpleado() throws InterruptedException, SQLException {
        try {
            System.out.print("Cargando");
            System.out.print(".");
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.println(".");
            Thread.sleep(1000);
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
        }
        int estado = 0;
        System.out.print("Nuevo Empleado\nIntroduzca el codigo: ");
        int codigo_empleado = scanner.nextInt();
        System.out.print("Introduzca el nombre: ");
        String nombre = scanner.next();
        System.out.print("Introduzca el apellido: ");
        String apellido = scanner.next();
        System.out.print("Introduzca la cedula: ");
        String cedula = scanner.next();
        System.out.print("Introduzca la direccion: ");
        String direccion = scanner.next();
        System.out.println("Introduzca el rol:\n1. Medio Tiempo\n2. Tiempo Completo");
        String rol = scanner.next();
        if (rol.equals("2")){
            System.out.println("Introduzca el estado:\n1.Activo\n2.Inactivo");
            estado = scanner.nextInt();
        }
        System.out.println("Introduzca el salario: ");
        double salarioBruto = scanner.nextDouble();
        if (rol.equals("1")){
            empleado.ingresarEmpleado(codigo_empleado,nombre,apellido,cedula,direccion,salarioBruto);
        }if (rol.equals("2")){
            empleadoTiempoCompleto.ingresarEmpleadoTiempoCompleto(codigo_empleado,nombre,apellido,cedula,direccion,estado,salarioBruto);
        }
        System.out.println("Entrada Exitosa!");
        Thread.sleep(1500);
        System.out.print("Volviendo al menu");
        System.out.print(".");
        Thread.sleep(1000);
        System.out.print(".");
        Thread.sleep(1000);
        System.out.println(".");
        Thread.sleep(1000);
    }// Cierre de metodo

    /**
     * Metodo para eliminar por terminal los datos de un empleado en la Base de Datos.
     */
    public void eliminarEmpleado() throws InterruptedException, SQLException {
        try {
            System.out.print("Cargando");
            System.out.print(".");
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.println(".");
            Thread.sleep(1000);
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
        }
        int estado = 0;
        System.out.print("Empleado\nIntroduzca el codigo del empleado a eliminar: ");
        int codigo_empleado = scanner.nextInt();
        empleado.eliminarEmpleado(codigo_empleado);

        System.out.println("Eliminación Exitosa!");
        Thread.sleep(1500);
        System.out.print("Volviendo al menu");
        System.out.print(".");
        Thread.sleep(1000);
        System.out.print(".");
        Thread.sleep(1000);
        System.out.println(".");
        Thread.sleep(1000);
    }// Cierre de metodo

    /**
     * Metodo para editar por terminal los datos de un empleado de la Base de Datos.
     */
    public void editarEmpleado() throws InterruptedException, SQLException {
        try {
            System.out.print("Cargando");
            System.out.print(".");
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.println(".");
            Thread.sleep(1000);
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
        }
        int estado = 0;
        System.out.print("Empleado a Editar\nIntroduzca el codigo del empleado: ");
        int codigo_empleado = scanner.nextInt();
        System.out.print("Introduzca el nuevo nombre: ");
        String nombre = scanner.next();
        System.out.print("Introduzca el nuevo apellido: ");
        String apellido = scanner.next();
        System.out.print("Introduzca la nueva cédula: ");
        String cedula = scanner.next();
        System.out.print("Introduzca la nuea dirección: ");
        String direccion = scanner.next();
        System.out.println("Introduzca el nuevo rol:\n1. Medio Tiempo\n2. Tiempo Completo");
        String rol = scanner.next();
        if (rol.equals("2")){
            System.out.println("Introduzca el nuevo estado:\n1. Activo\n2. Inactivo");
            estado = scanner.nextInt();
        }
        double salarioBruto = scanner.nextDouble();
        if (rol.equals("1")){
            empleado.editarEmpleado(codigo_empleado,nombre,apellido,cedula,direccion,"Medio Tiempo",salarioBruto);
        }else{
            empleadoTiempoCompleto.editarEmpleadoTiempoCompleto(codigo_empleado,nombre,apellido,cedula,direccion,estado,salarioBruto);
        }
        System.out.println("Cambio Exitoso!");
        System.out.print("Volviendo al menu");
        System.out.print(".");
        Thread.sleep(1000);
        System.out.print(".");
        Thread.sleep(1000);
        System.out.println(".");
        Thread.sleep(1000);
    }//Cierre de metodo

    /**
     * Metodo para mostrar por terminal los datos de un empleado a la Base de Datos.
     */
    public void mostrarEmpleados() throws InterruptedException, SQLException {
        try {
            System.out.print("Cargando");
            System.out.print(".");
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.println(".");
            Thread.sleep(1000);
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
        }
        System.out.println("\nCantidad de Empleados Registrados: " + volanteDePago.contarEmpleados());
        empleado.mostrarTodos();

        System.out.println("Presiona \"Enter\" para volver: ");
        Thread.sleep(5000);
        System.out.print("Volviendo al menu");
        System.out.print(".");
        Thread.sleep(1000);
        System.out.print(".");
        Thread.sleep(1000);
        System.out.println(".");
        Thread.sleep(1000);
    }// Cierre de metodo

    /**
     * Metodo para generar por terminal los datos de un nuevo volante a la Base de Datos.
     */
    public void generarVolante() throws InterruptedException {
        try {
            System.out.print("Cargando");
            System.out.print(".");
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.println(".");
            Thread.sleep(1000);
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
        }

        System.out.print("Nuevo Volante\nIntroduzca el titulo: ");
        String titulo = scanner.next();
        System.out.print("Introduzca la descripción: ");
        String descripcion = scanner.next();
        System.out.print("Introduzca la nueva cedula: ");
        int codigo_empleado = scanner.nextInt();

        volanteDePago.generarVolante(titulo,descripcion,codigo_empleado);

        System.out.println("\nVolante generado");
        Thread.sleep(1500);
        System.out.print("Volviendo al menu");
        System.out.print(".");
        Thread.sleep(1000);
        System.out.print(".");
        Thread.sleep(1000);
        System.out.println(".");
        Thread.sleep(1000);
    }// Cierre de metodo

    /**
     * Metodo para editar por terminal los datos de un volante en la Base de Datos.
     */
    public void editarVolante() throws InterruptedException {
        try {
            System.out.print("\nCargando");
            System.out.print(".");
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.println(".");
            Thread.sleep(1000);
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
        }

        System.out.println("Introduzca su número de volante: ");
        int id_volante = scanner.nextInt();
        System.out.print("Introduzca nuevo el titulo: ");
        String titulo = scanner.next();
        System.out.print("Introduzca la nueva descripción: ");
        String descripcion = scanner.next();

        volanteDePago.editarVolante(titulo,descripcion,id_volante);

        System.out.println("\nVolante cambiado");
        Thread.sleep(1500);
        System.out.print("Volviendo al menu");
        System.out.print(".");
        Thread.sleep(1000);
        System.out.print(".");
        Thread.sleep(1000);
        System.out.println(".");
        Thread.sleep(1000);
    }// Cierre de metodo

    /**
     * Metodo para mostrar por terminal los datos de un volante de la Base de Datos.
     */
    public void mostrarVolante() throws InterruptedException {
        try {
            System.out.print("\nCargando");
            System.out.print(".");
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.println(".");
            Thread.sleep(1000);
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
        }

        System.out.println("\nIntroduzca el número de volante a visualizar: ");
        int id_volante = scanner.nextInt();

        System.out.println(volanteDePago.mostrarVolante(id_volante));

        Thread.sleep(10000);

        System.out.print("Volviendo al menu");
        System.out.print(".");
        Thread.sleep(1000);
        System.out.print(".");
        Thread.sleep(1000);
        System.out.println(".");
        Thread.sleep(1000);
    }// Cierre de metodo

    /**
     * Metodo para manejar por terminal los movimientos de los datos en la Base de Datos.
     */
    public void menuPrincipal() throws IOException, InterruptedException, SQLException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.println("\nBIENVENIDO AL GESTOR DE NÓMINA");
        Thread.sleep(5000);
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        int opcion = 0;
        while(opcion!=8) {
            System.out.println("\n.....:MENU:.....");
            for (String i : opciones.keySet()) {
                System.out.println(i + " - " + opciones.get(i));
            }
            System.out.print("Ingrese la opción deseada: ");
            opcion = scanner.nextInt();
            switch (opcion){
                case 1:
                    introducirEmpleado();
                    break;
                case 2:
                    eliminarEmpleado();
                    break;
                case 3:
                    editarEmpleado();
                    break;
                case 4:
                    mostrarEmpleados();
                    break;
                case 5:
                    generarVolante();
                    break;
                case 6:
                    editarVolante();
                    break;
                case 7:
                    mostrarVolante();
                    break;
                case 8:
                    System.out.println("Gracias por usar el sistema - SALIENDO");
                    Thread.sleep(1000);
                    System.out.print(".");
                    Thread.sleep(1000);
                    System.out.print(".");
                    Thread.sleep(1000);
                    System.out.println(".");
                    Thread.sleep(1000);
                    break;
                default:
                    System.out.println("Favor seleccionar una de las opciones correctas");
                    break;
            }
        }
    }// Cierre de metodo

}// Cierre de clase