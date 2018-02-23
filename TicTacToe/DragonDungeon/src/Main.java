import java.io.File;
import java.util.ArrayList;
public class Main {
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
		Musicplayer.playSong();
		p.setName();
		p.addSpell(new Invigorating_Shout());

		Thread t=new Thread(r);
		t.start();
		SReader.read(SReader.ReadFile(new File("res\\dialogue\\Opening.txt")));
		SReader.read(SReader.ReadFile(new File("res\\dialogue\\BattleOP.txt")));
		do{
			player_choose();
			d.DoRandomAttack(p);
			
		}while (d.get_HP()>0 && p.get_HP()>0 && run==true);
		SReader.read("\nGame over");
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
		c.setMAX_loc(p.getSpells().length+1);
		while(!selectionmade) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			SReader.update(SReader.GenerateMenu(p.i.getInventoryforMenu(),c));


		}
		if(c.get_Location()<p.i.items.size()) {
			p.i.items.get(c.get_Location()-1).activateEffect();;
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
			
			SReader.update(SReader.GenerateMenu(new String[]{"QUIT AND SAVE","QUIT WHITHOUT SAVING","CANSEL"},c));

		}
	}
	public static Player getPlayer() {
		return p;
	}
}
