/*
 *
 * 
 */

import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.net.URL;
import  sun.audio.*;
import  java.io.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;


public class Juego extends JPanel implements Dimensiones {
  
  Image ii;
  Timer timer;
  String sMessage;
  Bola bolBola;
  Plataforma plaPlataforma;
  Bloque bloBloques[];
  Corazon corCorazones[];
  
  boolean bOver;
  int timerId;
  int iVidas;
  
  public Juego() {
    
    addKeyListener(new TAdapter());
    setFocusable(true);
    
    setDoubleBuffered(true);
    timer = new Timer();
    timer.scheduleAtFixedRate(new ScheduleTask(), 1000, 10);
  }
  
  public void addNotify() {
    super.addNotify();
    init();
  }
  
  public void init() {
    
    URL bURL = this.getClass().getResource("bola.gif");
    URL pURL = this.getClass().getResource("barra.gif");
    URL hURL = this.getClass().getResource("heart.gif");
    URL bhURL = this.getClass().getResource("badheart.gif");
    URL maURL = this.getClass().getResource("methAzul.gif");
    URL mjURL = this.getClass().getResource("methJesse.gif");
    URL meURL = this.getClass().getResource("methExp.gif");
    
    bolBola = new Bola(Toolkit.getDefaultToolkit().getImage(bURL));
    plaPlataforma = new Plataforma(Toolkit.getDefaultToolkit().getImage(pURL));
    bloBloques = new Bloque[30];
    corCorazones= new Corazon[3];
    sMessage= "Game Over";
    
    int k = 0;
    for (int i = 0; i < 5; i++) {
      int iCantMethExp= (int)(Math.random()*2);
      int iCantMethAzul= (int)(Math.random()*3);
      for (int j = 0; j < 6; j++) {
        
        int iRand= (int)(Math.random()*4);
        
        if(iRand==0&&iCantMethAzul>0){
          bloBloques[k] = new Bloque(j * Dimensiones.WIDTH/6 + 15 , i * Dimensiones.HEIGTH/20, 
                                     Toolkit.getDefaultToolkit().getImage(maURL));
          iCantMethAzul--;
        }
        else if(iRand==1&&iCantMethExp>0){
          bloBloques[k] = new Bloque(j * Dimensiones.WIDTH/6 + 15 , i * Dimensiones.HEIGTH/20, 
                                     Toolkit.getDefaultToolkit().getImage(meURL));
          iCantMethExp--;
        }
        else{
          bloBloques[k] = new Bloque(j * Dimensiones.WIDTH/6 + 15 , i * Dimensiones.HEIGTH/20, 
                                     Toolkit.getDefaultToolkit().getImage(mjURL));
        }
        k++;
      }
    }
    
    for(int i=0;i<3;i++){
      corCorazones[i]= new Corazon(2+10*i,0, Toolkit.getDefaultToolkit().getImage(hURL), true);
    }
    
    bOver= false;
    iVidas= 3;
  }
  
  
  public void paint(Graphics g) {
    super.paint(g);
    
    if (!bOver){
      g.drawImage(bolBola.getImage(), bolBola.getX(), bolBola.getY(),
                  bolBola.getWidth(), bolBola.getHeight(), this);
      g.drawImage(plaPlataforma.getImage(), plaPlataforma.getX(), plaPlataforma.getY(),
                  plaPlataforma.getWidth(), plaPlataforma.getHeight(), this);
      
      for (int i = 0; i < 30; i++) {
        if (!bloBloques[i].isDestruido())
          g.drawImage(bloBloques[i].getImage(), bloBloques[i].getX(),
                      bloBloques[i].getY(), bloBloques[i].getWidth(),
                      bloBloques[i].getHeight(), this);
      }
      
      for(int i=0;i<3;i++){
        if(corCorazones[i].getEncendido())
          g.drawImage(corCorazones[i].getImage(), corCorazones[i].getX(),
                      corCorazones[i].getY(), corCorazones[i].getWidth(),
                      corCorazones[i].getHeight(), this);
      }
    }
    
    else {
      
      Font font = new Font("Verdana", Font.BOLD, 18);
      FontMetrics metr = this.getFontMetrics(font);
      
      g.setColor(Color.BLACK);
      g.setFont(font);
      g.drawString(sMessage,
                   (Dimensiones.WIDTH - metr.stringWidth(sMessage)) / 2,
                   Dimensiones.WIDTH / 2);
    }
    
    
    Toolkit.getDefaultToolkit().sync();
    g.dispose();
  }
  
  private class TAdapter extends KeyAdapter {
    
    public void keyReleased(KeyEvent e) {
      plaPlataforma.keyReleased(e);
    }
    
    public void keyPressed(KeyEvent e) {
      plaPlataforma.keyPressed(e);
    }
  }
  
  
  class ScheduleTask extends TimerTask {
    
    public void run() {
      
      actualiza();
      checkCollision();
      repaint();
    }
  }
  
  public void stopGame() {
    bOver = true;
    timer.cancel();
  }
  
  
  
  public void actualiza(){
    bolBola.move();
    plaPlataforma.move();
  }
  
  public void checkCollision() {
    
    if (bolBola.getRect().getMaxY() > Dimensiones.BOTTOM) {
      iVidas--;
      if(iVidas==0){
        bOver= true;
      }
    }
    
    for (int i = 0, j = 0; i < 30; i++) {
      if (bloBloques[i].isDestruido()) {
        j++;
      }
      if (j == 30) {
        sMessage = "Victory";
        stopGame();
      }
    }
    
    if ((bolBola.getRect()).intersects(plaPlataforma.getRect())) {
      
      int plataformaLPos = (int)plaPlataforma.getRect().getMinX();
      int bolaLPos = (int)bolBola.getRect().getMinX();
      
      int first = plataformaLPos + 8;
      int second = plataformaLPos + 16;
      int third = plataformaLPos + 24;
      int fourth = plataformaLPos + 32;
      
      if (bolaLPos < first) {
        bolBola.setXDir(-1);
        bolBola.setYDir(-1);
      }
      
      if (bolaLPos >= first && bolaLPos < second) {
        bolBola.setXDir(-1);
        bolBola.setYDir(-1 * bolBola.getYDir());
      }
      
      if (bolaLPos >= second && bolaLPos < third) {
        bolBola.setXDir(0);
        bolBola.setYDir(-1);
      }
      
      if (bolaLPos >= third && bolaLPos < fourth) {
        bolBola.setXDir(1);
        bolBola.setYDir(-1 * bolBola.getYDir());
      }
      
      if (bolaLPos > fourth) {
        bolBola.setXDir(1);
        bolBola.setYDir(-1);
      }
    }
    
    for (int i = 0; i < 30; i++) {
      if ((bolBola.getRect()).intersects(bloBloques[i].getRect())) {
        
        int bolaLeft = (int)bolBola.getRect().getMinX();
        int bolaHeight = (int)bolBola.getRect().getHeight();
        int bolaWidth = (int)bolBola.getRect().getWidth();
        int bolaTop = (int)bolBola.getRect().getMinY();
        
        Point pointRight =
          new Point(bolaLeft + bolaWidth + 1, bolaTop);
        Point pointLeft = new Point(bolaLeft - 1, bolaTop);
        Point pointTop = new Point(bolaLeft, bolaTop - 1);
        Point pointBottom =
          new Point(bolaLeft, bolaTop + bolaHeight + 1);
        
        if (!bloBloques[i].isDestruido()) {
          if (bloBloques[i].getRect().contains(pointRight)) {
            bolBola.setXDir(-1);
          }
          
          else if (bloBloques[i].getRect().contains(pointLeft)) {
            bolBola.setXDir(1);
          }
          
          if (bloBloques[i].getRect().contains(pointTop)) {
            bolBola.setYDir(1);
          }
          
          else if (bloBloques[i].getRect().contains(pointBottom)) {
            bolBola.setYDir(-1);
          }
          bloBloques[i].setDestruido(true);
        }
      }
    }
  }
  
  public static void main(String[] args) {
    new BreakingBad();
  }
}
