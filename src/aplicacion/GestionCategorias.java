/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import baseDatos.FachadaBaseDatos;
import gui.FachadaGui;
import java.util.ArrayList;
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

    public List<Categoria> buscaCategorias() {
        List<Categoria> categorias = new ArrayList<Categoria> ();

        categorias = fbd.consultarCategorias();

        return categorias;
    }

    void borrarCategoria(String nombre) {
        fbd.borrarCategoria(nombre);
    }

    void anhadirCategoria(Categoria categoria) {
        fbd.anhadirCategoria(categoria);
    }
    
}
