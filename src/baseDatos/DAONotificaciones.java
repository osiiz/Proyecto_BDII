/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baseDatos;

import java.sql.Connection;
import java.util.List;
import aplicacion.Notificacion;
import aplicacion.TipoNotificacion;
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
    
    public List<Notificacion> obtenerNotificacionBasica(String usuario){
        List<Notificacion> resultado = new java.util.ArrayList<>();
        
        Notificacion notiActual;
        Connection con;
        PreparedStatement stmNotis = null;
        ResultSet rsNotis;

        con=this.getConexion();
        
        String consultaTareas = "SELECT id_notificacion, mensaje, leida, fecha, id_tarea, 'Basica' as Tipo "+
                "FROM Notificacion_basica nb "+
                "WHERE nb.id_usuario = ? "+
                "UNION "+
                "SELECT id_notificacion, mensaje, leida, fecha, id_tarea, 'Proyecto' as Tipo " +
                "FROM Notificacion_de_proyecto np, tener_notificacion_de_proyecto tnp " +
                "WHERE tnp.notificacion = np.id_notificacion "+
                "AND tnp.usuario = ? "+
                "ORDER BY fecha desc";
                
        
        try  {
            stmNotis = con.prepareStatement(consultaTareas);
            stmNotis.setString(1, usuario);
            stmNotis.setString(2, usuario);
            
            rsNotis = stmNotis.executeQuery();
            while (rsNotis.next()){
                if(rsNotis.getString("Tipo").equals("Basica"))
                    notiActual = new Notificacion(rsNotis.getInt("id_notificacion"), rsNotis.getString("mensaje"), rsNotis.getBoolean("leida"), 
                        rsNotis.getString("fecha"),rsNotis.getInt("id_tarea"), TipoNotificacion.Basica);
                else
                    notiActual = new Notificacion(rsNotis.getInt("id_notificacion"), rsNotis.getString("mensaje"), rsNotis.getBoolean("leida"), 
                        rsNotis.getString("fecha") ,rsNotis.getInt("id_tarea"), TipoNotificacion.Proyecto);

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
    
    public void insertarNotificacionBasica(Notificacion n, String idUsuario){
        Connection con;
        PreparedStatement stmNoti=null;

        con=super.getConexion();

        try {
                    stmNoti=con.prepareStatement("insert into Notificacion_basica(mensaje, leida, fecha, id_tarea, id_usuario) "+
                                              "values (?,?,?,?,?)");
                    stmNoti.setString(1, n.getMensaje());
                    stmNoti.setBoolean(2, n.isLeida());
                    stmNoti.setString(3, n.getFecha());
                    stmNoti.setInt(4, n.getIdTarea());
                    stmNoti.setString(5, idUsuario);
                    
                    stmNoti.executeUpdate();
            
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmNoti.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
        
    }
    
    public void insertarNotificacionProyecto(Notificacion n, String idUsuario){
        Connection con;
        PreparedStatement stmNoti=null;

        con=super.getConexion();

        try {
                    stmNoti=con.prepareStatement("insert into Notificacion_de_proyecto(mensaje, leida, fecha, id_tarea) "+
                                              "values (?,?,?,?)");
                    stmNoti.setString(1, n.getMensaje());
                    stmNoti.setBoolean(2, n.isLeida());
                    stmNoti.setString(3, n.getFecha());
                    stmNoti.setInt(4, n.getIdTarea());
                    
                    stmNoti.executeUpdate();
                    
                    stmNoti=con.prepareStatement("insert into Tener_notificacion_de_proyecto(usuario, notificacion) "+
                                              "values (?,?)");
                    stmNoti.setString(1, idUsuario);
                    stmNoti.setInt(2, n.getIdNotificacion());
                    
                    stmNoti.executeUpdate();
            
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmNoti.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
}
