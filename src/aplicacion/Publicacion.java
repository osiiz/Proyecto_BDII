/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import java.time.LocalDateTime;

/**
 *
 * @author alumnogreibd
 */
public class Publicacion {
    private int idPublicacion;
    private String texto;
    private String idUsuario;
    private LocalDateTime fecha;

    public Publicacion(int idPublicacion, String texto, String idUsuario, LocalDateTime fecha) {
        this.idPublicacion = idPublicacion;
        this.texto = texto;
        this.idUsuario = idUsuario;
        this.fecha = fecha;
    }

    public String getTexto() {
        return texto;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public int getIdPublicacion() {
        return idPublicacion;
    }
    
    
    
    
    
    
    
    
}
