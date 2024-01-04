/*Jessica Zhang
March 24, 2021
Java Final Version GUI game
ICS3U7 Ms. Strelkovska
*/
//class for the running the game
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class RunSpaceGame {
    public static void main(String[] args) throws IOException {
        MyFrame frame=new MyFrame("Escape Space");
        frame.addKeyListener(frame);
        frame.setSize(1360,718);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
