/*Jessica Zhang
March 24, 2021
Java Final Version GUI game
ICS3U7 Ms. Strelkovska
 */
//class for the small alien on the progress bar
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class SmallAlien {
    static int x;
    static int y;
    BufferedImage img;
    public SmallAlien(){
        x=0;
        y=-30;
		try {
            img = ImageIO.read(new File("smallAlien.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void myDraw(Graphics g){
        g.drawImage(img, x,y, 200,200,null);
    }
}
