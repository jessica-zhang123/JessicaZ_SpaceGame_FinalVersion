/*Jessica Zhang
March 24, 2021
Java Final Version GUI game
ICS3U7 Ms. Strelkovska
 */
//class for mushroom ammo
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class Mushroom {
    int x,y;
    double dx;
    int capacity;
    int type;
    BufferedImage img;
    public Mushroom(int n) throws IOException {
        x=GamePanel.pet.getX();
        y=GamePanel.pet.getY();
        dx=10;
        type=n;
        //given the parameter, select correct mushroom and give capacity a value because each type holds different amount of mushroom to use
        if (n==1){
            img=ImageIO.read(new File("ammo-mushroom1.png"));
            capacity=100;
        }
        else if (n==2){
            img=ImageIO.read(new File("ammo-mushroom2.png"));
            capacity=80;
        }
        else{
            img=ImageIO.read(new File("ammo-mushroom3.png"));
            capacity=60;
        }
    }
    public void myDraw(Graphics g){
        g.drawImage(img,x,y,100,100,null);
    }
    public void mySmallDraw(Graphics g){
        //code for small mushroom counter in the bottom left corner of screen
        g.drawImage(img,130,570,100,100,null);
        Font font=new Font("ISOCT_IV25",Font.BOLD, 60);
        g.setColor(Color.white);
        g.setFont(font);
        //counts how many mushrooms left
        g.drawString(""+(GamePanel.init.capacity-GamePanel.mushCount),5,650);
    }
    public void myMove(){
        x+=dx;
        if (dx>3) {
            dx -= 0.1;
        }
    }
    public boolean enemyContact(int n) {
        for (int i=0; i<GamePanel.enemies.size(); i++){
            //checks if top right corner of mushroom comes in contact with top left corner of enemy by seeing if the x coordinate lies within the enemies width and if y coordinate lies within enemies height
            if (GamePanel.mushrooms.get(n).x + 150 >= GamePanel.enemies.get(i).getX() && GamePanel.mushrooms.get(n).x + 150 <= GamePanel.enemies.get(i).getX() + 200 && (GamePanel.mushrooms.get(n).y>=GamePanel.enemies.get(i).getY() && GamePanel.mushrooms.get(n).y<=GamePanel.enemies.get(i).getY()+200 || GamePanel.mushrooms.get(n).y+150>=GamePanel.enemies.get(i).getY() && GamePanel.mushrooms.get(n).y+150<=GamePanel.enemies.get(i).getY()+200)) {
                //if enemy is meteor or spaceship, it can fade when hit
                if (GamePanel.enemies.get(i).getType()==2 || GamePanel.enemies.get(i).getType()==3){
                    GamePanel.enemies.get(i).setAlpha(0.05f);
                }
                //least volatile type of mushrooms
                if (GamePanel.mushrooms.get(n).type==1){
                    //enemy type is blackhole, it can't be injured
                    if (GamePanel.enemies.get(i).getType()==1){
                        GamePanel.enemies.get(i).increaseDamage(0);
                    }
                    //if its a meteor, it takes greater damage and takes more fade after a hit cause it is hurt easier
                    else if (GamePanel.enemies.get(i).getType()==2){
                        GamePanel.enemies.get(i).increaseDamage(2);
                        GamePanel.enemies.get(i).setAlpha(0.1f);
                    }
                    else{
                        //if its a space ship it takes less damage since they are more resiliant
                        GamePanel.enemies.get(i).increaseDamage(1);
                        GamePanel.enemies.get(i).setAlpha(0.05f);
                    }
                }
                //if its a more powerful type of mushroom
                else if (GamePanel.mushrooms.get(n).type==2){
                    if (GamePanel.enemies.get(i).getType()==1){
                        GamePanel.enemies.get(i).increaseDamage(0);
                    }
                    else if (GamePanel.enemies.get(i).getType()==2){
                        GamePanel.enemies.get(i).increaseDamage(4);
                        GamePanel.enemies.get(i).setAlpha(0.2f);
                    }
                    else{
                        GamePanel.enemies.get(i).increaseDamage(2);
                        GamePanel.enemies.get(i).setAlpha(0.1f);
                    }
                }
                //if its the most powerful mushroom
                else if (GamePanel.mushrooms.get(n).type==3){
                    if (GamePanel.enemies.get(i).getType()==1){
                        GamePanel.enemies.get(i).increaseDamage(0);
                    }
                    else if (GamePanel.enemies.get(i).getType()==2){
                        GamePanel.enemies.get(i).increaseDamage(6);
                        GamePanel.enemies.get(i).setAlpha(0.3f);
                    }
                    else{
                        GamePanel.enemies.get(i).increaseDamage(3);
                        GamePanel.enemies.get(i).setAlpha(0.2f);
                    }
                }
                //if its a meteor and sustains enough damage then it is removed from the screen
                if (GamePanel.enemies.get(i).getType()==2){
                    if (GamePanel.enemies.get(i).getDamage()>=12){
                        GamePanel.points++;
                        GamePanel.enemies.remove(i);
                    }
                }
                //if its a spaceship it has to take more damage
                else if (GamePanel.enemies.get(i).getType()==3){
                    if (GamePanel.enemies.get(i).getDamage()>=3){
                        GamePanel.points++;
                        GamePanel.enemies.remove(i);
                    }
                }
                return true;
            }
        }
        return false;
    }
}
