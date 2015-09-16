/**
 * Clase Corazon
 *
 * @author Alejandro Villaseñor
 * @version 1.00 2015/9/2
 */
import java.awt.Image;

public class Corazon extends Base {
  
  boolean bEncendido; //Variable que dice si aparece o no el corazon

 /**
  * Metodo constructor que hereda los atributos de la clase <code>Objeto</code>.
  * @param posX es la <code>posiscion en x</code> del objeto.
  * @param posY es el <code>posiscion en y</code> del objeto.
  * @param image es la <code>imagen</code> del objeto.
  */
 public Corazon(int posX,int posY,Image image, boolean bOn){
  super(posX,posY,image);
  bEncendido= bOn;
 }
 
 /**
  * Metodo de acceso que regresa si el corazon esta encendido 
  * @return bEncendido es si el <code>Corazon</code> esta encendido.
  */
 public boolean getEncendido(){
   return bEncendido;
 }
 
 /**
  * Metodo modificador usado para cambiar el estatus del Corazon 
  * @param bOn es el nuevo estatus del <code>Corazon</code>.
  */
 public void setEncendido(boolean bOn) {
  bEncendido= bOn;
 }
 
}
