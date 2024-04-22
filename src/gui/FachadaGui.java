/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import aplicacion.*;
import baseDatos.FachadaBaseDatos;
import java.util.List;

/**
 *
 * @author alumno
 */
public class FachadaGui {
    aplicacion.FachadaAplicacion fa;
    VPrincipalUsuario vp;
    VPrincipalAdmin vpa;
    Usuario usuario;
    
   public FachadaGui(aplicacion.FachadaAplicacion fa){
     this.fa=fa;
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


    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void visualizaTarea(Tarea tarea, List<String> restoCategorias, FachadaBaseDatos fbd) {
        VTarea vt;
        vt = new VTarea(fa, restoCategorias, tarea, fbd);
        vt.setVisible(true);
    }
    
    public void visualizaTarea(List<String> restoCategorias, FachadaBaseDatos fbd, String idUsuario){
        VTarea vt;
        vt = new VTarea(fa, restoCategorias, fbd, idUsuario);
        vt.setVisible(true);
    }
    
    public void ventanaForos(Usuario usuario) {
        VForos vf;
        vf = new VForos(fa, usuario, 2);
        vf.setVisible(true);
        
    }
    
   

    
   
}
