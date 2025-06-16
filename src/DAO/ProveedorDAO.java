/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Alvaro Jesus Cahuapaza
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Conexion;
import modelo.Proveedor;

public class ProveedorDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    // Requiere que tengas una clase Conexion con getConnection()
    Conexion cn = new Conexion();

    // Listar todos los proveedores
    public List<Proveedor> listar() {
        List<Proveedor> lista = new ArrayList<>();
        String sql = "SELECT * FROM Proveedor";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Proveedor p = new Proveedor();
                p.setId_proveedor(rs.getInt("id_proveedor"));
                p.setNombre(rs.getString("nombre"));
                p.setTelefono(rs.getString("telefono"));
                p.setDireccion_calle(rs.getString("direccion_calle"));
                p.setDireccion_av(rs.getString("direccion_av"));
                p.setDireccion_mz(rs.getString("direccion_mz"));
                p.setRUC(rs.getString("RUC"));
                p.setEmail(rs.getString("email"));
                p.setFechaRegistro(rs.getDate("fechaRegistro"));
                lista.add(p);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar proveedores: " + e.getMessage());
        }

        return lista;
    }

    // Agregar un proveedor
    public boolean agregar(Proveedor p) {
        String sql = "INSERT INTO Proveedor (nombre, telefono, direccion_calle, direccion_av, direccion_mz, RUC, email, fechaRegistro) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getTelefono());
            ps.setString(3, p.getDireccion_calle());
            ps.setString(4, p.getDireccion_av());
            ps.setString(5, p.getDireccion_mz());
            ps.setString(6, p.getRUC());
            ps.setString(7, p.getEmail());
            ps.setDate(8, p.getFechaRegistro());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al agregar proveedor: " + e.getMessage());
        }
        return false;
    }

    // Actualizar un proveedor
    public boolean actualizar(Proveedor p) {
        String sql = "UPDATE Proveedor SET nombre=?, telefono=?, direccion_calle=?, direccion_av=?, direccion_mz=?, RUC=?, email=?, fechaRegistro=? WHERE id_proveedor=?";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getTelefono());
            ps.setString(3, p.getDireccion_calle());
            ps.setString(4, p.getDireccion_av());
            ps.setString(5, p.getDireccion_mz());
            ps.setString(6, p.getRUC());
            ps.setString(7, p.getEmail());
            ps.setDate(8, p.getFechaRegistro());
            ps.setInt(9, p.getId_proveedor());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al actualizar proveedor: " + e.getMessage());
        }
        return false;
    }

    // Eliminar proveedor por ID
    public boolean eliminar(int id) {
        String sql = "DELETE FROM Proveedor WHERE id_proveedor=?";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al eliminar proveedor: " + e.getMessage());
        }
        return false;
    }
}

