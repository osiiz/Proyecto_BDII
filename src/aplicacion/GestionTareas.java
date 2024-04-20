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

    public java.util.List<Tarea> obtenerTareas(String nombre, String categoria, Boolean completada, Usuario usuario){
        return fbd.consultarTareas(nombre, categoria, completada, usuario);
    }

    public void visualizarTarea(Integer idTarea){
        List<String> restoCategorias;
        Tarea tarea;
        tarea = fbd.consultarTarea(idTarea);
        restoCategorias = fbd.obtenerRestoCategorias(idTarea);
        fgui.visualizaTarea(tarea, restoCategorias);
    }

    public void nuevoLibro(){
        /*java.util.List<String> restoCategorias = new java.util.ArrayList<String> ();

        for(Categoria c:fbd.consultarCategorias()){
            restoCategorias.add(c.getNombre());
        }

        fgui.nuevaTarea(restoCategorias);*/
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

    void actualizarCompletada(int idTarea, Boolean completada) {
        fbd.actualizarCompletada(idTarea, completada);
    }

    void borrarTarea(int idTarea) {
        fbd.borrarTarea(idTarea);
    }
}
