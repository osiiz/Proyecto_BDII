/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import aplicacion.*;

/**
 *
 * @author alumno
 */
public class FachadaGui {
    aplicacion.FachadaAplicacion fa;
    VPrincipalUsuario vp;
    VPrincipalAdmin vpa;
    Usuario usuario; //true es admin y false no admin
    
   public FachadaGui(aplicacion.FachadaAplicacion fa){
     this.fa=fa;
     //this.vp = new VPrincipalUsuario(fa);
     //this.vpa = new VPrincipalAdmin(fa, usuario);
     this.vp = null;
     this.vpa = null;
     
   } 
    
    public void iniciaVista(){
      VAutentificacion va;
    
      va = new VAutentificacion(fa);
      va.setVisible(true);
      
      if(fa.getUsuario().getTipoUsuario() == TipoUsuario.Normal || fa.getUsuario().getTipoUsuario() == TipoUsuario.Gestor){
          vp = new VPrincipalUsuario(fa);
          vp.setVisible(true);
      }else{
          vpa = new VPrincipalAdmin(fa);
          vpa.setVisible(true);
      }
      
    }
    
   
    public void visualizaLibro(Libro l, java.util.List<String>restoCategorias){
        VLibro vl;
        java.util.List<String> categorias = new java.util.ArrayList<String>();
        
        for(Categoria c:l.getCategorias()){
            categorias.add(c.getNombre());
        }
        
        vl=new VLibro(vp, true, fa, l, categorias, restoCategorias);
        vl.setVisible(true);
    }
    
    public void nuevoLibro(java.util.List<String>  restoCategorias){
        VLibro vl;
        
        vl=new VLibro(vp, true, fa, restoCategorias);
        vl.setVisible(true);
    }
    
    public void muestraExcepcion(String txtExcepcion){
       VAviso va;
       
       va = new VAviso(vp, true, txtExcepcion);
       va.setVisible(true);
    }
    
    public void ventanaUsuario(){
        VUsuario vu;
        
        vu = new VUsuario(vp, true, fa);
        vu.setVisible(true);
    }

    public void ventanaCategorias() {
        VCategorias vc;
        vc = new VCategorias(vp, true, fa);
        vc.setVisible(true);
    }

    public void ventanaPrestamos(Ejemplar ejemplar, VLibro vlibro) {
        VPrestamos vpres;
        
        vpres = new VPrestamos(vp, true, fa, ejemplar, vlibro);
        vpres.setVisible(true);
        
        
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
   

    
   
}
