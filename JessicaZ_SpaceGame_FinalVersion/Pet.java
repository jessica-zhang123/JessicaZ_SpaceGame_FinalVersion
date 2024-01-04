/*Jessica Zhang
March 24, 2021
Java Final Version GUI game
ICS3U7 Ms. Strelkovska
 */
//class for the pet
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Pet {
    public int x, y, dx, dy;
    BufferedImage img;
    String type;
    private float alpha;

    public Pet(String s) {
        //choose right image for parameter
		try {
            img = ImageIO.read(new File(s));
        } catch (IOException e) {
            e.printStackTrace();
        }
        x = 100;
        y = 300;
        alpha=1f;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String petType() {
        return type;
    }

    public void myDraw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        //give it a health bar
        g2d.setColor(Color.green);
        g2d.fillRect(x+30,y,80,10);
        g2d.setColor(Color.red);
        g2d.fillRect(x+30,y,GamePanel.petContact/5,10);
        g2d.drawImage(img, x, y, 150,150,null);
    }

    public void myMove() {
        y += dy;
        x += dx;
        //make it bounce when it hits borders
        if (y < 0 || y > 550) {
            y -= dy;
            dy *= -1;
        }
        if (x < 0 || x > 1200) {
            x -= dx;
            dx *= -1;
        }
    }

    public void enemyContact() {
        for (Enemies i : GamePanel.enemies) {
            //check contact by sensing if the top right corner is in contact with an enemy-within the width an height which we get by using dimensions and x y coordinates, then bottom right, top left, bottom left
            if ((GamePanel.pet.x>= i.getX() && GamePanel.pet.x <= i.getX() + 130 || GamePanel.pet.x + 130 >= i.getX() && GamePanel.pet.x + 130 <= i.getX() + 130) && (GamePanel.pet.y>=i.getY() && GamePanel.pet.y<=i.getY()+130 || GamePanel.pet.y+130>=i.getY() && GamePanel.pet.y+130<=i.getY()+130)) {
                GamePanel.petContact++;
            }
        }
    }
}
