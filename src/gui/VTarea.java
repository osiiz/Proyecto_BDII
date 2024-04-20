/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import aplicacion.FachadaAplicacion;
import aplicacion.Tarea;
import baseDatos.FachadaBaseDatos;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author loisf
 */
public class VTarea extends javax.swing.JFrame {

    private FachadaAplicacion fa;
    private Tarea tarea;
    private VPrincipalUsuario padre;
    private FachadaBaseDatos fbd; 

    /**
     * Creates new form VTarea
     * @param parent
     * @param modal
     * @param fa
     * @param restoCategorias
     */
    public VTarea(FachadaAplicacion fa, List<String> restoCategorias, FachadaBaseDatos fbd) {
        this.fa = fa;
        this.fbd = fbd;
        initComponents();

        ModeloListaStrings mListaRC=new ModeloListaStrings();
        listaCategorias.setModel(mListaRC);
        mListaRC.setElementos(restoCategorias);
        if (mListaRC.getSize()>0) {
            listaCategorias.setSelectedIndex(0);
            btnCambiarCategoria.setEnabled(true);
        } else btnCambiarCategoria.setEnabled(false);
        
        btnEliminarCategoria.setEnabled(false);
        txtId.setEditable(false);
        txtCategoriaActual.setEditable(false);
    }
    
    public VTarea(FachadaAplicacion fa, List<String> restoCategorias, Tarea tarea, FachadaBaseDatos fbd){
        this.fa = fa;
        this.fbd = fbd;
        initComponents();
        ModeloListaStrings mListaRC=new ModeloListaStrings();
        listaCategorias.setModel(mListaRC);
        mListaRC.setElementos(restoCategorias);
        if (mListaRC.getSize()>0) {
            listaCategorias.setSelectedIndex(0);
            btnCambiarCategoria.setEnabled(true);
        } else btnCambiarCategoria.setEnabled(false);
        
        this.tarea = tarea;
        
        txtNombre.setText(tarea.getNombre());
        txtId.setText(((Integer)tarea.getIdTarea()).toString());
        checkCompletada.setSelected(tarea.getCompletada());
        txtFechaFin.setText(tarea.getFechaFin().toString());
        
        btnGuardarTarea.setEnabled(true);
        
        txtCategoriaActual.setText(tarea.getCategoria().toString());
        btnEliminarCategoria.setEnabled(true);
        txtId.setEditable(false);
        txtCategoriaActual.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        checkCompletada = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        txtFechaFin = new javax.swing.JTextField();
        btnGuardarTarea = new javax.swing.JButton();
        btnSalirTarea = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaCategorias = new javax.swing.JList<>();
        txtCategoriaActual = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnCambiarCategoria = new javax.swing.JButton();
        btnEliminarCategoria = new javax.swing.JButton();
        btnGuardarCategoria = new javax.swing.JButton();
        btnSalirCategoria = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nombre:");

        jLabel2.setText("Id:");

        jLabel3.setText("Completada:");

        jLabel4.setText("Fecha de finalización:");

        btnGuardarTarea.setText("Guardar");
        btnGuardarTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarTareaActionPerformed(evt);
            }
        });

        btnSalirTarea.setText("Salir");
        btnSalirTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirTareaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnGuardarTarea)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalirTarea))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkCompletada))
                        .addGap(0, 134, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(checkCompletada))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarTarea)
                    .addComponent(btnSalirTarea))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Tarea", jPanel1);

        jLabel5.setText("Categoría actual");

        listaCategorias.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listaCategorias);

        jLabel6.setText("Categorías disponibles");

        btnCambiarCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/flechaI.jpg"))); // NOI18N
        btnCambiarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarCategoriaActionPerformed(evt);
            }
        });

        btnEliminarCategoria.setText("Eliminar categoría");
        btnEliminarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCategoriaActionPerformed(evt);
            }
        });

        btnGuardarCategoria.setText("Guardar");

        btnSalirCategoria.setText("Salir");
        btnSalirCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirCategoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtCategoriaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCambiarCategoria))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnEliminarCategoria)))
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(34, 34, 34))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGuardarCategoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalirCategoria)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(btnCambiarCategoria))
                            .addComponent(txtCategoriaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarCategoria)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalirCategoria)
                    .addComponent(btnGuardarCategoria))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Categorías", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarTareaActionPerformed
        Tarea t;
        t = new Tarea(Integer.parseInt(txtId.getText()), txtNombre.getText(), checkCompletada.isSelected(), LocalDate.parse(txtFechaFin.getText()), tarea.getCategoria());

        fa.actualizarTarea(t);
    }//GEN-LAST:event_btnGuardarTareaActionPerformed

    private void btnSalirTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirTareaActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirTareaActionPerformed

    private void btnCambiarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCambiarCategoriaActionPerformed

    private void btnSalirCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirCategoriaActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirCategoriaActionPerformed

    private void btnEliminarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCategoriaActionPerformed
        fa.eliminarCategoriaTarea(tarea.getIdTarea());
        Tarea t;
        t = new Tarea(Integer.parseInt(txtId.getText()), txtNombre.getText(), checkCompletada.isSelected(), LocalDate.parse(txtFechaFin.getText()), tarea.getCategoria());
        fa.actualizarTarea(t);
        ((ModeloListaStrings)listaCategorias.getModel()).setElementos(fbd.obtenerRestoCategorias(tarea.getIdTarea()));
        txtCategoriaActual.setText("");
    }//GEN-LAST:event_btnEliminarCategoriaActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambiarCategoria;
    private javax.swing.JButton btnEliminarCategoria;
    private javax.swing.JButton btnGuardarCategoria;
    private javax.swing.JButton btnGuardarTarea;
    private javax.swing.JButton btnSalirCategoria;
    private javax.swing.JButton btnSalirTarea;
    private javax.swing.JCheckBox checkCompletada;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JList<String> listaCategorias;
    private javax.swing.JTextField txtCategoriaActual;
    private javax.swing.JTextField txtFechaFin;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
