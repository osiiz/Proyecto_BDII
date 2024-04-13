/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

/**
 *
 * @author alumnogreibd
 */
public class Prestamo {
    String idUsuario;
    String nombreUsuario;
    String emailUsuario;
    int numPrestamos;
    
    public Prestamo(String idUsuario, String nombreUsuario, String emailUsuario, int numPrestamos){
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.emailUsuario = emailUsuario;
        this.numPrestamos = numPrestamos;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public int getNumPrestamos() {
        return numPrestamos;
    }

    public void setNumPrestamos(int numPrestamos) {
        this.numPrestamos = numPrestamos;
    }
    
    

    
    
    
}
