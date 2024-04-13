/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDatos;
import aplicacion.Usuario;
import aplicacion.TipoUsuario;
import java.sql.*;
/**
 *
 * @author basesdatos
 */
public class DAOUsuarios extends AbstractDAO {

    public DAOUsuarios (Connection conexion, aplicacion.FachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public Usuario validarUsuario(String idUsuario, String clave){
        Usuario resultado=null;
        Connection con;
        PreparedStatement stmUsuario=null;
        ResultSet rsUsuario;

        con=this.getConexion();

        try {
        stmUsuario=con.prepareStatement("select id_usuario, clave, nombre, direccion, email, tipo_usuario "+
                                        "from usuario "+
                                        "where id_usuario = ? and clave = ?");
        stmUsuario.setString(1, idUsuario);
        stmUsuario.setString(2, clave);
        rsUsuario=stmUsuario.executeQuery();
        if (rsUsuario.next())
        {
            resultado = new Usuario(rsUsuario.getString("id_usuario"), rsUsuario.getString("clave"),
                                      rsUsuario.getString("nombre"), rsUsuario.getString("direccion"),
                                      rsUsuario.getString("email"), TipoUsuario.valueOf(rsUsuario.getString("tipo_usuario")));

        }
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }
    
    
    public java.util.List<Usuario> consultarUsuarios(String id, String nombre){
        java.util.List<Usuario> resultado = new java.util.ArrayList<Usuario>();
        Usuario usuarioActual;
        Connection con;
        PreparedStatement stmUsuarios=null;
        ResultSet rsUsuarios;

        con=this.getConexion();
        
        String consulta = "select id_usuario, nombre, email, tipo_usuario, clave, direccion " +
                                         "from usuario as u " +
                                         "where id_usuario like ?" +
                                         "and nombre like ?";
    
        try  {
         stmUsuarios=con.prepareStatement(consulta);
         stmUsuarios.setString(1, "%"+id+"%");
         stmUsuarios.setString(2, "%"+nombre+"%");
         rsUsuarios=stmUsuarios.executeQuery();
        while (rsUsuarios.next())
        {
            usuarioActual = new Usuario(rsUsuarios.getString("id_usuario"), rsUsuarios.getString("clave"),
                                      rsUsuarios.getString("nombre"), rsUsuarios.getString("direccion"),
                                      rsUsuarios.getString("email"), TipoUsuario.valueOf(rsUsuarios.getString("tipo_usuario")));
            
            resultado.add(usuarioActual);
        }

        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmUsuarios.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }
    
    public void insertarUsuario(Usuario u){
        Connection con;
        PreparedStatement stmUsuario=null;

        con=super.getConexion();

        try {
        stmUsuario=con.prepareStatement("insert into usuario(id_usuario, nombre, email, tipo_usuario, clave, direccion) "+
                                      "values (?,?,?,?,?,?)");
        stmUsuario.setString(1, u.getIdUsuario());
        stmUsuario.setString(2, u.getNombre());
        stmUsuario.setString(3, u.getEmail());
        stmUsuario.setString(4, u.getTipoUsuario().toString());
        stmUsuario.setString(5, u.getClave());
        stmUsuario.setString(6, u.getDireccion());
        stmUsuario.executeUpdate();

        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
    
    public void modificarUsuario(Usuario u){
        Connection con;
        PreparedStatement stmUsuario=null;

        con=super.getConexion();

        try {
        stmUsuario=con.prepareStatement("update usuario "+
                                    "set nombre=?, "+
                                    "    email=?, "+
                                    "    tipo_usuario=?, "+
                                    "    clave=?, "+
                                    "    direccion=? "+
                                    "where id_usuario=?");
        stmUsuario.setString(1, u.getNombre());
        stmUsuario.setString(2, u.getEmail());
        stmUsuario.setString(3, u.getTipoUsuario().toString());
        stmUsuario.setString(4, u.getClave());
        stmUsuario.setString(5,u.getDireccion());
        stmUsuario.setString(6, u.getIdUsuario());
        stmUsuario.executeUpdate();

        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
    }
    
    public void borrarUsuario(String idUsuario){
        Connection con = super.getConexion();
        PreparedStatement stmUsuario=null;
        PreparedStatement stmPrestamos=null;
        ResultSet rsPrestamos = null;
        
        try{
            stmPrestamos=con.prepareStatement("select * from prestamo where usuario = ?");
            stmUsuario = con.prepareStatement("delete from usuario where id_usuario = ? ");
            
            stmUsuario.setString(1, idUsuario);
            stmPrestamos.setString(1, idUsuario);
            
            rsPrestamos = stmPrestamos.executeQuery();
            if (rsPrestamos.next()){
                this.getFachadaAplicacion().muestraExcepcion("No se puede eliminar un usuario con préstamos");
                    try {stmPrestamos.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
                    return;
            }
            stmUsuario.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {if (stmUsuario != null) stmUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }

   
}
