import java.awt.*;
import javax.swing.*;
import java.util.Random;

class UnMobile extends JPanel implements Runnable {
	int saLargeur, saHauteur, sonDebDessin;
	final int sonPas = 10, sonCote = 40;
	int sonTemps;
	UneFenetre fenetre;
	int mobileId;

	UnMobile(int telleLargeur, int telleHauteur, UneFenetre fenetre, int mobileId) {
		super();
		saLargeur = telleLargeur;
		saHauteur = telleHauteur;
		setSize(telleLargeur, telleHauteur);
		this.fenetre = fenetre;
		this.mobileId = mobileId;

		Random random = new Random();
		sonTemps = 30 + random.nextInt(1020);
	}

	public void run() {
		while (true) {
			for (sonDebDessin = 0; sonDebDessin < saLargeur / 3; sonDebDessin += sonPas) {
				repaint();
				try {
					Thread.sleep(sonTemps);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			try {
				fenetre.barrage.acquire();
				for (; sonDebDessin < 2 * saLargeur / 3; sonDebDessin += sonPas) {
					repaint();
					Thread.sleep(sonTemps);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				fenetre.barrage.release();
			}

			for (; sonDebDessin < saLargeur; sonDebDessin += sonPas) {
				repaint();
				try {
					Thread.sleep(sonTemps);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}


	public void paintComponent(Graphics telCG) {
		super.paintComponent(telCG);
		telCG.fillRect(sonDebDessin, saHauteur / 2, sonCote, sonCote);
	}
}
