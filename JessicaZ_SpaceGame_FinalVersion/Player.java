/*Jessica Zhang
March 24, 2021
Java Final Version GUI game
ICS3U7 Ms. Strelkovska
 */
//class for the player
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player{
    public int x,y,dx,dy;
    BufferedImage img;
    String s;
    private float alpha;
    public Player() throws IOException{
        x=50;
        y=100;
		try {
            img = ImageIO.read(new File("player-alien.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        alpha=1f;
    }
    public void myDraw(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        //give it a health bar
        g2d.setColor(Color.green);
        g2d.fillRect(x+60,y-20,80,10);
        g2d.setColor(Color.red);
        g2d.fillRect(x+60,y-20,GamePanel.playerContact/5,10);
        g2d.drawImage(img, x, y, 200,200,null);
    }
    public void myMove(){
        y+=dy;
        x+=dx;
        //make it bounce back after it hits the sides
        if (y<20|| y>500){
            y-=dy;
            dy*=-1;
        }
        if (x<0 || x>1150){
            x-=dx;
            dx*=-1;
        }
    }
    public void enemyContact() {
        for (Enemies i : GamePanel.enemies) {
            //check contact by sensing if the top right corner is in contact with an enemy-within the width an height which we get by using dimensions and x y coordinates, then bottom right, top left, bottom left
            if ((GamePanel.player.x>= i.getX() && GamePanel.player.x <= i.getX() + 180 || GamePanel.player.x + 180 >= i.getX() && GamePanel.player.x + 180 <= i.getX() + 180) && (GamePanel.player.y>=i.getY() && GamePanel.player.y<=i.getY()+180 || GamePanel.player.y+180>=i.getY() && GamePanel.player.y+180<=i.getY()+180)) {
                GamePanel.playerContact++;
            }
        }
    }
    public void friendliesContact(){
        for (int i=0; i<GamePanel.friendlies.size(); i++) {
            //check contact by sensing if the top right corner is in contact with an enemy-within the width an height which we get by using dimensions and x y coordinates, then bottom right, top left, bottom left
            if ((GamePanel.player.x>= GamePanel.friendlies.get(i).getX() && GamePanel.player.x <= GamePanel.friendlies.get(i).getX() + 180 || GamePanel.player.x + 180 >= GamePanel.friendlies.get(i).getX() && GamePanel.player.x + 180 <= GamePanel.friendlies.get(i).getX() + 180) && (GamePanel.player.y>=GamePanel.friendlies.get(i).getY() && GamePanel.player.y<=GamePanel.friendlies.get(i).getY()+180 || GamePanel.player.y+180>=GamePanel.friendlies.get(i).getY() && GamePanel.player.y+180<=GamePanel.friendlies.get(i).getY()+180)) {
                if (GamePanel.friendlies.get(i).getType()==2){
                    //if the type is a shooting star, greatly reduce playerContact which simulates increased health
                    GamePanel.playerContact-=80;
                    //stop adding at a certain point so the bar doesn't grow beyond its bounds
                    if (GamePanel.points<28) {
                        GamePanel.points++;
                    }
                }
                else if (GamePanel.friendlies.get(i).getType()==3){
                    //if its a wormhole, greatly increase points
                    if (GamePanel.points<=18) {
                        GamePanel.points += 10;
                    }
                    else{
                        GamePanel.points=28;
                    }
                }
                else {
                    if (GamePanel.points<28) {
                        GamePanel.points++;
                    }
                }
                //regardless of friendly type, increase health after all
                GamePanel.playerContact -= 20;
                if (GamePanel.playerContact<0){
                    //once the health of player is full, give any excess health points to pet
                    if (GamePanel.petContact+GamePanel.playerContact>=0) {
                        GamePanel.petContact += GamePanel.playerContact;
                    }
                    else{
                        //stop giving once its full so health bar doesnt keep growing
                        GamePanel.petContact=0;
                    }
                }
                //remove it after its been collected
                GamePanel.friendlies.remove(i);
            }
        }
    }
}
