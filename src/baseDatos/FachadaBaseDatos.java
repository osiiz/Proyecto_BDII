/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDatos;

import aplicacion.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author basesdatos
 */
public class FachadaBaseDatos {
    private aplicacion.FachadaAplicacion fa;
    private java.sql.Connection conexion;
    private DAOUsuarios daoUsuarios;
    private DAOTareas daoTareas;
    private DAOForos daoForos;
    private DAOProyectos daoProyectos;
    private DAONotificaciones daoNotis;
    private DAOCategorias daoCategorias;


    public FachadaBaseDatos (aplicacion.FachadaAplicacion fa){
        
        Properties configuracion = new Properties();
        this.fa=fa;
        FileInputStream arqConfiguracion;

        try {
            arqConfiguracion = new FileInputStream("baseDatos.properties");
            configuracion.load(arqConfiguracion);
            arqConfiguracion.close();

            Properties usuario = new Properties();
     

            String gestor = configuracion.getProperty("gestor");

            usuario.setProperty("user", configuracion.getProperty("usuario"));
            usuario.setProperty("password", configuracion.getProperty("clave"));
            this.conexion=java.sql.DriverManager.getConnection("jdbc:"+gestor+"://"+
                    configuracion.getProperty("servidor")+":"+
                    configuracion.getProperty("puerto")+"/"+
                    configuracion.getProperty("baseDatos"),
                    usuario);
            
            daoUsuarios = new DAOUsuarios(conexion, fa);     
            daoTareas = new DAOTareas(conexion, fa);
            daoForos = new DAOForos(conexion, fa);
            daoProyectos = new DAOProyectos(conexion,fa);
            daoNotis = new DAONotificaciones(conexion, fa);
            daoCategorias = new DAOCategorias(conexion, fa);


        } catch (FileNotFoundException f){
            System.out.println(f.getMessage());
            fa.muestraExcepcion(f.getMessage());
        } catch (IOException | java.sql.SQLException i){
            System.out.println(i.getMessage());
            fa.muestraExcepcion(i.getMessage());
        }
        
    }
    
    

    public Usuario validarUsuario(String idUsuario, String clave){
        return daoUsuarios.validarUsuario(idUsuario, clave);
    }
   
    
    public java.util.List<Usuario> consultarUsuarios(String id, String nombre){
        return daoUsuarios.consultarUsuarios(id,nombre);
    }
    
    public void insertarUsuario(Usuario u, String idAntiguo){
        daoUsuarios.insertarUsuario(u, idAntiguo);
    }
    
    public void modificarUsuario(Usuario u, Boolean clave_modificada){
        daoUsuarios.modificarUsuario(u, clave_modificada);
    }

    public void borrarUsuario(Usuario usuario){
        daoUsuarios.borrarUsuario(usuario);
    }

    public List<Tarea> consultarTareas(String nombre, Boolean completada, Usuario usuario, int descendente) {
        return daoTareas.obtenerTareasBasicas(nombre, completada, usuario, descendente);
    }

    public void actualizarCompletada(int idTarea, Boolean completada) {
        daoTareas.actualizarCompletada(idTarea, completada);
    }

    public void borrarTarea(int idTarea) {
        daoTareas.borrarTarea(idTarea);
    }

    public Tarea consultarTarea(Integer idTarea) {
        return daoTareas.consultarTarea(idTarea);
    }

    public List<String> obtenerRestoCategorias(Integer idTarea) {
        return daoTareas.obtenerRestoCategorias(idTarea);
    }

    public void actualizarTarea(Tarea t) {
        daoTareas.actualizarTarea(t);
    }

    public void eliminarCategoriaTarea(int idTarea, String nombre) {
        daoTareas.eliminarCategoriaTarea(idTarea, nombre);
    }

    public void cambiarCategoriaTarea(int idTarea, String nombre) {
        daoTareas.cambiarCategoriaTarea(idTarea, nombre);
    }


    public Tarea anhadirTarea(Tarea t, String idUsuario) {
        return daoTareas.anhadirTarea(t, idUsuario);
    }
    
    public void nuevoForo(String text, int idProyecto) {
        daoForos.nuevoForo(text, idProyecto);
    }

    public List<Foro> obtenerForos(int idProyecto) {
        return daoForos.obtenerForos(idProyecto);
    }

    public void borrarForo(int idForo) {
        daoForos.borrarForo(idForo);
    }

    public List<Publicacion> buscarPublicaciones(int idForo) {
        return daoForos.buscarPublicaciones(idForo);
    }

    public void nuevaPublicacion(String text, String idUsuario, int idForo) {
        daoForos.nuevaPublicacion(text, idUsuario, idForo);
    }

    public void borrarPublicacion(int idPublicacion) {
        daoForos.borrarPublicacion(idPublicacion);
    }

    public void cambiarNombreForo(String nombre, int idForo) {
        daoForos.cambiarNombreForo(nombre, idForo);
    }
    
    public ArrayList<Proyecto> obtenerProyectos(Usuario usuario){
        return daoProyectos.obtenerProyectos(usuario);
    }
      
    public List<Notificacion> obtenerNotificaciones(String usuario){
        return daoNotis.obtenerNotificacionBasica(usuario);
    }
    
    public List<Tarea> notiTareaBasica(String idUsuario){
        return daoTareas.notiTareaBasica(idUsuario);
    }
    
    public List<Tarea> notiTareaProyecto(String idUsuario){
        return daoTareas.notiTareaProyecto(idUsuario);
    }
    
    public void insertarNotificacionBasica(Notificacion n, String idUsuario){
        daoNotis.insertarNotificacionBasica(n, idUsuario);
    }
    public void insertarNotificacionProyecto(Notificacion n, String idUsuario){
        daoNotis.insertarNotificacionProyecto(n, idUsuario);
    }
    
    public void borrarNotificacionBasica(int idNotificacion){
        daoNotis.borrarNotificacionBasica(idNotificacion);
    }
    
    public void borrarNotificacionProyecto(int idNotificacion){
        daoNotis.borrarNotificacionProyecto(idNotificacion);
    }
    
    public List<Categoria> consultarCategorias(String nombre){
        return daoCategorias.consultarCategorias(nombre);
    }
    
    public void insertarCategoria(Categoria c){
        daoCategorias.insertarCategoria(c);
    }
    
    public void borrarCategoria(Categoria c){
        daoCategorias.borrarCategoria(c);
    }
    
    public void editarCategoria(String nombreAntiguo, String nuevoNombre){
        daoCategorias.editarCategoria(nombreAntiguo, nuevoNombre);
    }
}
