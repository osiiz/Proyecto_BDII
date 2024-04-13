/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import java.time.LocalDate;

/**
 *
 * @author basesdatos
 */
public class Ejemplar {

    private Integer numEjemplar;
    private String localizador;
    private String anoCompra;
    private Integer idLibro;
    private String idUsuario;
    private LocalDate fechaPrestamo;
    private LocalDate fechaVencimiento;

    public Ejemplar(Integer idLibro, Integer numEjemplar, String localizador, String anoCompra, String nombreUsuario, LocalDate fechaPrestamo, LocalDate fechaVencimiento) {
        this.numEjemplar = numEjemplar;
        this.anoCompra = anoCompra;
        this.localizador = localizador;
        this.idLibro = idLibro;
        this.idUsuario = nombreUsuario;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaVencimiento = fechaVencimiento;
    }

    public Integer getNumEjemplar() {
        return this.numEjemplar;
    }

    public String getAnoCompra() {
        return this.anoCompra;
    }

    public String getLocalizador() {
        return this.localizador;
    }

    public Integer getIdLibro() {
        return this.idLibro;
    }

    public void setLocalizador(String l) {
        localizador = l;
    }

    public void setAnoCompra(String a) {
        anoCompra = a;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public void setNumEjemplar(Integer numEjemplar) {
        this.numEjemplar = numEjemplar;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }
    
    

}
