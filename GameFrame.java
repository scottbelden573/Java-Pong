// GameFrame.java
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GameFrame extends JFrame{

  GamemPanel panel;


  GameFrame() {
      panel = new GamePanel();
      this.add(panel);
      this.setTitle("Pong Game");
      this.setResizable(false); // because we don't want people to resize GameFrame
      this.setBackground(Color.black);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // so when we hit X it closes application
      this.pack();  // will fit snguly around gamePanel. don't need to set size of JFrame.
                    // will adjust accordingly.
      this.setVisible(true);
      this.setLocationRelativeTo(null);
      


  }

}
