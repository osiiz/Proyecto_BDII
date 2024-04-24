/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;
import aplicacion.*;
import java.util.*;

/**
 *
 * @author alumnogreibd
 */
public class VProyecto extends javax.swing.JFrame {
    
    FachadaAplicacion fa;
    Proyecto proyecto;
    Usuario usuario;
    /**
     * Creates new form VProyecto
     * @param fa
     * @param proyecto
     * @param usuario
     */
    public VProyecto(FachadaAplicacion fa,Proyecto proyecto,Usuario usuario) {
        this.fa=fa;
        this.proyecto=proyecto;
        this.usuario=usuario;
       
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

        bSalir = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        mProyecto = new javax.swing.JMenu();
        btnForos = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(proyecto.getNProyecto());

        bSalir.setText("Salir");
        bSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalirActionPerformed(evt);
            }
        });

        mProyecto.setText("Proyecto");

        btnForos.setText("Foros");
        btnForos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnForosActionPerformed(evt);
            }
        });
        mProyecto.add(btnForos);

        jMenuBar1.add(mProyecto);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(342, Short.MAX_VALUE)
                .addComponent(bSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(bSalir)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_bSalirActionPerformed

    private void btnForosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnForosActionPerformed
        fa.visualizarForos();
    }//GEN-LAST:event_btnForosActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bSalir;
    private javax.swing.JMenuItem btnForos;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu mProyecto;
    // End of variables declaration//GEN-END:variables




}
