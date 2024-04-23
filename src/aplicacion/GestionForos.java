/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import baseDatos.FachadaBaseDatos;
import gui.FachadaGui;
import gui.VForos;
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

    public List<Publicacion> buscarPublicaciones(int idForo) {
        return fbd.buscarPublicaciones(idForo);
    }

    public void ventanaPublicaciones(Foro foro, VForos vf) {
        fgui.ventanaPublicaciones(foro, vf);
    }

    public void nuevaPublicacion(String text, String idUsuario, int idForo) {
        fbd.nuevaPublicacion(text, idUsuario, idForo);
    }

    public void borrarPublicacion(int idPublicacion) {
        fbd.borrarPublicacion(idPublicacion);
    }

    public void ventanaBorrarPublicaciones(int idForo) {
        fgui.ventanaBorrarPublicaciones(idForo);
    }

    public void cambiarNombreForo(String nombre, int idForo) {
        fbd.cambiarNombreForo(nombre, idForo);

    }
    
}
