/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aplicacion;
import gui.FachadaGui;
import baseDatos.FachadaBaseDatos;
/**
 *
 * @author basesdatos
 */
public class GestionUsuarios {
     
    FachadaGui fgui;
    FachadaBaseDatos fbd;
    
   
    public GestionUsuarios(FachadaGui fgui, FachadaBaseDatos fbd){
     this.fgui=fgui;
     this.fbd=fbd;
    }  
    
    
    
  public Usuario comprobarAutentificacion(String idUsuario, String clave){
      Usuario u;

      u=fbd.validarUsuario(idUsuario, clave);
      return u;
  }
  
  public java.util.List<Usuario> obtenerUsuarios(String id, String nombre){
        return fbd.consultarUsuarios(id, nombre);
   }
  
  public void actualizarUsuario(Usuario u, Boolean existeUsuario , Boolean clave_modificada, String idAntiguo){
      
      if (existeUsuario){
          fbd.modificarUsuario(u, clave_modificada);
      }else{
          fbd.insertarUsuario(u, idAntiguo);
      }
  }
  
  public void borrarUsuario(Usuario usuario){
      fbd.borrarUsuario(usuario);
  }
  
 
  
}
