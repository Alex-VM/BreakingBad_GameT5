import javax.swing.ImageIcon;


public class Jefe extends Base implements Dimensiones {

   private int xdir;
   private int ydir;

   protected String ball = "headbreaking.png";   //Path de la imagen de la bola

   public Bola() {

     ydir = 1;  // Al iniciar el juego se ira hacia abajo

     ImageIcon ii = new ImageIcon(this.getClass().getResource(ball));
     image = ii.getImage();
     
     width = image.getWidth(null);      //ancho de la imagen
     heigth = image.getHeight(null);    //largo de la imagen

     posicionOriginal();
    }

    // Funcion que hace mover la bola
    public void move()
    {
      x += xdir;    // Aumenta la posicion x segun la velocidad x
      y += ydir;    // Aumenta la posicion y segun la velocidad y

      if (x == 0) {         //si la bola llega a la pared izquierda cambiar direccion a la derecha
        setXDir(1);
      }

      if (x == BOLA_RIGHT) {    //si la bola llega a la pared derecha cambiar direccion a la izquierda
        setXDir(-1);
      }

      if (y == 0) {     // si la bola llega al "techo" cambiar direccion a abajo
        setYDir(1);
      }
    }
    
    //Funcion para poner la bola en su posición original
    public void posicionOriginal() 
    {
      x = WIDTH/2;
      y = HEIGTH/2;
    }

    // funcion para cambiar la direccion x
    public void setXDir(int x)
    {
      xdir = x;
    }
    
    // funcion para cambiar la direccion y
    public void setYDir(int y)
    {
      ydir = y;
    }

    // funcion para obtener la direccion y
    public int getYDir()
    {
      return ydir;
    }
}
