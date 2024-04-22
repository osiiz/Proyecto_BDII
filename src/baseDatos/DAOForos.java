/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baseDatos;


import aplicacion.Foro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author alumnogreibd
 */
public class DAOForos extends AbstractDAO {
    
    public DAOForos (Connection conexion, aplicacion.FachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public void nuevoForo(String text, int idProyecto) {
        Connection con;
        PreparedStatement stmForo;
        con=super.getConexion();
        
        try{
            stmForo = con.prepareStatement("insert into foro (titulo, id_proyecto) values (?, ?) ");
            stmForo.setString(1, text);
            stmForo.setInt(2, idProyecto);
            stmForo.executeUpdate();
            
            stmForo.close();
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }
    }
    
    public List<Foro> obtenerForos(int idProyecto){
        List<Foro> resultado = new java.util.ArrayList<>();
        
        Foro foroActual;
        Connection con;
        PreparedStatement stmForos;
        ResultSet rsForos;
        
        con=this.getConexion();
        
        String consultaTareas = "select id_foro, titulo, id_proyecto from foro where id_proyecto = ?";
                
        try  {
            stmForos = con.prepareStatement(consultaTareas);
            stmForos.setInt(1, idProyecto);
            rsForos = stmForos.executeQuery();
            while (rsForos.next()){
                foroActual = new Foro(rsForos.getInt("id_foro"), rsForos.getString("titulo"), rsForos.getInt("id_proyecto"));
                resultado.add(foroActual);
            }
            
            rsForos.close();
            stmForos.close();

        } catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }
        return resultado;
        
        
    }
    
}
