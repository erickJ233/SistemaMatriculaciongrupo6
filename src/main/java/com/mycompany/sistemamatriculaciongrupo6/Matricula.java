/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemamatriculaciongrupo6;

import java.util.Date;

/**
 *
 * @author Mini Wernaso
 */
public class Matricula {

    private Vehiculo vehiculo;
    private Date fechaRegistro;
    private boolean estadoPago;
    
    //Metodo constructor
    public Matricula(Vehiculo vehiculo, Date fechaRegistro, boolean estadoPago) {
    if (vehiculo == null) {
        throw new IllegalArgumentException("El vehículo no puede ser nulo.");
    }

    if (fechaRegistro == null) {
        throw new IllegalArgumentException("La fecha de registro no puede ser nula.");
    }

    Date hoy = new Date();
    if (fechaRegistro.after(hoy)) {
        throw new IllegalArgumentException("La fecha de registro no puede estar en el futuro.");
    }

    this.vehiculo = vehiculo;
    this.fechaRegistro = fechaRegistro;
    this.estadoPago = estadoPago;
}

    public boolean getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(boolean estadoPago) {
        this.estadoPago = estadoPago;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    @Override
    public String toString() {
        return String.format("""
                             Fecha de generación: %s 
                             Placa: %s
                             Estado pagado: %b
                             Marca: %s
                             Modelo: %s
                             Año: %d
                             Tipo: %s
                             Propietario con Cédula: %s
                             """, fechaRegistro, vehiculo.getPlaca(), estadoPago, vehiculo.getMarca(), vehiculo.getModelo(), vehiculo.getAnio(), vehiculo.getTipo(), vehiculo.getPropietario().getCedula());
    }

}
