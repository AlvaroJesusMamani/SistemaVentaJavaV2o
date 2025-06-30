/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package generaPDF;
/**
 *
 * @author Alvaro Jesus Cahuapaza
 */
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import modelo.DetalleVenta;
import modelo.Producto;
import modelo.Venta;

import java.io.FileOutputStream;
import java.util.List;

public class GenerarBoletaPDF {

    public static void generarBoleta(Venta venta, List<DetalleVenta> detalles, String ruta) {
        try {
            Document documento = new Document();
            PdfWriter.getInstance(documento, new FileOutputStream(ruta));
            documento.open();

            // Encabezado de la boleta
            documento.add(new Paragraph("BOLETA DE VENTA", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18)));
            documento.add(new Paragraph("ID Venta: " + venta.getId_venta()));
            documento.add(new Paragraph("Fecha: " + venta.getFechaVenta()));
            documento.add(new Paragraph("Método de Pago: " + venta.getMetodoPago()));
            documento.add(new Paragraph("ID Cliente: " + venta.getId_cliente()));
            documento.add(new Paragraph("ID Empleado: " + venta.getId_empleado()));
            documento.add(new Paragraph(" "));

            // Tabla con los productos vendidos
            PdfPTable tabla = new PdfPTable(4);
            tabla.addCell("Producto");
            tabla.addCell("Cantidad");
            tabla.addCell("Precio Unitario");
            tabla.addCell("Importe");

            for (DetalleVenta d : detalles) {
                Producto p = d.getProducto();

                String nombreProducto = (p != null && p.getDescripcion() != null)
                        ? p.getDescripcion()
                        : "Producto desconocido";

                tabla.addCell(nombreProducto);
                tabla.addCell(String.valueOf(d.getCantidad()));
                tabla.addCell(String.format("%.2f", d.getPrecioUnitario()));
                tabla.addCell(String.format("%.2f", d.getImporte()));
            }

            documento.add(tabla);
            documento.close();

            System.out.println("Boleta generada en: " + ruta);

        } catch (Exception e) {
            System.err.println("Error al generar PDF: " + e.getMessage());
        }
    }
}
