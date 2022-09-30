// GamePanel.java
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable{

  static final int GAME_WIDTH = 1000;   // static b/c if multiple instances of GamePanel, will share 1 var.
                                        // final b/c prohibits us from accidentally modifying GAME_WIDTH in final program
  static final int GAME_HEIGHT = (int)(GAME_WIDTH * (0.5555));  // standard ping pong ratio is 5'x 9'. will round down to 0. 5/9 = 0.5555
  static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
  static final int BALL_DIAMETER = 20; // 20 pixels
  static final int PADDLE_WIDTH = 25;
  static final int PADDLE_HEIGHT = 100;
  Thread gameThread;
  Image image;
  Graphics graphics;
  Random random;
  Paddle paddle1;
  Paddle paddle2;
  Ball ball;
  Score score;




  GamePanel() {
      newPaddles();
      newBall();
      score = new Score(GAME_WIDTH, GAME_HEIGHT);
      this.setFocusable(true);
      this.addKeyListener(new AL());
      this.setPreferredSize(SCREEN_SIZE);

      gameThread = new Thread(this);
      gameThread.start();

  }
  public void newBall() {

  }
  public void newPaddles() {
    paddle1 = new Paddle(0,(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,1);
    paddle2 = new Paddle(GAME_WIDTH-PADDLE_WIDTH,(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,2);
  }
  public void paint(Graphics g) {
    image = createImage(getWidth(),getHeight());
    graphics = image.getGraphics();
    draw(graphics);
    g.drawImage(image,0,0,this);

  }
  public void draw(Graphics g) {
    paddle1.draw(g);
    paddle2.draw(g);


  }
  public void move() {

  }
  public void checkCollision() {

  }
  public void run(){
    // game loop. 60FPS?
    long lastTime = System.nanoTime();           //copying a game loop for MineCraft w/ a few adjustments
    double amountOfTicks = 60.0;
    double ns = 1000000000 / amountOfTicks;
    double delta = 0;
    while(true) {                               // or could set Boolean running
        long now = System.nanoTime();
        delta += (now - lastTime)/ns;
        lastTime = now;
        if (delta >= 1) {
          move();
          checkCollision();
          repaint();
          delta--;
          System.out.println("TEST");   // to make sure gamePanel works
        }
    }



  }
  public class AL extends KeyAdapter(){       // AL is short for ActionListener
    public void keyPressed(KeyEvent e){
      paddle1.keyPressed(e);
      paddle2.keyPressed(e);

    }
    public void keyReleased(KeyEvent e){
      paddle1.keyReleased(e);
      paddle2.keyReleased(e);
    }
  }




}
