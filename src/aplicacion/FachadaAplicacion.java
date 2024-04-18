/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aplicacion;

import gui.VLibro;
import java.util.List;


/**
 *
 * @author basesdatos
 */
public class FachadaAplicacion {
    gui.FachadaGui fgui;
    baseDatos.FachadaBaseDatos fbd;
    GesionLibros cl;
    GestionUsuarios cu;
    GestionCategorias cc;
    GestionPrestamos cp;
    Usuario usuario;
    
    
 public FachadaAplicacion(){
   fgui =new gui.FachadaGui(this);
   fbd = new baseDatos.FachadaBaseDatos(this);
   cl = new GesionLibros(fgui, fbd);
   cu = new GestionUsuarios(fgui, fbd);
   cc = new GestionCategorias(fgui, fbd);
   cp = new GestionPrestamos(fgui, fbd);
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
 
public java.util.List<Libro> obtenerLibros(Integer id, String titulo, String isbn, String autor){
  return cl.obtenerLibros(id, titulo,  isbn,  autor);
};

public void visualizarLibro(Integer idLibro){
 cl.visualizarLibro(idLibro);
}

public void nuevoLibro(){
 cl.nuevoLibro();
}

public Integer actualizarLibro(Libro l){
  return cl.actualizarLibro(l);
}

public void borrarLibro(Integer idLibro){
   cl.borrarLibro(idLibro);
}

public void actualizarCategoriasLibro(Integer idLibro, java.util.List<String> categorias){
 cl.actualizarCategoriasLibro(idLibro, categorias);
}

public java.util.List<Ejemplar> actualizarEjemplaresLibro(Integer idLibro, java.util.List<Ejemplar> ejemplares, java.util.List<Integer> borrar){
  return cl.actualizarEjemplaresLibro(idLibro, ejemplares, borrar);
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

public void ventanaCategorias(){
    fgui.ventanaCategorias();
}

public List<Categoria> buscaCategorias() {
    return cc.buscaCategorias();
}

public void borrarCategoria(String nombre) {
    cc.borrarCategoria(nombre);
}

public void anhadirCategoria(Categoria categoria) {
    cc.anhadirCategoria(categoria);
}

public List<Prestamo> obtenerPrestamos(String id, String nombre, int numEjemplar) {
    return cp.obtenerPrestamos(id, nombre, numEjemplar);
}

    public void ventanaPrestamos(Ejemplar ejemplar, VLibro vlibro) {
        fgui.ventanaPrestamos(ejemplar, vlibro);
    }

    public void devolverEjemplar(Integer idEjemplar, Integer idLibro) {
        cp.devolverEjemplar(idEjemplar, idLibro);
    }

    public void prestarEjemplar(Integer numEjemplar, Integer idLibro, String idUsuario) {
        cp.prestarEjemplar(numEjemplar, idLibro, idUsuario);
    }




}
