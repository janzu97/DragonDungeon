import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Player implements Targetable{
	ArrayList<Attack> Spells=new ArrayList<Attack>();
	int HP=1000;
	int MP=1000;
	int Max_mp=1000;
	int MAX_HP=1000;
	Inventory i;
	double armor=1.00;
	String name="";
	public Player() {
		this.i=new Inventory();
	}
	public Player(Inventory I) {
		this.i=I;
	}
	public void addSpell(Attack a){
		Spells.add(a);
	}
	

	public void setName() {
		File f=new File("name.txt");
		Scanner sc;
		try {
			sc = new Scanner(f);
			while(sc.hasNext()) {
				name+=sc.next();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	public String getname() {
		return name;
	}
	public void lightAttack(Targetable t) {
		SReader.read("You launch into a quick attack.\n");
		if(RNG.roll(80)) {
			t.takeDamage(20);
		}else {
			SReader.read("But you misssed.");
		}
	}
	public void heavyAttack(Targetable t) {
		SReader.read("You bring down your sword on the dragon with all your might\n");
		if(RNG.roll(60)) {
			t.takeDamage(90);
		}else {
			SReader.read("But you misssed.");
		}
	}
	@Override
	public int get_HP() {
		return this.HP;
	}
	public Attack[] getSpells() {
		Attack[] a=new Attack[Spells.size()];
		for(int i=0; i<Spells.size(); i++) {
			a[i]=Spells.get(i);
		}
		return a;

	}
	public String[] getSpellnamesForMenu() {
		String[] a=new String[Spells.size()+1];
		for(int i=0; i<Spells.size(); i++) {
			a[i]= Spells.get(i).getName();
		}
		a[Spells.size()]="BACK";
		return a;

	}
	@Override
	public int getmaxhp() {
		return this.MAX_HP;
	}
	@Override
	public void takeDamage(int amount) {
		HP-=amount*armor;
		SReader.read("You took "+amount*armor+" damage");
	}
	@Override
	public void takemagicDamage(int amount) {
		HP=HP-amount;
	}
	public void NIS(){
		if(armor>0.125)
			armor=this.armor/2;

	}
	public String getHpbar() {
		String hp_bar="[";
		double pros=(HP*10.0)/MAX_HP;
		for(int i=0; i<=10; i++) {
			if(pros>=i) {
				hp_bar+="#";
				
			}else {
				hp_bar+=" ";
			}
			
		}
		hp_bar+="]";
		return hp_bar;
	}
	public String getMPbar() {
		String MP_bar="[";
		double pros=MP*10.0/Max_mp;
		for(int i=0; i<=10; i++) {
			if(pros>=i) {
				MP_bar+="#";
				
			}else {
				MP_bar+=" ";
			}
			
		}
		MP_bar+="]";
		return MP_bar;
	}
	@Override
	public void useMana(int a) {
		MP-=a;
	}
}