/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDatos;
import aplicacion.Categoria;
import java.sql.*;
/**
 *
 * @author basesdatos
 */
public class DAOCategorias extends AbstractDAO {
   
    
    public DAOCategorias (Connection conexion, aplicacion.FachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public java.util.List<Categoria> consultarCategorias(){
        java.util.List<Categoria> resultado = new java.util.ArrayList<Categoria>();
        Categoria categoriaActual;
        Connection con;
        PreparedStatement stmCategorias=null;
        ResultSet rsCategorias;

        con=this.getConexion();

        try  {
        stmCategorias=con.prepareStatement("select nombre, descripcion from categoria");
        rsCategorias=stmCategorias.executeQuery();
        while (rsCategorias.next())
        {
            categoriaActual = new Categoria(rsCategorias.getString("nombre"), rsCategorias.getString("descripcion"));
            resultado.add(categoriaActual);
        }

        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmCategorias.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }

    void borrarCategoria(String nombre) {
        Connection con;
        PreparedStatement stmCategorias = null;
        
        con=this.getConexion();
        
        try{
            stmCategorias = con.prepareStatement("delete from categoria where nombre = ?");
            stmCategorias.setString(1, nombre);
            stmCategorias.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmCategorias.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }

    void anhadirCategoria(Categoria categoria) {
        Connection con;
        PreparedStatement stmCategorias=null;

        con=super.getConexion();

        try {
        stmCategorias=con.prepareStatement("insert into categoria(nombre, descripcion) "+
                                      "values (?,?)");
        stmCategorias.setString(1, categoria.getNombre());
        stmCategorias.setString(2, categoria.getDescripcion());
        stmCategorias.executeUpdate();

        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmCategorias.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }


   

}
