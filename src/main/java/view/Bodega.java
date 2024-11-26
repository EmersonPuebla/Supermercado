/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ProductoDAO;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Producto;

public class Bodega extends javax.swing.JFrame {

    public void vaciarCasillas() {
        jTextFieldCodigo.setText("");
        jTextFieldNombre.setText("");
        jTextFieldMarca.setText("");
        jTextFieldMedida.setText("");
        jTextFieldUnidadMedida.setText("");
        jTextFieldStock.setText("");
        jTextFieldPrecio.setText("");
        jTextFieldDescuento.setText("");    
    }
    
    public void volverEstadoDefault() {
        jTextFieldCodigo.setEnabled(true);
        jTextFieldNombre.setEnabled(false);
        jTextFieldMarca.setEnabled(false);
        jTextFieldMedida.setEnabled(false);
        jTextFieldUnidadMedida.setEnabled(false);
        jTextFieldStock.setEnabled(false);
        jTextFieldPrecio.setEnabled(false);
        jTextFieldDescuento.setEnabled(false);
        jButtonActualizar.setEnabled(false);
        jButtonEliminar.setEnabled(false);
    }
    
    
    /**
     * Creates new form Bodega
     */
    int estadoAgregar = 0;
    
 
    public Bodega() {
        initComponents();
        setLocationRelativeTo(null);
        volverEstadoDefault();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonVolver = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jButtonEliminar = new javax.swing.JButton();
        jButtonActualizar = new javax.swing.JButton();
        jButtonBuscar = new javax.swing.JButton();
        jButtonAgregar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableSalida = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabelDescuento = new javax.swing.JLabel();
        jLabelPrecio = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelCodigo = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jTextFieldDescuento = new javax.swing.JTextField();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldPrecio = new javax.swing.JTextField();
        jTextFieldMarca = new javax.swing.JTextField();
        jLabelMarca = new javax.swing.JLabel();
        jLabelUnidadMedida = new javax.swing.JLabel();
        jLabelMedida = new javax.swing.JLabel();
        jTextFieldMedida = new javax.swing.JTextField();
        jTextFieldUnidadMedida = new javax.swing.JTextField();
        jTextFieldStock = new javax.swing.JTextField();
        jLabelStock = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bodega");

        jButtonVolver.setText("Volver");
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverActionPerformed(evt);
            }
        });

        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        jButtonActualizar.setText("Actualizar");
        jButtonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarActionPerformed(evt);
            }
        });

        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jButtonAgregar.setText("Agregar");
        jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonAgregar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonActualizar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jButtonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTableSalida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Marca", "Medida", "Unidad Medida", "Precio", "Stock", "Descuento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableSalida.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTableSalida);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabelDescuento.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabelDescuento.setText("%Descuento");

        jLabelPrecio.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabelPrecio.setText("Precio");

        jLabelNombre.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabelNombre.setText("Nombre");

        jLabelCodigo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabelCodigo.setText("Codigo");

        jTextFieldCodigo.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jTextFieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreActionPerformed(evt);
            }
        });

        jTextFieldMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMarcaActionPerformed(evt);
            }
        });

        jLabelMarca.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabelMarca.setText("Marca");

        jLabelUnidadMedida.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabelUnidadMedida.setText("U. Medida");

        jLabelMedida.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabelMedida.setText("Medida");

        jLabelStock.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabelStock.setText("Stock");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldNombre)
                    .addComponent(jTextFieldCodigo)
                    .addComponent(jTextFieldMarca)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelMedida)
                                    .addComponent(jLabelCodigo)
                                    .addComponent(jLabelNombre)
                                    .addComponent(jLabelMarca)
                                    .addComponent(jTextFieldMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jTextFieldUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldStock, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabelUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelStock, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelPrecio))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelDescuento)
                                    .addComponent(jTextFieldDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, 0))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCodigo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelMarca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMedida)
                    .addComponent(jLabelUnidadMedida)
                    .addComponent(jLabelStock))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldStock, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPrecio)
                    .addComponent(jLabelDescuento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(93, 93, 93))
        );

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logo-mini.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
            .addComponent(jSeparator1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonVolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMarcaActionPerformed
            
    }//GEN-LAST:event_jTextFieldMarcaActionPerformed

    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        
        
        if (estadoAgregar == 0){
        
            int opcion = JOptionPane.showConfirmDialog(null, 
        "¿Seguro que deseas agregar un producto?", 
        "Confirmación", 
        JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                estadoAgregar++;
            }
            
        } else if (estadoAgregar == 1) {
            vaciarCasillas();        
            
            estadoAgregar ++;
            jTextFieldCodigo.setEnabled(false);
            jTextFieldNombre.setEnabled(true);
            jTextFieldMarca.setEnabled(true);
            jTextFieldMedida.setEnabled(true);
            jTextFieldUnidadMedida.setEnabled(true);
            jTextFieldStock.setEnabled(true);
            jTextFieldPrecio.setEnabled(true);
            jTextFieldDescuento.setEnabled(true);

            jButtonBuscar.setEnabled(false);
            jButtonActualizar.setEnabled(false);
            jButtonEliminar.setEnabled(false);

            JOptionPane.showMessageDialog(null, "Ingresa los datos del producto a agregar y presiona nuevamente el boton", "Información", JOptionPane.INFORMATION_MESSAGE);
        } else if (estadoAgregar == 2) {     
            try {
            
            // Obtiene todos los datos de las casillas
            String nombre = jTextFieldNombre.getText();
            String marca = jTextFieldMarca.getText();
            String medida = jTextFieldMedida.getText();
            String unidadMedida = jTextFieldUnidadMedida.getText();
            String stock = jTextFieldStock.getText();
            String precio = jTextFieldPrecio.getText();
            String descuento = jTextFieldDescuento.getText();

            
            // Comprueba si alguno esta vacio
            boolean faltaDato = nombre.isEmpty() || marca.isEmpty() || medida.isEmpty() || 
                    unidadMedida.isEmpty() || stock.isEmpty() || precio.isEmpty() || 
                    descuento.isEmpty();

            
            // Si existe alguno vacio lo informa
            if (faltaDato) {
                JOptionPane.showMessageDialog(null, "Porfavor rellena los campos faltantes", "Error", JOptionPane.ERROR_MESSAGE);
                
            // Confirma si la unidad de medida es valida
            } else if (!Producto.isUnidadMedidaValido(unidadMedida)) {
                JOptionPane.showMessageDialog(null, "Información invalida, la unidad de medida es erronea", "Error",
            JOptionPane.ERROR_MESSAGE);
            
            // Pero si no queda ninguno por completar envia la info
            } else if (Integer.parseInt(medida) > 0 && Integer.parseInt(stock) > 0 && Integer.parseInt(precio) > 0 && Integer.parseInt(descuento) >= 0 && Integer.parseInt(descuento) <= 100) {
                ProductoDAO.agregarProducto(nombre,marca,Integer.parseInt(medida), unidadMedida,Integer.parseInt(stock),  Integer.parseInt(precio),  Integer.parseInt(descuento));
                
                JOptionPane.showMessageDialog(null, "El producto se ha agregado exitosamente!", "Información", JOptionPane.INFORMATION_MESSAGE);

                volverEstadoDefault();
                estadoAgregar = 0;
                
            } else {
                JOptionPane.showMessageDialog(null, "Información invalida, vuelva a ingresar la información", "Error",
            JOptionPane.ERROR_MESSAGE);
            }
        
         } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Información invalida, vuelva a ingresar la información", "Error",
            JOptionPane.ERROR_MESSAGE);
        }
        
       }
    }//GEN-LAST:event_jButtonAgregarActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        
        
        try {
        int codigo = Integer.parseInt(jTextFieldCodigo.getText());
        
         int opcion = JOptionPane.showConfirmDialog(null, 
        "¿Seguro que deseas eliminar este producto?", 
        "Confirmación", 
        JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                if (ProductoDAO.eliminarProducto(codigo)) {
                    vaciarCasillas();
                    volverEstadoDefault();
                    JOptionPane.showMessageDialog(null, "El producto se ha eliminado exitosamente!", "Información", JOptionPane.INFORMATION_MESSAGE);
                
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "No hay nada que eliminar", "Error",
            JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarActionPerformed
         // Obtiene todos los datos de las casillas
        String id = jTextFieldCodigo.getText();
        String nombre = jTextFieldNombre.getText();
        String marca = jTextFieldMarca.getText();
        String medida = jTextFieldMedida.getText();
        String unidadMedida = jTextFieldUnidadMedida.getText();
        String stock = jTextFieldStock.getText();
        String precio = jTextFieldPrecio.getText();
        String descuento = jTextFieldDescuento.getText();
        
        ProductoDAO.actualizarProducto(
                Integer.parseInt(id),
                nombre,
                marca,
                Integer.parseInt(medida),
                unidadMedida,
                Integer.parseInt(precio),
                Integer.parseInt(stock),
                Integer.parseInt(descuento)
        );
        
        
        
        
        
        
        
    }//GEN-LAST:event_jButtonActualizarActionPerformed

    private void jButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonVolverActionPerformed
        Hub hubWindow = new Hub();
        hubWindow.setVisible(true);
        this.dispose();
    }// GEN-LAST:event_jButtonVolverActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonBuscarActionPerformed

        try {
            int codigo = Integer.parseInt(jTextFieldCodigo.getText());

            String nombre = ProductoDAO.getNombre(codigo);

            
            String marca = ProductoDAO.getMarca(codigo);

            int medida = ProductoDAO.getMedida(codigo);
            String unidadMedida = ProductoDAO.getUnidadMedida(codigo);

            int precio = ProductoDAO.getPrecio(codigo);
            int stock = ProductoDAO.getStock(codigo);
            int descuento = ProductoDAO.getDescuento(codigo);
            
            if (nombre == null) {
                JOptionPane.showMessageDialog(null, "No se ha encontrado el producto en los registros", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                // Coloca la info en las casillas
                jTextFieldNombre.setText(nombre);
                jTextFieldMarca.setText(marca);
                jTextFieldMedida.setText(String.valueOf(medida));
                jTextFieldUnidadMedida.setText(unidadMedida);
                jTextFieldStock.setText(String.valueOf(stock));
                jTextFieldPrecio.setText(String.valueOf(precio));
                jTextFieldDescuento.setText(String.valueOf(descuento));
                

                // Habilita las casillas
                jTextFieldNombre.setEnabled(true);
                jTextFieldMarca.setEnabled(true);
                jTextFieldMedida.setEnabled(true);
                jTextFieldUnidadMedida.setEnabled(true);
                jTextFieldStock.setEnabled(true);
                jTextFieldPrecio.setEnabled(true);
                jTextFieldDescuento.setEnabled(true);
                jButtonActualizar.setEnabled(true);
                jButtonEliminar.setEnabled(true);
                
                
            }


            // Obtener el modelo directamente del JTable
            DefaultTableModel modelo = (DefaultTableModel) jTableSalida.getModel();
            // Agregar una nueva fila al modelo

            int fila = 0;

            // Editar cada columna de la fila
            modelo.setValueAt(codigo, fila, 0); // Columna "Código"
            modelo.setValueAt(nombre, fila, 1); // Columna "Nombre"
            modelo.setValueAt(marca, fila, 2); // Columna "Marca"
            modelo.setValueAt(medida, fila, 3); // Columna "Medida"
            modelo.setValueAt(unidadMedida, fila, 4); // Columna "Unidad"
            modelo.setValueAt("$" + precio, fila, 5); // Columna "Precio"
            modelo.setValueAt(stock, fila, 6); // Columna "Stock"
            modelo.setValueAt(descuento + "%", fila, 7); // Columna "Descuento"
            
           
            
            
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Porfavor ingrese el codigo del producto", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

    }// GEN-LAST:event_jButtonBuscarActionPerformed

    private void jTextFieldNombreActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextFieldNombreActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jTextFieldNombreActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Bodega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bodega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bodega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bodega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bodega().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonActualizar;
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelDescuento;
    private javax.swing.JLabel jLabelMarca;
    private javax.swing.JLabel jLabelMedida;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelPrecio;
    private javax.swing.JLabel jLabelStock;
    private javax.swing.JLabel jLabelUnidadMedida;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTableSalida;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldDescuento;
    private javax.swing.JTextField jTextFieldMarca;
    private javax.swing.JTextField jTextFieldMedida;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldPrecio;
    private javax.swing.JTextField jTextFieldStock;
    private javax.swing.JTextField jTextFieldUnidadMedida;
    // End of variables declaration//GEN-END:variables
}
