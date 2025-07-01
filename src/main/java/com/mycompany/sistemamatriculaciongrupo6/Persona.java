
package com.mycompany.sistemamatriculaciongrupo6;

public class Persona {
    protected String nombre, cedula, direccion, telefono;
//Metodo constructor
    public Persona(String nombre, String cedula, String direccion, String telefono) {
    // Validar nombre
    if (nombre == null || nombre.trim().isEmpty()) {
        throw new IllegalArgumentException("El nombre no puede ser nulo o vacío.");
    }
    if (nombre.matches(".*\\d.*")) {
        throw new IllegalArgumentException("El nombre no debe contener números.");
    }

    // Validar cédula
    if (cedula == null || cedula.trim().isEmpty()) {
        throw new IllegalArgumentException("La cédula no puede ser nula o vacía.");
    }
    if (!cedula.matches("\\d{10}")) {
        throw new IllegalArgumentException("La cédula debe contener exactamente 10 dígitos.");
    }

    // Validar dirección
    if (direccion == null || direccion.trim().isEmpty()) {
        throw new IllegalArgumentException("La dirección no puede ser nula o vacía.");
    }

    // Validar teléfono
    if (telefono == null || telefono.trim().isEmpty()) {
        throw new IllegalArgumentException("El teléfono no puede ser nulo o vacío.");
    }
    if (!telefono.matches("\\d+")) {
        throw new IllegalArgumentException("El teléfono debe contener solo números.");
    }

    // Asignación
    this.nombre = nombre;
    this.cedula = cedula;
    this.direccion = direccion;
    this.telefono = telefono;
}

    public String getNombre() {
        return nombre;
    }

   
    public String getCedula() {
        return cedula;
    }

    

    public String getDireccion() {
        return direccion;
    }

  

    public String getTelefono() {
        return telefono;
    }

   
    
    
}
