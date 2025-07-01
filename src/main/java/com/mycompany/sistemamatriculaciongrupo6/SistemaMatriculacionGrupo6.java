package com.mycompany.sistemamatriculaciongrupo6;

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class SistemaMatriculacionGrupo6 {

    static List<Propietario> propietarioslist = new ArrayList<>();
    static List<Matricula> matriculalist = new ArrayList<>();
    static List<Pago> pagolist = new ArrayList<>();

    //metodo instancia
    public void registrarPropietario(String nombre, String cedula, String direccion, String telefono) {

        // Validaciones básicas
        if (nombre == null || nombre.trim().isEmpty() || nombre.matches(".*\\d.*")) {
            throw new IllegalArgumentException("El nombre no debe estar vacío ni contener números.");
        }

        if (cedula == null || !cedula.matches("\\d{10}")) {
            throw new IllegalArgumentException("La cédula debe contener exactamente 10 dígitos numéricos.");
        }

        if (direccion == null || direccion.trim().isEmpty()) {
            throw new IllegalArgumentException("La dirección no puede estar vacía.");
        }

        if (telefono == null || !telefono.matches("\\d{7,10}")) {
            throw new IllegalArgumentException("El teléfono debe tener entre 7 y 10 dígitos.");
        }

        // Verificar si el propietario ya existe
        for (Propietario p : propietarioslist) {
            if (p.getCedula().equals(cedula)) {
                throw new IllegalArgumentException("Este propietario ya está registrado.");
            }
        }

        var propietario = new Propietario(nombre, cedula, direccion, telefono);
        propietarioslist.add(propietario);
        System.out.println("Propietario registrado con éxito.");
    }

    //metodo instancia
    public void consultarPropietario(String cedula) {

        if (cedula == null || !cedula.matches("\\d{10}")) {
            throw new IllegalArgumentException("La cédula debe contener exactamente 10 dígitos numéricos.");
        }

        if (propietarioslist.isEmpty()) {
            throw new IllegalStateException("No hay propietarios registrados.");
        }

        for (Propietario p : propietarioslist) {
            if (p.getCedula().equals(cedula)) {
                System.out.println(p.toString());
                return;
            }
        }

        throw new NoSuchElementException("No se encuentra ningún propietario con la cédula: " + cedula);
    }

    //metodo instancia
    public void registrarMatricula(String placa, String marca, String modelo, int anio, String tipo, String cedula) {

        // Validaciones básicas
        if (placa == null || !placa.matches("[A-Z]{3}-\\d{3,4}")) {
            throw new IllegalArgumentException("La placa debe tener el formato ABC-123 o ABC-1234.");
        }

        if (marca == null || marca.trim().isEmpty()) {
            throw new IllegalArgumentException("La marca no puede estar vacía.");
        }

        if (modelo == null || modelo.trim().isEmpty()) {
            throw new IllegalArgumentException("El modelo no puede estar vacío.");
        }

        if (anio < 1900 || anio > Calendar.getInstance().get(Calendar.YEAR)) {
            throw new IllegalArgumentException("El año del vehículo no es válido.");
        }

        if (tipo == null || tipo.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de vehículo no puede estar vacío.");
        }

        if (cedula == null || !cedula.matches("\\d{10}")) {
            throw new IllegalArgumentException("La cédula debe contener exactamente 10 dígitos.");
        }

        if (propietarioslist.isEmpty()) {
            throw new IllegalStateException("No hay propietarios registrados.");
        }

        for (Matricula m : matriculalist) {
            if (m.getVehiculo().getPlaca().equals(placa)) {
                throw new IllegalArgumentException("Este vehículo ya está matriculado.");
            }
        }

        for (Propietario p : propietarioslist) {
            if (p.getCedula().equals(cedula)) {
                var vehiculo = new Vehiculo(placa, marca, modelo, tipo, anio, p);
                Date fechaActual = new Date();
                var matricula = new Matricula(vehiculo, fechaActual, false);
                matriculalist.add(matricula);
                System.out.println("Matrícula registrada con éxito. Recuerde pagar la matrícula.");
                return;
            }
        }

        throw new NoSuchElementException("No se encontró un propietario con el número de cédula: " + cedula);
    }

    //metodo Estatico
    public static void consultarMatricula(String placa) {
        if (placa == null || !placa.matches("[A-Z]{3}-\\d{3,4}")) {
            throw new IllegalArgumentException("La placa debe tener el formato ABC-123 o ABC-1234.");
        }

        if (matriculalist.isEmpty()) {
            throw new IllegalStateException("No hay matrículas registradas.");
        }

        for (Matricula m : matriculalist) {
            if (m.getVehiculo().getPlaca().equals(placa)) {
                System.out.println(m.toString());
                return;
            }
        }

        throw new NoSuchElementException("No se encontró ninguna matrícula con esta placa: " + placa);
    }

    //metodo Estatico
    public static void pagarMatricula(String placa, String metodoPago, Double monto, boolean estadoPago) {
        if (placa == null || !placa.matches("[A-Z]{3}-\\d{3,4}")) {
            throw new IllegalArgumentException("La placa debe tener el formato ABC-123 o ABC-1234.");
        }

        if (metodoPago == null || metodoPago.trim().isEmpty()) {
            throw new IllegalArgumentException("El método de pago no puede estar vacío.");
        }

        if (monto == null || monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor que cero.");
        }

        if (matriculalist.isEmpty()) {
            throw new IllegalStateException("No hay matrículas registradas.");
        }

        for (Matricula m : matriculalist) {
            if (m.getVehiculo().getPlaca().equals(placa)) {
                if (m.getEstadoPago()) {
                    throw new IllegalStateException("Esta matrícula ya ha sido pagada anteriormente.");
                }

                Date fechaPago = new Date();
                m.setEstadoPago(estadoPago);
                var pago = new Pago(m, metodoPago, monto, fechaPago);
                pagolist.add(pago);
                System.out.println("¡Pagado con éxito!");
                return;
            }
        }

        throw new NoSuchElementException("No se encontró una matrícula con la placa: " + placa);
    }

    public static void main(String[] args) {
        int option;
        Scanner scanner = new Scanner(System.in);
        SistemaMatriculacionGrupo6 sistema = new SistemaMatriculacionGrupo6();
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

                    sistema.registrarPropietario(nombre, cedula, direccion, telefono);

                }

                case 2 -> {
                    System.out.println("Escriba su número de cédula");
                    var cedula = scanner.nextLine();

                    sistema.consultarPropietario(cedula);
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

                    sistema.registrarMatricula(placa, marca, modelo, anio, tipo, cedula);
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
