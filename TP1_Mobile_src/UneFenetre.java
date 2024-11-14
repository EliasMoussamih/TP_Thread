import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Semaphore;

public class UneFenetre extends JFrame {
    private UnMobile mobile1, mobile2, mobile3;
    private boolean enMouvement1 = true;
    private boolean enMouvement2 = true;
    private Thread threadMobile1, threadMobile2, threadMobile3;
    Semaphore barrage;
    public UneFenetre() {
        super("Fenêtre avec des mobiles");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 200);
        barrage = new Semaphore(1);

        setLayout(new GridLayout(3, 3));

        mobile1 = new UnMobile(300, 200, this, 1);
        mobile2 = new UnMobile(300, 200, this, 2);
        mobile3 = new UnMobile(300, 200, this, 3);

        add(mobile1);
        add(mobile2);
        add(mobile3);

        threadMobile1 = new Thread(mobile1);
        threadMobile1.start();

        threadMobile2 = new Thread(mobile2);
        threadMobile2.start();

        threadMobile3 = new Thread(mobile3);
        threadMobile3.start();

        setVisible(true);
    }

    public boolean isEnMouvement(int mobileId) {
        if (mobileId == 1) {
            return enMouvement1;
        } else if (mobileId == 2) {
            return enMouvement2;
        }
        return false;
    }
}
