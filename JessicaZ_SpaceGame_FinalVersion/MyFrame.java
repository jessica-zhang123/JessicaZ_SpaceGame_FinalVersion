/*Jessica Zhang
March 24, 2021
Java Final Version GUI game
ICS3U7 Ms. Strelkovska
 */
//class for mushroom ammo
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
    public class MyFrame extends JFrame implements KeyListener {
        static CardLayout cardsL;
        static Container c;
        static Container c2;
        static MyOpeningPanel open;
        static ChoiceMenu choicem;
        static Instructions instruct;
        ImageIcon ii;
        public MyFrame(String title)  throws IOException {
            super(title);
            ii=new ImageIcon("player-alien.png");
            this.setIconImage(ii.getImage());
            open=new MyOpeningPanel();
            choicem=new ChoiceMenu();
            instruct=new Instructions();
            addKeyListener(this);
            c=getContentPane();
            cardsL=new CardLayout();
            c.setLayout(cardsL);
            c.addKeyListener(this);
            //
            c.add(open);
            c.add(choicem);
            c.add(instruct);
            this.setSize(1360,718);
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
