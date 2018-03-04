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
	public static void main(String[] args) {
		Runnable r = new Runnable() {
			public void run() {

				c.launch();
			}
		};
		
			loadSavedGame("res"+File.separator+"progress"+File.separator+"GameProgress.txt");
		
		Musicplayer.playSong();
		p.setName();
		p.addSpell(new Invigorating_Shout());
		p.addSpell(new Inferno());
		p.addSpell(new Blizzard());
		p.addSpell(new PoisonCloud());

		Thread t=new Thread(r);
		t.start();
		SReader.read(SReader.ReadFile(new File("res"+File.separator+"dialogue"+File.separator+"Opening.txt")));
		SReader.read(SReader.ReadFile(new File("res"+File.separator+"dialogue"+File.separator+"BattleOP.txt")));
		do{
			player_choose();
			d.DoRandomAttack(p);
			
		}while (d.get_HP()>0 && p.get_HP()>0 && run==true);
		SReader.read("\nGame over");
		saveScore();
		System.exit(0);
	}
	public long getScore(Dragon D) {
		return D.getScore();
	}
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
			SReader.update(p.name+" HP "+p.getHpbar()+"\n"+p.name+" MP "+p.getMPbar()+"\n"+SReader.GenerateMenu(options,c));
			
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
	public static Player getPlayer() {
		return p;
	}
	public static void saveScore() {
		try {
		    Files.write(Paths.get("res"+File.separator+"progress"+File.separator+"Scores.txt"), (p.name + d.getScore()).getBytes(), StandardOpenOption.APPEND);
		    Files.write(Paths.get("res"+File.separator+"progress"+File.separator+"Scores.txt"), ("\n").getBytes(), StandardOpenOption.APPEND);
		    Files.delete(new File("res"+File.separator+"progress"+File.separator+"GameProgress.txt").toPath());
		}catch (IOException e) {
		    
		}
	}
	public static void loadSavedGame(String file) {
		try {
		FileInputStream fis = new FileInputStream(file);
        Scanner scanner = new Scanner(fis);
      
        p.HP = Integer.parseInt(scanner.nextLine());
        p.MP = Integer.parseInt(scanner.nextLine());
        d.HP=Integer.parseInt(scanner.nextLine());
        scanner.close();
		}catch(FileNotFoundException f) {
			
		}
           
	}
	public static void saveGameDataToFile(String file) {   
		try {
			FileWriter fw = new FileWriter(file);
			fw.write(p.HP+"");
			fw.write("\r\n");
			fw.write(p.MP+"");
			fw.write("\r\n");
			fw.write(d.HP+"");
			fw.close();
		}catch(IOException e) {
		}
	}
}
	