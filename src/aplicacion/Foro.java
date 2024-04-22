/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

/**
 *
 * @author alumnogreibd
 */
public class Foro {
    private int idForo;
    private String titulo;
    private int idProyecto;
    
    public Foro (int idForo, String titulo, int idProyecto){
        this.idForo = idForo;
        this.titulo = titulo;
        this.idProyecto = idProyecto;
    }

    public int getIdForo() {
        return idForo;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getIdProyecto() {
        return idProyecto;
    }
    
    
    
}
