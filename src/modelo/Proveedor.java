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

public class Proveedor {
    private int id_proveedor;
    private String nombre;
    private String telefono;
    private String direccion_calle;
    private String direccion_av;
    private String direccion_mz;
    private String RUC;
    private String email;
    private Date fechaRegistro;

    public Proveedor() {}

    public Proveedor(int id_proveedor, String nombre, String telefono, String direccion_calle,
                     String direccion_av, String direccion_mz, String RUC, String email, Date fechaRegistro) {
        this.id_proveedor = id_proveedor;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion_calle = direccion_calle;
        this.direccion_av = direccion_av;
        this.direccion_mz = direccion_mz;
        this.RUC = RUC;
        this.email = email;
        this.fechaRegistro = fechaRegistro;
    }

    public int getId_proveedor() { return id_proveedor; }
    public void setId_proveedor(int id_proveedor) { this.id_proveedor = id_proveedor; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getDireccion_calle() { return direccion_calle; }
    public void setDireccion_calle(String direccion_calle) { this.direccion_calle = direccion_calle; }

    public String getDireccion_av() { return direccion_av; }
    public void setDireccion_av(String direccion_av) { this.direccion_av = direccion_av; }

    public String getDireccion_mz() { return direccion_mz; }
    public void setDireccion_mz(String direccion_mz) { this.direccion_mz = direccion_mz; }

    public String getRUC() { return RUC; }
    public void setRUC(String RUC) { this.RUC = RUC; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Date getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(Date fechaRegistro) { this.fechaRegistro = fechaRegistro; }
}
