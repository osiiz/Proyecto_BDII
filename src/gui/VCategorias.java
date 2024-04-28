/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package gui;

import aplicacion.Categoria;
import aplicacion.TipoUsuario;
import aplicacion.Usuario;

/**
 *
 * @author alumnogreibd
 */
public class VCategorias extends javax.swing.JDialog {

    aplicacion.FachadaAplicacion fa;

    /**
     * Creates new form VUsuario
     */
    public VCategorias(java.awt.Frame parent, boolean modal, aplicacion.FachadaAplicacion fa) {
        super(parent, modal);
        initComponents();
        this.fa = fa;
        //jLabel6.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSalir = new javax.swing.JButton();
        btnBorrarCategoria = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        buscaNombre = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnGuardarCategoria = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        insertaNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        editaNombre = new javax.swing.JTextField();
        btnEditarCategoria = new javax.swing.JButton();
        jscrollpane = new javax.swing.JScrollPane();
        listaCategorias = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Categorías");

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnBorrarCategoria.setText("Borrar");
        btnBorrarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarCategoriaActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnGuardarCategoria.setText("Añadir");
        btnGuardarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCategoriaActionPerformed(evt);
            }
        });

        jLabel2.setText("Nueva Categoria:");

        insertaNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertaNombreActionPerformed(evt);
            }
        });

        jLabel3.setText("Editar Categoria:");

        editaNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editaNombreActionPerformed(evt);
            }
        });

        btnEditarCategoria.setText("Editar");
        btnEditarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarCategoriaActionPerformed(evt);
            }
        });

        listaCategorias.setModel(new ModeloListaCategorias());
        listaCategorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaCategoriasMouseClicked(evt);
            }
        });
        jscrollpane.setViewportView(listaCategorias);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jscrollpane)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBuscar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBorrarCategoria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalir))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(editaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(insertaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGuardarCategoria, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnEditarCategoria, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(buscaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jscrollpane, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(editaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditarCategoria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(insertaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardarCategoria))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBorrarCategoria)
                    .addComponent(btnSalir))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        buscaCategoria();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnGuardarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCategoriaActionPerformed
        // TODO add your handling code here:
        
        if (insertaNombre.getText().isBlank()) {
            return; // Salir del método sin realizar ninguna acción
        }
        Categoria c;
        try {
            c = new Categoria(insertaNombre.getText());

            ModeloListaCategorias m = (ModeloListaCategorias) listaCategorias.getModel();

            Boolean existeCategoria = false;
            if (m.getSize() > 0) {
                for (int i = 0; i < m.getSize(); i++) {
                    Categoria cActual = m.getElementAt(i);
                    if (insertaNombre.getText().equals(cActual.getNombre())) {
                        existeCategoria = true;
                    }
                }
            }

            fa.insertarCategoria(c, existeCategoria);
            buscaCategoria();
            btnBorrarCategoria.setEnabled(true);
            insertaNombre.setText("");
            editaNombre.setText("");

        } catch (Exception exc) {
            this.fa.muestraExcepcion(exc.getMessage());
        }
    }//GEN-LAST:event_btnGuardarCategoriaActionPerformed

    private void btnBorrarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarCategoriaActionPerformed
        // TODO add your handling code here:
        ModeloListaCategorias m = (ModeloListaCategorias) listaCategorias.getModel();

        if (listaCategorias.getSelectedIndex()== -1) {
            return; // Salir del método sin realizar ninguna acción
        }

        Categoria c = m.getElementAt(listaCategorias.getSelectedIndex());
        fa.borrarCategoria(c);

        buscaCategoria();
    }//GEN-LAST:event_btnBorrarCategoriaActionPerformed

    private void insertaNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertaNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_insertaNombreActionPerformed

    private void editaNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editaNombreActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_editaNombreActionPerformed

    private void btnEditarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarCategoriaActionPerformed
        // TODO add your handling code here:
        ModeloListaCategorias m = (ModeloListaCategorias) listaCategorias.getModel();

        if (listaCategorias.getSelectedIndex() == -1 || editaNombre.getText().isBlank()) {
            return; // Salir del método sin realizar ninguna acción
        }

        Categoria c = m.getElementAt(listaCategorias.getSelectedIndex());
        fa.editarCategoria(c.getNombre(), editaNombre.getText());

        buscaCategoria();
    }//GEN-LAST:event_btnEditarCategoriaActionPerformed

    private void listaCategoriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaCategoriasMouseClicked
        ModeloListaCategorias m = (ModeloListaCategorias) listaCategorias.getModel();

        if (m.getSize() > 0) {
            Categoria c = m.getElementAt(listaCategorias.getSelectedIndex());

            editaNombre.setText(c.getNombre());
        }
    }//GEN-LAST:event_listaCategoriasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrarCategoria;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditarCategoria;
    private javax.swing.JButton btnGuardarCategoria;
    private javax.swing.JButton btnSalir;
    private javax.swing.JTextField buscaNombre;
    private javax.swing.JTextField editaNombre;
    private javax.swing.JTextField insertaNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jscrollpane;
    private javax.swing.JList<String> listaCategorias;
    // End of variables declaration//GEN-END:variables

    public void buscaCategoria() {

        ModeloListaCategorias m;

        m = (ModeloListaCategorias) listaCategorias.getModel();
        m.setElementos(fa.obtenerCategorias(buscaNombre.getText()));

    }

}
