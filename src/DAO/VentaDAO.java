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
import modelo.Venta;
import modelo.Producto;

public class VentaDAO {
    
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    Conexion cn = new Conexion();
// ✅ Registrar venta y obtener el ID generado (usado al generar la venta)
public int registrarVenta(Venta v) {
    String sql = "INSERT INTO Venta (fechaVenta, metodoPago, id_empleado, id_cliente) VALUES (?, ?, ?, ?)";
    int idGenerado = -1;

    try {
        con = cn.getConnection();
        ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setDate(1, v.getFechaVenta());
        ps.setString(2, v.getMetodoPago());
        ps.setInt(3, v.getId_empleado());
        ps.setInt(4, v.getId_cliente());
        ps.executeUpdate();

        rs = ps.getGeneratedKeys();
        if (rs.next()) {
            idGenerado = rs.getInt(1);
        }
    } catch (SQLException e) {
        System.err.println("Error al registrar venta: " + e.getMessage());
    }
    return idGenerado;
    
}

// ✅ Registrar detalle de venta
public boolean registrarDetalleVenta(DetalleVenta d) {
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
        System.err.println("Error al registrar detalle venta: " + e.getMessage());
    }
    return false;
}

// ✅ Buscar ID de producto por código
public int buscarIdProductoPorCodigo(String codigo) {
    String sql = "SELECT id_producto FROM Producto WHERE codigo = ?";
    int id = -1;

    try {
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        ps.setString(1, codigo);
        rs = ps.executeQuery();
        if (rs.next()) {
            id = rs.getInt("id_producto");
        }
    } catch (SQLException e) {
        System.err.println("Error al buscar id_producto por código: " + e.getMessage());
    }

    return id;
}
    // Listar todas las ventas
    public List<Venta> listar() {
        List<Venta> lista = new ArrayList<>();
        String sql = "SELECT * FROM Venta";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Venta v = new Venta();
                v.setId_venta(rs.getInt("id_venta"));
                v.setFechaVenta(rs.getDate("fechaVenta"));
                v.setMetodoPago(rs.getString("metodoPago"));
                v.setId_empleado(rs.getInt("id_empleado"));
                v.setId_cliente(rs.getInt("id_cliente"));
                lista.add(v);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar ventas: " + e.getMessage());
        }

        return lista;
    }

    // Agregar venta
    public boolean agregar(Venta v) {
        String sql = "INSERT INTO Venta (fechaVenta, metodoPago, id_empleado, id_cliente) VALUES (?, ?, ?, ?)";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setDate(1, v.getFechaVenta());
            ps.setString(2, v.getMetodoPago());
            ps.setInt(3, v.getId_empleado());
            ps.setInt(4, v.getId_cliente());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al agregar venta: " + e.getMessage());
        }

        return false;
    }

    // Actualizar venta
    public boolean actualizar(Venta v) {
        String sql = "UPDATE Venta SET fechaVenta=?, metodoPago=?, id_empleado=?, id_cliente=? WHERE id_venta=?";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setDate(1, v.getFechaVenta());
            ps.setString(2, v.getMetodoPago());
            ps.setInt(3, v.getId_empleado());
            ps.setInt(4, v.getId_cliente());
            ps.setInt(5, v.getId_venta());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al actualizar venta: " + e.getMessage());
        }

        return false;
    }

    // Eliminar venta
    public boolean eliminar(int id) {
        String sql = "DELETE FROM Venta WHERE id_venta=?";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al eliminar venta: " + e.getMessage());
        }

        return false;
    }
    
    public Venta buscarPorId(int idVenta) {
    Venta v = null;
    String sql = "SELECT * FROM Venta WHERE id_venta=?";
    try {
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        ps.setInt(1, idVenta);
        rs = ps.executeQuery();
        if (rs.next()) {
            v = new Venta();
            v.setId_venta(rs.getInt("id_venta"));
            v.setFechaVenta(rs.getDate("fechaVenta"));
            v.setMetodoPago(rs.getString("metodoPago"));
            v.setId_empleado(rs.getInt("id_empleado"));
            v.setId_cliente(rs.getInt("id_cliente"));
        }
    } catch (SQLException e) {
        System.err.println("Error al buscar venta: " + e.getMessage());
    }
    return v;
}
    
public List<DetalleVenta> obtenerDetallesVenta(int idVenta) {
    List<DetalleVenta> lista = new ArrayList<>();
    String sql = "SELECT * FROM DetalleVenta WHERE id_venta=?";

    try {
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        ps.setInt(1, idVenta);
        rs = ps.executeQuery();

        while (rs.next()) {
            DetalleVenta d = new DetalleVenta();
            d.setId_detalle(rs.getInt("id_detalle"));
            d.setId_venta(rs.getInt("id_venta"));
            d.setId_producto(rs.getInt("id_producto"));
            d.setCantidad(rs.getInt("cantidad"));
            d.setPrecioUnitario(rs.getDouble("precioUnitario"));
            d.setImporte(rs.getDouble("importe"));
            lista.add(d);
        }

    } catch (SQLException e) {
        System.err.println("Error al obtener detalles de venta: " + e.getMessage());
    }

    return lista;
}
public List<DetalleVenta> listarDetalleVenta(int idVenta) {
    List<DetalleVenta> lista = new ArrayList<>();
    String sql = "SELECT dv.*, p.descripcion FROM DetalleVenta dv JOIN Producto p ON dv.id_producto = p.id_producto WHERE dv.id_venta = ?";

    try {
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        ps.setInt(1, idVenta);
        rs = ps.executeQuery();

        while (rs.next()) {
            DetalleVenta d = new DetalleVenta();
            d.setId_detalle(rs.getInt("id_detalle"));
            d.setId_venta(rs.getInt("id_venta"));
            d.setId_producto(rs.getInt("id_producto"));
            d.setCantidad(rs.getInt("cantidad"));
            d.setPrecioUnitario(rs.getDouble("precioUnitario"));
            d.setImporte(rs.getDouble("importe"));

            // Asociar producto con descripción (para el PDF)
            Producto p = new Producto();
            p.setId_producto(rs.getInt("id_producto"));
            p.setDescripcion(rs.getString("descripcion"));
            d.setProducto(p);

            lista.add(d);
        }
    } catch (SQLException e) {
        System.err.println("Error al listar detalle de venta: " + e.getMessage());
    }

    return lista;
}


}


