/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

/**
 *
 * @author alumnogreibd
 */
public class NotificacionBasica {
    private int idNotificacion;
    private String mensaje;
    private boolean leida;
    private String idTarea;

    public NotificacionBasica(int idNotificacion, String mensaje, boolean leida, String idTarea) {
        this.idNotificacion = idNotificacion;
        this.mensaje = mensaje;
        this.leida = leida;
        this.idTarea = idTarea;
    }

    public int getIdNotificacion() {
        return idNotificacion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public boolean isLeida() {
        return leida;
    }

    public String getIdTarea() {
        return idTarea;
    }

    public void setIdNotificacion(int idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setLeida(boolean leida) {
        this.leida = leida;
    }

    public void setIdTarea(String idTarea) {
        this.idTarea = idTarea;
    }
    
    
    
}
