/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;
import gui.FachadaGui;
import baseDatos.FachadaBaseDatos;
import java.util.List;

/**
 *
 * @author alumnogreibd
 */
public class GestionCategorias {
    
    FachadaGui fgui;
    FachadaBaseDatos fbd;
    
    public GestionCategorias(FachadaGui fgui, FachadaBaseDatos fbd){
     this.fgui=fgui;
     this.fbd=fbd;
    }
    
    public List<Categoria> obtenerCategorias(String nombre){
        return fbd.consultarCategorias(nombre);
   }
    
    public void insertarCategoria(Categoria c, Boolean existeCategoria){
        if(!existeCategoria){
            fbd.insertarCategoria(c);
        }
    }
    
    public void borrarCategoria(Categoria c){
        fbd.borrarCategoria(c);
    }
    
    public void editarCategoria(String nombreAntiguo, String nuevoNombre){
        fbd.editarCategoria(nombreAntiguo, nuevoNombre);
    }
}
