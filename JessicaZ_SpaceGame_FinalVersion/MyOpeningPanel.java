/*Jessica Zhang
March 24, 2021
Java Final Version GUI game
ICS3U7 Ms. Strelkovska
 */
//class for the opening panel
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class MyOpeningPanel extends JPanel implements ActionListener, MouseListener, MouseMotionListener {
    Image img;
    Timer timer;
    Image backGround;
    ButtonMaker getButton;
    ButtonMaker getButton2;
    JButton button;
    JButton button2;
    int starCount;
    private float alpha;
    static ArrayList<Stars> stars;
    public MyOpeningPanel() throws IOException {
        setLayout(null);
		img=new ImageIcon("logo.png").getImage();
        backGround= ImageIO.read(new File("SpaceBackground.png"));
        getButton=new ButtonMaker("button-Rules.png",450,350,1);
        getButton2=new ButtonMaker("button-Play.png",450,350,2);
        button=getButton.goButton;
        button2=getButton2.goButton;
        button.setLocation(220,540);
        button.setSize(420,160);
        button2.setLocation(730,540);
        button2.setSize(420,160);
        add(button);
        add(button2);
        starCount=0;
        stars=new ArrayList<Stars>();
		alpha= 0f;
        timer=new Timer(6,this);
        timer.start();
    }
    public void paintComponent(Graphics g) {
        //fade in graphics
        super.paintComponent(g);
        g.drawImage(backGround,0,0,1360,718,this);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        g2d.drawImage(img, 230, 40, 870,870,null);
        //when to create another star
        if (starCount/25==1){
            starCount=0;
            try {
                stars.add(new Stars());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for (int i=0; i<stars.size();i++){
            stars.get(i).myDraw(g);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==timer){
            starCount++;
        }
        alpha += 0.005f;
        //fade in every 6 miliseconds
        if (alpha >= 1) {
            alpha = 1;
        }
        //moving the stars
        for (int i=0; i<stars.size();i++){
            stars.get(i).myMove();
        }
        repaint();
    }
    public void mouseClicked(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {
    }
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseDragged(MouseEvent e) {
    }
    public void mouseMoved(MouseEvent e) {}
}
