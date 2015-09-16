/*
 * 
 */


import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.Image;


public class Plataforma extends Base implements Dimensiones {

    String plat = "barra.gif";    //path de la imagen de la plataforma

    int dx; // cambio en x

    public Plataforma(Image image) {

        super(0, 0, image);
            
        posicionOriginal();     //posicion original
    }
    
    //funcion para mover la plataforma
    public void move() {
        iX += dx;    //sumale a la posicion x el cambio en x
        if (iX <= 2)     //que no pase la pared de la izquierda
          iX = 2;
        if (iX >= Dimensiones.PLATAFORMA_RIGHT)  //que no pase la pared de la derecha
          iX = Dimensiones.PLATAFORMA_RIGHT;
    }
    
    //detecta las teclas que presionas, cambiara el cambio en x dependiendo a la flechita que presiones
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {  //presiona flecha izq para moverlo a la izq
            dx = -2;

        }

        if (key == KeyEvent.VK_RIGHT) { //presiona flecha der para moverlo a la der
            dx = 2;
        }
    }
    
    // detecta cuando sueltas la tecla, dejara de moverse cuando sueltes la tecla
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }
    }
    
    //Mueve la plataforma a su posicion original
    public void posicionOriginal() {
        iX = Dimensiones.WIDTH/2;
        iY = Dimensiones.HEIGTH-100;
    }
}
