/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import aplicacion.FachadaAplicacion;
import aplicacion.Foro;
import aplicacion.Publicacion;
import aplicacion.TipoUsuario;
import aplicacion.Usuario;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alumnogreibd
 */
public final class VPublicaciones extends javax.swing.JFrame {

    private FachadaAplicacion fa;
    private Usuario usuario;
    private Foro foro;
    private VForos vf;

    /**
     * Creates new form VPublicaciones
     * @param fa
     * @param usuario
     * @param foro
     */
    public VPublicaciones(FachadaAplicacion fa, Usuario usuario, Foro foro, VForos vf) {
        initComponents();
        this.fa = fa;
        this.usuario = usuario;
        this.foro = foro;
        this.vf = vf;
        txtNombre.setText(foro.getTitulo());
        if (usuario.getTipoUsuario() == TipoUsuario.Gestor){
            txtNombre.setEditable(true);
            btnBorrarPublicacion.setVisible(true);
            btnGuardarNombre.setVisible(true);
            btnEnviar.setEnabled(false);
        }else{
            txtNombre.setEditable(false);
            btnBorrarPublicacion.setVisible(false);
            btnGuardarNombre.setVisible(false);
        }
        
        actualizarPublicaciones();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaMensajes = new javax.swing.JTextArea();
        btnSalir = new javax.swing.JButton();
        txtMensaje = new javax.swing.JTextField();
        btnEnviar = new javax.swing.JButton();
        btnBorrarPublicacion = new javax.swing.JButton();
        btnGuardarNombre = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();

        jButton1.setText("jButton1");

        jButton2.setText("jButton2");

        jButton4.setText("jButton4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Publicaciones");

        areaMensajes.setColumns(20);
        areaMensajes.setRows(5);
        jScrollPane1.setViewportView(areaMensajes);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        btnBorrarPublicacion.setText("Borrar publicacion");
        btnBorrarPublicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarPublicacionActionPerformed(evt);
            }
        });

        btnGuardarNombre.setText("Guardar Nombre");
        btnGuardarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarNombreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtNombre)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardarNombre))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtMensaje)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEnviar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnBorrarPublicacion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalir)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnviar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBorrarPublicacion)
                    .addComponent(btnSalir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        if (txtMensaje.getText().isBlank()){
            return;
        }
        fa.nuevaPublicacion(txtMensaje.getText(), usuario.getIdUsuario(), foro.getIdForo());
        txtMensaje.setText("");
        actualizarPublicaciones();
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void btnBorrarPublicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarPublicacionActionPerformed
        fa.ventanaBorrarPublicacion(foro.getIdForo());
        actualizarPublicaciones();
    }//GEN-LAST:event_btnBorrarPublicacionActionPerformed

    private void btnGuardarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarNombreActionPerformed
        if (txtNombre.getText().isBlank()) return;
        fa.cambiarNombreForo(txtNombre.getText(), foro.getIdForo());
        vf.buscarForos();
    }//GEN-LAST:event_btnGuardarNombreActionPerformed

    public List<Publicacion> buscarPublicaciones(){
        return fa.buscarPublicaciones(foro.getIdForo());
    }
    
    private void actualizarPublicaciones(){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm");
        areaMensajes.setText("");
        for (Publicacion pub : buscarPublicaciones()){
            String publi = "[" + pub.getFecha().format(formato) + "] " + pub.getIdUsuario() + ": "
                      + pub.getTexto() +"\n";
            areaMensajes.append(publi);
        }
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaMensajes;
    private javax.swing.JButton btnBorrarPublicacion;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnGuardarNombre;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtMensaje;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
