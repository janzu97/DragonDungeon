import java.util.ArrayList;

public class Dragon implements Targetable{
	ArrayList<Attack> attacks=new ArrayList<Attack>();
	int HP=Integer.MAX_VALUE;
	int MaxHp=Integer.MAX_VALUE;
	double armor=20;
	Freeze frozen;
	boolean poison;
	@Override
	public void takeDamage(int amount) {
		if(!poison) {
		int dmg=(int)(amount/armor);
		HP-=dmg;
		SReader.read("Dragon took "+dmg+" damage.");
		}else {
			int dmg=(int)(amount/armor*2);
			HP-=dmg;
			SReader.read("Poisoned dragon took "+dmg+" damage.");
			if(RNG.roll(70)) {
				poison=false;
				SReader.read("Poison lost it's effect on the Dragon");
			}
		}
	}
	public long getScore() {
		return MaxHp-HP;
	}
	public double getArmor() {
		return armor;
	}
	public void setArmor(double armor) {
		this.armor=armor;
	}
	public void Attack(int A_ID) {


	}
	@Override
	public int get_HP() {
		return HP;
	}
	public void EarthshatteringStomp(Player p){
		SReader.read("\nDragon tries to step on you with its entire weight,");
		if(RNG.roll(20)) {
			SReader.read("\nIt's a devastating blow ");
			p.takeDamage(990);
		}else {
			SReader.read("But it missed.");

		}}
	public void DoRandomAttack(Player t){
		if(frozen == null) {
			switch(RNG.rint(4)) {
			case 0 : InfernalFlames(t);
			break;
			case 1 : DraconicFrenzy(t);
			break;
			case 2 : EarthshatteringStomp(t);
			break;
			case 3 : PoisonFang(t);
			break;
			
		}
		}else {
				SReader.read("Dragon is frozen and can't attack\n");
				frozen.setRounds(frozen.getRounds()-1);
				if(frozen.getRounds()==0) {
					frozen = null;
				}
		}
		
	}
	public void InfernalFlames(Player p) {
	
		p.takemagicDamage(400);
		SReader.read("\nA blazing wall of fire erupts from the dragons mouth,\n you took 400 magic damage.");
	}
	public void PoisonFang(Player p){
		SReader.read("Dragon tries to bite you,\n");
		if(RNG.roll(40)) {
			p.takeDamage(400);
			p.poisoned();
			}else {
			SReader.read("But it missed.");	
			
		}	
	}
	public void DraconicFrenzy(Player p) {
		SReader.read("Dragon jumps into a furious onslaught,\n");
		if(RNG.roll(60)) {
			p.takeDamage(590);
			
			
		}else {
			SReader.read("But it missed.");	
			
		}	
	}
	public void Attack(Player p) {

	}
	@Override
	public void useMana(int a) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int getmaxhp() {
		return Integer.MAX_VALUE;
	}
	@Override
	public void takemagicDamage(int i) {
		this.HP-=i;
		SReader.read("Dragon took "+i+" damage.\n");
	}
	public void setFrozen(Freeze f) {
		frozen=f;
		
	}
	public int getMp() {
		return Integer.MAX_VALUE;
	}
	@Override
	public int getmaxMp() {
		return Integer.MAX_VALUE;
	}
	@Override
	public void setMP(int mp) {
		
	}
	public void poisoned() {
		poison=true;
	}
	
	

}