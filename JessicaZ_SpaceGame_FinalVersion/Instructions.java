/*Jessica Zhang
March 24, 2021
Java Final Version GUI game
ICS3U7 Ms. Strelkovska
 */
//class instructions
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Instructions extends JPanel implements ActionListener, MouseListener, MouseMotionListener {
    Image img;
    BufferedImage player;
    BufferedImage axolotl;
    BufferedImage anglerfish;
    BufferedImage blobfish;
    BufferedImage boba;
    BufferedImage donut;
    BufferedImage icecream;
    BufferedImage star;
    BufferedImage worm;
    BufferedImage blackhole;
    BufferedImage ship;
    BufferedImage meteor;
    BufferedImage mush1;
    BufferedImage mush2;
    BufferedImage mush3;
    Timer timer;
    Image backGround;
    static ButtonMaker getNextInstruct;
    static JButton nextButton;
    public Instructions() throws IOException {
        setLayout(null);
		img=new ImageIcon("logo.png").getImage();
        player=ImageIO.read(new File("player-alien.png"));
        axolotl=ImageIO.read(new File("pet-axolotl.png"));
        anglerfish=ImageIO.read(new File("pet-anglerfish.png"));
        blobfish=ImageIO.read(new File("pet-blobfish.png"));
        boba=ImageIO.read(new File("food-boba.png"));
        donut=ImageIO.read(new File("food-donut.png"));
        icecream=ImageIO.read(new File("food-icecream.png"));
        star=ImageIO.read(new File("friend-shootingstar.png"));
        worm=ImageIO.read(new File("friend-wormhole.png"));
        blackhole=ImageIO.read(new File("enemy-blackhole.png"));
        ship=ImageIO.read(new File("enemy-spaceship.png"));
        meteor=ImageIO.read(new File("enemy-meteor.png"));
        mush1=ImageIO.read(new File("ammo-mushroom1.png"));
        mush2=ImageIO.read(new File("ammo-mushroom2.png"));
        mush3=ImageIO.read(new File("ammo-mushroom3.png"));
        getNextInstruct=new ButtonMaker("nextArrow.png",250,250,15);
        nextButton=getNextInstruct.goButton;
        nextButton.setLocation(950,520);
        nextButton.setSize(250,250);
        backGround= ImageIO.read(new File("background-instructions.png"));
        this.add(nextButton);
		timer=new Timer(1,this);
        timer.start();
    }
    public void paintComponent(Graphics g) {
        //fade in graphics
        super.paintComponent(g);
        g.drawImage(backGround,0,0,1360,800,this);
        if (ButtonMaker.instructCount==1) {
            try {
                Image page = ImageIO.read(new File("instructions1.png"));
                g.drawImage(page, 0, 0, 1360, 718, this);
            } catch (IOException e) {
                e.printStackTrace();
            }
            g.drawImage(player, 350,90,130,130, null);
            g.drawImage(axolotl, 350,220, 130,130, null);
        }
		//count when next button is clicked and draw on a different instruction page
        else if (ButtonMaker.instructCount==2){
            try {
                Image page = ImageIO.read(new File("instructions2.png"));
                g.drawImage(page, 0, 0, 1360, 718, this);
            } catch (IOException e) {
                e.printStackTrace();
            }
            g.drawImage(boba, 0, 130, 120,120, null);
            g.drawImage(donut, 130, 135, 120,120, null);
            g.drawImage(icecream, 270, 135, 120,120, null);
            g.drawImage(star, 460, 135, 170,170, null);
            g.drawImage(worm, 630, 135, 130,130, null);
            g.drawImage(blackhole, 0, 320, 130,130, null);
            g.drawImage(ship, 150, 320, 130,130, null);
            g.drawImage(meteor, 290, 320, 140,140, null);
            g.drawImage(player,930,400,130,130, null);

        }
        else if (ButtonMaker.instructCount==3){
            try {
                Image page = ImageIO.read(new File("instructions3.png"));
                g.drawImage(page, 0, 0, 1360, 718, this);
            } catch (IOException e) {
                e.printStackTrace();
            }
            g.drawImage(anglerfish, 0, 70, 120,120, null);
            g.drawImage(axolotl, 160, 70, 120,120, null);
            g.drawImage(blobfish, 320, 70, 120,120, null);
            g.drawImage(player, 340, 400, 120,120, null);
        }
        else if (ButtonMaker.instructCount==4){
            try {
                Image page = ImageIO.read(new File("instructions4.png"));
                g.drawImage(page, 0, 0, 1360, 718, this);
            } catch (IOException e) {
                e.printStackTrace();
            }
            g.drawImage(blackhole, 0, 70, 180,180, null);
            g.drawImage(meteor, 0, 230, 180,180, null);
            g.drawImage(ship, 0, 330,180,180, null);
        }
        else if (ButtonMaker.instructCount==5){
            try {
                Image page = ImageIO.read(new File("instructions5.png"));
                g.drawImage(page, 0, 0, 1360, 718, this);
            } catch (IOException e) {
                e.printStackTrace();
            }
            g.drawImage(boba, 0, 80, 150,150, null);
            g.drawImage(donut, 170, 80, 150,150, null);
            g.drawImage(icecream, 330, 80, 150,150, null);
            g.drawImage(star, 20, 220, 230,230, null);
            g.drawImage(worm, 30,390, 180,180, null);
        }
        else if (ButtonMaker.instructCount==6){
            try {
                Image page = ImageIO.read(new File("instructions6.png"));
                g.drawImage(page, 0, 0, 1360, 718, this);
            } catch (IOException e) {
                e.printStackTrace();
            }
            g.drawImage(mush1, 20, 80, 180,180, null);
            g.drawImage(mush2, 20, 250, 180,180, null);
            g.drawImage(mush3, 20, 400, 180,180, null);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==timer){

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