
package Vista;

import DAO.ClienteDAO;
import DAO.EmpleadoDAO;
import DAO.ProductoDAO;
import DAO.ProveedorDAO;
import DAO.VentaDAO;
import generaPDF.GenerarBoletaPDF;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.Empleado;
import modelo.Producto;
import modelo.Proveedor;
import modelo.Venta;
import modelo.DetalleVenta;


/**
 *
 * @author Alvaro Jesus Cahuapaza
 */

public class FrmSistemaVentas extends javax.swing.JFrame {

    private final ProveedorDAO proveedorDAO = new ProveedorDAO();
    private DefaultTableModel modelo;
    private int filaSeleccionada = -1;
    
    private DefaultTableModel modeloProducto;
    private int filaSeleccionadaProducto = -1;
    
    
    

    
    public FrmSistemaVentas() {
        initComponents();
        //hacer que el campo id sea editable:
        txtIdCliente.setEditable(false); //<< Cliente id
        txtId.setEditable(false); //<< Proveedor id
        txtIdEmp.setEditable(false); //<< Empleado id
        txtIdProducto.setEditable(true); //<<ProductoId
        
    //Esta parte vincula los botones con las pestañas
    btnClientes.addActionListener(e -> jTabbedPane1.setSelectedIndex(0)); 
    btnProveedor.addActionListener(e -> jTabbedPane1.setSelectedIndex(1)); 
    btnEmpleado.addActionListener(e -> jTabbedPane1.setSelectedIndex(2)); 
    btnProductos.addActionListener(e -> jTabbedPane1.setSelectedIndex(3)); 
    btnVentas.addActionListener(e -> jTabbedPane1.setSelectedIndex(4)); 
    btnDetalleVenta.addActionListener(e -> jTabbedPane1.setSelectedIndex(5));  
        //lista los datos de la bd en la tabla a la hora de ejecutar
        listarClientes(); 
        listarProveedores();
        listarProductos();
        listarProductos();
        listarEmpleados();
        mostrarFechaYHoraSeparadas();
        //oculta las pestañas
        jTabbedPane1.setUI(null);
// COLORES BTN
btnClientes.setBackground(new Color(52, 152, 219)); // azul principal
btnClientes.setForeground(Color.WHITE);             // texto blanco
btnClientes.setBorderPainted(false);                // sin borde
btnClientes.setFocusPainted(false);                 // sin resaltado de foco


//ICONOS PNG A BOTONES
// CLIENTES
ImageIcon iconCliente = new ImageIcon(getClass().getResource("/imagenes/cliente.png"));
Image imgCliente = iconCliente.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
btnClientes.setIcon(new ImageIcon(imgCliente));
btnClientes.setHorizontalTextPosition(SwingConstants.RIGHT);
btnClientes.setVerticalTextPosition(SwingConstants.CENTER);
btnClientes.setIconTextGap(10);

// PROVEEDOR
ImageIcon iconProveedor = new ImageIcon(getClass().getResource("/imagenes/proveedor.png"));
Image imgProveedor = iconProveedor.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
btnProveedor.setIcon(new ImageIcon(imgProveedor));
btnProveedor.setHorizontalTextPosition(SwingConstants.RIGHT);
btnProveedor.setVerticalTextPosition(SwingConstants.CENTER);
btnProveedor.setIconTextGap(10);

// EMPLEADO
ImageIcon iconEmpleado = new ImageIcon(getClass().getResource("/imagenes/empleado.png"));
Image imgEmpleado = iconEmpleado.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
btnEmpleado.setIcon(new ImageIcon(imgEmpleado));
btnEmpleado.setHorizontalTextPosition(SwingConstants.RIGHT);
btnEmpleado.setVerticalTextPosition(SwingConstants.CENTER);
btnEmpleado.setIconTextGap(10);

// PRODUCTOS
ImageIcon iconProducto = new ImageIcon(getClass().getResource("/imagenes/producto.png"));
Image imgProducto = iconProducto.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
btnProductos.setIcon(new ImageIcon(imgProducto));
btnProductos.setHorizontalTextPosition(SwingConstants.RIGHT);
btnProductos.setVerticalTextPosition(SwingConstants.CENTER);
btnProductos.setIconTextGap(10);

// VENTAS
ImageIcon iconVenta = new ImageIcon(getClass().getResource("/imagenes/venta.png"));
Image imgVenta = iconVenta.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
btnVentas.setIcon(new ImageIcon(imgVenta));
btnVentas.setHorizontalTextPosition(SwingConstants.RIGHT);
btnVentas.setVerticalTextPosition(SwingConstants.CENTER);
btnVentas.setIconTextGap(10);






    } 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnClientes = new javax.swing.JButton();
        btnProveedor = new javax.swing.JButton();
        btnEmpleado = new javax.swing.JButton();
        btnProductos = new javax.swing.JButton();
        btnVentas = new javax.swing.JButton();
        btnDetalleVenta = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JTextField();
        txtEmailCliente = new javax.swing.JTextField();
        txtTelefonoCliente = new javax.swing.JTextField();
        txtMzCliente = new javax.swing.JTextField();
        txtCalleCliente = new javax.swing.JTextField();
        txtAvCliente = new javax.swing.JTextField();
        txtCiudadCliente = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        txtIdCliente = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtRUC = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        btnAgregar2 = new javax.swing.JButton();
        btnModificar2 = new javax.swing.JButton();
        btnEliminar2 = new javax.swing.JButton();
        btnLimpiar2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaProveedor = new javax.swing.JTable();
        txtMz = new javax.swing.JTextField();
        txtCalle = new javax.swing.JTextField();
        txtAv = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jdcFechaRegistro = new com.toedter.calendar.JDateChooser();
        jLabel21 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        txtIdEmp = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtNombreEmp = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtDniEmp = new javax.swing.JTextField();
        txtTelefonoEmp = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtMzEmp = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txtCalleEmp = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtAvEmp = new javax.swing.JTextField();
        txtCiudadEmp = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaEmpleado = new javax.swing.JTable();
        jLabel50 = new javax.swing.JLabel();
        btnAgregar3 = new javax.swing.JButton();
        btnModificar3 = new javax.swing.JButton();
        btnEliminar3 = new javax.swing.JButton();
        btnLimpiar3 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        txtEmailEmp = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        txtIdProducto = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        btnAgregar4 = new javax.swing.JButton();
        btnModificar4 = new javax.swing.JButton();
        btnEliminar4 = new javax.swing.JButton();
        btnLimpiar4 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        jLabel31 = new javax.swing.JLabel();
        txtCodigoProd = new javax.swing.JTextField();
        jdcFechaVencimiento = new com.toedter.calendar.JDateChooser();
        jLabel32 = new javax.swing.JLabel();
        cboCategoria = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        txtIdVenta = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        txtCodCliente = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        btnBuscarCliente = new javax.swing.JButton();
        txtTotalVenta = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        txtCodProducto = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        spinnerCantidadVenta = new javax.swing.JSpinner();
        btnBuscarProducto = new javax.swing.JButton();
        jLabel45 = new javax.swing.JLabel();
        txtPrecio2 = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        txtProducto = new javax.swing.JTextField();
        txtStock3 = new javax.swing.JTextField();
        btnAgregar5 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblDetalleVenta = new javax.swing.JTable();
        btnGenerarVenta = new javax.swing.JButton();
        btnCancelar2 = new javax.swing.JButton();
        jLabel49 = new javax.swing.JLabel();
        cbxMetodoPago = new javax.swing.JComboBox<>();
        btnGenerarBoleta = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        lblFecha = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(242, 107, 224));

        jPanel8.setBackground(new java.awt.Color(245, 246, 250));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("SISTEMA DE VENTAS");

        btnClientes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnClientes.setText("Clientes");
        btnClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnClientesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnClientesMouseExited(evt);
            }
        });

        btnProveedor.setText("Proveedor");

        btnEmpleado.setText("Empleado");

        btnProductos.setText("Productos");

        btnVentas.setText("Ventas");

        btnDetalleVenta.setText("DetalleVenta");

        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jTabbedPane1.setBackground(new java.awt.Color(245, 246, 250));

        jPanel1.setBackground(new java.awt.Color(245, 246, 250));

        jLabel2.setText("Nombre");

        jLabel3.setText("Telefono");

        jLabel5.setText("Email");

        jLabel6.setText("Direccion:");

        jLabel7.setText("Mz");

        jLabel8.setText("Calle");

        jLabel9.setText("Av.");

        jLabel10.setText("Ciudad");

        txtCalleCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCalleClienteActionPerformed(evt);
            }
        });

        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Email", "Telefono", "Mz", "Calle", "Av", "Ciudad"
            }
        ));
        tblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblClientes);

        jLabel11.setText("ID Cliente :");

        txtIdCliente.setBackground(new java.awt.Color(245, 246, 250));
        txtIdCliente.setBorder(null);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEmailCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel6)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtMzCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCalleCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAvCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCiudadCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(jLabel7)
                                        .addGap(64, 64, 64)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel9))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtTelefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                                .addComponent(jLabel10)
                                .addGap(43, 43, 43))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnEliminar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnAgregar)
                                        .addGap(43, 43, 43)
                                        .addComponent(btnModificar)))
                                .addGap(70, 70, 70)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 791, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtEmailCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTelefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMzCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCalleCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAvCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCiudadCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(126, 126, 126))
        );

        jTabbedPane1.addTab("Clientes", jPanel1);

        jPanel2.setBackground(new java.awt.Color(245, 246, 250));

        jLabel12.setText("Nombre");

        jLabel13.setText("Telefono");

        jLabel14.setText("Email");

        jLabel15.setText("RUC");

        jLabel16.setText("Direccion detallada:");

        jLabel17.setText("Mz");

        jLabel18.setText("Calle");

        jLabel19.setText("Av");

        btnAgregar2.setText("AGREGAR");
        btnAgregar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar2ActionPerformed(evt);
            }
        });

        btnModificar2.setText("MODIFICAR");
        btnModificar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar2ActionPerformed(evt);
            }
        });

        btnEliminar2.setText("ELIMINAR");
        btnEliminar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar2ActionPerformed(evt);
            }
        });

        btnLimpiar2.setText("LIMPIAR");
        btnLimpiar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar2ActionPerformed(evt);
            }
        });

        tablaProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Telefono", "Calle", "Av", "Mz", "RUC", "Email", "Fecha Registro"
            }
        ));
        tablaProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProveedorMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaProveedor);

        jLabel20.setText("Fecha de Registro");

        jLabel21.setText("ID Proveedor");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13)
                            .addComponent(jLabel15)
                            .addComponent(jLabel12))
                        .addGap(21, 21, 21))
                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRUC, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(128, 128, 128)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCalle)
                            .addComponent(txtAv, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(152, 152, 152))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(56, 56, 56)
                                .addComponent(txtMz)
                                .addGap(54, 54, 54)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 378, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jdcFechaRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(64, 64, 64))))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregar2)
                    .addComponent(btnEliminar2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLimpiar2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel20)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(jLabel17)
                        .addComponent(txtMz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jdcFechaRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(jLabel18)
                        .addComponent(txtCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(jLabel19)
                        .addComponent(txtAv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(txtRUC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAgregar2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnModificar2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLimpiar2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(130, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Proveedor", jPanel2);

        jPanel3.setBackground(new java.awt.Color(245, 246, 250));

        jLabel22.setText("ID Empleado");

        jLabel23.setText("Nombre");

        jLabel25.setText("DNI");

        jLabel26.setText("Telefono");

        jLabel27.setText("Direccion de empleado");

        jLabel28.setText("Mz");

        jLabel29.setText("Calle");

        jLabel30.setText("Av");

        tablaEmpleado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Telefono", "DNI", "Email", "Calle", "Av", "Mz", "Ciudad"
            }
        ));
        tablaEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaEmpleadoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablaEmpleado);
        if (tablaEmpleado.getColumnModel().getColumnCount() > 0) {
            tablaEmpleado.getColumnModel().getColumn(8).setResizable(false);
        }

        jLabel50.setText("Ciudad");

        btnAgregar3.setText("AGREGAR");
        btnAgregar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar3ActionPerformed(evt);
            }
        });

        btnModificar3.setText("MODIFICAR");
        btnModificar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar3ActionPerformed(evt);
            }
        });

        btnEliminar3.setText("ELIMINAR");
        btnEliminar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar3ActionPerformed(evt);
            }
        });

        btnLimpiar3.setText("LIMPIAR");

        jLabel24.setText("Email");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel23)
                                .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel26)
                            .addComponent(jLabel24))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtIdEmp)
                            .addComponent(txtNombreEmp)
                            .addComponent(txtDniEmp)
                            .addComponent(txtTelefonoEmp, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                            .addComponent(txtEmailEmp))
                        .addGap(127, 127, 127)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel28)
                                    .addComponent(jLabel29)
                                    .addComponent(jLabel30)
                                    .addComponent(jLabel50))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMzEmp)
                                    .addComponent(txtCalleEmp)
                                    .addComponent(txtAvEmp, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                    .addComponent(txtCiudadEmp))
                                .addGap(135, 135, 135)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnEliminar3, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                                    .addComponent(btnAgregar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(35, 35, 35)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnModificar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnLimpiar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel27)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1050, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(154, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregar3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnModificar3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(txtIdEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28)
                            .addComponent(txtMzEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtNombreEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel29)
                                .addComponent(txtCalleEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel30)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtDniEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel25)))
                                .addGap(18, 18, 18)
                                .addComponent(txtTelefonoEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtAvEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCiudadEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel50)
                                    .addComponent(jLabel26)))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEliminar3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLimpiar3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addComponent(txtEmailEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(121, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Empleado", jPanel3);

        jPanel4.setBackground(new java.awt.Color(245, 246, 250));

        jLabel33.setText("ID Producto");

        jLabel34.setText("Descripcion");

        jLabel35.setText("Precio");

        jLabel37.setText("Categoria");

        jLabel38.setText("Stock");

        btnAgregar4.setText("AGREGAR");
        btnAgregar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar4ActionPerformed(evt);
            }
        });

        btnModificar4.setText("MODIFICAR");
        btnModificar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar4ActionPerformed(evt);
            }
        });

        btnEliminar4.setText("ELIMINAR");
        btnEliminar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar4ActionPerformed(evt);
            }
        });

        btnLimpiar4.setText("LIMPIAR");
        btnLimpiar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar4ActionPerformed(evt);
            }
        });

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo Prod.", "Descripcion", "Precio", "Categoria", "Stock", "FechaVencimiento", "ID"
            }
        ));
        tblProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductosMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblProductos);

        jLabel31.setText("Codigo Prod.");

        jLabel32.setText("Fecha de Vencimiento");

        cboCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--CATEGORIA--", "Alimentos", "Bebidas", "Lácteos", "Carnes", "Abarrotes", "Limpieza", "Higiene", "Congelados", "Panadería" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33)
                            .addComponent(jLabel34)
                            .addComponent(jLabel35))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                            .addComponent(txtIdProducto)
                            .addComponent(txtDescripcion))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel38)
                            .addComponent(jLabel37)
                            .addComponent(jLabel31))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtStock)
                            .addComponent(txtCodigoProd)
                            .addComponent(cboCategoria, 0, 120, Short.MAX_VALUE))
                        .addGap(101, 101, 101)
                        .addComponent(jLabel32)
                        .addGap(18, 18, 18)
                        .addComponent(jdcFechaVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 885, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnModificar4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminar4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregar4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnLimpiar4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel31)
                        .addComponent(txtCodigoProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel32))
                    .addComponent(jLabel33)
                    .addComponent(jdcFechaVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel38)
                                .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel35)
                        .addComponent(jLabel37))
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(btnAgregar4)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar4)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar4)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpiar4)
                        .addGap(164, 164, 164))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))))
        );

        jTabbedPane1.addTab("Productos", jPanel4);

        jPanel5.setBackground(new java.awt.Color(245, 246, 250));

        jLabel40.setText("ID Venta");

        jLabel41.setText("COD Cliente");

        jLabel42.setText("Total Venta ");

        btnBuscarCliente.setText("Buscar");
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        jLabel43.setText("COD Producto");

        jLabel44.setText("Precio");

        btnBuscarProducto.setText("Buscar");
        btnBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductoActionPerformed(evt);
            }
        });

        jLabel45.setText("Cantidad");

        jLabel46.setText("Cliente");

        jLabel47.setText("Producto");

        jLabel48.setText("Stock");

        btnAgregar5.setText("Agregar");
        btnAgregar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar5ActionPerformed(evt);
            }
        });

        tblDetalleVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nro", "Codigo", "Nombre", "Producto", "Cantidad", "Precio", "SubTotal"
            }
        ));
        jScrollPane5.setViewportView(tblDetalleVenta);

        btnGenerarVenta.setText("Generar Venta");
        btnGenerarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarVentaActionPerformed(evt);
            }
        });

        btnCancelar2.setText("Cancelar");
        btnCancelar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar2ActionPerformed(evt);
            }
        });

        jLabel49.setText("Metodo de pago");

        cbxMetodoPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "METODO DE PAGO", "EFECTIVO", "TARJETA", "YAPE" }));

        btnGenerarBoleta.setText("Boleta");
        btnGenerarBoleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarBoletaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel41)
                            .addComponent(jLabel40)
                            .addComponent(jLabel43)
                            .addComponent(jLabel44)
                            .addComponent(jLabel45))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtIdVenta)
                            .addComponent(txtCodCliente)
                            .addComponent(txtCodProducto)
                            .addComponent(spinnerCantidadVenta)
                            .addComponent(txtPrecio2, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscarCliente)
                            .addComponent(btnBuscarProducto)
                            .addComponent(btnAgregar5))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel47)
                                    .addComponent(jLabel48))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtStock3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel46)
                                .addGap(18, 18, 18)
                                .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)
                                .addComponent(jLabel49)
                                .addGap(44, 44, 44)
                                .addComponent(cbxMetodoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 190, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane5)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txtTotalVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel42)
                        .addGap(40, 40, 40))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGenerarBoleta)
                .addGap(78, 78, 78)
                .addComponent(btnGenerarVenta)
                .addGap(55, 55, 55)
                .addComponent(btnCancelar2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(316, 316, 316))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(txtIdVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(txtCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarCliente)
                    .addComponent(jLabel46)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxMetodoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(txtCodProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarProducto)
                    .addComponent(jLabel47)
                    .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(jLabel48)
                    .addComponent(txtStock3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecio2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar5))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(spinnerCantidadVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancelar2)
                            .addComponent(btnGenerarVenta)
                            .addComponent(btnGenerarBoleta))
                        .addContainerGap(24, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabel42)
                        .addGap(18, 18, 18)
                        .addComponent(txtTotalVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Ventas", jPanel5);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1236, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 625, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("DetalleVenta", jPanel6);

        jPanel7.setBackground(new java.awt.Color(245, 246, 250));

        lblFecha.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(102, 102, 255));
        lblFecha.setText(".");

        lblHora.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblHora.setForeground(new java.awt.Color(102, 102, 255));
        lblHora.setText(".");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHora, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblFecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(lblFecha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblHora)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btnSalir)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEmpleado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDetalleVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(441, 441, 441)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDetalleVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95)
                        .addComponent(btnSalir))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        Cliente cliente = new Cliente();
        cliente.setNombre(txtNombreCliente.getText());
        cliente.setEmail(txtEmailCliente.getText());
        cliente.setTelefono(txtTelefonoCliente.getText());
        cliente.setDireccion_mz(txtMzCliente.getText());
        cliente.setDireccion_calle(txtCalleCliente.getText());
        cliente.setDireccion_av(txtAvCliente.getText());
        cliente.setCiudad(txtCiudadCliente.getText());

        ClienteDAO dao = new ClienteDAO();
        if (dao.agregar(cliente)) {
            JOptionPane.showMessageDialog(this, "Cliente agregado correctamente.");
            listarClientes();
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(this, "Error al agregar cliente.");
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        int fila = tblClientes.getSelectedRow(); // tablaClientes 

        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona una fila para modificar.");
            return;
        }

        try {
            int id = Integer.parseInt(txtIdCliente.getText());
            String nombre = txtNombreCliente.getText();
            String telefono = txtTelefonoCliente.getText();
            String email = txtEmailCliente.getText();
            String calle = txtCalleCliente.getText();
            String av = txtAvCliente.getText();
            String mz = txtMzCliente.getText();
            String ciudad = txtCiudadCliente.getText();

            Cliente c = new Cliente();
            c.setId_cliente(id);
            c.setNombre(nombre);
            c.setTelefono(telefono);
            c.setEmail(email);
            c.setDireccion_calle(calle);
            c.setDireccion_av(av);
            c.setDireccion_mz(mz);
            c.setCiudad(ciudad);

            ClienteDAO dao = new ClienteDAO();
            boolean exito = dao.actualizar(c);

            if (exito) {
                JOptionPane.showMessageDialog(this, "Cliente actualizado correctamente.");
                limpiarCampos();
                listarClientes();
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar el cliente.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = tblClientes.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona un cliente para eliminar.");
            return;
        }

        int id = Integer.parseInt(txtIdCliente.getText());

        ClienteDAO dao = new ClienteDAO();
        if (dao.eliminar(id)) {
            JOptionPane.showMessageDialog(this, "Cliente eliminado.");
            listarClientes();
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(this, "Error al eliminar cliente.");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesMouseClicked
        int fila = tblClientes.getSelectedRow();
        if (fila != -1) {
            txtIdCliente.setText(tblClientes.getValueAt(fila, 0).toString());
            txtNombreCliente.setText(tblClientes.getValueAt(fila, 1).toString());
            txtTelefonoCliente.setText(tblClientes.getValueAt(fila, 2).toString());
            txtEmailCliente.setText(tblClientes.getValueAt(fila, 3).toString());
            txtCalleCliente.setText(tblClientes.getValueAt(fila, 4).toString());
            txtAvCliente.setText(tblClientes.getValueAt(fila, 5).toString());
            txtMzCliente.setText(tblClientes.getValueAt(fila, 6).toString());
            txtCiudadCliente.setText(tblClientes.getValueAt(fila, 7).toString());
    }//GEN-LAST:event_tblClientesMouseClicked
}

//metodo limpiar
    private void limpiarCampos() {
        txtIdCliente.setText("");
        txtNombreCliente.setText("");
        txtEmailCliente.setText("");
        txtTelefonoCliente.setText("");
        txtMzCliente.setText("");
        txtCalleCliente.setText("");
        txtAvCliente.setText("");
        txtCiudadCliente.setText("");
        tblClientes.clearSelection();
    }

    private void listarClientes() {
        ClienteDAO dao = new ClienteDAO();
        List<Cliente> lista = dao.listar();

        DefaultTableModel modelo = (DefaultTableModel) tblClientes.getModel();
        modelo.setRowCount(0); // Limpiar

        for (Cliente c : lista) {
            modelo.addRow(new Object[]{
                c.getId_cliente(),
                c.getNombre(),
                c.getEmail(),
                c.getTelefono(),
                c.getDireccion_mz(),
                c.getDireccion_calle(),
                c.getDireccion_av(),
                c.getCiudad()
            });
        }
    }

//CODIGO PARA PROVEEDOR TODO A PARTIR DE ACA ES PARA PROVEEDOR
    public void listarProveedores() {
        modelo = (DefaultTableModel) tablaProveedor.getModel();
        modelo.setRowCount(0); // Limpiar tabla

        List<Proveedor> lista = proveedorDAO.listar();
        for (Proveedor p : lista) {
            modelo.addRow(new Object[]{
                p.getId_proveedor(),
                p.getNombre(),
                p.getTelefono(),
                p.getDireccion_calle(),
                p.getDireccion_av(),
                p.getDireccion_mz(),
                p.getRUC(),
                p.getEmail(),
                p.getFechaRegistro()
            });
        }
    }

    private void btnAgregar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar2ActionPerformed
        Proveedor p = new Proveedor();
        p.setNombre(txtNombre.getText());
        p.setTelefono(txtTelefono.getText());
        p.setDireccion_calle(txtCalle.getText());
        p.setDireccion_av(txtAv.getText());
        p.setDireccion_mz(txtMz.getText());
        p.setRUC(txtRUC.getText());
        p.setEmail(txtEmail.getText());

        java.util.Date fechaUtil = jdcFechaRegistro.getDate();
        java.sql.Date fechaSql = new java.sql.Date(fechaUtil.getTime());
        p.setFechaRegistro(fechaSql);

        if (proveedorDAO.agregar(p)) {
            JOptionPane.showMessageDialog(null, "Proveedor agregado correctamente");
            listarProveedores();
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(null, "Error al agregar proveedor");
        }

    }//GEN-LAST:event_btnAgregar2ActionPerformed

    private void btnModificar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar2ActionPerformed
        if (filaSeleccionada != -1) {
            int id = Integer.parseInt(txtId.getText());
            Proveedor p = new Proveedor();
            p.setId_proveedor(id);
            p.setNombre(txtNombre.getText());
            p.setTelefono(txtTelefono.getText());
            p.setDireccion_calle(txtCalle.getText());
            p.setDireccion_av(txtAv.getText());
            p.setDireccion_mz(txtMz.getText());
            p.setRUC(txtRUC.getText());
            p.setEmail(txtEmail.getText());

            java.util.Date fechaUtil = jdcFechaRegistro.getDate();
            java.sql.Date fechaSql = new java.sql.Date(fechaUtil.getTime());
            p.setFechaRegistro(fechaSql);

            if (proveedorDAO.actualizar(p)) {
                JOptionPane.showMessageDialog(null, "Proveedor actualizado");
                listarProveedores();
                limpiarCampos();
                filaSeleccionada = -1;
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar proveedor");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona una fila para modificar");
        }
    }//GEN-LAST:event_btnModificar2ActionPerformed

    private void btnEliminar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar2ActionPerformed
        if (filaSeleccionada != -1) {
            int id = Integer.parseInt(txtId.getText());
            int confirm = JOptionPane.showConfirmDialog(null, "¿Deseas eliminar este proveedor?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                if (proveedorDAO.eliminar(id)) {
                    JOptionPane.showMessageDialog(null, "Proveedor eliminado");
                    listarProveedores();
                    limpiarCampos();
                    filaSeleccionada = -1;
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar proveedor");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona una fila para eliminar");
        }

    }//GEN-LAST:event_btnEliminar2ActionPerformed

    private void tablaProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProveedorMouseClicked
        filaSeleccionada = tablaProveedor.getSelectedRow();

        if (filaSeleccionada != -1) {
            txtId.setText(tablaProveedor.getValueAt(filaSeleccionada, 0).toString());
            txtNombre.setText(tablaProveedor.getValueAt(filaSeleccionada, 1).toString());
            txtTelefono.setText(tablaProveedor.getValueAt(filaSeleccionada, 2).toString());
            txtCalle.setText(tablaProveedor.getValueAt(filaSeleccionada, 3).toString());
            txtAv.setText(tablaProveedor.getValueAt(filaSeleccionada, 4).toString());
            txtMz.setText(tablaProveedor.getValueAt(filaSeleccionada, 5).toString());
            txtRUC.setText(tablaProveedor.getValueAt(filaSeleccionada, 6).toString());
            txtEmail.setText(tablaProveedor.getValueAt(filaSeleccionada, 7).toString());

            // Para el JDateChooser (fechaRegistro), conviertes String a Date:
            try {
                java.util.Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(tablaProveedor.getValueAt(filaSeleccionada, 8).toString());
                jdcFechaRegistro.setDate(fecha);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void limpiarCampos2() {
        txtId.setText("");
        txtNombre.setText("");
        txtTelefono.setText("");
        txtCalle.setText("");
        txtAv.setText("");
        txtMz.setText("");
        txtRUC.setText("");
        txtEmail.setText("");
        jdcFechaRegistro.setDate(null);
    }//GEN-LAST:event_tablaProveedorMouseClicked

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnLimpiar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar2ActionPerformed
        limpiarCampos2();

    }//GEN-LAST:event_btnLimpiar2ActionPerformed
//PESTAÑA EMPLEADO, TODO A PARTIR DE ACA ES PARA EMPLEADO
    private void btnAgregar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar3ActionPerformed
        Empleado emp = new Empleado();
    emp.setNombre(txtNombreEmp.getText());
    emp.setTelefono(txtTelefonoEmp.getText());
    emp.setDni(txtDniEmp.getText());
    emp.setEmail(txtEmailEmp.getText());
    emp.setDireccion_calle(txtCalleEmp.getText());
    emp.setDireccion_av(txtAvEmp.getText());
    emp.setDireccion_mz(txtMzEmp.getText());
    emp.setCiudad(txtCiudadEmp.getText());

    EmpleadoDAO dao = new EmpleadoDAO();
    if (dao.agregar(emp)) {
        JOptionPane.showMessageDialog(this, "Empleado agregado correctamente.");
        listarEmpleados();
        limpiarCamposEmpleado();
    } else {
        JOptionPane.showMessageDialog(this, "Error al agregar empleado.");
    }
    
    }//GEN-LAST:event_btnAgregar3ActionPerformed

    private void btnModificar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar3ActionPerformed
        int fila = tablaEmpleado.getSelectedRow();
    if (fila == -1) {
        JOptionPane.showMessageDialog(this, "Selecciona un empleado para modificar.");
        return;
    }

    try {
        int id = Integer.parseInt(txtIdEmp.getText());
        Empleado emp = new Empleado();
        emp.setId_empleado(id);
        emp.setNombre(txtNombreEmp.getText());
        emp.setTelefono(txtTelefonoEmp.getText());
        emp.setDni(txtDniEmp.getText());
        emp.setEmail(txtEmailEmp.getText());
        emp.setDireccion_calle(txtCalleEmp.getText());
        emp.setDireccion_av(txtAvEmp.getText());
        emp.setDireccion_mz(txtMzEmp.getText());
        emp.setCiudad(txtCiudadEmp.getText());

        EmpleadoDAO dao = new EmpleadoDAO();
        if (dao.actualizar(emp)) {
            JOptionPane.showMessageDialog(this, "Empleado actualizado correctamente.");
            listarEmpleados();
            limpiarCamposEmpleado();
        } else {
            JOptionPane.showMessageDialog(this, "Error al actualizar empleado.");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
    }
    }//GEN-LAST:event_btnModificar3ActionPerformed

    private void btnEliminar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar3ActionPerformed
        int fila = tablaEmpleado.getSelectedRow();
    if (fila == -1) {
        JOptionPane.showMessageDialog(this, "Selecciona un empleado para eliminar.");
        return;
    }

    int id = Integer.parseInt(txtIdEmp.getText());

    EmpleadoDAO dao = new EmpleadoDAO();
    if (dao.eliminar(id)) {
        JOptionPane.showMessageDialog(this, "Empleado eliminado.");
        listarEmpleados();
        limpiarCamposEmpleado();
    } else {
        JOptionPane.showMessageDialog(this, "Error al eliminar empleado.");
    }
    }//GEN-LAST:event_btnEliminar3ActionPerformed

    private void tablaEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEmpleadoMouseClicked
        int fila = tablaEmpleado.getSelectedRow();
    if (fila != -1) {
        txtIdEmp.setText(tablaEmpleado.getValueAt(fila, 0).toString());
        txtNombreEmp.setText(tablaEmpleado.getValueAt(fila, 1).toString());
        txtTelefonoEmp.setText(tablaEmpleado.getValueAt(fila, 2).toString());
        txtDniEmp.setText(tablaEmpleado.getValueAt(fila, 3).toString());
        txtEmailEmp.setText(tablaEmpleado.getValueAt(fila, 4).toString());
        txtCalleEmp.setText(tablaEmpleado.getValueAt(fila, 5).toString());
        txtAvEmp.setText(tablaEmpleado.getValueAt(fila, 6).toString());
        txtMzEmp.setText(tablaEmpleado.getValueAt(fila, 7).toString());
        txtCiudadEmp.setText(tablaEmpleado.getValueAt(fila, 8).toString());
    }
    }//GEN-LAST:event_tablaEmpleadoMouseClicked

    private void btnAgregar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar4ActionPerformed
    ProductoDAO dao = new ProductoDAO();
    Producto p = new Producto();

    // 1. Generar código automáticamente
    String nuevoCodigo = dao.generarCodigoProducto();
    txtCodigoProd.setText(nuevoCodigo); // Mostrar en el campo
    txtCodigoProd.setEditable(false);   // Evitar edición manual (opcional)
    p.setCodigo(nuevoCodigo);

    // 2. Asignar datos desde el formulario
    p.setDescripcion(txtDescripcion.getText());
    p.setPrecio(Double.parseDouble(txtPrecio.getText()));
    p.setCategoria((String) cboCategoria.getSelectedItem());
    p.setStock(Integer.parseInt(txtStock.getText()));

    // Validar y asignar la fecha
    if (jdcFechaVencimiento.getDate() != null) {
        java.sql.Date fecha = new java.sql.Date(jdcFechaVencimiento.getDate().getTime());
        p.setFechaVencimiento(fecha);
    } else {
        JOptionPane.showMessageDialog(this, "Por favor, selecciona una fecha de vencimiento.");
        return;
    }

    // 3. Guardar producto
    if (dao.agregar(p)) {
        JOptionPane.showMessageDialog(this, "Producto agregado correctamente.");
        listarProductos();
        limpiarCamposProducto(); // Si aquí borras el código, se volverá a generar en el siguiente "Agregar"
    } else {
        JOptionPane.showMessageDialog(this, "Error al agregar producto.");
    }
    }//GEN-LAST:event_btnAgregar4ActionPerformed

    private void btnModificar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar4ActionPerformed
        if (filaSeleccionadaProducto != -1) {
        Producto p = new Producto();
        p.setId_producto(Integer.parseInt(txtIdProducto.getText()));
        p.setCodigo(txtCodigoProd.getText());
        p.setDescripcion(txtDescripcion.getText());
        p.setPrecio(Double.parseDouble(txtPrecio.getText()));
        p.setCategoria((String) cboCategoria.getSelectedItem());
        p.setStock(Integer.parseInt(txtStock.getText()));
        java.sql.Date fecha = new java.sql.Date(jdcFechaVencimiento.getDate().getTime());
        p.setFechaVencimiento(fecha);
        
ProductoDAO dao = new ProductoDAO();
Producto actual = dao.buscarPorId(Integer.parseInt(txtIdProducto.getText()));
p.setId_proveedor(actual.getId_proveedor());  // ⬅️ usamos el proveedor existente

        
        if (dao.actualizar(p)) {
            JOptionPane.showMessageDialog(this, "Producto modificado correctamente.");
            listarProductos();
            limpiarCamposProducto();
        } else {
            JOptionPane.showMessageDialog(this, "Error al modificar producto.");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Selecciona una fila para modificar.");
    }
    }//GEN-LAST:event_btnModificar4ActionPerformed

    private void btnEliminar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar4ActionPerformed
        if (filaSeleccionadaProducto != -1) {
        int id = Integer.parseInt(txtIdProducto.getText());
        int confirm = JOptionPane.showConfirmDialog(this, "¿Deseas eliminar este producto?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            ProductoDAO dao = new ProductoDAO();
            if (dao.eliminar(id)) {
                JOptionPane.showMessageDialog(this, "Producto eliminado.");
                listarProductos();
                limpiarCamposProducto();
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar producto.");
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Selecciona una fila para eliminar.");
    }
    }//GEN-LAST:event_btnEliminar4ActionPerformed

    private void btnLimpiar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar4ActionPerformed
         limpiarCamposProducto();
    }//GEN-LAST:event_btnLimpiar4ActionPerformed

    private void tblProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosMouseClicked
         filaSeleccionadaProducto = tblProductos.getSelectedRow();
if (filaSeleccionadaProducto != -1) {
    txtCodigoProd.setText(tblProductos.getValueAt(filaSeleccionadaProducto, 0).toString());
    txtDescripcion.setText(tblProductos.getValueAt(filaSeleccionadaProducto, 1).toString());
    txtPrecio.setText(tblProductos.getValueAt(filaSeleccionadaProducto, 2).toString());
    cboCategoria.setSelectedItem(tblProductos.getValueAt(filaSeleccionadaProducto, 3).toString());
    txtStock.setText(tblProductos.getValueAt(filaSeleccionadaProducto, 4).toString());

    // ✅ Establecer fecha en el jdcFechaVencimiento
    try {
        String fechaStr = tblProductos.getValueAt(filaSeleccionadaProducto, 5).toString();
        java.util.Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(fechaStr);
        jdcFechaVencimiento.setDate(fecha);
    } catch (Exception e) {
        e.printStackTrace();
    }

    // ✅ Obtener id_producto desde la columna oculta
    txtIdProducto.setText(tblProductos.getValueAt(filaSeleccionadaProducto, 6).toString());
}

    }//GEN-LAST:event_tblProductosMouseClicked

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
         int confirm = JOptionPane.showConfirmDialog(this, "¿Deseas salir del sistema?", "Confirmar salida", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        System.exit(0); // Cierra todo el programa
    }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        String cod = txtCodCliente.getText();
        ClienteDAO dao = new ClienteDAO();
        Cliente c = dao.buscarPorCodigo(cod);
        if (c != null) {
            txtCliente.setText(c.getNombre());
        } else {
            JOptionPane.showMessageDialog(null, "Cliente no encontrado");
        }
    
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void btnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoActionPerformed
        String cod = txtCodProducto.getText();
        ProductoDAO dao = new ProductoDAO();
        Producto p = dao.buscarPorCodigo(cod);
        if (p != null) {
            txtProducto.setText(p.getDescripcion());
            txtPrecio2.setText(String.valueOf(p.getPrecio()));
            txtStock3.setText(String.valueOf(p.getStock()));
        } else {
            JOptionPane.showMessageDialog(null, "Producto no encontrado");
        }
    
    }//GEN-LAST:event_btnBuscarProductoActionPerformed

    private void btnAgregar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar5ActionPerformed
        //@Override
        String codigo = txtCodProducto.getText();
        String nombre = txtProducto.getText();
        String producto = txtProducto.getText(); // puedes cambiar si tienes otro campo específico
        int cantidad = (int) spinnerCantidadVenta.getValue();
        double precio = Double.parseDouble(txtPrecio2.getText());
        int stock = Integer.parseInt(txtStock3.getText());

        // Validar stock disponible
        if (cantidad > stock) {
            JOptionPane.showMessageDialog(null, "Stock insuficiente.");
            return;
        }

        double subtotal = cantidad * precio;

        // Número correlativo de fila (Nro)
        int fila = tblDetalleVenta.getRowCount() + 1;

        DefaultTableModel modelo = (DefaultTableModel) tblDetalleVenta.getModel();
        modelo.addRow(new Object[]{
            fila,          // Nro
            codigo,        // Código
            nombre,        // Nombre
            producto,      // Producto
            cantidad,      // Cantidad
            precio,        // Precio
            subtotal       // SubTotal
        });

        calcularTotalVenta(); // Llamada al método para recalcular el total
    }//GEN-LAST:event_btnAgregar5ActionPerformed
//------------GENERA LA VENTA-----------
    private void btnGenerarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarVentaActionPerformed
            Venta v = new Venta();
    VentaDAO vdao = new VentaDAO();

    v.setId_cliente(Integer.parseInt(txtCodCliente.getText()));
    v.setMetodoPago(cbxMetodoPago.getSelectedItem().toString());
    v.setFechaVenta(new java.sql.Date(System.currentTimeMillis()));
    v.setId_empleado(1); // Puedes cambiarlo por el empleado actual si lo manejas

    int idVenta = vdao.registrarVenta(v);

    if (idVenta != -1) {
        txtIdVenta.setText(String.valueOf(idVenta)); // Mostrar el ID generado

        for (int i = 0; i < tblDetalleVenta.getRowCount(); i++) {
            DetalleVenta d = new DetalleVenta();
            d.setId_venta(idVenta);

            String codigo = tblDetalleVenta.getValueAt(i, 1).toString();
            int idProd = vdao.buscarIdProductoPorCodigo(codigo);
            d.setId_producto(idProd);
            d.setCantidad(Integer.parseInt(tblDetalleVenta.getValueAt(i, 4).toString()));
            d.setPrecioUnitario(Double.parseDouble(tblDetalleVenta.getValueAt(i, 5).toString()));
            d.setImporte(Double.parseDouble(tblDetalleVenta.getValueAt(i, 6).toString()));

            vdao.registrarDetalleVenta(d);
        }

        JOptionPane.showMessageDialog(null, "Venta registrada con éxito");
        limpiarFormularioVenta(); // Este método debe dejar txtIdVenta intacto si quieres que se mantenga visible
    } else {
        JOptionPane.showMessageDialog(null, "Error al registrar venta");
    }
    
    }//GEN-LAST:event_btnGenerarVentaActionPerformed
//
    private void btnCancelar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar2ActionPerformed
        
        limpiarFormularioVenta();
    
    }//GEN-LAST:event_btnCancelar2ActionPerformed
//---------GENERA LA BOLETAA------------
    private void btnGenerarBoletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarBoletaActionPerformed
         try {
        int idVenta = Integer.parseInt(txtIdVenta.getText());

        VentaDAO vdao = new VentaDAO();
        ProductoDAO pdao = new ProductoDAO();

        Venta v = vdao.buscarPorId(idVenta);
        List<DetalleVenta> detalles = vdao.obtenerDetallesVenta(idVenta);

        // 🔁 Asignar el producto completo con descripción a cada detalle
        for (DetalleVenta d : detalles) {
            Producto producto = pdao.buscarPorId(d.getId_producto());
            d.setProducto(producto);
        }

        if (v != null && detalles != null && !detalles.isEmpty()) {
            String ruta = "C:/Users/PC/Documents/NetBeansProjects/SSistemaVentas/Boletas/Boleta_" + idVenta + ".pdf";
            new File("C:/Users/PC/Documents/NetBeansProjects/SSistemaVentas/Boletas").mkdirs();

            GenerarBoletaPDF.generarBoleta(v, detalles, ruta);

            JOptionPane.showMessageDialog(null, "Boleta generada exitosamente:\n" + ruta);
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró información para generar la boleta.");
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "ID de venta inválido.");
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Error al generar la boleta: " + ex.getMessage());
    }
         
    }//GEN-LAST:event_btnGenerarBoletaActionPerformed

    private void btnClientesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClientesMouseEntered
      
    }//GEN-LAST:event_btnClientesMouseEntered

    private void btnClientesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClientesMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnClientesMouseExited

    private void txtCalleClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCalleClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCalleClienteActionPerformed

    
    public void calcularTotal() {
    double total = 0;
    for (int i = 0; i < tblDetalleVenta.getRowCount(); i++) {
        total += Double.parseDouble(tblDetalleVenta.getValueAt(i, 6).toString());
    }
    txtTotalVenta.setText(String.valueOf(total));
}
    public void calcularTotalVenta() {
    double total = 0;
    DefaultTableModel modelo = (DefaultTableModel) tblDetalleVenta.getModel();
    for (int i = 0; i < modelo.getRowCount(); i++) {
        total += Double.parseDouble(modelo.getValueAt(i, 6).toString()); // Columna 6: SubTotal
    }
    txtTotalVenta.setText(String.valueOf(total));
}


    
    private void limpiarCamposProducto() {
    txtIdProducto.setText("");
    txtCodigoProd.setText("");
    txtDescripcion.setText("");
    txtPrecio.setText("");
    cboCategoria.setSelectedIndex(0);
    txtStock.setText("");
    jdcFechaVencimiento.setDate(null);
    filaSeleccionadaProducto = -1;
    tblProductos.clearSelection();
}
    //--FECHAAAAAAAAAA
    private void mostrarFechaYHoraSeparadas() {
    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Date ahora = new Date();

            // Formatos separados
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");

            lblFecha.setText("Fecha: " + formatoFecha.format(ahora));
            lblHora.setText("Hora: " + formatoHora.format(ahora));
        }
    });
    timer.start();
}




    public void limpiarFormularioVenta() {
    //txtIdVenta.setText("");
    txtCodCliente.setText("");
    txtCliente.setText("");
    txtCodProducto.setText("");
    txtProducto.setText("");
    txtPrecio2.setText("");
    txtStock3.setText("");
    spinnerCantidadVenta.setValue(0);
    txtTotalVenta.setText("");
    cbxMetodoPago.setSelectedIndex(0);

    DefaultTableModel modelo = (DefaultTableModel) tblDetalleVenta.getModel();
    modelo.setRowCount(0);
}

    
    public void listarProductos() {
    DefaultTableModel modelo = (DefaultTableModel) tblProductos.getModel();
    modelo.setRowCount(0); // Limpia la tabla

    ProductoDAO dao = new ProductoDAO();
    List<Producto> lista = dao.listar();

    for (Producto p : lista) {
        Object[] fila = new Object[7];
        fila[0] = p.getCodigo(); // Mostrar el código como identificador visible
        fila[1] = p.getDescripcion();
        fila[2] = p.getPrecio();
        fila[3] = p.getCategoria();
        fila[4] = p.getStock();
        fila[5] = p.getFechaVencimiento(); // Aquí se incluye la fecha
        fila[6] = p.getId_producto(); // Internamente, no visible si no lo deseas mostrar
        modelo.addRow(fila);
    }

    // Ocultar la columna 0 (id_producto)
    tblProductos.getColumnModel().getColumn(6).setMinWidth(0);
    tblProductos.getColumnModel().getColumn(6).setMaxWidth(0);
    tblProductos.getColumnModel().getColumn(6).setPreferredWidth(0);
}



    
    private void limpiarCamposEmpleado() {
    txtIdEmp.setText("");
    txtNombreEmp.setText("");
    txtTelefonoEmp.setText("");
    txtDniEmp.setText("");
    txtEmailEmp.setText("");
    txtCalleEmp.setText("");
    txtAvEmp.setText("");
    txtMzEmp.setText("");
    txtCiudadEmp.setText("");
    tablaEmpleado.clearSelection();
}
    public void listarEmpleados() {
    EmpleadoDAO dao = new EmpleadoDAO();
    List<Empleado> lista = dao.listar();

    DefaultTableModel modelo = (DefaultTableModel) tablaEmpleado.getModel();
    modelo.setRowCount(0); // Limpia tabla

    for (Empleado emp : lista) {
        modelo.addRow(new Object[]{
            emp.getId_empleado(),
            emp.getNombre(),
            emp.getTelefono(),
            emp.getDni(),
            emp.getEmail(),
            emp.getDireccion_calle(),
            emp.getDireccion_av(),
            emp.getDireccion_mz(),
            emp.getCiudad()
        });
    }
}
  
     
    
   //COLOR btn
    

   

    
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (ClassNotFoundException ex) {
        java.util.logging.Logger.getLogger(FrmSistemaVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        java.util.logging.Logger.getLogger(FrmSistemaVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        java.util.logging.Logger.getLogger(FrmSistemaVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(FrmSistemaVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new FrmSistemaVentas().setVisible(true);
        }
    });

}

 


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAgregar2;
    private javax.swing.JButton btnAgregar3;
    private javax.swing.JButton btnAgregar4;
    private javax.swing.JButton btnAgregar5;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnBuscarProducto;
    private javax.swing.JButton btnCancelar2;
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnDetalleVenta;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminar2;
    private javax.swing.JButton btnEliminar3;
    private javax.swing.JButton btnEliminar4;
    private javax.swing.JButton btnEmpleado;
    private javax.swing.JButton btnGenerarBoleta;
    private javax.swing.JButton btnGenerarVenta;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnLimpiar2;
    private javax.swing.JButton btnLimpiar3;
    private javax.swing.JButton btnLimpiar4;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnModificar2;
    private javax.swing.JButton btnModificar3;
    private javax.swing.JButton btnModificar4;
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton btnProveedor;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnVentas;
    private javax.swing.JComboBox<String> cboCategoria;
    private javax.swing.JComboBox<String> cbxMetodoPago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.toedter.calendar.JDateChooser jdcFechaRegistro;
    private com.toedter.calendar.JDateChooser jdcFechaVencimiento;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblHora;
    private javax.swing.JSpinner spinnerCantidadVenta;
    private javax.swing.JTable tablaEmpleado;
    private javax.swing.JTable tablaProveedor;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTable tblDetalleVenta;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtAv;
    private javax.swing.JTextField txtAvCliente;
    private javax.swing.JTextField txtAvEmp;
    private javax.swing.JTextField txtCalle;
    private javax.swing.JTextField txtCalleCliente;
    private javax.swing.JTextField txtCalleEmp;
    private javax.swing.JTextField txtCiudadCliente;
    private javax.swing.JTextField txtCiudadEmp;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtCodCliente;
    private javax.swing.JTextField txtCodProducto;
    private javax.swing.JTextField txtCodigoProd;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtDniEmp;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmailCliente;
    private javax.swing.JTextField txtEmailEmp;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtIdEmp;
    private javax.swing.JTextField txtIdProducto;
    private javax.swing.JTextField txtIdVenta;
    private javax.swing.JTextField txtMz;
    private javax.swing.JTextField txtMzCliente;
    private javax.swing.JTextField txtMzEmp;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtNombreEmp;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtPrecio2;
    private javax.swing.JTextField txtProducto;
    private javax.swing.JTextField txtRUC;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtStock3;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTelefonoCliente;
    private javax.swing.JTextField txtTelefonoEmp;
    private javax.swing.JTextField txtTotalVenta;
    // End of variables declaration//GEN-END:variables
}
