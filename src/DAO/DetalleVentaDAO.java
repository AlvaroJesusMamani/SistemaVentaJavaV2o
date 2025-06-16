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
import modelo.DetalleVenta;

public class DetalleVentaDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();

    // Listar todos los detalles de venta
    public List<DetalleVenta> listar() {
        List<DetalleVenta> lista = new ArrayList<>();
        String sql = "SELECT * FROM DetalleVenta";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                DetalleVenta d = new DetalleVenta();
                d.setId_detalle(rs.getInt("id_detalle"));
                d.setId_venta(rs.getInt("id_venta"));
                d.setId_producto(rs.getInt("id_producto"));
                d.setCantidad(rs.getInt("cantidad"));
                d.setPrecioUnitario(rs.getDouble("precioUnitario"));
                d.setImporte(rs.getDouble("importe")); // solo lectura
                lista.add(d);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar detalle ventas: " + e.getMessage());
        }

        return lista;
    }

    // Agregar detalle de venta
    public boolean agregar(DetalleVenta d) {
        String sql = "INSERT INTO DetalleVenta (id_venta, id_producto, cantidad, precioUnitario) VALUES (?, ?, ?, ?)";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, d.getId_venta());
            ps.setInt(2, d.getId_producto());
            ps.setInt(3, d.getCantidad());
            ps.setDouble(4, d.getPrecioUnitario());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al agregar detalle venta: " + e.getMessage());
        }

        return false;
    }

    // Actualizar detalle (no se suele hacer, pero por si acaso)
    public boolean actualizar(DetalleVenta d) {
        String sql = "UPDATE DetalleVenta SET id_venta=?, id_producto=?, cantidad=?, precioUnitario=? WHERE id_detalle=?";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, d.getId_venta());
            ps.setInt(2, d.getId_producto());
            ps.setInt(3, d.getCantidad());
            ps.setDouble(4, d.getPrecioUnitario());
            ps.setInt(5, d.getId_detalle());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al actualizar detalle venta: " + e.getMessage());
        }

        return false;
    }

    // Eliminar por ID
    public boolean eliminar(int id) {
        String sql = "DELETE FROM DetalleVenta WHERE id_detalle=?";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al eliminar detalle venta: " + e.getMessage());
        }

        return false;
    }
}


