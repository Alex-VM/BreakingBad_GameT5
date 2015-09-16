/*
 * 
 */

import javax.swing.ImageIcon;
import java.awt.Image;


public class Bola extends Base implements Dimensiones {

   private int iDirX;
   private int iDirY;

   protected String ball = "bola.gif";   //Path de la imagen de la bola

   public Bola(Image image) {
     
     super(0,0, image);
     iWidth= 30;
     iHeight= 30;
     iDirY = 1;  // Al iniciar el juego se ira hacia abajo
     posicionOriginal();
    }

    // Funcion que hace mover la bola
    public void move()
    {
      iX += iDirX;    // Aumenta la posicion x segun la velocidad x
      iY += iDirY;    // Aumenta la posicion y segun la velocidad y

      if (iX == 0) {         //si la bola llega a la pared izquierda cambiar direccion a la derecha
        setXDir(1);
      }

      if (iX == bola_RIGHT) {    //si la bola llega a la pared derecha cambiar direccion a la izquierda
        setXDir(-1);
      }

      if (iY == 0) {     // si la bola llega al "techo" cambiar direccion a abajo
        setYDir(1);
      }
    }
    
    //Funcion para poner la bola en su posición original
    public void posicionOriginal() 
    {
      iX = WIDTH/2;
      iY = HEIGTH/2;
    }

    // funcion para cambiar la direccion x
    public void setXDir(int iX)
    {
      iDirX = iX;
    }
    
    // funcion para cambiar la direccion y
    public void setYDir(int iY)
    {
      iDirY = iY;
    }

    // funcion para obtener la direccion y
    public int getYDir()
    {
      return iDirY;
    }
}
