/**
 * 
 */
import java.io.*;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.BufferedReader;
import java.lang.String;

public class Affichage extends Thread{
	String texte;
	public static CemafaurBinaire cemafaurBinaire;

	public Affichage (String txt){
		texte=txt;
		this.cemafaurBinaire = new CemafaurBinaire(1);}

	public void run(){
			cemafaurBinaire.syncWait();
			for (int i=0; i<texte.length(); i++){
                System.out.print(texte.charAt(i));
				try {sleep(100);} catch(InterruptedException e){};

			} cemafaurBinaire.syncSignal();
	}
}
