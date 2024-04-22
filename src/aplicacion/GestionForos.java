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
public class GestionForos {

    private final FachadaGui fgui;
    private final FachadaBaseDatos fbd;

    public GestionForos(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }

    public void nuevoForo(String text, int idProyecto) {
        fbd.nuevoForo(text, idProyecto);
    }

    public List<Foro> obtenerForos(int idProyecto) {
        return fbd.obtenerForos(idProyecto);
    }

    public void borrarForo(int idForo) {
        fbd.borrarForo(idForo);
    }

    public void buscarPublicaciones(int idForo) {
        fbd.buscarPublicaciones(idForo);
    }
    
}
