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
import modelo.Cliente;
import modelo.Conexion;

public class ClienteDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    Conexion cn = new Conexion();

    // Listar clientes
    public List<Cliente> listar() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM Cliente";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId_cliente(rs.getInt("id_cliente"));
                c.setNombre(rs.getString("nombre"));
                c.setTelefono(rs.getString("telefono"));
                c.setEmail(rs.getString("email"));
                c.setDireccion_calle(rs.getString("direccion_calle"));
                c.setDireccion_av(rs.getString("direccion_av"));
                c.setDireccion_mz(rs.getString("direccion_mz"));
                c.setCiudad(rs.getString("ciudad"));
                lista.add(c);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar clientes: " + e.getMessage());
        }

        return lista;
    }

    // Agregar cliente
    public boolean agregar(Cliente c) {
        String sql = "INSERT INTO Cliente (nombre, telefono, email, direccion_calle, direccion_av, direccion_mz, ciudad) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getTelefono());
            ps.setString(3, c.getEmail());
            ps.setString(4, c.getDireccion_calle());
            ps.setString(5, c.getDireccion_av());
            ps.setString(6, c.getDireccion_mz());
            ps.setString(7, c.getCiudad());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al agregar cliente: " + e.getMessage());
        }
        return false;
    }

    // Actualizar cliente
    public boolean actualizar(Cliente c) {
        String sql = "UPDATE Cliente SET nombre=?, telefono=?, email=?, direccion_calle=?, direccion_av=?, direccion_mz=?, ciudad=? WHERE id_cliente=?";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getTelefono());
            ps.setString(3, c.getEmail());
            ps.setString(4, c.getDireccion_calle());
            ps.setString(5, c.getDireccion_av());
            ps.setString(6, c.getDireccion_mz());
            ps.setString(7, c.getCiudad());
            ps.setInt(8, c.getId_cliente());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al actualizar cliente: " + e.getMessage());
        }
        return false;
    }

    // Eliminar cliente
    public boolean eliminar(int id) {
        String sql = "DELETE FROM Cliente WHERE id_cliente=?";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al eliminar cliente: " + e.getMessage());
        }
        return false;
    }
}

