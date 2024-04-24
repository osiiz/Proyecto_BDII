/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import baseDatos.FachadaBaseDatos;
import gui.FachadaGui;
import java.util.*;
/**
 *
 * @author alumnogreibd
 */
public class GestionProyectos {
     
    FachadaGui fgui;
    FachadaBaseDatos fbd;
    
   
    public GestionProyectos(FachadaGui fgui, FachadaBaseDatos fbd){
     this.fgui=fgui;
     this.fbd=fbd;
    }  
    
    
    public ArrayList<Proyecto> obtenerProyectos(Usuario usuario){
        return fbd.obtenerProyectos(usuario);
    }
}
