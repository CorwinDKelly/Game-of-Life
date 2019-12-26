/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Life;

/**
 *
 * @author corwinman
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.geom.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Random;

public class DrawGrid extends JPanel implements ActionListener{
    
    Timer time = new Timer(500, this);
    Life earth = new Life();
     
    public static void main(String[] args) {
        //create a frame
        JFrame f = new JFrame("Narnia");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1000,1000);
        f.getContentPane().add(new DrawGrid());
        f.setLocation(550, 25);
        f.setVisible(true);
    }

    //create a grid and associate each square with an array index
    public void paint(Graphics g) {
        Random randy = new Random();        
        super.paintComponent(g);
        //Life earth = new Life();
        Graphics2D g2 = (Graphics2D) g;
        for(int i = 0; i<Math.pow(earth.getSideLength(),2); i++){
            
            /*Colors for the n00bs
            int r = (int)(randy.nextInt(256));
            int gr = (int)(randy.nextInt(256));
            int b = (int)(randy.nextInt(256));
            Color color = new Color(r,gr,b);
            g.setColor(color);
               */      

            if(earth.currentFrame[i])
                g2.fillRect(i%earth.getSideLength()*10, i/earth.getSideLength()*10, 10, 10);
            else
                g2.drawRect(i%earth.getSideLength()*10, i/earth.getSideLength()*10, 10, 10);
        }
        time.start();
    }
    
    public void actionPerformed(ActionEvent e){
        earth.getFrame();
        repaint();
    }
}

