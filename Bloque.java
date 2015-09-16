/*
 * 
 */
import javax.swing.ImageIcon;
import java.awt.Image;


public class Bloque extends Base {

    String brick = "methAzul.gif";  //path de la imagen del bloque

    boolean bDestruido;  // status del bloque (Destruida o no destruido)


    public Bloque(int iX, int iY, Image ima) {
      super(iX, iY, ima);

      bDestruido = false;                //cuando creas el bloque aun no esta destruido
    }
    
    //funcion que checa si un bloque esta destruido
    public boolean isDestruido()
    {
      return bDestruido;
    }
    
    //funcion para cambiar el status del bloque(destruido o no destruido)
    public void setDestruido(boolean bDestruido)
    {
      this.bDestruido = bDestruido;
    }

}
