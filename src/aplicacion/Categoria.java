package aplicacion;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author basesdatos
 */
public class Categoria {

    private String nombre;

   public Categoria (String nombre){
    this.nombre=nombre;
   }

   public String getNombre(){

       return this.nombre;
   }
   
   @Override
   public String toString(){
       return this.nombre;
   }
}

