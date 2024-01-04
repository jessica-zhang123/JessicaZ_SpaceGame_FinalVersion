/*Jessica Zhang
March 24, 2021
Java Final Version GUI game
ICS3U7 Ms. Strelkovska
*/
//class for stars that fall on the opening screen
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class Stars {
    private double x,y, dx,dy;
    BufferedImage img;
    int size;
    float alpha;
    public Stars() throws IOException {
        alpha=1f;
		//random position and speeds and size
        x=Math.random()*1360;
        y=Math.random()*100;
        dx=Math.random()*1+1;
        dy=Math.random()*1+1;
        size=(int)(Math.random()*50)+50;
        img = ImageIO.read(new File("star1.png"));
    }
    public void myDraw(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        g2d.drawImage(img, (int)x, (int)y, size,size,null);
    }
    public void myMove(){
        x-=dx;
        y+=dy;
    }
}
