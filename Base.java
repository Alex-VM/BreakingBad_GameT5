/*
 * 
 * 
 */

import java.awt.Image;
import java.awt.Rectangle;

public class Base {     //Objeto Base. Bloque, bola, y plataforma son hijos de BASE
    
    protected int iX;        //posicion x
    protected int iY;        //posicion y
    protected int iWidth;    //ancho
    protected int iHeight;   //largo
    protected Image imaImage;  //imagen
    
    public Base(int iX, int iY, Image imaImage){
      this.iX= iX;
      this.iY= iY;
      this.imaImage= imaImage;
    }

    //funcion para cambiar posicion x
    public void setX(int iX) {
        this.iX = iX;
    }
    //funcion para obtener posicion x
    public int getX() {
        return iX;
    }
    
    //funcion para cambiar posicion y
    public void setY(int iY) {
        this.iY = iY;
    }

    //funcion para obtener posicion y
    public int getY() {
        return iY;
    }
    
    //obtener ancho
    public int getWidth() {
        return iWidth;
    }
    
    //obtener largo
    public int getHeight() {
        return iHeight;
    }

    //obtener imagen
    Image getImage()
    {
      return imaImage;
    }

    //obtener rectangulo
    Rectangle getRect()
    {
      return new Rectangle(iX, iY, 
          imaImage.getWidth(null), imaImage.getHeight(null));
    }
}
