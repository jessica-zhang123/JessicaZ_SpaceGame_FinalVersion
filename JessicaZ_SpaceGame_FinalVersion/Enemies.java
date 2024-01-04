/*Jessica Zhang
March 24, 2021
Java Final Version GUI game
ICS3U7 Ms. Strelkovska
 */
//abstract class for enemies
import java.awt.*;
public abstract class Enemies {
    public abstract int getDamage();
    public abstract void increaseDamage(int n);
    public abstract int getX();
    public abstract int getY();
    public abstract void myDraw(Graphics g);
    public abstract void myMove();
    public abstract int getType();
    public abstract void setAlpha(float f);
}