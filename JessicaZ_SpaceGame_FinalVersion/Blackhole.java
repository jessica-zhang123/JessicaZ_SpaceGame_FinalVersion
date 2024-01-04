/*Jessica Zhang
March 24, 2021
Java Final Version GUI game
ICS3U7 Ms. Strelkovska
 */
//class for blackholes
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class Blackhole extends Enemies{
    private int x,y;
    private double dx,dy;
    BufferedImage img;
    int damage;
    private float alpha;
    public Blackhole() throws IOException {
        x=(int)(Math.random()*400)+1000;
        y=(int)(Math.random()*200);
        dx=(int)(Math.random()*3)+1;
        dy=(int)(Math.random()*3);
        img= ImageIO.read(new File("enemy-blackhole.png"));
        damage=0;
        alpha=1f;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public void increaseDamage(int n) {
        damage++;
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
        return 1;
    }

    @Override
    public void setAlpha(float f) {
    }
}
