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
import modelo.Empleado;

public class EmpleadoDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    Conexion cn = new Conexion();

    // Listar empleados
    public List<Empleado> listar() {
        List<Empleado> lista = new ArrayList<>();
        String sql = "SELECT * FROM Empleado";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Empleado e = new Empleado();
                e.setId_empleado(rs.getInt("id_empleado"));
                e.setNombre(rs.getString("nombre"));
                e.setTelefono(rs.getString("telefono"));
                e.setDni(rs.getString("dni"));
                e.setEmail(rs.getString("email"));
                e.setDireccion_calle(rs.getString("direccion_calle"));
                e.setDireccion_av(rs.getString("direccion_av"));
                e.setDireccion_mz(rs.getString("direccion_mz"));
                e.setCiudad(rs.getString("ciudad"));
                lista.add(e);
            }
        } catch (SQLException ex) {
            System.err.println("Error al listar empleados: " + ex.getMessage());
        }

        return lista;
    }

    // Agregar empleado
    public boolean agregar(Empleado e) {
        String sql = "INSERT INTO Empleado (nombre, telefono, dni, email, direccion_calle, direccion_av, direccion_mz, ciudad) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, e.getNombre());
            ps.setString(2, e.getTelefono());
            ps.setString(3, e.getDni());
            ps.setString(4, e.getEmail());
            ps.setString(5, e.getDireccion_calle());
            ps.setString(6, e.getDireccion_av());
            ps.setString(7, e.getDireccion_mz());
            ps.setString(8, e.getCiudad());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al agregar empleado: " + ex.getMessage());
        }
        return false;
    }

    // Actualizar empleado
    public boolean actualizar(Empleado e) {
        String sql = "UPDATE Empleado SET nombre=?, telefono=?, dni=?, email=?, direccion_calle=?, direccion_av=?, direccion_mz=?, ciudad=? WHERE id_empleado=?";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, e.getNombre());
            ps.setString(2, e.getTelefono());
            ps.setString(3, e.getDni());
            ps.setString(4, e.getEmail());
            ps.setString(5, e.getDireccion_calle());
            ps.setString(6, e.getDireccion_av());
            ps.setString(7, e.getDireccion_mz());
            ps.setString(8, e.getCiudad());
            ps.setInt(9, e.getId_empleado());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al actualizar empleado: " + ex.getMessage());
        }
        return false;
    }

    // Eliminar empleado
    public boolean eliminar(int id) {
        String sql = "DELETE FROM Empleado WHERE id_empleado=?";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al eliminar empleado: " + ex.getMessage());
        }
        return false;
    }
}

