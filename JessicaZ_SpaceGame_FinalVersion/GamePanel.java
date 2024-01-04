/*Jessica Zhang
March 24, 2021
Java Final Version GUI game
ICS3U7 Ms. Strelkovska
 */
//class for game panel
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class GamePanel extends JPanel implements ActionListener, MouseListener, MouseMotionListener, KeyListener {
    Timer timer;
    static Player player;
    Image backGround;
    static Pet pet;
    SmallAlien smallAlien;
    static ArrayList<Mushroom> mushrooms;
    static ArrayList<Enemies> enemies;
    static ArrayList<Friendlies> friendlies;
    static Mushroom init;
    boolean shoot;
    static int points;
    static int petContact;
    static int playerContact;
    static int mushCount;
    int timeBlackhole;
    int timeMeteor;
    int timeRocketship;
    int timeFood;
    int timeShootingstar;
    int timeWormhole;
    static int roundCount;
    public GamePanel() throws IOException {
        smallAlien=new SmallAlien();
        roundCount=1;
        backGround= ImageIO.read(new File("gameBackground.png"));
        pet=new Pet(ButtonMaker.petID);
        player=new Player();
        shoot=false;
        mushCount=0;
        timeBlackhole=0;
        timeMeteor=0;
        timeRocketship=0;
        timeFood=0;
        timeShootingstar=0;
        timeWormhole=0;
        petContact=0;
        playerContact=0;
        points=0;
        init=new Mushroom(ButtonMaker.ammoID);
        mushrooms=new ArrayList<Mushroom>();
        enemies=new ArrayList<Enemies>();
        friendlies=new ArrayList<Friendlies>();
        this.addKeyListener(this);
        this.setFocusTraversalKeysEnabled(false);
        this.requestFocusInWindow();
        this.setFocusable(true);
        this.requestFocus();
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        timer=new Timer(6,this);
        timer.start();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backGround,0,0,1360,718,this);
        //progress bar
        g.setColor(Color.decode("#A1B6F4"));
        g.fillRect(50,40,1200, 30);
        g.setColor(Color.decode("#9861E0"));
        g.fillRect(50,40,points*50, 30);
        SmallAlien.x=points*50-20;
        smallAlien.myDraw(g);

        //if the player touches too many enemies, it has too low health and dies-written on screen
        if (playerContact<410) {
            player.myDraw(g);
            player.enemyContact();
            player.friendliesContact();
        }
        //if the pet touches too many enemies, it has too low health and dies-written on screen
        if (petContact<410) {
            pet.myDraw(g);
            pet.enemyContact();
        }
        //if shooting, add more mushrooms to the arraylist that will be drawn out later
        if (shoot) {
            for (int i = 0; i < mushrooms.size(); i++) {
                mushrooms.get(i).myDraw(g);
            }
        }
        //using this code to time the appearences of items on screen, the lower the divisor, the more often it will appear
        if (timeBlackhole/250==1){
            timeBlackhole=0;
            try {
                enemies.add(new Blackhole());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (timeMeteor/50==1){
            timeMeteor=0;
            try {
                enemies.add(new Meteor());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (timeRocketship/100==1){
            timeRocketship=0;
            try {
                enemies.add(new Spaceship());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (timeFood/300==1){
            timeFood=0;
            try {
                friendlies.add(new Food(ButtonMaker.foodID));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (timeShootingstar/400==1){
            timeShootingstar=0;
            try {
                friendlies.add(new Shootingstar());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (timeWormhole/800==1){
            timeWormhole=0;
            try {
                friendlies.add(new Wormholes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for (int i=0; i<enemies.size(); i++){
           enemies.get(i).myDraw(g);
        }
        for (int i=0; i<friendlies.size();i++){
            friendlies.get(i).myDraw(g);
        }
        init.mySmallDraw(g);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer) {
            //updating my timer tools at each delay
            timeBlackhole++;
            timeMeteor++;
            timeRocketship++;
            timeFood++;
            timeShootingstar++;
            timeWormhole++;
            player.myMove();
            //using JOption pane for certain events like death and winning
            if (GamePanel.points>=24){
                ImageIcon icon=new ImageIcon(ButtonMaker.planetID);
                JOptionPane.showMessageDialog(null, "You made it home!","Success!", JOptionPane.INFORMATION_MESSAGE, icon);
                int optionType=JOptionPane.OK_CANCEL_OPTION;
                int result=JOptionPane.showConfirmDialog(null, "Do you want to leave?","Hurrah!", JOptionPane.YES_NO_CANCEL_OPTION, optionType);
                if (result==JOptionPane.OK_OPTION){
                    System.exit(0);
                }
            }
            if (playerContact>=410 && petContact>=410) {
                roundCount++;
                JOptionPane.showMessageDialog(null, "You and your pet have both been defeated, you never made it home :(", "DEFEAT!", JOptionPane.INFORMATION_MESSAGE);
                int optionType = JOptionPane.OK_CANCEL_OPTION;
                int result = JOptionPane.showConfirmDialog(null, "Press YES to play again", "Play Again?", JOptionPane.YES_NO_CANCEL_OPTION, optionType);
                if (result == JOptionPane.OK_OPTION) {
                    try {
                        MyGameFrame.gamePanel=new GamePanel();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
                else{
                        System.exit(0);
                    }
                }
            if (shoot){
                for (int i=0; i<mushrooms.size(); i++) {
                    mushrooms.get(i).myMove();
                }
            }
            for (int i=0; i<enemies.size(); i++){
                enemies.get(i).myMove();
            }
            pet.myMove();
            repaint();
            //removing mushrooms if they touch enemies
            for (int i=0; i<mushrooms.size(); i++){
                if (mushrooms.get(i).enemyContact(i)){
                    mushrooms.remove(i);
                }
            }
            for (int i=0; i<friendlies.size(); i++){
                friendlies.get(i).myMove();
            }
        }
    }
    //once move key is released, player/pet stops moving
    //takes an int as a parameter to identify if it stops the pet or player
    public void released(int n){
        if (n==1) {
            player.dx = 0;
            player.dy = 0;
        }
        else{
            pet.dx=0;
            pet.dy=0;
        }
    }
    public void up(int n){
        if (n==1) {
            //controls speed so that it has a maximum speed
            if (player.dy > -7)
                player.dy -= 3;
        }
        else{
            if (pet.dy > -7)
                pet.dy -= 3;
        }
    }
    public void down(int n){
        if (n==1) {
            if (player.dy < 7)
                player.dy += 3;
        }
        else{
            if (pet.dy < 7)
                pet.dy += 3;
        }
    }
    public void left(int n){
        if (n==1) {
            if (player.dx > -7)
                player.dx -= 3;
        }
        else{
            if (pet.dx > -7)
                pet.dx -= 3;
        }
    }
    public void right(int n){
        if (n==1) {
            if (player.dx < 7)
                player.dx += 3;
        }
        else{
            if (pet.dx < 7)
                pet.dx += 3;
        }
    }
    public void keyTyped(KeyEvent e) {}
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            left(1);
        }
        if (key==65){
            left(2);
        }
        if (key == KeyEvent.VK_RIGHT) {
            right(1);
        }
        if (key==68){
            right(2);
        }
        if (key == KeyEvent.VK_UP) {
            up(1);
        }
        if (key==87){
            up(2);
        }
        if (key == KeyEvent.VK_DOWN) {
            down(1);
        }
        if (key==83){
            down(2);
        }
        if (key==32){
            shoot=true;
            if (mushCount<init.capacity) {
                try {
                    mushrooms.add(new Mushroom(ButtonMaker.ammoID));
                    mushCount++;
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
            else{
                System.out.println("You ran out of mushrooms");
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_RIGHT || e.getKeyCode()==KeyEvent.VK_LEFT || e.getKeyCode()==KeyEvent.VK_UP || e.getKeyCode()==KeyEvent.VK_DOWN){
            released(1);
        }
        if (e.getKeyCode()==65 || e.getKeyCode()==68 || e.getKeyCode()==87 || e.getKeyCode()==83){
            released(2);
        }
    }
    public void mouseClicked(MouseEvent e) {
    }
    public void mousePressed(MouseEvent e) {
    }
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseDragged(MouseEvent e) {
    }
    public void mouseMoved(MouseEvent e) {}
}
