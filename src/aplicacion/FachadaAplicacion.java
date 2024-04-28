/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aplicacion;

import gui.VForos;
import java.util.ArrayList;
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
    GestionNotificaciones cn;
    GestionForos cf;
    GestionProyectos gp;
    Usuario usuario;
    
    
    public FachadaAplicacion(){
      fgui =new gui.FachadaGui(this);
      fbd = new baseDatos.FachadaBaseDatos(this);
      cu = new GestionUsuarios(fgui, fbd);
      ct = new GestionTareas(fgui, fbd);
      cn = new GestionNotificaciones(fgui, fbd);
      cf = new GestionForos(fgui, fbd);
      gp = new GestionProyectos(fgui,fbd);
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
 
    public Usuario comprobarAutentificacion(String idUsuario, String clave){
        this.usuario = cu.comprobarAutentificacion(idUsuario, clave);
        return usuario;
    }

    public void ventanaUsuario(){
        fgui.ventanaUsuario();
    }
    public void ventanaNotificaciones(){
        fgui.ventanaNotificaciones();
    }
    public java.util.List<Usuario> obtenerUsuarios(String id, String nombre){
        return cu.obtenerUsuarios(id, nombre);
    }

    public void actualizarUsuario(Usuario u, Boolean existeUsuario, Boolean clave_cambiada, String idAntiguo){
        cu.actualizarUsuario(u, existeUsuario, clave_cambiada, idAntiguo);
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

    public List<Tarea> obtenerTareas(String nombre, Boolean completada, int descendente){
        return ct.obtenerTareas(nombre, completada, usuario, descendente);
    }
    
    public List<Notificacion> obtenerNotificaciones(){
        return cn.obtenerNotificaciones(usuario.getIdUsuario());
    }

    public void actualizarCompletada(int idTarea, Boolean completada) {
        ct.actualizarCompletada(idTarea, completada);
    }

    public void borrarTarea(int idTarea) {
        ct.borrarTarea(idTarea);
    }
    
    public Tarea consultarTarea(int idTarea){
        return ct.consultarTarea(idTarea);
    }
    
    public void actualizarTarea(Tarea tarea){
        ct.actualizarTarea(tarea);
    }


    public void eliminarCategoriaTarea(int idTarea, String nombre) {
        ct.eliminarCategoriaTarea(idTarea, nombre);
    }

    public void cambiarCategoriaTarea(int idTarea, String nombre) {
        ct.cambiarCategoriaTarea(idTarea, nombre);
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

    public List<Foro> obtenerForos(int idProyecto) {
        return cf.obtenerForos(idProyecto);
        
    }

    public void ventanaNuevoForo(int idProyecto) {
        fgui.ventanaNuevoForo(idProyecto);
    }

    public void borrarForo(int idForo) {
        cf.borrarForo(idForo);
    }

    public List<Publicacion> buscarPublicaciones(int idForo) {
        return cf.buscarPublicaciones(idForo);
    }
    
    public void ventanaPublicaciones(Foro foro, VForos vf){
        cf.ventanaPublicaciones(foro, vf);
    }

    public void nuevaPublicacion(String text, String idUsuario, int idForo) {
        cf.nuevaPublicacion(text, idUsuario, idForo);
    }

    public void borrarPublicacion(int idPublicacion) {
        cf.borrarPublicacion(idPublicacion);
    
    }

    public void ventanaBorrarPublicacion(int idForo) {
        cf.ventanaBorrarPublicaciones(idForo);
    }

    public void cambiarNombreForo(String nombre, int idForo) {
        cf.cambiarNombreForo(nombre, idForo);
    }


    public void nuevoVPrincipalProyectos() {
        fgui.nuevoVPProyecto();
    }

    public ArrayList<Proyecto> obtenerProyectos(Usuario usuario) {
        return gp.obtenerProyectos(usuario);
    }

    public void nuevoVProyecto(Proyecto p) {
        fgui.nuevoVProyecto(p);
    }
       
    
    public List<Tarea> notiTareaBasica(){
        return ct.notiTareaBasica(usuario.getIdUsuario());
    }
    
    public List<Tarea> notiTareaProyecto(){
        return ct.notiTareaProyecto(usuario.getIdUsuario());
    }
    
    public void insertarNotificacionBasica(Notificacion n){
        cn.insertarNotificacionBasica(n, usuario.getIdUsuario());
    }
    
    public void insertarNotificacionProyecto(Notificacion n){
        cn.insertarNotificacionProyecto(n, usuario.getIdUsuario());
    }
    
    public void borrarNotificacionBasica(int idNotificacion){
        cn.borrarNotificacionBasica(idNotificacion);
    }
    
    public void borrarNotificacionProyecto(int idNotificacion){
        cn.borrarNotificacionProyecto(idNotificacion);
    }
}
