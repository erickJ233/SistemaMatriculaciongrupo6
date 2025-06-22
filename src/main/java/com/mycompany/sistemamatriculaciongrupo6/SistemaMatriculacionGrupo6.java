package com.mycompany.sistemamatriculaciongrupo6;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaMatriculacionGrupo6 {

    static List<Propietario> propietarioslist = new ArrayList<>();
    static List<Matricula> matriculalist = new ArrayList<>();
    static List<Pago> pagolist = new ArrayList<>();

    public static void registrarPropietario(String nombre, String cedula, String direccion, String telefono) {

        if (!propietarioslist.isEmpty()) {

            for (Propietario p : propietarioslist) {
                if (p.getCedula().equals(cedula)) {
                    System.out.println("Este propietario ya esta registrado");
                    return;
                }
            }
        }

        var propietario = new Propietario(nombre, cedula, direccion, telefono);
        propietarioslist.add(propietario);
        System.out.println("Propietario registrado con exito!");
    }

    public static void consultarPropietario(String cedula) {

        if (!propietarioslist.isEmpty()) {
            var encontrado = false;
            for (Propietario p : propietarioslist) {
                if (p.getCedula().equals(cedula)) {
                    System.out.println(p.toString());
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("No se encuentra ningún propietario con cedula: " + cedula);
            }
        } else {
            System.out.println("No hay propietarios");
        }

    }

    public static void registrarMatricula(String placa, String marca, String modelo, int anio, String tipo, String cedula) {

        if (!propietarioslist.isEmpty()) {
            var encontrado = false;
            
            
            
            for (Matricula m : matriculalist) {
                if (m.getVehiculo().getPlaca().equals(placa)) {
                    System.out.println("Este vehiculo ya esta matriculado");
                    return;
                }
            }
            
            for (Propietario p : propietarioslist) {
                if (p.getCedula().equals(cedula)) {
                    var vehiculo = new Vehiculo(placa, marca, modelo, tipo, anio, p);
                    Date fechaActual = new Date();
                    var estadoPago = false;
                    var matricula = new Matricula(vehiculo, fechaActual, estadoPago);
                    matriculalist.add(matricula);
                    System.out.println("Matricula registrada con exito");
                    System.out.println("Recuerde pagar la matricula");
                    encontrado = true;
                    break;

                }
            }
            if (!encontrado) {
                System.out.println("No se encontro un propietario con el siguiente número de cédula" + cedula);
            }
        } else {
            System.out.println("No hay propietarios");
        }
    }

    public static void consultarMatricula(String placa) {

        if (!matriculalist.isEmpty()) {
            var encontrado=false;
            for (Matricula m : matriculalist) {
                if (m.getVehiculo().getPlaca().equals(placa)) {
                    System.out.println(m.toString());
                    encontrado=true;
                    break;
                } 
            }
            if(!encontrado){
                System.out.println("No se encuentra ninguna matricula con esta placa: " + placa);
            }
        } else {
            System.out.println("No hay matriculas");
        }

    }

    public static void pagarMatricula(String placa, String metodoPago, Double monto, boolean estadoPago) {
        if (!matriculalist.isEmpty()) {
            var encontrado=false;
            for (Matricula m : matriculalist) {
                if (m.getVehiculo().getPlaca().equals(placa)) {
                    if (m.getEstadoPago() == false) {
                        Date fechaPago = new Date();
                        m.setEstadoPago(estadoPago);
                        var pago = new Pago(m, metodoPago, monto, fechaPago);
                        pagolist.add(pago);
                        System.out.println("Pagado con exito!");
                    } else {
                        System.out.println("Ya ha pagado esta matricula anteriormente");
                    }
                    encontrado=true;
                    break;
                } 
            }
            if(!encontrado){
                System.out.println("No se encuentra un auto matriculado con esta placa " + placa);
            }

        } else {
            System.out.println("No hay matriculas registradas");
        }
    }

    public static void main(String[] args) {
        int option;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Registrar propietario");
            System.out.println("2. Consulta de datos de propietario");
            System.out.println("3. Registro de matricula");
            System.out.println("4. Consultar matrícula");
            System.out.println("5. Pago de matricula");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            option = Integer.parseInt(scanner.nextLine());
            
            
            
           
            
            
            switch (option) {
                case 1 -> {
                    System.out.println("Escriba su nombre: ");
                    var nombre = scanner.nextLine();

                    System.out.println("Escriba el número de Cédula: ");
                    var cedula = scanner.nextLine();

                    System.out.println("Escriba su dirección");
                    var direccion = scanner.nextLine();

                    System.out.println("Escriba su número de telefono");
                    var telefono = scanner.nextLine();

                    registrarPropietario(nombre, cedula, direccion, telefono);

                }

                case 2 -> {
                    System.out.println("Escriba su número de cédula");
                    var cedula = scanner.nextLine();

                    consultarPropietario(cedula);
                }

                case 3 -> {

                    System.out.println("Escriba la placa del Vehículo");
                    var placa = scanner.nextLine();

                    System.out.println("Escriba la marca del Vehículo");
                    var marca = scanner.nextLine();

                    System.out.println("Escriba la modelo del Vehículo");
                    var modelo = scanner.nextLine();

                    System.out.println("Escriba la año del Vehículo");
                    var anio = Integer.parseInt(scanner.nextLine());

                    System.out.println("Escriba la tipo del Vehículo");
                    var tipo = scanner.nextLine();

                    System.out.println("Escriba su cédula");
                    var cedula = scanner.nextLine();

                    registrarMatricula(placa, marca, modelo, anio, tipo, cedula);
                }

                case 4 -> {
                    System.out.println("Escriba la placa del vehiculo para buscar la matricula");
                    var placa = scanner.nextLine();
                    consultarMatricula(placa);
                }

                case 5 -> {
                    System.out.println("Escriba la placa del vehiculo para pagar la matricula");
                    var placa = scanner.nextLine();

                    System.out.println("Escriba el metodo de pago (efectivo/tarjeta)");
                    var metodoPago = scanner.nextLine();

                    System.out.println("¿Desea pagar la matricula, son 17$ (true/false)?");
                    var estadoPago = Boolean.parseBoolean(scanner.nextLine());

                    var monto = 0.0;
                    if (estadoPago) {
                        
                        monto = 17;
                        pagarMatricula(placa, metodoPago, monto, estadoPago);
                    }
                }

                case 6 ->
                    System.out.println("Saliendo...");
                default ->
                    System.out.println("Opción inválida");
            }
        } while (option != 6);
    }
}
