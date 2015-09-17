/*
 * 
 */


import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.Image;


public class Plataforma extends Base implements Dimensiones {
  
    private int iDir; // cambio en x

    public Plataforma(Image image) {

        super(0, 0, image);
        iWidth= 90;
        iHeight= 20;
            
        posicionOriginal();     //posicion original
    }
    
    //funcion para mover la plataforma
    public void move() {
        iX += iDir;    //sumale a la posicion x el cambio en x
        if (iX <= 2)     //que no pase la pared de la izquierda
          iX = 2;
        if (iX+90 >= Dimensiones.PLATAFORMA_RIGHT)  //que no pase la pared de la derecha
          iX = Dimensiones.PLATAFORMA_RIGHT;
    }
    
    //Mueve la plataforma a su posicion original
    public void posicionOriginal() {
        iX = Dimensiones.WIDTH/2;
        iY = Dimensiones.HEIGTH-100;
    }
    
    public int getDx(){
      return iDir;
    }
    
    public void setDir(int iDir){
      this.iDir= iDir;
    }
}
