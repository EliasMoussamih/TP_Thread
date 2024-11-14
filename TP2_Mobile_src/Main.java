import java.io.*;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.BufferedReader;
import java.lang.String;

public class Main {

	public static void main(String[] args) {
		Affichage TA = new Affichage("AAA");
		Affichage TB = new Affichage("BB");
		Affichage TC = new Affichage("DDDDDDDDDDD");
		Affichage TD = new Affichage("CCCCCCCCCCCCCCCCCCCCCC");

		TA.start();

		TB.start();

		TC.start();

		TD.start();
	}

}
