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
    GestionForos cf;
    Usuario usuario;
    
    
    public FachadaAplicacion(){
      fgui =new gui.FachadaGui(this);
      fbd = new baseDatos.FachadaBaseDatos(this);
      cu = new GestionUsuarios(fgui, fbd);
      ct = new GestionTareas(fgui, fbd);
      cf = new GestionForos(fgui, fbd);
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
        ct.nuevaTarea(usuario.getIdUsuario());
    }

    public void visualizarTarea(int idTarea){
        ct.visualizarTarea(idTarea);
    }

    public List<Tarea> obtenerTareas(String nombre, String categoria, Boolean completada, int descendente){
        return ct.obtenerTareas(nombre, categoria, completada, usuario, descendente);
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

    public void eliminarCategoriaTarea(int idTarea) {
        ct.eliminarCategoriaTarea(idTarea);
    }

    public void cambiarCategoriaTarea(int idTarea, String nombre) {
        ct.cambiarCategoriaTarea(idTarea, nombre);
    }

    public Tarea actualizarDatosTarea(int idTarea) {
        return ct.actualizarDatosTarea(idTarea);
        
    }

    public Tarea anhadirTarea(Tarea t, String idUsuario) {
        return ct.anhadirTarea(t, idUsuario);
    }
    
    public void visualizarForos() {
        fgui.ventanaForos(usuario);
    }

    public void nuevoForo(String text, int idProyecto) {
        cf.nuevoForo(text, idProyecto);
    }

    public void obtenerForos(int idProyecto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
