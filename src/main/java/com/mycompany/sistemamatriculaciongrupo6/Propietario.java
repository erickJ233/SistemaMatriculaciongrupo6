/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemamatriculaciongrupo6;

/**
 *
 * @author Mini Wernaso
 */
public class Propietario extends Persona {
//Metodo constructor
    public Propietario(String nombre, String cedula, String direccion, String telefono) {
        super(nombre, cedula, direccion, telefono);
    }

    public String getCedula() {
        return cedula;
    }

    @Override
    public String toString() {
        return String.format("""
                             Propietario con Cédula: %s
                             Nombre %s 
                             Direccion: %s
                             Telefono: %s """, cedula, nombre, direccion, telefono);
    }

}
