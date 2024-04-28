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
    
    public void insertarNotificacionBasica(Notificacion n, String idUsuario){
        fbd.insertarNotificacionBasica(n, idUsuario);
    }
    
    public void insertarNotificacionProyecto(Notificacion n, String idUsuario){
        fbd.insertarNotificacionProyecto(n, idUsuario);
    }
    
    public void borrarNotificacionBasica(int idNotificacion){
        fbd.borrarNotificacionBasica(idNotificacion);
    }
    
    public void borrarNotificacionProyecto(int idNotificacion){
        fbd.borrarNotificacionProyecto(idNotificacion);
    }
}
