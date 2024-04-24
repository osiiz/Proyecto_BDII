package gui;
import aplicacion.*;
import java.util.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author alumnogreibd
 */
public class VPrincipalProyectos extends javax.swing.JFrame {
    aplicacion.FachadaAplicacion fa;
    Usuario usuario;
    ArrayList<Proyecto> proyectos;
    /**
     * Creates new form VPrincipalProyectos
     * @param fa
     * @param usuario
     */
    public VPrincipalProyectos(FachadaAplicacion fa,Usuario usuario) {
        this.fa = fa;
        this.usuario = usuario;
        initComponents();
        actualizarListaProyectos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lProyectos = new javax.swing.JList<>();
        bEntrar = new javax.swing.JButton();
        bSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Proyectos");

        lProyectos.setModel(new ModeloListaStrings());
        lProyectos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lProyectos.setAlignmentX(5.0F);
        jScrollPane1.setViewportView(lProyectos);

        bEntrar.setText("Entrar");
        bEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEntrarActionPerformed(evt);
            }
        });

        bSalir.setText("Salir");
        bSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(253, Short.MAX_VALUE)
                        .addComponent(bEntrar)
                        .addGap(18, 18, 18)
                        .addComponent(bSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(23, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bEntrar)
                    .addComponent(bSalir))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_bSalirActionPerformed

    private void bEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEntrarActionPerformed
        Proyecto p=null;
        ModeloListaStrings modelo;
        modelo=(ModeloListaStrings) lProyectos.getModel();
        if (lProyectos.getSelectedIndex() < 0){
            return;
        }
        String aux = modelo.getElementAt(lProyectos.getSelectedIndex()); 
        for(Proyecto pr: proyectos) if((pr.getNProyecto()+" ["+pr.getIdProyecto()+"]").equals(aux)) p= pr;
        fa.nuevoVProyecto(p);
        
    }//GEN-LAST:event_bEntrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bEntrar;
    private javax.swing.JButton bSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> lProyectos;
    // End of variables declaration//GEN-END:variables

public final void actualizarListaProyectos(){
    ModeloListaStrings modelo;
    modelo=(ModeloListaStrings) lProyectos.getModel();
    List<String> nombresProyectos = new ArrayList<>();
    proyectos = fa.obtenerProyectos(usuario);
    for(Proyecto p : proyectos) nombresProyectos.add(p.getNProyecto()+" ["+p.getIdProyecto()+"]");
    modelo.setElementos(nombresProyectos);
}



}
