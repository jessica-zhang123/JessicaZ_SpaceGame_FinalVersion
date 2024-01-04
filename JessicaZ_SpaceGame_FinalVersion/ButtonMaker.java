/*Jessica Zhang
March 24, 2021
Java Final Version GUI game
ICS3U7 Ms. Strelkovska
 */
//class for buttons
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ButtonMaker extends JPanel implements ActionListener {
    public JButton goButton;
    ImageIcon img;
    private int pos;
    int w, h;
    public static String petID;
    public static String planetID;
    public static int ammoID;
    public static String foodID;
    public static int count;
    static boolean selected1;
    static boolean selected2;
    static boolean selected3;
    static boolean selected4;
    String finalFood;
    String finalPet;
    String finalAmmo;
    String finalPlanet;
    String restButtons;
    static int instructCount;
    public ButtonMaker(String s, int w, int h, int n) throws IOException {
        count = 0;
        petID = "";
        planetID = "";
        ammoID = 0;
        foodID = "";
        pos = n;
        restButtons=s;
        selected1=false;
        selected2=false;
        selected3=false;
        selected4=false;
        instructCount=1;
        this.w = w;
        this.h = h;
        //making a custom button but using an image specified in the parameter
        goButton = new JButton();
        img = new ImageIcon(new ImageIcon(s).getImage().getScaledInstance(w, h, Image.SCALE_DEFAULT));
        goButton.setIcon(img);
        goButton.setBorderPainted(false);
        goButton.setFocusPainted(false);
        goButton.setContentAreaFilled(false);
        goButton.addActionListener(this);
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //make background of button panel transparent
        this.setBackground(new Color(1, 2, 3, 0));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == goButton) {
            if (instructCount==6){
                instructCount=1;
                MyFrame.cardsL.first(MyFrame.c);
            }
            if (pos == 1) {
                MyFrame.cardsL.last(MyFrame.c);
            } else if (pos == 2) {
                MyFrame.cardsL.next(MyFrame.c);
            }
            //using pos to identify button
            if (pos == 3 || pos == 4 || pos == 5) {
                if (pos == 3) {
                    petID = "pet-anglerfish.png";
                    finalPet="pet-anglerfish2.png";
                }
                else if (pos == 4) {
                    petID = "pet-axolotl.png";
                    finalPet="pet-axolotl2.png";
                } else {
                    petID = "pet-blobfish.png";
                    finalPet="pet-blobfish2.png";
                }
                //code to set outline on selected button and make other buttons that were clicked previously look unselected if they are not the selected button
                img = new ImageIcon(new ImageIcon(finalPet).getImage().getScaledInstance(w, h, Image.SCALE_DEFAULT));
                if (pos==3){
                    ChoiceMenu.button.setIcon(img);
                    img = new ImageIcon(new ImageIcon(ChoiceMenu.getButton2.restButtons).getImage().getScaledInstance(ChoiceMenu.getButton2.w, h, Image.SCALE_DEFAULT));
                    ChoiceMenu.button2.setIcon(img);
                    img = new ImageIcon(new ImageIcon(ChoiceMenu.getButton3.restButtons).getImage().getScaledInstance(ChoiceMenu.getButton3.w, h, Image.SCALE_DEFAULT));
                    ChoiceMenu.button3.setIcon(img);
                }
                else if (pos==4){
                    ChoiceMenu.button2.setIcon(img);
                    img = new ImageIcon(new ImageIcon(ChoiceMenu.getButton.restButtons).getImage().getScaledInstance(ChoiceMenu.getButton.w, h, Image.SCALE_DEFAULT));
                    ChoiceMenu.button.setIcon(img);
                    img = new ImageIcon(new ImageIcon(ChoiceMenu.getButton3.restButtons).getImage().getScaledInstance(ChoiceMenu.getButton3.w, h, Image.SCALE_DEFAULT));
                    ChoiceMenu.button3.setIcon(img);
                }
                else {
                    ChoiceMenu.button3.setIcon(img);
                    img = new ImageIcon(new ImageIcon(ChoiceMenu.getButton.restButtons).getImage().getScaledInstance(ChoiceMenu.getButton.w, h, Image.SCALE_DEFAULT));
                    ChoiceMenu.button.setIcon(img);
                    img = new ImageIcon(new ImageIcon(ChoiceMenu.getButton2.restButtons).getImage().getScaledInstance(ChoiceMenu.getButton2.w, h, Image.SCALE_DEFAULT));
                    ChoiceMenu.button2.setIcon(img);

                }
                //confirm button is pressed
                selected1=true;
            }
            if (pos == 6 || pos == 7 || pos == 8) {
                if (pos == 6) {
                    planetID = "planet-Cancri.png";
                    finalPlanet="planet-Cancri2.png";
                } else if (pos == 7) {
                    planetID = "planet-Gliese.png";
                    finalPlanet="planet-Gliese2.png";
                } else {
                    planetID = "planet-HAT.png";
                    finalPlanet="planet-HAT2.png";
                }
                img = new ImageIcon(new ImageIcon(finalPlanet).getImage().getScaledInstance(w, h, Image.SCALE_DEFAULT));
                if (pos==6){
                    ChoiceMenu.button4.setIcon(img);
                    img = new ImageIcon(new ImageIcon(ChoiceMenu.getButton5.restButtons).getImage().getScaledInstance(ChoiceMenu.getButton5.w, ChoiceMenu.getButton5.h, Image.SCALE_DEFAULT));
                    ChoiceMenu.button5.setIcon(img);
                    img = new ImageIcon(new ImageIcon(ChoiceMenu.getButton6.restButtons).getImage().getScaledInstance(ChoiceMenu.getButton6.w, ChoiceMenu.getButton6.h, Image.SCALE_DEFAULT));
                    ChoiceMenu.button6.setIcon(img);
                }
                else if (pos==7){
                    ChoiceMenu.button5.setIcon(img);
                    img = new ImageIcon(new ImageIcon(ChoiceMenu.getButton4.restButtons).getImage().getScaledInstance(ChoiceMenu.getButton4.w, ChoiceMenu.getButton4.h, Image.SCALE_DEFAULT));
                    ChoiceMenu.button4.setIcon(img);
                    img = new ImageIcon(new ImageIcon(ChoiceMenu.getButton6.restButtons).getImage().getScaledInstance(ChoiceMenu.getButton6.w, ChoiceMenu.getButton6.h, Image.SCALE_DEFAULT));
                    ChoiceMenu.button6.setIcon(img);
                }
                else {
                    ChoiceMenu.button6.setIcon(img);
                    img = new ImageIcon(new ImageIcon(ChoiceMenu.getButton4.restButtons).getImage().getScaledInstance(ChoiceMenu.getButton4.w, ChoiceMenu.getButton4.h, Image.SCALE_DEFAULT));
                    ChoiceMenu.button4.setIcon(img);
                    img = new ImageIcon(new ImageIcon(ChoiceMenu.getButton5.restButtons).getImage().getScaledInstance(ChoiceMenu.getButton5.w, ChoiceMenu.getButton5.h, Image.SCALE_DEFAULT));
                    ChoiceMenu.button5.setIcon(img);

                }
                selected2=true;
            }
            if (pos == 9 || pos == 10 || pos == 11) {
                if (pos == 9) {
                    ammoID = 1;
                    finalAmmo="ammo-mushroom1-2.png";
                } else if (pos == 10) {
                    ammoID = 2;
                    finalAmmo="ammo-mushroom2-2.png";
                } else {
                    ammoID = 3;
                    finalAmmo="ammo-mushroom3-2.png";
                }
                img = new ImageIcon(new ImageIcon(finalAmmo).getImage().getScaledInstance(w, h, Image.SCALE_DEFAULT));
                if (pos==9){
                    ChoiceMenu.button7.setIcon(img);
                    img = new ImageIcon(new ImageIcon(ChoiceMenu.getButton8.restButtons).getImage().getScaledInstance(ChoiceMenu.getButton8.w, ChoiceMenu.getButton8.h, Image.SCALE_DEFAULT));
                    ChoiceMenu.button8.setIcon(img);
                    img = new ImageIcon(new ImageIcon(ChoiceMenu.getButton9.restButtons).getImage().getScaledInstance(ChoiceMenu.getButton9.w, ChoiceMenu.getButton9.h, Image.SCALE_DEFAULT));
                    ChoiceMenu.button9.setIcon(img);
                }
                else if (pos==10){
                    ChoiceMenu.button8.setIcon(img);
                    img = new ImageIcon(new ImageIcon(ChoiceMenu.getButton7.restButtons).getImage().getScaledInstance(ChoiceMenu.getButton7.w, ChoiceMenu.getButton7.h, Image.SCALE_DEFAULT));
                    ChoiceMenu.button7.setIcon(img);
                    img = new ImageIcon(new ImageIcon(ChoiceMenu.getButton9.restButtons).getImage().getScaledInstance(ChoiceMenu.getButton9.w, ChoiceMenu.getButton9.h, Image.SCALE_DEFAULT));
                    ChoiceMenu.button9.setIcon(img);
                }
                else {
                    ChoiceMenu.button9.setIcon(img);
                    img = new ImageIcon(new ImageIcon(ChoiceMenu.getButton7.restButtons).getImage().getScaledInstance(ChoiceMenu.getButton7.w, ChoiceMenu.getButton7.h, Image.SCALE_DEFAULT));
                    ChoiceMenu.button7.setIcon(img);
                    img = new ImageIcon(new ImageIcon(ChoiceMenu.getButton8.restButtons).getImage().getScaledInstance(ChoiceMenu.getButton8.w, ChoiceMenu.getButton8.h, Image.SCALE_DEFAULT));
                    ChoiceMenu.button8.setIcon(img);
                }
                selected3=true;
            }
            if (pos == 12 || pos == 13 || pos == 14) {
                if (pos == 12) {
                    foodID = "food-boba.png";
                    finalFood="food-boba2.png";

                } else if (pos == 13) {
                    foodID = "food-donut.png";
                    finalFood="food-donut2.png";
                } else {
                    foodID = "food-icecream.png";
                    finalFood="food-icecream2.png";
                }
                img = new ImageIcon(new ImageIcon(finalFood).getImage().getScaledInstance(w, h, Image.SCALE_DEFAULT));
                if (pos==12){
                    ChoiceMenu.button10.setIcon(img);
                    img = new ImageIcon(new ImageIcon(ChoiceMenu.getButton11.restButtons).getImage().getScaledInstance(ChoiceMenu.getButton11.w, h, Image.SCALE_DEFAULT));
                    ChoiceMenu.button11.setIcon(img);
                    img = new ImageIcon(new ImageIcon(ChoiceMenu.getButton12.restButtons).getImage().getScaledInstance(ChoiceMenu.getButton12.w, h, Image.SCALE_DEFAULT));
                    ChoiceMenu.button12.setIcon(img);
                }
                else if (pos==13){
                    ChoiceMenu.button11.setIcon(img);
                    img = new ImageIcon(new ImageIcon(ChoiceMenu.getButton12.restButtons).getImage().getScaledInstance(ChoiceMenu.getButton12.w, h, Image.SCALE_DEFAULT));
                    ChoiceMenu.button12.setIcon(img);
                    img = new ImageIcon(new ImageIcon(ChoiceMenu.getButton10.restButtons).getImage().getScaledInstance(ChoiceMenu.getButton10.w, h, Image.SCALE_DEFAULT));
                    ChoiceMenu.button10.setIcon(img);
                }
                else {
                    ChoiceMenu.button12.setIcon(img);
                    img = new ImageIcon(new ImageIcon(ChoiceMenu.getButton11.restButtons).getImage().getScaledInstance(ChoiceMenu.getButton11.w, h, Image.SCALE_DEFAULT));
                    ChoiceMenu.button11.setIcon(img);
                    img = new ImageIcon(new ImageIcon(ChoiceMenu.getButton10.restButtons).getImage().getScaledInstance(ChoiceMenu.getButton10.w, h, Image.SCALE_DEFAULT));
                    ChoiceMenu.button10.setIcon(img);

                }
                selected4=true;
            }
            if (pos==15){
                instructCount++;
            }
            //if all buttons are selected, create instance of new frame containing game
            if (selected1 && selected2 && selected3 && selected4) {
                try {
                    MyGameFrame myNewFrame=new MyGameFrame("Escape Space");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
    }
}

