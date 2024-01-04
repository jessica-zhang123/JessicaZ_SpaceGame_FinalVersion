/*Jessica Zhang
March 24, 2021
Java Final Version GUI game
ICS3U7 Ms. Strelkovska
*/
//class for wormholes
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class Wormholes extends Friendlies{
    private int x,y;
    private double dx,dy;
    BufferedImage img;
    private float alpha;
    public Wormholes() throws IOException {
        x=(int)(Math.random()*400)+1000;
        y=(int)(Math.random()*300);
        dx=(int)(Math.random()*2)+1;
        dy=(int)(Math.random()*2)+1;
        img = ImageIO.read(new File("friend-wormhole.png"));
        alpha=1f;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
    public int getType(){
        return 3;
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
}
