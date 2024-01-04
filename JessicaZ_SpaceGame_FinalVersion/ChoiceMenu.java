/*Jessica Zhang
March 24, 2021
Java Final Version GUI game
ICS3U7 Ms. Strelkovska
 */
//class for choice panel
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
public class ChoiceMenu extends JPanel implements ActionListener, MouseListener, MouseMotionListener {
    Timer timer;
    Image backGround;
    Image petLabel;
    Image ammoLabel;
    Image planetLabel;
    Image foodLabel;
    Image title;
    Image petNames;
    Image ammoNames;
    Image planetNames;
    Image foodNames;
    static ButtonMaker getButton;
    static ButtonMaker getButton2;
    static ButtonMaker getButton3;
    static ButtonMaker getButton4;
    static ButtonMaker getButton5;
    static ButtonMaker getButton6;
    static ButtonMaker getButton7;
    static ButtonMaker getButton8;
    static ButtonMaker getButton9;
    static ButtonMaker getButton10;
    static ButtonMaker getButton11;
    static ButtonMaker getButton12;
    static JButton button;
    static JButton button2;
    static JButton button3;
    static JButton button4;
    static JButton button5;
    static JButton button6;
    static JButton button7;
    static JButton button8;
    static JButton button9;
    static JButton button10;
    static JButton button11;
    static JButton button12;
    public ChoiceMenu() throws IOException {
        setLayout(null);
        title=ImageIO.read(new File("title-sign.png"));
        backGround= ImageIO.read(new File("Background-menu.png"));
        petLabel=ImageIO.read(new File("PETlabel.png"));
        ammoLabel=ImageIO.read(new File("ammoLabel.png"));
        planetLabel=ImageIO.read(new File("planetLabel.png"));
        foodLabel=ImageIO.read(new File("foodLabel.png"));
        petNames=ImageIO.read(new File("petNames.png"));
        ammoNames=ImageIO.read(new File("ammoNames.png"));
        planetNames=ImageIO.read(new File("planetNames.png"));
        foodNames=ImageIO.read(new File("foodNames.png"));
        //constructing custom buttons
        getButton=new ButtonMaker("pet-anglerfish.png",180,180,3);
        getButton2=new ButtonMaker("pet-axolotl.png",180,180,4);
        getButton3=new ButtonMaker("pet-blobfish.png",180,180,5);
        //
        getButton4=new ButtonMaker("planet-Cancri.png",200,200,6);
        getButton5=new ButtonMaker("planet-Gliese.png",180,180,7);
        getButton6=new ButtonMaker("planet-HAT.png",180,180,8);
        //
        getButton7=new ButtonMaker("ammo-mushroom1.png",180,180,9);
        getButton8=new ButtonMaker("ammo-mushroom2.png",180,180,10);
        getButton9=new ButtonMaker("ammo-mushroom3.png",180,180,11);
        //
        getButton10=new ButtonMaker("food-boba.png",180,180,12);
        getButton11=new ButtonMaker("food-donut.png",180,180,13);
        getButton12=new ButtonMaker("food-icecream.png",180,180,14);
        //
        button=getButton.goButton;
        button2=getButton2.goButton;
        button3=getButton3.goButton;
        //
        button4=getButton4.goButton;
        button5=getButton5.goButton;
        button6=getButton6.goButton;
        //
        button7=getButton7.goButton;
        button8=getButton8.goButton;
        button9=getButton9.goButton;
        //
        button10=getButton10.goButton;
        button11=getButton11.goButton;
        button12=getButton12.goButton;
        //manually setting location of buttons
        button.setLocation(50,150);
        button.setSize(180,180);
        button2.setLocation(260,140);
        button2.setSize(180,180);
        button3.setLocation(440,160);
        button3.setSize(180,180);
        //
        button4.setLocation(700,140);
        button4.setSize(200,200);
        button5.setLocation(920,140);
        button5.setSize(180,180);
        button6.setLocation(1120,140);
        button6.setSize(180,180);
        //
        //
        button7.setLocation(50,460);
        button7.setSize(180,180);
        button8.setLocation(220,460);
        button8.setSize(180,180);
        button9.setLocation(410,460);
        button9.setSize(180,180);
        //
        button10.setLocation(790,450);
        button10.setSize(180,180);
        button11.setLocation(950,450);
        button11.setSize(180,180);
        button12.setLocation(1100,450);
        button12.setSize(180,180);
        //
        add(button);
        add(button2);
        add(button3);
        add(button4);
        add(button5);
        add(button6);
        add(button7);
        add(button8);
        add(button9);
        add(button10);
        add(button11);
        add(button12);
		timer=new Timer(6,this);
        timer.start();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backGround,0,0,1700,718,this);
        g.drawImage(petLabel,40,40,320,320,null);
        g.drawImage(ammoLabel,40,360,360,360,null);
        g.drawImage(planetLabel,1050,60,240,240,null);
        g.drawImage(foodLabel,1040,350,350,350,null);
        g.drawImage(petNames,60,220,500,500,null);
        g.drawImage(ammoNames,40,520,630,580,null);
        g.drawImage(planetNames, 690,210,800,560,null);
        g.drawImage(foodNames, 830, 510,500,500, null);
        g.drawImage(title,400,10,600,500,null);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer) {
        }
        repaint();
    }
    public void mouseClicked(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {
    }
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {
        button12.setBackground(Color.green);
    }
    public void mouseExited(MouseEvent e) {}
    public void mouseDragged(MouseEvent e) {
    }
    public void mouseMoved(MouseEvent e) {}
}
