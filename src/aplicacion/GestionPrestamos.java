/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import baseDatos.FachadaBaseDatos;
import gui.FachadaGui;
import java.util.List;

/**
 *
 * @author alumnogreibd
 */
class GestionPrestamos {
    
    FachadaGui fgui;
    FachadaBaseDatos fbd;
    
   
    public GestionPrestamos(FachadaGui fgui, FachadaBaseDatos fbd){
     this.fgui=fgui;
     this.fbd=fbd;
    }  

    public List<Prestamo> obtenerPrestamos(String id, String nombre, int numEjemplar) {
        return fbd.obtenerPrestamos(id, nombre, numEjemplar);
    }

    void devolverEjemplar(Integer idEjemplar, Integer idLibro) {
        fbd.devolverEjemplar(idEjemplar, idLibro);
    }

    void prestarEjemplar(Integer numEjemplar, Integer idLibro, String idUsuario) {
        fbd.prestarEjemplar(numEjemplar, idLibro, idUsuario);
    }
    
}
