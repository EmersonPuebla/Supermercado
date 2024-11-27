/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ProductoDAO;
import controller.VentaDAO;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Boleta;
import model.LoginSystem;
import model.Validador;
import model.SoundManager;

public class Caja extends javax.swing.JFrame {

    /**
     * Creates new form Caja
     */
    Date now = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    String formattedDate = sdf.format(now);

    public void switchActivarBotonCobrar(DefaultTableModel modelo) {
        if (modelo.getRowCount() > 0) {
            jButtonCobrar.setEnabled(true);
        } else {
            jButtonCobrar.setEnabled(false);
        }
    }

    public void imprimirDatosTabla(DefaultTableModel modelo) {
        // Obtener los datos de la tabla en un arreglo bidimensional
        Object[][] datosTabla = obtenerDatosTabla(modelo);

        // Recorrer e imprimir los datos
        for (int i = 0; i < datosTabla.length; i++) {
            System.out.print("Fila " + (i + 1) + ": ");
            for (int j = 0; j < datosTabla[i].length; j++) {
                // Imprimir el valor de cada columna de la fila
                System.out.print(datosTabla[i][j] + " ");
            }
            System.out.println();  // Nueva línea al final de cada fila
        }
    }

    public Object[][] obtenerDatosTabla(DefaultTableModel modelo) {
        // Crear un arreglo bidimensional para almacenar los datos de las filas
        int numFilas = modelo.getRowCount();
        Object[][] datosTabla = new Object[numFilas][6];  // 6 columnas (Código, Descripción, Cantidad, Precio Unitario, Descuento, Precio Fila)

        // Recorrer las filas de la tabla
        for (int i = 0; i < numFilas; i++) {
            // Obtener los valores de cada columna en la fila actual
            datosTabla[i][0] = modelo.getValueAt(i, 0);  // Código
            datosTabla[i][1] = modelo.getValueAt(i, 1);  // Descripción
            datosTabla[i][2] = modelo.getValueAt(i, 2);  // Cantidad
            datosTabla[i][3] = modelo.getValueAt(i, 3);  // Precio Unitario
            datosTabla[i][4] = modelo.getValueAt(i, 4);  // Descuento
            datosTabla[i][5] = modelo.getValueAt(i, 5);  // Precio Fila
        }

        // Devolver el arreglo bidimensional con todos los datos
        return datosTabla;
    }

    public Object[] getDetalleCompra(DefaultTableModel modelo) {
        // Inicializar las variables
        int descuento_total = 0;
        int neto = 0;
        int cantidad_x = 0;
        int descuento = 0;
        int total_fila = 0;

        // Recorrer las filas y sumar los valores de "Precio fila"
        for (int i = 0; i < modelo.getRowCount(); i++) {
            cantidad_x = (int) modelo.getValueAt(i, 2);  // Cantidad
            descuento = (int) modelo.getValueAt(i, 4);   // Descuento
            total_fila = (int) modelo.getValueAt(i, 5);  // Total por fila

            descuento_total += descuento * cantidad_x;   // Sumar el descuento total
            neto += total_fila;                          // Sumar el total neto
        }

        // Calcular IVA, Total y Puntos
        int iva = Boleta.calcularIVA(neto);
        int total = neto + iva;
        int puntos = Boleta.calcularPuntos(total);

        // Crear el detalle de la compra
        Object[] detalleCompra = new Object[]{
            descuento_total, // Descuento total
            neto, // Monto neto
            iva, // IVA
            total, // Total (neto + IVA)
            puntos // Puntos
        };

        return detalleCompra;
    }

    public void actualizarDetalleCompra(DefaultTableModel modelo) {
        // Llamar al método getDetalleCompra para obtener los detalles
        Object[] detalleCompra = getDetalleCompra(modelo);

        // Obtener los valores desde el arreglo detalleCompra
        int descuento_total = (int) detalleCompra[0];
        int neto = (int) detalleCompra[1];
        int iva = (int) detalleCompra[2];
        int total = (int) detalleCompra[3];
        int puntos = (int) detalleCompra[4];

        // Actualizar las etiquetas con los valores calculados
        jLabelPuntos.setText("Puntos: +" + puntos);
        jLabelDescuento.setText("Descuento: -$" + descuento_total);
        jLabelNeto.setText("Neto: $" + neto);
        jLabelIva.setText("IVA: $" + iva);
        jLabelTotal.setText("TOTAL: $" + total);
    }

    public void limpiarFieldCodigo() {
        jFormattedTextFieldCodigo.setText("");
    }

    public void reiniciarSpinnerCantidad() {
        jSpinnerCantidad.setValue(1);
    }

    public void focusFieldCodigo() {
        jFormattedTextFieldCodigo.requestFocus();
    }

    public Caja() {
        initComponents();
        setLocationRelativeTo(null);
        jLabelFecha.setText("Fecha: " + formattedDate);
        jLabelCajero.setText("Cajero: " + LoginSystem.getNombreEmpleado() + " " + LoginSystem.getApellidoEmpleado());
        jLabelFolio.setText("Folio: " + VentaDAO.obtenerFolio());
        jButtonCobrar.setEnabled(false);
        jFormattedTextFieldCodigo.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonVolver = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabelRut = new javax.swing.JLabel();
        jComboBoxMetodoPago = new javax.swing.JComboBox<>();
        jLabelMetodoDePago = new javax.swing.JLabel();
        jLabelRut1 = new javax.swing.JLabel();
        jLabelCantidad = new javax.swing.JLabel();
        jFormattedTextFieldCodigo = new javax.swing.JFormattedTextField();
        jSpinnerCantidad = new javax.swing.JSpinner();
        jFormattedTextFieldRut = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jButtonAgregar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabelFecha = new javax.swing.JLabel();
        jLabelFolio = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabelPuntos = new javax.swing.JLabel();
        jLabelNeto = new javax.swing.JLabel();
        jLabelIva = new javax.swing.JLabel();
        jLabelTotal = new javax.swing.JLabel();
        jButtonCobrar = new javax.swing.JButton();
        jLabelDescuento = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDetalle = new javax.swing.JTable();
        jLabelCajero = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Caja");

        jButtonVolver.setText("Volver");
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverActionPerformed(evt);
            }
        });

        jLabelRut.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabelRut.setText("RUT");

        jComboBoxMetodoPago.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jComboBoxMetodoPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Debito", "Credito", "Efectivo", "Edenred" }));

        jLabelMetodoDePago.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabelMetodoDePago.setText("Metodo de pago");

        jLabelRut1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabelRut1.setText("Codigo");

        jLabelCantidad.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabelCantidad.setText("Cantidad");

        jFormattedTextFieldCodigo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jFormattedTextFieldCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldCodigoActionPerformed(evt);
            }
        });
        jFormattedTextFieldCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jFormattedTextFieldCodigoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jFormattedTextFieldCodigoKeyTyped(evt);
            }
        });

        jSpinnerCantidad.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        jSpinnerCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jSpinnerCantidadKeyTyped(evt);
            }
        });

        try {
            jFormattedTextFieldRut.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxMetodoPago, javax.swing.GroupLayout.Alignment.TRAILING, 0, 316, Short.MAX_VALUE)
                    .addComponent(jFormattedTextFieldCodigo)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelRut)
                            .addComponent(jLabelMetodoDePago)
                            .addComponent(jLabelRut1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jFormattedTextFieldRut))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCantidad)
                    .addComponent(jSpinnerCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabelRut)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFormattedTextFieldRut, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabelMetodoDePago)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxMetodoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelRut1)
                    .addComponent(jLabelCantidad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSpinnerCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jFormattedTextFieldCodigo))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jButtonAgregar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButtonAgregar.setText("Agregar");
        jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarActionPerformed(evt);
            }
        });

        jButtonEliminar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(jButtonAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabelFecha.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabelFecha.setText("Fecha: ");

        jLabelFolio.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabelFolio.setText("N° Folio:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelFecha)
                    .addComponent(jLabelFolio))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelFecha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelFolio)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabelPuntos.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabelPuntos.setText("Puntos: ");

        jLabelNeto.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabelNeto.setText("Neto:");

        jLabelIva.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabelIva.setText("IVA: ");

        jLabelTotal.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabelTotal.setText("TOTAL: ");

        jButtonCobrar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButtonCobrar.setText("Cobrar");
        jButtonCobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCobrarActionPerformed(evt);
            }
        });

        jLabelDescuento.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabelDescuento.setText("Descuento:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelPuntos)
                            .addComponent(jLabelNeto)
                            .addComponent(jLabelIva)
                            .addComponent(jLabelTotal))
                        .addGap(69, 69, 69))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButtonCobrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabelDescuento)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabelPuntos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelDescuento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelNeto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelIva)
                .addGap(12, 12, 12)
                .addComponent(jLabelTotal)
                .addGap(12, 12, 12)
                .addComponent(jButtonCobrar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jTableDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descripcion", "Cantidad", "Precio unitario", "Descuento", "Precio fila"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableDetalle.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableDetalle);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabelCajero.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabelCajero.setText("Cajero:");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logo-mini.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelCajero)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelCajero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverActionPerformed
        SoundManager.reproducirSonido("question");
        int opcion = JOptionPane.showConfirmDialog(null,
                "¿Seguro que deseas terminar y cancelar la compra?\nsí confirmas la informacion de la compra en curso se perderá",
                "Confirmación",
                JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION) {
            System.out.println("Seleccionaste Aceptar");
            Hub hubWindow = new Hub();
            hubWindow.setVisible(true);
            this.dispose();

        } else if (opcion == JOptionPane.NO_OPTION) {
            System.out.println("Seleccionaste Cancelar");
        }
    }//GEN-LAST:event_jButtonVolverActionPerformed

    private void jButtonCobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCobrarActionPerformed
        int opcion = JOptionPane.showConfirmDialog(null,
                "¿Seguro que deseas terminar y cobrar la compra?",
                "Confirmación",
                JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION) {
            System.out.println("Seleccionaste Aceptar");
            SoundManager.reproducirSonido("cobrar");

            // RUT
            String rut = jFormattedTextFieldRut.getText();
            // METODO PAGO
            String metodoPago = jComboBoxMetodoPago.getSelectedItem().toString();

            // FECHA 
            Date now = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fecha = sdf.format(now);

            // FOLIO
            int folio = VentaDAO.obtenerFolio();

            DefaultTableModel modelo = (DefaultTableModel) jTableDetalle.getModel();
            Object[] detalleCompra = getDetalleCompra(modelo);

            // Obtener los valores desde el arreglo detalleCompra
            // DESCUENTO TOTAL
            int descuento_total = (int) detalleCompra[0];
            // NETO
            int neto = (int) detalleCompra[1];

            // IVA
            int iva = (int) detalleCompra[2];

            // TOTAL
            int total = (int) detalleCompra[3];
            // PUNTOS
            int puntos = (int) detalleCompra[4];

            // Obtener el username del empleado logueado
            String username = LoginSystem.getUsernameEmpleado(); // Método que devuelve el username del vendedor

            // Insertar la venta en la tabla venta
            boolean ventaInsertada = VentaDAO.insertarVenta(folio, rut, metodoPago, fecha, total, username);

            if (ventaInsertada) {
                // Insertar los productos de la venta en la tabla venta_producto
                for (int i = 0; i < modelo.getRowCount(); i++) {
                    String codigo = modelo.getValueAt(i, 0).toString();  // Obtener código
                    String descripcion = modelo.getValueAt(i, 1).toString(); // Descripción (si lo necesitas)
                    int cantidad = (int) modelo.getValueAt(i, 2);       // Cantidad
                    int precioUnitario = (int) modelo.getValueAt(i, 3); // Precio unitario
                    int descuento = (int) modelo.getValueAt(i, 4);      // Descuento

                    // Insertar cada producto de la venta en la tabla venta_producto
                    boolean productoInsertado = VentaDAO.insertarVentaProducto(folio, codigo, cantidad, precioUnitario, descuento);

                    if (!productoInsertado) {
                        System.out.println("Error al insertar producto: " + codigo);
                    }
                }
                jFormattedTextFieldRut.setText("");
                jComboBoxMetodoPago.setSelectedIndex(0);
                jFormattedTextFieldCodigo.setText("");
                jSpinnerCantidad.setValue(0);
                modelo.setRowCount(0);
                JOptionPane.showMessageDialog(null, "Venta realizada con éxito!");

            } else {
                JOptionPane.showMessageDialog(null, "Error al insertar la venta.");
            }

        } else if (opcion == JOptionPane.NO_OPTION) {
            System.out.println("Seleccionaste Cancelar");
        }

    }//GEN-LAST:event_jButtonCobrarActionPerformed

    private void jFormattedTextFieldCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldCodigoActionPerformed

    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        if (jFormattedTextFieldCodigo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Porfavor ingresa el codigo del producto",
                    "Error agregar producto", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int codigo = Integer.parseInt(jFormattedTextFieldCodigo.getText());

        if (ProductoDAO.getNombre(codigo) == null) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado el producto en la base de datos",
                    "Error agregar producto", JOptionPane.ERROR_MESSAGE);
        } else {

            String metodoDePago = (String) jComboBoxMetodoPago.getSelectedItem();
            int cantidad = (int) jSpinnerCantidad.getValue();
            String descripcion = ProductoDAO.getNombre(codigo) + " " + ProductoDAO.getMarca(codigo) + " " + ProductoDAO.getMedida(codigo) + ProductoDAO.getUnidadMedida(codigo);
            int precio_unitario = ProductoDAO.getPrecio(codigo);
            int porcentaje_descuento = ProductoDAO.getDescuento(codigo);
            int precio_con_descuento = Boleta.calcularPrecioDescuento(precio_unitario, porcentaje_descuento);
            int precio_a_descontar = precio_unitario - precio_con_descuento;
            int precio_fila = (precio_unitario - precio_a_descontar) * cantidad;

            // Obtener el modelo directamente del JTable
            DefaultTableModel modelo = (DefaultTableModel) jTableDetalle.getModel();

            boolean productoExistente = false;

            // Buscar si el producto ya está en la tabla
            for (int i = 0; i < modelo.getRowCount(); i++) {
                int codigoExistente = (int) modelo.getValueAt(i, 0); // Obtener el código del producto existente
                if (codigoExistente == codigo) {
                    // Si el producto ya existe, actualizar la cantidad y el precio de la fila
                    int cantidadExistente = (int) modelo.getValueAt(i, 2); // Obtener la cantidad actual
                    int nuevaCantidad = cantidadExistente + cantidad;
                    modelo.setValueAt(nuevaCantidad, i, 2); // Actualizar la cantidad
                    int nuevoPrecioFila = (precio_unitario - precio_a_descontar) * nuevaCantidad;
                    modelo.setValueAt(nuevoPrecioFila, i, 5); // Actualizar el precio fila
                    productoExistente = true;
                    break;
                }
            }

            // Si el producto no existe, agregarlo como nueva fila
            if (!productoExistente) {
                modelo.addRow(new Object[]{codigo, descripcion, cantidad, precio_unitario, precio_a_descontar, precio_fila});
            }

            if (codigo == 41 && ProductoDAO.getNombre(codigo).equals("Nacho Taco Chimichanga")) {
                SoundManager.reproducirSonido("orale");
            }

            SoundManager.reproducirSonido("addProducto");
            actualizarDetalleCompra(modelo);
            switchActivarBotonCobrar(modelo);
            limpiarFieldCodigo();
            reiniciarSpinnerCantidad();
            focusFieldCodigo();

        }
    }//GEN-LAST:event_jButtonAgregarActionPerformed

    private void jFormattedTextFieldCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFieldCodigoKeyTyped
        Validador.bloquearLetras(evt);
        Validador.bloquearSimbolos(evt);
    }//GEN-LAST:event_jFormattedTextFieldCodigoKeyTyped

    private void jSpinnerCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jSpinnerCantidadKeyTyped
        Validador.bloquearLetras(evt);
        Validador.bloquearSimbolos(evt);
    }//GEN-LAST:event_jSpinnerCantidadKeyTyped

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        // Obtener el modelo de la tabla
        DefaultTableModel modelo = (DefaultTableModel) jTableDetalle.getModel();
        int filaSeleccionada = jTableDetalle.getSelectedRow();

        // Verificar que hay una fila seleccionada
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "Por favor selecciona un producto de la tabla para eliminar.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Obtener el código del producto de la fila seleccionada
        int codigoProducto = (int) modelo.getValueAt(filaSeleccionada, 0);

        // Mostrar ventana emergente para eliminar completamente o modificar cantidad
        Object[] options = {"Eliminar producto", "Eliminar cantidad", "Cancelar"};
        int opcionSeleccionada = JOptionPane.showOptionDialog(
                null,
                "¿Qué acción deseas realizar?",
                "Eliminar producto o cantidad especifica",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[2] // Por defecto "Cancelar"
        );

        if (opcionSeleccionada == 0) {
            // Eliminar la fila completamente
            modelo.removeRow(filaSeleccionada);
            actualizarDetalleCompra(modelo);
            switchActivarBotonCobrar(modelo);
            limpiarFieldCodigo();
            reiniciarSpinnerCantidad();
            focusFieldCodigo();

        } else if (opcionSeleccionada == 1) {
            // Modificar la cantidad del producto
            String cantidadStr = JOptionPane.showInputDialog("Ingresa la cantidad a eliminar:");
            if (cantidadStr != null && !cantidadStr.isEmpty()) {
                try {
                    int cantidadEliminar = Integer.parseInt(cantidadStr);
                    int cantidadActual = (int) modelo.getValueAt(filaSeleccionada, 2);

                    if (cantidadEliminar < cantidadActual) {
                        // Reducir la cantidad de la fila
                        int nuevaCantidad = cantidadActual - cantidadEliminar;
                        modelo.setValueAt(nuevaCantidad, filaSeleccionada, 2);  // Actualizar la cantidad en la tabla

                        // Recalcular el precio fila
                        int precioUnitario = (int) modelo.getValueAt(filaSeleccionada, 3);
                        int descuento = (int) modelo.getValueAt(filaSeleccionada, 4);
                        int precioConDescuento = (precioUnitario - descuento) * nuevaCantidad;
                        modelo.setValueAt(precioConDescuento, filaSeleccionada, 5);  // Actualizar el precio fila

                        actualizarDetalleCompra(modelo);
                        switchActivarBotonCobrar(modelo);
                        limpiarFieldCodigo();
                        reiniciarSpinnerCantidad();
                        focusFieldCodigo();

                    } else {
                        JOptionPane.showMessageDialog(null, "La cantidad a eliminar no puede ser mayor a la cantidad actual.",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Por favor ingresa un número válido para la cantidad.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }


    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jFormattedTextFieldCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFieldCodigoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jSpinnerCantidad.requestFocus();
        }
    }//GEN-LAST:event_jFormattedTextFieldCodigoKeyPressed

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
            java.util.logging.Logger.getLogger(Caja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Caja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Caja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Caja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Caja().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonCobrar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JComboBox<String> jComboBoxMetodoPago;
    private javax.swing.JFormattedTextField jFormattedTextFieldCodigo;
    private javax.swing.JFormattedTextField jFormattedTextFieldRut;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelCajero;
    private javax.swing.JLabel jLabelCantidad;
    private javax.swing.JLabel jLabelDescuento;
    private javax.swing.JLabel jLabelFecha;
    private javax.swing.JLabel jLabelFolio;
    private javax.swing.JLabel jLabelIva;
    private javax.swing.JLabel jLabelMetodoDePago;
    private javax.swing.JLabel jLabelNeto;
    private javax.swing.JLabel jLabelPuntos;
    private javax.swing.JLabel jLabelRut;
    private javax.swing.JLabel jLabelRut1;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSpinner jSpinnerCantidad;
    private javax.swing.JTable jTableDetalle;
    // End of variables declaration//GEN-END:variables
}
