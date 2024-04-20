/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aplicacion;

import java.util.List;


/**
 *
 * @author basesdatos
 */
public class FachadaAplicacion {
    gui.FachadaGui fgui;
    baseDatos.FachadaBaseDatos fbd;
    GestionUsuarios cu;
    GestionTareas ct;
    Usuario usuario;
    
    
    public FachadaAplicacion(){
      fgui =new gui.FachadaGui(this);
      fbd = new baseDatos.FachadaBaseDatos(this);
      cu = new GestionUsuarios(fgui, fbd);
      ct = new GestionTareas(fgui, fbd);
      usuario = null;
    }

    public static void main(String args[]) {
        FachadaAplicacion fa;

        fa= new FachadaAplicacion();
        fa.iniciaInterfazUsuario();
    }

    public void iniciaInterfazUsuario(){
        fgui.iniciaVista();
    }

    public void muestraExcepcion(String e){
        fgui.muestraExcepcion(e);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario us) {
        this.usuario = us;
    }
 
    public Usuario comprobarAutentificacion(String idUsuario, String clave){
        this.usuario = cu.comprobarAutentificacion(idUsuario, clave);
        return usuario;
    }

    public void ventanaUsuario(){
        fgui.ventanaUsuario();
    }
    public java.util.List<Usuario> obtenerUsuarios(String id, String nombre){
        return cu.obtenerUsuarios(id, nombre);
    }

    public void actualizarUsuario(Usuario u, Boolean existeUsuario){
        cu.actualizarUsuario(u, existeUsuario);
    }

    public void borrarUsuario(Usuario usuario){
        cu.borrarUsuario(usuario);
    }

    public void nuevaTarea(){

    }

    public void visualizarTarea(int idTarea){
        ct.visualizarTarea(idTarea);
    }

    public List<Tarea> obtenerTareas(String nombre, String categoria, Boolean completada){
        return ct.obtenerTareas(nombre, categoria, completada, usuario);
    }

    public void actualizarCompletada(int idTarea, Boolean completada) {
        ct.actualizarCompletada(idTarea, completada);
    }

    public void borrarTarea(int idTarea) {
        ct.borrarTarea(idTarea);
    }

    public void actualizarTarea(Tarea t) {
        ct.actualizarTarea(t);
    }


}
