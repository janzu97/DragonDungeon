import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.Scanner;

import javafx.scene.media.*;
public class SReader {
	String Readabletext;

	public static String ReadFile(File f) {
		//Lukee tiedosto string olioksi
		String text = "";
		try {
			Scanner sc=new Scanner(f);
			while(sc.hasNextLine()) {
				text+=sc.nextLine()+"\n";

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return text;

	}
	public static void read(String txt) {
		//lukee tiedoston merkki kerrallaa soittataen jokaisen merkin kohdalla aaniefektin merkkien tulostus nopeus riippuu merkista
		txt=txt.replaceAll("pelaaja", Main.getPlayer().getname());
		long nanotime1=System.nanoTime();
		long nanotime2=0;

		AudioClip sc = new AudioClip(Paths.get("res\\sfx\\sfx-typwriter.wav").toUri().toString());
		sc.setVolume(0.5f);
		for(int i=0; i<txt.length(); i++) {
			char x=txt.charAt(i);
			System.out.print(x);
			if(x==' '|x=='\n') {
				while(nanotime2-nanotime1<100000000) {
					nanotime2=System.nanoTime();
				}
			}else if(x==','|x=='.'){

				while(nanotime2-nanotime1<100000000) {
					nanotime2=System.nanoTime();
				}
				sc.play();


			}else {
				while(nanotime2-nanotime1<50000000) {
					nanotime2=System.nanoTime();
				}
				sc.play();
			}

			nanotime1=System.nanoTime();
		}
		while(nanotime2-nanotime1<300000000) {
			nanotime2=System.nanoTime();
		}
	}
	public static String GenerateMenu(String[] options,Controller c) {
		//luo valikon parametrina annetuista vaihtoehdoista jota ohjaa parametrina annettu ohjain
		String result="";
		for(int i=1; i<=options.length; i++) {
			result+=options[i-1];
			if(i==c.get_Location()) {
				result+="<";
			}
			result +="\n";

		}
		return result;
	}
	public static void update(String nframe) {
		//tyhjentaa konsoli ruudun ja tulostaa annetun String oion 
		System.out.println("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
		System.out.println(nframe);
	}
}
