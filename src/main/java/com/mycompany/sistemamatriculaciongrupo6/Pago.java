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
public class Pago {

    private Matricula matricula;
    private String metodoPago;
    private Double monto;
    private Date fechaPago;
        //Metodo constructor

    public Pago(Matricula matricula, String metodoPago, Double monto, Date fechaPago) {
        if (matricula == null) {
            throw new IllegalArgumentException("La matrícula no puede ser nula.");
        }

        if (metodoPago == null || metodoPago.trim().isEmpty()) {
            throw new IllegalArgumentException("El método de pago no puede ser nulo o vacío.");
        }

        if (monto == null || monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor que cero.");
        }

        if (fechaPago == null) {
            throw new IllegalArgumentException("La fecha de pago no puede ser nula.");
        }

        Date hoy = new Date();
        if (fechaPago.after(hoy)) {
            throw new IllegalArgumentException("La fecha de pago no puede ser en el futuro.");
        }

        this.matricula = matricula;
        this.metodoPago = metodoPago;
        this.monto = monto;
        this.fechaPago = fechaPago;
    }

}
