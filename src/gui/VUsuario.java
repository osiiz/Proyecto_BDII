/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package gui;
import aplicacion.Usuario;
import aplicacion.TipoUsuario;



/**
 *
 * @author alumnogreibd
 */
public class VUsuario extends javax.swing.JDialog {
    aplicacion.FachadaAplicacion fa;

    /**
     * Creates new form VUsuario
     */
    public VUsuario(java.awt.Frame parent, boolean modal, aplicacion.FachadaAplicacion fa) {
        super(parent, modal);
        initComponents();
        this.fa = fa;
        labelTipo.setVisible(false);
        labelCompleta.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        editaEmail = new javax.swing.JTextField();
        buscaUsuario = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        editaId = new javax.swing.JTextField();
        editaTipo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        editaDireccion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnNuevoUsuario = new javax.swing.JButton();
        editaClave = new javax.swing.JTextField();
        btnGuardarUsuario = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        btnBorrarUsuario = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        buscaId = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        buscaNombre = new javax.swing.JTextField();
        editaNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        labelTipo = new javax.swing.JLabel();
        labelCompleta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de Usuarios");

        jLabel2.setText("Nombre:");

        buscaUsuario.setText("Buscar");
        buscaUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscaUsuarioActionPerformed(evt);
            }
        });

        jLabel9.setText("Dirección:");

        jLabel3.setText("Id:");

        jLabel4.setText("Clave:");

        btnNuevoUsuario.setText("Nuevo");
        btnNuevoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoUsuarioActionPerformed(evt);
            }
        });

        btnGuardarUsuario.setText("Guardar");
        btnGuardarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarUsuarioActionPerformed(evt);
            }
        });

        tablaUsuarios.setModel(new ModeloTablaUsuarios());
        tablaUsuarios.setColumnSelectionAllowed(true);
        tablaUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaUsuarios);

        jLabel5.setText("Tipo:");

        btnBorrarUsuario.setText("Borrar");
        btnBorrarUsuario.setEnabled(false);
        btnBorrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarUsuarioActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jLabel7.setText("Nombre:");

        jLabel1.setText("Id:");

        jLabel8.setText("E-mail:");

        labelTipo.setForeground(new java.awt.Color(255, 0, 0));
        labelTipo.setText("¡Tipo Incorrecto!");

        labelCompleta.setForeground(new java.awt.Color(255, 0, 0));
        labelCompleta.setText("¡Completa todos los campos!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buscaId, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 136, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94)
                        .addComponent(buscaUsuario))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNuevoUsuario)
                                .addGap(18, 18, 18)
                                .addComponent(btnGuardarUsuario)
                                .addGap(56, 56, 56)
                                .addComponent(labelCompleta))
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(editaId, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(editaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(editaClave, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                                    .addComponent(editaEmail))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(editaTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(editaDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(labelTipo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                                .addComponent(btnBorrarUsuario)
                                .addGap(18, 18, 18)
                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscaId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(buscaUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editaId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(editaClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(editaTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(editaEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(editaDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevoUsuario)
                    .addComponent(btnGuardarUsuario)
                    .addComponent(btnBorrarUsuario)
                    .addComponent(btnSalir)
                    .addComponent(labelTipo)
                    .addComponent(labelCompleta))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscaUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscaUsuarioActionPerformed
        // TODO add your handling code here:
        buscaUsuario();
        
    }//GEN-LAST:event_buscaUsuarioActionPerformed

    private void btnGuardarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarUsuarioActionPerformed
        if (!editaTipo.getText().equals("Normal") && !editaTipo.getText().equals("Gestor") && !editaTipo.getText().equals("Administrador")){
            labelTipo.setVisible(true);
            return;
        }
        if(editaNombre.getText().equals("") || editaClave.getText().equals("") || 
           editaId.getText().equals("")){
            labelCompleta.setVisible(true);
            return;
        }
        
        labelTipo.setVisible(false);
        labelCompleta.setVisible(false);
        
        Usuario us;
        try{
            us=new Usuario(editaId.getText(), editaClave.getText(), editaNombre.getText(), 
                    editaDireccion.getText(), editaEmail.getText(), TipoUsuario.valueOf(editaTipo.getText()));

            ModeloTablaUsuarios m=(ModeloTablaUsuarios) tablaUsuarios.getModel();

            Boolean existeUsuario = false;
            Boolean clave_modificada = true;
            Boolean id_modificado = true;
            String idAntiguo = "";
            if (m.getRowCount() > 0){
                for (int i = 0; i < m.getRowCount(); i++){
                    Usuario usActual = m.obtenerUsuario(i);
                    if (editaId.getText().equals(usActual.getIdUsuario())){
                        existeUsuario = true;
                        id_modificado = false;
                        break;
                    }
                }
                Usuario usActual = m.obtenerUsuario(tablaUsuarios.getSelectedRow());
                if (editaClave.getText().equals(usActual.getClave())){
                    clave_modificada = false;
                }
                if (id_modificado){
                    idAntiguo = m.obtenerUsuario(tablaUsuarios.getSelectedRow()).getIdUsuario();
                }
            }

            fa.actualizarUsuario(us, existeUsuario, clave_modificada, idAntiguo);
            buscaUsuario();
            btnBorrarUsuario.setEnabled(true);

        }catch(Exception exc){
            this.fa.muestraExcepcion(exc.getMessage());
        }
    }//GEN-LAST:event_btnGuardarUsuarioActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void tablaUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaUsuariosMouseClicked
        ModeloTablaUsuarios m=(ModeloTablaUsuarios) tablaUsuarios.getModel();
        
        if (m.getRowCount() > 0) {
            Usuario usuario = m.obtenerUsuario(tablaUsuarios.getSelectedRow());
            
            editaNombre.setText(usuario.getNombre());
            editaId.setText(usuario.getIdUsuario());
            editaEmail.setText(usuario.getEmail());
            editaTipo.setText(usuario.getTipoUsuario().toString());
            editaClave.setText(usuario.getClave());
            editaDireccion.setText(usuario.getDireccion());
        }
    }//GEN-LAST:event_tablaUsuariosMouseClicked

    private void btnNuevoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoUsuarioActionPerformed
        editaNombre.setText("");
        editaId.setText("");
        editaEmail.setText("");
        editaTipo.setText("");
        editaClave.setText("");
        editaDireccion.setText("");
    }//GEN-LAST:event_btnNuevoUsuarioActionPerformed

    private void btnBorrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarUsuarioActionPerformed
        ModeloTablaUsuarios m=(ModeloTablaUsuarios) tablaUsuarios.getModel();
        Usuario usuario = m.obtenerUsuario(tablaUsuarios.getSelectedRow());
        fa.borrarUsuario(usuario);
        buscaUsuario();
    }//GEN-LAST:event_btnBorrarUsuarioActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrarUsuario;
    private javax.swing.JButton btnGuardarUsuario;
    private javax.swing.JButton btnNuevoUsuario;
    private javax.swing.JButton btnSalir;
    private javax.swing.JTextField buscaId;
    private javax.swing.JTextField buscaNombre;
    private javax.swing.JButton buscaUsuario;
    private javax.swing.JTextField editaClave;
    private javax.swing.JTextField editaDireccion;
    private javax.swing.JTextField editaEmail;
    private javax.swing.JTextField editaId;
    private javax.swing.JTextField editaNombre;
    private javax.swing.JTextField editaTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCompleta;
    private javax.swing.JLabel labelTipo;
    private javax.swing.JTable tablaUsuarios;
    // End of variables declaration//GEN-END:variables
   
    public void buscaUsuario(){
        ModeloTablaUsuarios m;

        m=(ModeloTablaUsuarios) tablaUsuarios.getModel();
        m.setFilas(fa.obtenerUsuarios(buscaId.getText(), buscaNombre.getText()));
        if (m.getRowCount() > 0) {
            tablaUsuarios.setRowSelectionInterval(0, 0);
            Usuario usuario = m.obtenerUsuario(0);
            
            editaNombre.setText(usuario.getNombre());
            editaId.setText(usuario.getIdUsuario());
            editaEmail.setText(usuario.getEmail());
            editaTipo.setText(usuario.getTipoUsuario().toString());
            editaClave.setText(usuario.getClave());
            editaDireccion.setText(usuario.getDireccion());
            
            btnGuardarUsuario.setEnabled(true);
            btnBorrarUsuario.setEnabled(true);
        }
        else{
            btnBorrarUsuario.setEnabled(false);
            btnGuardarUsuario.setEnabled(true);
        }
    }
    
}
