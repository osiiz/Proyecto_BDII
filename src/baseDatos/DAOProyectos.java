/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baseDatos;

import aplicacion.TipoUsuario;
import aplicacion.Usuario;
import aplicacion.*;
import java.sql.*;
import java.text.SimpleDateFormat;
/**
 *
 * @author alumnogreibd
 */
public class DAOProyectos extends AbstractDAO {
    
    public DAOProyectos (Connection conexion, aplicacion.FachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }
    
    
    public java.util.ArrayList<Proyecto> obtenerProyectos(Usuario usuario){
        java.util.ArrayList<Proyecto> resultado = new java.util.ArrayList<>();
        Connection con;
        PreparedStatement stmProyectos=null;
        ResultSet rsProyectos;
        Proyecto proyectoActual;
        
        
        con=this.getConexion();
        
        String consulta = "select * from proyecto as p " +
                            "where (p.id_proyecto in (select id_proyecto from participar where id_usuario = ?)) or p.id_gestor = ?";
    
        try  {
         stmProyectos=con.prepareStatement(consulta);
         stmProyectos.setString(1,usuario.getIdUsuario());
         stmProyectos.setString(2,usuario.getIdUsuario());
         rsProyectos=stmProyectos.executeQuery();
        while (rsProyectos.next())
        {
            
            proyectoActual = new Proyecto(rsProyectos.getInt("id_proyecto"), rsProyectos.getString("nombre"),
                                      rsProyectos.getString("id_gestor"));
            
            resultado.add(proyectoActual);
        }

        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmProyectos.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
        return resultado;
    }
    
    
}
