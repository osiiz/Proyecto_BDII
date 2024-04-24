/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;
import java.util.List;
import gui.FachadaGui;
import baseDatos.FachadaBaseDatos;

/**
 *
 * @author alumnogreibd
 */
public class GestionNotificaciones {
    
    FachadaGui fgui;
    FachadaBaseDatos fbd;

    public GestionNotificaciones(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }
    
    public List<Notificacion> obtenerNotificaciones(String usuario){
        return fbd.obtenerNotificaciones(usuario);
    }
    
}
