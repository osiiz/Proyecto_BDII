/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import baseDatos.FachadaBaseDatos;
import gui.FachadaGui;

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

    void nuevoForo(String text, int idProyecto) {
        fbd.nuevoForo(text, idProyecto);
    }
    
}
