/*Jessica Zhang
March 24, 2021
Java Final Version GUI game
ICS3U7 Ms. Strelkovska
 */
//class for the game frame that opens when playing the game
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class MyGameFrame extends JFrame implements KeyListener {
    static CardLayout cardsL;
    static Container c;
    static GamePanel gamePanel;
    ImageIcon ii;

    public MyGameFrame(String title) throws IOException {
        super(title);
        ii = new ImageIcon("player-alien.png");
        this.setIconImage(ii.getImage());
        gamePanel = new GamePanel();
        addKeyListener(this);
        c = getContentPane();
        cardsL = new CardLayout();
        c.setLayout(cardsL);
        c.addKeyListener(this);
        //
        gamePanel.addKeyListener(this);
        gamePanel.setFocusable(true);
        c.add(gamePanel);
        this.setSize(1360, 718);
        setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
