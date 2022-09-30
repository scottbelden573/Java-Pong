// Paddle.java
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Paddle extends Rectangle {
  // declare variables
  int id; // id1 for for player/paddle1. id2 for player/paddle2
  int yVelocity; // how fast the paddle moves up and down when we press tc_button




  Paddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id) {
    super(x,y,PADDLE_WIDTH,PADDLE_HEIGHT);
    this.id=id;


  }
  public void keyPressed(KeyEvent e) {
    switch(id) {                        // examine contents of id variable

    }
  }
  public void keyReleased(KeyEvent e) {

  }
  public void setYDirection(int yDirection) {

  }
  public void move() {

  }
  public void draw(Graphics g){
    if(id==1)
      g.setColor(Color.blue);
    else
      g.setColor(Color.red);                    // else id must be 2
    g.fillRect(x, y, width, height);
    }



}
