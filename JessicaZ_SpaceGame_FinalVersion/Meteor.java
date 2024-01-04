/*Jessica Zhang
March 24, 2021
Java Final Version GUI game
ICS3U7 Ms. Strelkovska
 */
//class for meteor enemies
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
public class Meteor extends Enemies{
    private int x,y;
    private double dx,dy;
    BufferedImage img;
    int damage;
    private float alpha;
    public Meteor() throws IOException {
        x=(int)(Math.random()*400)+1000;
        y=(int)(Math.random()*200);
        dx=(int)(Math.random()*5)+1;
        dy=(int)(Math.random()*5)+1;
        img= ImageIO.read(new File("enemy-meteor.png"));
        damage=0;
        alpha=1f;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public void increaseDamage(int n) {
        damage+=n;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void myDraw(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        g2d.drawImage(img, x, y, 200,200,null);
    }
    public void myMove(){
        x-=dx;
        y+=dy;
    }

    @Override
    public int getType() {
        return 3;
    }

    @Override
    public void setAlpha(float f) {
        //have it gradually fade as setAlpha is called on it
        alpha-=f;
    }
}
