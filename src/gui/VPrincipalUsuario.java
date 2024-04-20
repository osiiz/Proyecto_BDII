/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 /*
 * VPrincipal.java
 *
 * Created on 27-ene-2011, 10:31:24
 */
package gui;

import aplicacion.*;

/**
 *
 * @author basesdatos
 */
public class VPrincipalUsuario extends javax.swing.JFrame {

    aplicacion.FachadaAplicacion fa;
    Usuario usuario;

    /**
     * Creates new form VPrincipal
     *
     * @param fa
     */
    public VPrincipalUsuario(FachadaAplicacion fa) {
        this.fa = fa;
        this.usuario = fa.getUsuario();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        etiquetaTitulo = new javax.swing.JLabel();
        buscaNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        buscaCategoria = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTareas = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnNuevaTarea = new javax.swing.JButton();
        btnEditarTarea = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        buscaCompletada = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        selecAscDesc = new javax.swing.JComboBox<>();
        btnBorrarTarea = new javax.swing.JButton();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();

        jScrollPane2.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Biblioteca de Informática");
        setName("vPrincipal"); // NOI18N
        setResizable(false);

        jLabel1.setText("Nombre:");

        jLabel2.setText("Categoría:");

        buscaCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscaCategoriaActionPerformed(evt);
            }
        });

        tablaTareas.setModel(new gui.ModeloTablaTareasBasicas(fa));
        tablaTareas.setColumnSelectionAllowed(true);
        tablaTareas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaTareas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaTareas);
        tablaTareas.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnNuevaTarea.setText("Nueva");
        btnNuevaTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaTareaActionPerformed(evt);
            }
        });

        btnEditarTarea.setText("Editar");
        btnEditarTarea.setEnabled(false);
        btnEditarTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarTareaActionPerformed(evt);
            }
        });

        jLabel3.setText("Completada:");

        buscaCompletada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscaCompletadaActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/bell (1).png"))); // NOI18N

        selecAscDesc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Descendente", "ascendente" }));
        selecAscDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selecAscDescActionPerformed(evt);
            }
        });

        btnBorrarTarea.setText("Borrar");
        btnBorrarTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarTareaActionPerformed(evt);
            }
        });

        jMenu2.setText("Proyectos");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar2.add(jMenu2);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnNuevaTarea)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBorrarTarea)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEditarTarea)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSalir))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(etiquetaTitulo)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buscaCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(selecAscDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(btnBuscar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buscaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buscaCompletada)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(24, 24, 24))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(etiquetaTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(buscaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3))
                            .addComponent(buscaCompletada))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(buscaCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar)
                            .addComponent(selecAscDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(btnNuevaTarea)
                    .addComponent(btnEditarTarea)
                    .addComponent(btnBorrarTarea))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("Biblioteca Informática");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscaCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscaCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscaCategoriaActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscarTareas();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEditarTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarTareaActionPerformed

        ModeloTablaTareasBasicas mtb = (ModeloTablaTareasBasicas) tablaTareas.getModel();
        int idTarea;
        idTarea = mtb.obtenerTareas(tablaTareas.getSelectedRow()).getIdTarea();
        fa.visualizarTarea(idTarea);
        buscarTareas();
    }//GEN-LAST:event_btnEditarTareaActionPerformed

    private void btnNuevaTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaTareaActionPerformed
        // TODO add your handling code here:
        fa.nuevaTarea();
    }//GEN-LAST:event_btnNuevaTareaActionPerformed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu2MouseClicked

    private void buscaCompletadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscaCompletadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscaCompletadaActionPerformed

    private void selecAscDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selecAscDescActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selecAscDescActionPerformed

    private void btnBorrarTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarTareaActionPerformed
        ModeloTablaTareasBasicas m;
        m = (ModeloTablaTareasBasicas) tablaTareas.getModel();
        int idTarea;
        idTarea = m.obtenerTareas(tablaTareas.getSelectedRow()).getIdTarea();
        fa.borrarTarea(idTarea);
        buscarTareas();

    }//GEN-LAST:event_btnBorrarTareaActionPerformed

    public void buscarTareas() {
        ModeloTablaTareasBasicas m;

        m = (ModeloTablaTareasBasicas) tablaTareas.getModel();
        m.setFilas(fa.obtenerTareas(buscaNombre.getText(), buscaCategoria.getText(), buscaCompletada.isSelected()));
        if (m.getRowCount() > 0) {
            tablaTareas.setRowSelectionInterval(0, 0);
            btnEditarTarea.setEnabled(true);
        } else {
            btnEditarTarea.setEnabled(false);
        }
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrarTarea;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditarTarea;
    private javax.swing.JButton btnNuevaTarea;
    private javax.swing.JButton btnSalir;
    private javax.swing.JTextField buscaCategoria;
    private javax.swing.JCheckBox buscaCompletada;
    private javax.swing.JTextField buscaNombre;
    private javax.swing.JLabel etiquetaTitulo;
    private javax.swing.JButton jButton1;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> selecAscDesc;
    private javax.swing.JTable tablaTareas;
    // End of variables declaration//GEN-END:variables

}
