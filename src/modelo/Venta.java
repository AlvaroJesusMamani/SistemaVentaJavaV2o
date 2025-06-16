/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Alvaro Jesus Cahuapaza
 */


import java.sql.Date;

public class Venta {
    private int id_venta;
    private Date fechaVenta;
    private String metodoPago;
    private int id_empleado;
    private int id_cliente;

    public Venta() {}

    public Venta(int id_venta, Date fechaVenta, String metodoPago, int id_empleado, int id_cliente) {
        this.id_venta = id_venta;
        this.fechaVenta = fechaVenta;
        this.metodoPago = metodoPago;
        this.id_empleado = id_empleado;
        this.id_cliente = id_cliente;
    }

    public int getId_venta() { return id_venta; }
    public void setId_venta(int id_venta) { this.id_venta = id_venta; }

    public Date getFechaVenta() { return fechaVenta; }
    public void setFechaVenta(Date fechaVenta) { this.fechaVenta = fechaVenta; }

    public String getMetodoPago() { return metodoPago; }
    public void setMetodoPago(String metodoPago) { this.metodoPago = metodoPago; }

    public int getId_empleado() { return id_empleado; }
    public void setId_empleado(int id_empleado) { this.id_empleado = id_empleado; }

    public int getId_cliente() { return id_cliente; }
    public void setId_cliente(int id_cliente) { this.id_cliente = id_cliente; }
}

