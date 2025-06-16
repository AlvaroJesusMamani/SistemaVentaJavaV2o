/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Alvaro Jesus Cahuapaza
 */


public class Cliente {
    private int id_cliente;
    private String nombre;
    private String telefono;
    private String email;
    private String direccion_calle;
    private String direccion_av;
    private String direccion_mz;
    private String ciudad;

    public Cliente() {}

    public Cliente(int id_cliente, String nombre, String telefono, String email,
                   String direccion_calle, String direccion_av, String direccion_mz, String ciudad) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.direccion_calle = direccion_calle;
        this.direccion_av = direccion_av;
        this.direccion_mz = direccion_mz;
        this.ciudad = ciudad;
    }

    public int getId_cliente() { return id_cliente; }
    public void setId_cliente(int id_cliente) { this.id_cliente = id_cliente; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getDireccion_calle() { return direccion_calle; }
    public void setDireccion_calle(String direccion_calle) { this.direccion_calle = direccion_calle; }

    public String getDireccion_av() { return direccion_av; }
    public void setDireccion_av(String direccion_av) { this.direccion_av = direccion_av; }

    public String getDireccion_mz() { return direccion_mz; }
    public void setDireccion_mz(String direccion_mz) { this.direccion_mz = direccion_mz; }

    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }
}

