/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baseDatos;


import aplicacion.Foro;
import aplicacion.Publicacion;
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

    public void borrarForo(int idForo) {
        Connection con;
        PreparedStatement stmBorrarForo;
        con=super.getConexion();
        
        try{
            stmBorrarForo = con.prepareStatement("delete from foro where id_foro = ?");
            stmBorrarForo.setInt(1, idForo);
            stmBorrarForo.executeUpdate();
            
            stmBorrarForo.close();
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }
    }

    public List<Publicacion> buscarPublicaciones(int idForo) {
        List<Publicacion> resultado = new java.util.ArrayList<>();
        
        Publicacion publicacionActual;
        Connection con;
        PreparedStatement stmPublicaciones;
        ResultSet rsPublicaciones;
        
        con=this.getConexion();
        
        String consultaTareas = "select id_publicacion, mensaje, id_usuario, fecha from publicacion where id_foro = ? "
                + "order by fecha asc";
                
        try  {
            stmPublicaciones = con.prepareStatement(consultaTareas);
            stmPublicaciones.setInt(1, idForo);
            rsPublicaciones = stmPublicaciones.executeQuery();
            while (rsPublicaciones.next()){
                publicacionActual = new Publicacion(rsPublicaciones.getInt("id_publicacion"), 
                        rsPublicaciones.getString("mensaje"), rsPublicaciones.getString("id_usuario"),
                        rsPublicaciones.getTimestamp("fecha").toLocalDateTime());
                resultado.add(publicacionActual);
            }
            
            rsPublicaciones.close();
            stmPublicaciones.close();

        } catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }
        return resultado;
        
    }

    public void nuevaPublicacion(String text, String idUsuario, int idForo) {
        Connection con;
        PreparedStatement stmPubli;
        con=super.getConexion();
        
        try{
            stmPubli = con.prepareStatement("INSERT INTO publicacion (mensaje, id_foro, id_usuario, fecha) "
                    + "VALUES (?, ?, ?, now())");
            stmPubli.setString(1, text);
            stmPubli.setInt(2, idForo);
            stmPubli.setString(3, idUsuario);
            stmPubli.executeUpdate();
            
            stmPubli.close();
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }
    }

    public void borrarPublicacion(int idPublicacion) {
        Connection con;
        PreparedStatement stmBorrar;
        con=super.getConexion();
        
        try{
            stmBorrar = con.prepareStatement("delete from publicacion where id_publicacion = ?");
            stmBorrar.setInt(1, idPublicacion);
            stmBorrar.executeUpdate();
            
            stmBorrar.close();
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }
    }

    public void cambiarNombreForo(String nombre, int idForo) {
        Connection con;
        PreparedStatement stmCambiarNombre;
        con=super.getConexion();
        
        try{
            stmCambiarNombre = con.prepareStatement("update foro set titulo = ? where id_foro = ?");
            stmCambiarNombre.setString(1, nombre);
            stmCambiarNombre.setInt(2, idForo);
            stmCambiarNombre.executeUpdate();
            
            stmCambiarNombre.close();
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }
    }
    
}
