/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemamatriculaciongrupo6;

/**
 *
 * @author Mini Wernaso
 */
public class Vehiculo {

    private String placa, marca, modelo, tipo;
    private int anio;
    private Propietario propietario;
//Metodo constructor
    public Vehiculo(String placa, String marca, String modelo, String tipo, int anio, Propietario propietario) {
        if (placa == null || placa.trim().isEmpty()) {
            throw new IllegalArgumentException("La placa no puede ser nula o vacía.");
        }
        if (marca == null || marca.trim().isEmpty()) {
            throw new IllegalArgumentException("La marca no puede ser nula o vacía.");
        }
        if (modelo == null || modelo.trim().isEmpty()) {
            throw new IllegalArgumentException("El modelo no puede ser nulo o vacío.");
        }
        if (tipo == null || tipo.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo no puede ser nulo o vacío.");
        }

        int anioActual = java.time.Year.now().getValue();
        if (anio < 1900 || anio > anioActual) {
            throw new IllegalArgumentException("El año debe estar entre 1900 y " + anioActual + ".");
        }

        
        if (propietario == null) {
            throw new IllegalArgumentException("El propietario no puede ser nulo.");
        }
        String nombrePropietario = propietario.getNombre(); // Asumiendo que hay un método getNombre()
        if (nombrePropietario == null || nombrePropietario.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del propietario no puede ser nulo o vacío.");
        }
        if (nombrePropietario.matches(".*\\d.*")) {
            throw new IllegalArgumentException("El nombre del propietario no debe contener números.");
        }

        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.tipo = tipo;
        this.anio = anio;
        this.propietario = propietario;
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public int getAnio() {
        return anio;
    }

    public Propietario getPropietario() {
        return propietario;
    }
    

}
