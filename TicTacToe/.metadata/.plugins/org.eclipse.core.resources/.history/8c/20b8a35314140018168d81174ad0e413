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
		// TODO Auto-generated method stub
		
	}
	public void heavyAttack() {
		// TODO Auto-generated method stub
		
	}
	}