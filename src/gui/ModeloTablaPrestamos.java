/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import aplicacion.Prestamo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alumnogreibd
 */
public class ModeloTablaPrestamos extends AbstractTableModel {
    private List<Prestamo> prestamos;
    
    public ModeloTablaPrestamos(){
        this.prestamos = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return prestamos.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Object resultado = null;
        
        switch (col){
            case 0: resultado= prestamos.get(row).getIdUsuario(); break;
            case 1: resultado= prestamos.get(row).getNombreUsuario(); break;
            case 2: resultado=prestamos.get(row).getEmailUsuario();break;
            case 3: resultado=prestamos.get(row).getNumPrestamos(); break;
        }
        return resultado;
    }
    
    public void setFilas(List<Prestamo> prestamos){
        this.prestamos=prestamos;
        fireTableDataChanged();
    }

    public Prestamo obtenerPrestamo(int i){
        return this.prestamos.get(i);
    }
    
    @Override
    public String getColumnName(int col){
        String nombre="";

        switch (col){
            case 0: nombre= "Id ejemplar"; break;
            case 1: nombre= "Nombre"; break;
            case 2: nombre="E-mail"; break;
            case 3: nombre="Préstamos vencidos"; break;
        }
        return nombre;
    }
    
    @Override
    public Class getColumnClass(int col){
        Class clase=null;

        switch (col){
            case 0: clase= java.lang.Integer.class; break;
            case 1: clase= java.lang.String.class; break;
            case 2: clase=java.lang.String.class; break;
            case 3: clase=java.lang.Integer.class; break;
        }
        return clase;
    }

    @Override
    public boolean isCellEditable(int row, int col){
        return false;
    }
    
}


