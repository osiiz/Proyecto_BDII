/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baseDatos;

import aplicacion.Ejemplar;
import aplicacion.Libro;
import aplicacion.Prestamo;
import aplicacion.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author alumnogreibd
 */
class DAOPrestamos extends AbstractDAO {
    
    public DAOPrestamos (Connection conexion, aplicacion.FachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public List<Prestamo> obtenerPrestamos(String id, String nombre, int idLibro) {
        java.util.List<Prestamo> resultado = new java.util.ArrayList<>();
        Connection con;
        PreparedStatement stmPrestamos=null;
        PreparedStatement stmNumPrestamos=null;
        ResultSet rsPrestamos;
        ResultSet rsNumPrestamos;
        Prestamo prestamoActual;

        con=this.getConexion();
        
        String consulta= "select u.id_usuario, u.nombre, u.email "
                + "from usuario u "
                + "where u.id_usuario like ? "
                + "and u.nombre like ?";
        
        String consultaNumPrestamos = "select count(*) as numPrest "
                + "from prestamo p join usuario u on p.usuario = u.id_usuario "
                + "where u.id_usuario like ? "
                + "and u.nombre like ? "
                + "and fecha_devolucion is null "
                + "and now() - fecha_prestamo > '30 day'";
        
        try  {
            stmPrestamos=con.prepareStatement(consulta);
            stmNumPrestamos=con.prepareStatement(consultaNumPrestamos);
            stmPrestamos.setString(1, "%"+id+"%");
            stmPrestamos.setString(2, "%"+nombre+"%");
            rsPrestamos=stmPrestamos.executeQuery();
                 
            while (rsPrestamos.next()){
                try{
                    stmNumPrestamos.setString(1, rsPrestamos.getString("id_usuario"));
                    stmNumPrestamos.setString(2, rsPrestamos.getString("nombre"));
                    rsNumPrestamos=stmNumPrestamos.executeQuery();
                    
                    rsNumPrestamos.next();
                    prestamoActual = new Prestamo(rsPrestamos.getString("id_usuario"), rsPrestamos.getString("nombre"),
                                        rsPrestamos.getString("email"), rsNumPrestamos.getInt("numPrest"));
                    resultado.add(prestamoActual);
                }catch (SQLException e){
                    System.out.println(e.getMessage());
                    this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
                }
            }

        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {
              stmPrestamos.close();
              stmNumPrestamos.close();
          } catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }

    void devolverEjemplar(Integer idEjemplar, Integer idLibro) {
        Connection con;
        PreparedStatement stmPrestamo=null;

        con=super.getConexion();

        try {
        stmPrestamo=con.prepareStatement("UPDATE prestamo SET fecha_devolucion = now() WHERE ejemplar = ? AND libro = ?");
        stmPrestamo.setInt(1, idEjemplar);
        stmPrestamo.setInt(2, idLibro);
        stmPrestamo.executeUpdate();

        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmPrestamo.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }

    void prestarEjemplar(Integer numEjemplar, Integer idLibro, String idUsuario) {
        Connection con;
        PreparedStatement stmPrestamo=null;

        con=super.getConexion();
        
        try{
            stmPrestamo=con.prepareStatement("INSERT INTO prestamo VALUES (?, ?, ?, now(), NULL, now() + INTERVAL '30 day' )");
            stmPrestamo.setString(1, idUsuario);
            stmPrestamo.setInt(2, idLibro);
            stmPrestamo.setInt(3, numEjemplar);
            stmPrestamo.executeUpdate();
       }catch (SQLException e){
           System.out.println(e.getMessage());
           this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
       }finally{
            try{
                stmPrestamo.close();
            }catch (SQLException e){
                System.out.println("Imposible cerrar cursores");
            }
        }
    }
    
    
    
}
