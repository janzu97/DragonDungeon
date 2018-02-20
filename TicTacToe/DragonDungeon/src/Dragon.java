import java.util.ArrayList;

public class Dragon extends Targetable{
	ArrayList<Attack> attacks=new ArrayList<Attack>();
	long HP=Integer.MAX_VALUE;
	long MaxHp=Integer.MAX_VALUE;
	double armor=1.00;
	@Override
	public void takeDamage(int amount) {
		int dmg=(int)(amount/armor);
		HP-=dmg;
		SReader.read("Dragon took "+dmg+" damage.");
	}
	public long getScore() {
		return MaxHp-HP;
	}
	public void Attack(int A_ID) {
		
		
	}
	public void EarthshatteringStomp(Player p){
		if(RNG.roll(20)) {
		p.takeDamage(990);
	}else {
		
		
	}}
	public void DoRandomAttack(Player t){
		
	}
	public void InfernalFlames(Player p) {
		p.takeMagicDamage(400);
	}	
	public void DraconicFrenzy(Player p) {
		if(RNG.roll(60)) {
			p.takeDamage(590);
		}else {
			
			
		}	
	}
	public void Attack(Player p) {
		
	}
	
}