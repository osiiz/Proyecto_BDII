/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baseDatos;

import java.sql.Connection;
import java.util.List;
import aplicacion.NotificacionBasica;
import java.sql.*;

/**
 *
 * @author alumnogreibd
 */
public class DAONotificaciones extends AbstractDAO{
    
    public DAONotificaciones (Connection conexion, aplicacion.FachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }
    
    public List<NotificacionBasica> obtenerNotificacionBasica(String usuario){
        List<NotificacionBasica> resultado = new java.util.ArrayList<>();
        
        NotificacionBasica notiActual;
        Connection con;
        PreparedStatement stmNotis = null;
        ResultSet rsNotis;

        con=this.getConexion();
        
        String consultaTareas = "SELECT id_notificacion, mensaje, leida, id_tarea "+
                "FROM Notificacion_basica nb "+
                "WHERE nb.id_usuario = ?";
                
        
        try  {
            stmNotis = con.prepareStatement(consultaTareas);
            stmNotis.setString(1, usuario);
            
            rsNotis = stmNotis.executeQuery();
            while (rsNotis.next()){
                notiActual = new NotificacionBasica(rsNotis.getInt("id_notificacion"), rsNotis.getString("mensaje"), rsNotis.getBoolean("leida"), 
                        rsNotis.getString("id_tarea"));

                resultado.add(notiActual);
            }

        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
            try {
                if (stmNotis != null) stmNotis.close();
            } catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
        
    }
}
