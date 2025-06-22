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

    public Matricula(Vehiculo vehiculo, Date fechaRegistro, boolean estadoPago) {
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

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
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
                             """,fechaRegistro ,vehiculo.getPlaca(),estadoPago,vehiculo.getMarca(), vehiculo.getModelo(),vehiculo.getAnio(),vehiculo.getTipo(),vehiculo.getPropietario().getCedula());
    }
    
}
