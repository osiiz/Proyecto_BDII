/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

/**
 *
 * @author alumnogreibd
 */
public class Proyecto {
    int idProyecto;
    String nProyecto;
    String idGestor;
    
    public Proyecto(int idProyecto,String nProyecto,String idGestor){
        this.idProyecto=idProyecto;
        this.nProyecto=nProyecto;
        this.idGestor=idGestor;
    }
    
    public int getIdProyecto(){
        return idProyecto;
    }
    public String getNProyecto(){
        return nProyecto;
    }
    public String getIdGestor(){
        return idGestor;
    }
    public void setIdProyecto(int idProyecto){
        this.idProyecto=idProyecto;
    }
    public void setNProyecto(String nProyecto){
        this.nProyecto=nProyecto;
    }
    public void setIdGestor(String idGestor){
        this.idGestor=idGestor;
    }
    
    
    
    
}
