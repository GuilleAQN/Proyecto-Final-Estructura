package Interfaz;

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
        put("4","Mostrar Empleado");
        put("5","Generar Volante");
        put("6","Editar Volante");
        put("7","Mostrar Volante");
        put("8","Finalizar Programa");
    }};

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
        if (rol.equals("1")){
            System.out.println("Introduzca el estado:\n1.Activo\n2.Inactivo");
            estado = scanner.nextInt();
        }
        System.out.println("Introduzca el salario: ");
        double salarioBruto = scanner.nextDouble();
        if (rol.equals("1")){
            empleado.ingresarEmpleado(codigo_empleado,nombre,apellido,cedula,direccion,salarioBruto);
        }else{
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
    }

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
    }

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
        System.out.print("Nuevo Empleado\nIntroduzca el codigo: ");
        int codigo_empleado = scanner.nextInt();
        System.out.print("Introduzca el nuevo nombre: ");
        String nombre = scanner.next();
        System.out.print("Introduzca el nuevo apellido: ");
        String apellido = scanner.next();
        System.out.print("Introduzca la nueva cedula: ");
        String cedula = scanner.next();
        System.out.print("Introduzca la nuea dirección: ");
        String direccion = scanner.next();
        System.out.println("Introduzca el nuevo rol:\n1. Medio Tiempo\nTiempo Completo");
        String rol = scanner.next();
        if (rol.equals("1")){
            System.out.println("Introduzca el nuevo estado:\n1.Activo\n2.Inactivo");
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
    }

    public void mostrarEmpleados() throws InterruptedException{
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
        empleado.showAll();

        System.out.println("Presiona \"Enter\" para volver: ");
        String espera = scanner.next();
        System.out.print("Volviendo al menu");
        System.out.print(".");
        Thread.sleep(1000);
        System.out.print(".");
        Thread.sleep(1000);
        System.out.println(".");
        Thread.sleep(1000);
    }
    
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

        System.out.println("Volante generado");
        Thread.sleep(1500);
        System.out.print("Volviendo al menu");
        System.out.print(".");
        Thread.sleep(1000);
        System.out.print(".");
        Thread.sleep(1000);
        System.out.println(".");
        Thread.sleep(1000);
    }

    public void editarVolante() throws InterruptedException {
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

        System.out.println("Introduzca su número de volante: ");
        int id_volante = scanner.nextInt();
        System.out.print("Introduzca nuevo el titulo: ");
        String titulo = scanner.next();
        System.out.print("Introduzca la nueva descripción: ");
        String descripcion = scanner.next();
        System.out.print("Introduzca la nueva cedula: ");
        int codigo_empleado = scanner.nextInt();

        volanteDePago.editarVolante(titulo,descripcion,id_volante);

        System.out.println("Volante cambiado");
        Thread.sleep(1500);
        System.out.print("Volviendo al menu");
        System.out.print(".");
        Thread.sleep(1000);
        System.out.print(".");
        Thread.sleep(1000);
        System.out.println(".");
        Thread.sleep(1000);
    }

    public void mostrarVolante() throws InterruptedException {
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

        System.out.println("Introduzca el número de volante a visualizar: ");
        int id_volante = scanner.nextInt();

        volanteDePago.mostrarVolante(id_volante);

        System.out.println("Presiona \"Enter\" para volver: ");
        String espera = scanner.next();
        System.out.print("Volviendo al menu");
        System.out.print(".");
        Thread.sleep(1000);
        System.out.print(".");
        Thread.sleep(1000);
        System.out.println(".");
        Thread.sleep(1000);
    }

    public void menuPrincipal() throws IOException, InterruptedException, SQLException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.println("BIENVENIDO AL GESTOR DE NÓMINA");
        Thread.sleep(5000);
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        int opcion = 0;
        while(opcion!=8) {
            System.out.println(".....:MENU:.....");
            for (String i : opciones.keySet()) {
                System.out.println(i + " - " + opciones.get(i));
            }
            System.out.print("Ingrese el valor deseado: ");
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
                    break;
                default:
                    System.out.println("Favor seleccionar una de las opciones correctas");
                    break;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException, SQLException , IOException{
        Menu menu = new Menu();
        menu.menuPrincipal();
    }
}
