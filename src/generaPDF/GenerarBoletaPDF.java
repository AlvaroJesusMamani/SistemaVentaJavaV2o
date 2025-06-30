/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package generaPDF;
/**
 *
 * @author Alvaro Jesus Cahuapaza
 */
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
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

            // Encabezado
            documento.add(new Paragraph("BOLETA DE VENTA", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18)));
            documento.add(new Paragraph("ID Venta: " + venta.getId_venta()));
            documento.add(new Paragraph("Fecha: " + venta.getFechaVenta()));
            documento.add(new Paragraph("Método de Pago: " + venta.getMetodoPago()));
            documento.add(new Paragraph("ID Cliente: " + venta.getId_cliente()));
            documento.add(new Paragraph("ID Empleado: " + venta.getId_empleado()));
            documento.add(new Paragraph(" "));

            // Tabla de detalles
            PdfPTable tabla = new PdfPTable(4);
            tabla.setWidthPercentage(100); // Ajuste ancho
            tabla.setSpacingBefore(10f);
            tabla.setSpacingAfter(10f);

            // Encabezados
            tabla.addCell("Producto");
            tabla.addCell("Cantidad");
            tabla.addCell("Precio Unitario");
            tabla.addCell("Importe");

            double total = 0;

            for (DetalleVenta d : detalles) {
                Producto p = d.getProducto();
                String nombreProducto = (p != null && p.getDescripcion() != null)
                        ? p.getDescripcion()
                        : "Producto desconocido";

                tabla.addCell(nombreProducto);
                tabla.addCell(String.valueOf(d.getCantidad()));
                tabla.addCell(String.format("%.2f", d.getPrecioUnitario()));
                tabla.addCell(String.format("%.2f", d.getImporte()));

                total += d.getImporte();
            }

            // 🔲 Fila de TOTAL en recuadro
            PdfPCell celdaTotalLabel = new PdfPCell(new Phrase("TOTAL VENTA:"));
            celdaTotalLabel.setColspan(3);
            celdaTotalLabel.setHorizontalAlignment(Element.ALIGN_RIGHT);
            celdaTotalLabel.setBackgroundColor(BaseColor.LIGHT_GRAY);
            tabla.addCell(celdaTotalLabel);

            PdfPCell celdaTotalValor = new PdfPCell(new Phrase("S/. " + String.format("%.2f", total)));
            celdaTotalValor.setHorizontalAlignment(Element.ALIGN_RIGHT);
            celdaTotalValor.setBackgroundColor(BaseColor.LIGHT_GRAY);
            tabla.addCell(celdaTotalValor);

            documento.add(tabla);
            documento.close();

            System.out.println("Boleta generada en: " + ruta);

        } catch (Exception e) {
            System.err.println("Error al generar PDF: " + e.getMessage());
        }
    }
}