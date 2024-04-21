/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aplicacion;
import gui.FachadaGui;
import baseDatos.FachadaBaseDatos;
import java.util.List;
/**
 *
 * @author basesdatos
 */
public class GestionTareas{
    FachadaGui fgui;
    FachadaBaseDatos fbd;
    
    public GestionTareas(FachadaGui fgui, FachadaBaseDatos fbd){
     this.fgui=fgui;
     this.fbd=fbd;
    }

    public java.util.List<Tarea> obtenerTareas(String nombre, String categoria, Boolean completada, Usuario usuario, int descendente){
        return fbd.consultarTareas(nombre, categoria, completada, usuario, descendente);
    }

    public void visualizarTarea(Integer idTarea){
        List<String> restoCategorias;
        Tarea tarea;
        tarea = fbd.consultarTarea(idTarea);
        restoCategorias = fbd.obtenerRestoCategorias(idTarea);
        fgui.visualizaTarea(tarea, restoCategorias, fbd);
    }

    public void nuevaTarea(int idUsuario){
        List<String> restoCategorias;
        restoCategorias = fbd.obtenerRestoCategorias(-1);

        fgui.visualizaTarea(restoCategorias, fbd, idUsuario);
    }/*
    
    public Integer actualizarLibro(Libro l){
        
       Integer idLibro;

       if (l.getIdLibro()==null)
           idLibro=fbd.insertarLibro(l);
       else{
          fbd.modificarLibro(l);
          idLibro=l.getIdLibro();
       }

       return idLibro;
    }

    public void borrarLibro(Integer idLibro){
       fbd.borrarLibro(idLibro);
    }

    public void actualizarCategoriasLibro(Integer idLibro, java.util.List<String> categorias){
       fbd.modificarCategoriasLibro(idLibro, categorias);
    }

    public java.util.List<Ejemplar> actualizarEjemplaresLibro(Integer idLibro, java.util.List<Ejemplar> ejemplares, java.util.List<Integer> borrar){

       for (Ejemplar e:ejemplares){
        if (e.getNumEjemplar()==null) fbd.insertarEjemplarLibro(idLibro, e);
        else fbd.modificarEjemplarLibro(idLibro, e);
       }
       if (!borrar.isEmpty()){
           fbd.borrarEjemplaresLibro(idLibro, borrar);
       }
       return fbd.consultarEjemplaresLibro(idLibro);
    }*/

    public void actualizarCompletada(int idTarea, Boolean completada) {
        fbd.actualizarCompletada(idTarea, completada);
    }

    public void borrarTarea(int idTarea) {
        fbd.borrarTarea(idTarea);
    }

    public void actualizarTarea(Tarea t) {
        fbd.actualizarTarea(t);
    }

    public void eliminarCategoriaTarea(int idTarea) {
        fbd.eliminarCategoriaTarea(idTarea);
    }

    public void cambiarCategoriaTarea(int idTarea, String nombre) {
        fbd.cambiarCategoriaTarea(idTarea, nombre);
    }

    public Tarea actualizarDatosTarea(int idTarea) {
        return fbd.actualizarDatosTarea(idTarea);
    }

    public Tarea anhadirTarea(Tarea t, int idUsuario) {
        return fbd.anhadirTarea(t, idUsuario);
    }

}
