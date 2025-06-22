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
import java.util.*;
import modelo.Conexion;
import modelo.Producto;

public class ProductoDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();

    // ✅ Obtener el primer proveedor registrado
    public int obtenerPrimerIdProveedor() {
        String sql = "SELECT TOP 1 id_proveedor FROM Proveedor ORDER BY id_proveedor ASC";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("id_proveedor");
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener proveedor por defecto: " + e.getMessage());
        }
        return -1; // Retorna -1 si no hay proveedores
    }

    // ✅ Listar productos
    public List<Producto> listar() {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM Producto";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto p = new Producto();
                p.setId_producto(rs.getInt("id_producto"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setPrecio(rs.getDouble("precio"));
                p.setCategoria(rs.getString("categoria"));
                p.setFechaVencimiento(rs.getDate("fechaVencimiento"));
                p.setId_proveedor(rs.getInt("id_proveedor"));
                p.setStock(rs.getInt("stock"));
                p.setCodigo(rs.getString("codigo"));
                lista.add(p);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar productos: " + e.getMessage());
        }

        return lista;
    }

    // Agregar producto con proveedor automático
    public boolean agregar(Producto p) {
        String sql = "INSERT INTO Producto (descripcion, precio, categoria, fechaVencimiento, id_proveedor, stock, codigo) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            int idProveedor = obtenerPrimerIdProveedor();
            if (idProveedor == -1) {
                System.err.println("No hay proveedores disponibles. Agrega al menos uno.");
                return false;
            }

            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getDescripcion());
            ps.setDouble(2, p.getPrecio());
            ps.setString(3, p.getCategoria());
            ps.setDate(4, new java.sql.Date(p.getFechaVencimiento().getTime()));
            ps.setInt(5, idProveedor); // asigna proveedor automáticamente
            ps.setInt(6, p.getStock());
            ps.setString(7, p.getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al agregar producto: " + e.getMessage());
        }
        return false;
    }

    // ✅ Actualizar producto
    public boolean actualizar(Producto p) {
        String sql = "UPDATE Producto SET descripcion=?, precio=?, categoria=?, fechaVencimiento=?, id_proveedor=?, stock=?, codigo=? WHERE id_producto=?";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getDescripcion());
            ps.setDouble(2, p.getPrecio());
            ps.setString(3, p.getCategoria());
            ps.setDate(4, new java.sql.Date(p.getFechaVencimiento().getTime()));
            ps.setInt(5, p.getId_proveedor()); // En actualizar sí usas el que se seleccione
            ps.setInt(6, p.getStock());
            ps.setString(7, p.getCodigo());
            ps.setInt(8, p.getId_producto());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al actualizar producto: " + e.getMessage());
        }
        return false;
    }

    // ✅ Eliminar producto
    public boolean eliminar(int id) {
        String sql = "DELETE FROM Producto WHERE id_producto=?";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al eliminar producto: " + e.getMessage());
        }
        return false;
    }
}



