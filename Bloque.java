/*
 * 
 */
import javax.swing.ImageIcon;
import java.awt.Image;


public class Bloque extends Base {

    boolean bDestruido;  // status del bloque (Destruida o no destruido)
    boolean bExplosivo;


    public Bloque(int iX, int iY, Image ima, boolean exp) {
      super(iX, iY, ima);
      iWidth= 80;
      iHeight= 40;
      bExplosivo= exp;
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
    
    public void setExplosivo(boolean bExp){
      this.bExplosivo= bExp;
    }
    
    public boolean isExplosivo(){
      return bExplosivo;
    }

}
