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
	Freeze frozen;
	Inventory i;
	boolean poison;
	double armor=1.00;
	String name="";
	//Luo uuden pelaaja olion oletus Inventorylla
	public Player() {
		this.i=new Inventory();
		i.addItem(new BagOfSalt());
		i.addItem(new MagicalEssence());
		i.addItem(new MagicalEssence());
		i.addItem(new PotionOfInvigoration());
		i.addItem(new PotionOfFortification());
	}
	//Luo parametrina saadusta listasta Inventoryn ja asettaa sen pelaajalle
	public void SetInventory(String[] rigth){
		this.i=new Inventory();
		for(String s : rigth) {
			i.addItem(ItemCreator.getItemByID(s));
		}
	}
	//Palauttaa pelaajan Invetoryn
	public String[] getInventory() {
		return i.getInventory();
	}
	//Luo Uuden pelaaja olion jonka Inventory annetaan parametrina 
	public Player(Inventory I) {
		this.i=I;
	}
	// Lisää Loitsun loitsulistalle 
	public void addSpell(Attack a){
		Spells.add(a);
	}
	//Jäädyttää pelaajan
	public void setFrozen(Freeze f) {
		frozen=f;
		
	}
	//Myrkyttää pelaajan
	public void poisoned() {
		poison=true;
		SReader.read("You got poisoned!\n");
	}
	//Palautta armorin arvon
	public double getArmor() {
		return armor;
	}
	// asettaa armorin arvon
	public void setArmor(double armor) {
		this.armor=armor;
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
	//Palauttaa pelaajan nimen
	public String getname() {
		return name;
	}
	//Vahingoittaa lohikäärmettä 
	public void lightAttack(Targetable t) {
		SReader.read("You launch into a quick attack.\n");
		if(RNG.roll(80)) {
			t.takeDamage(150);
		}else {
			SReader.read("But you misssed.\n");
		}
	}
	//Vahingoitaa lohikäärmettä enemmän
	public void heavyAttack(Targetable t) {
		SReader.read("You bring down your sword on the dragon with all your might\n");
		if(RNG.roll(60)) {
			t.takeDamage(300);
		}else {
			SReader.read("But you misssed.\n");
		}
	}
	@Override
	//Palauttaa HP:n arvon
	public int get_HP() {
		return this.HP;
	}
	//Palauttaa pelaajan loitsut Arrayssa
	public Attack[] getSpells() {
		Attack[] a=new Attack[Spells.size()];
		for(int i=0; i<Spells.size(); i++) {
			a[i]=Spells.get(i);
		}
		return a;

	}
	//Palauttaa palauttaa loutsu valikon  
	public String[] getSpellnamesForMenu() {
		String[] a=new String[Spells.size()+1];
		for(int i=0; i<Spells.size(); i++) {
			a[i]= Spells.get(i).getName();
		}
		a[Spells.size()]="BACK";
		return a;

	}
	@Override
	//Palautta maksimi HP:n 
	public int getmaxhp() {
		return this.MAX_HP;
	}
	@Override
	//Antaa vahinkoa fyysisestä hyökkäyksestä
	public void takeDamage(int amount) {
		if(poison) {
			HP-=amount*armor*2;
			SReader.read("You took "+amount*armor*2+" damage\n");
			if(RNG.roll(70)) {
				poison=false;
				SReader.read("Poison lost it's effect on you\n");
			}

		}else {
		HP-=amount*armor;
		SReader.read("You took "+amount*armor+" damage\n");
		}
	}
	@Override
	//Antaa vahinkoa maagisesta hyökkäyksestä
	public void takemagicDamage(int amount) {
		HP=HP-amount;
	}
	//Nostaa armoria
	public void ArmorUp(){
		if(armor>0.125) {
			armor=this.armor/2;
			SReader.read("pelaaja's armor was raised.\n");
		}else {
			SReader.read("pelaaja's armor can't go any higher.\n");
		}
	}
	//Piirtää HP palkin
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
	//Piirtää MP palkin
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
	Vähentää manaa parametrin verran
	public void useMana(int a) {
		MP-=a;
	}
	@Override
	//Palauttaa MP:n
	public int getMp() {
		return MP;
	}
	@Override
	//Palauttaa maksimi MP:n
	public int getmaxMp() {
		return Max_mp;
	}
	@Override
	//Asettaa parametrin MP:n arvoksi
	public void setMP(int mp) {
		this.MP=mp;
		
	}
	@Override
	//Alentaa armoria 
	public void LowerArmor() {
		if(armor<6) {
			armor=armor*2;
			SReader.read("pelaaja lowered their armor.\n");
		}else {
			SReader.read("pelaaja's armor can't go any lower.\n");
		}
	}
}
