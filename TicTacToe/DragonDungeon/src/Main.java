import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

public class Main implements Serializable{
	private static final long serialVersionUID = 1L;
	static Player p=new Player();
	static Controller c=new Controller();
	static boolean selectionmade=false;
	private static boolean run=true;
	static Dragon d=new Dragon();
	//Peliloop on täällä
	public static void main(String[] args) {
		Runnable r = new Runnable() {
			public void run() {

				c.launch();
			}
		};
		
		
		Musicplayer.playSong();
		p.setName();
		p.addSpell(new Invigorating_Shout());
		p.addSpell(new Inferno());
		p.addSpell(new Blizzard());
		p.addSpell(new PoisonCloud());
		p.addSpell(new HealthtoMana());
		p.addSpell(new BurningAcid());
		p.addSpell(new Stoneskin());

		Thread t=new Thread(r);
		t.start();
		Strt();
		do{
			player_choose();
			d.DoRandomAttack(p);
			
		}while (d.get_HP()>0 && p.get_HP()>0 && run==true);
		if(p.get_HP()>0 && d.get_HP()<=0) {
			SReader.read(SReader.ReadFile(new File("res"+File.separator+"dialogue"+File.separator+"BattleED.txt")));
			System.exit(0);
		}
		SReader.read("\nGame over");
		saveScore();
		System.exit(0);
	}
	//Palautta pelin lopputuloksen
	public long getScore(Dragon D) {
		return D.getScore();
	}
	//Luo päävalikon jossa pelaaja voi valita seuraavan toiminnon
	public static void player_choose() {
		selectionmade=false;
		c.setMAX_loc(4);
		String[] options= {"MELEE","MAGIC","ITEM","RUN"};
		while(!selectionmade) {

			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			SReader.update("Dragon HP"+d.getHpbar()+"\n"+p.name+" HP "+p.getHpbar()+"\n"+p.name+" MP "+p.getMPbar()+"\n"+SReader.GenerateMenu(options,c));
			
		}
		if(c.get_Location()==1) {
			chose_melee();
		}
		else if(c.get_Location()==2) {

			chose_magic();
		}
		else if(c.get_Location()==3) {
			chose_Item();
		}
		else if(c.get_Location()==4) {
			chose_run();
		}
	}
	// Luo hyökkäysvalikon josta pelaaja voi valita kumpaa käyttää 
	public static void chose_melee() {
		selectionmade=false;
		c.setMAX_loc(3);
		while(!selectionmade) {
			String[] options= {"HEAVY","LIGHT","BACK"};

			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			SReader.update(SReader.GenerateMenu(options,c));
		}
		switch(c.get_Location()) {
		case 1 : p.heavyAttack(d);
		break;
		case 2 : p.lightAttack(d);
		break;
		case 3 : player_choose();
		break;
		}
	}
	//Luo taikavalikon josta pelaaja voi valita mitä käyttää
	public static void chose_magic() {
		selectionmade=false;
		String[] options= p.getSpellnamesForMenu();
		c.setMAX_loc(p.getSpells().length+1);
		while(!selectionmade) {

			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			SReader.update(SReader.GenerateMenu(options,c));
		}
		if(c.get_Location()<options.length) {
			Attack[] spells=p.getSpells();
			for(int i=0; i<spells.length; i++) {
				if(i+1==c.get_Location()) {
					spells[i].activate(p, d);
				}
			}
		}else {
			player_choose();
		}
	}
	//Luo itemvalikon jossa pelaaja voi valita mitä hän haluaa käyttää
	public static void chose_Item() {
		selectionmade=false;
		c.setMAX_loc(p.getInventory().length+1);
		while(!selectionmade) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			SReader.update(SReader.GenerateMenu(p.i.getInventoryforMenu(),c));


		}
		if(c.get_Location()<p.i.items.size()+1) {
			p.i.activate_Item(p.i.getItem(c.get_Location()-1));
		}else {
			player_choose();
		}
	}
	//Kysyy pelaajalta aloitetaanko uusi peli vai jatketaanko vanhaa
	public static void Strt() {
		selectionmade=false;
		c.setMAX_loc(2);
		while(!selectionmade) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			SReader.update(SReader.GenerateMenu(new String[]{"New Game","Load Game"},c));

		}
		switch(c.get_Location()) {
		case 1 : SReader.read(SReader.ReadFile(new File("res"+File.separator+"dialogue"+File.separator+"Opening.txt")));
		SReader.read(SReader.ReadFile(new File("res"+File.separator+"dialogue"+File.separator+"BattleOP.txt")));
		;
		break;
		case 2 : loadSavedGame("res"+File.separator+"progress"+File.separator+"GameProgress.txt");
		break;
		
		}
	}
	//Lopetusvalikko jossa pelaaja voi valita haluaako hän tallentaa pelin
	public static void chose_run() {
		selectionmade=false;
		c.setMAX_loc(3);
		while(!selectionmade) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			SReader.update(SReader.GenerateMenu(new String[]{"QUIT AND SAVE","QUIT WHITHOUT SAVING","BACK"},c));

		}
		switch(c.get_Location()) {
		case 1 : saveGameDataToFile("res"+File.separator+"progress"+File.separator+"GameProgress.txt");
		System.exit(0);
		break;
		case 2 : saveScore();
		System.exit(0);
		break;
		case 3 : player_choose();
		break;
		}
	}
	//Palauttaa pelaajan
	public static Player getPlayer() {
		return p;
	}
	//Talentaa pelin lopputuloksen tiedostoon 
	public static void saveScore() {
		try {
		    Files.write(Paths.get("res"+File.separator+"progress"+File.separator+"Scores.txt"), (p.name + d.getScore()).getBytes(), StandardOpenOption.APPEND);
		    Files.write(Paths.get("res"+File.separator+"progress"+File.separator+"Scores.txt"), ("\n").getBytes(), StandardOpenOption.APPEND);
		    Files.delete(new File("res"+File.separator+"progress"+File.separator+"GameProgress.txt").toPath());
		}catch (IOException e) {
		    
		}
	}
	//Jatkaa tallennettua peliä 
	public static void loadSavedGame(String file) {
		try {
		FileInputStream fis = new FileInputStream(file);
        Scanner scanner = new Scanner(fis);
        p.armor=Double.parseDouble(scanner.nextLine());
        d.armor=Double.parseDouble(scanner.nextLine());
        p.HP = Integer.parseInt(scanner.nextLine());
        p.MP = Integer.parseInt(scanner.nextLine());
        d.HP=Integer.parseInt(scanner.nextLine());
        p.poison=Boolean.parseBoolean(scanner.nextLine());
        d.poison=Boolean.parseBoolean(scanner.nextLine());
        String frez=scanner.nextLine();
        if(frez.equals("")) {
        }else {
        	d.frozen = new Freeze(Integer.parseInt(frez));
        }
        String[] rigth = scanner.nextLine().split(" ");
        p.SetInventory(rigth);
        scanner.close();
		}catch(FileNotFoundException f) {
			
		}
           
	}
	//Tallentaa pelin tilan tiedostoon
	public static void saveGameDataToFile(String file) {   
		try {
			FileWriter fw = new FileWriter(file);
			fw.write(p.armor+"\n");
			fw.write(d.armor+"\n");
			fw.write(p.HP+"\n");
			fw.write(p.MP+"\n");
			fw.write(d.HP+"\n");
			fw.write(""+p.poison+"\n");
			fw.write(""+d.poison+"\n");
			if(d.frozen != null) {
	        	fw.write(""+d.frozen.getRounds()+"\n");
	        }else {
	        	fw.write("\n");
	        }
			String[] s = p.getInventory();
			if(s.length>0) {
				String items1="";
			for(String i : s) {
				items1+=i+" ";
				
			}
			
			fw.write(items1.substring(0, items1.length()-1));
			}else fw.write("");
			fw.close();
		}catch(IOException e) {
		}
	}
}
	
