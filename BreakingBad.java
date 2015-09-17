/**
 *
 * @author Kevin
 */

import javax.swing.JFrame;

public class BreakingBad extends JFrame{

    public BreakingBad()
    {
        add(new Juego());
        setTitle("Breaking Bad");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(Dimensiones.WIDTH, Dimensiones.HEIGTH);
        setLocationRelativeTo(null);
        setIgnoreRepaint(true);
        setResizable(false);
        setVisible(true);
    }
    
    
}
