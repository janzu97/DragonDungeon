import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Player {
	int HP=1000;
	int MP=1000;
	Inventory i;
	double armor=1.00;
	String name="";
	public Player() {
		this.i=new Inventory();
	}
	public Player(Inventory I) {
		this.i=I;
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
	public void lightAttack() {

	}
	public void heavyAttack() {

	}
	public int get_HP() {
		return HP;
	}
	public void takeDamage(int amount) {
		HP-=amount*armor;
	}
	public void takeMagicDamage(int amount) {
		HP-=amount;
	}
	public void NIS(){
		if(armor>0.125)
		armor=this.armor/2;
		
	}
}