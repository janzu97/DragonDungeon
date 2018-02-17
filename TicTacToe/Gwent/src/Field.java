
public class Field {
	Lane melee=new Lane();
	Lane range=new Lane();
	Lane siege=new Lane();
	public void buffLane(int lane) {
		if(lane==1) {
			melee.buff();
		}
		if(lane==2) {
			range.buff();
		}
		if(lane==3) {
			siege.buff();
		}
	}
	public int totalStrenght() {
		int mr=melee.laneStrenght();
		int rr=range.laneStrenght();
		int sr=siege.laneStrenght();
		if(melee.buffed()) {
			mr=mr*2;
		}
		if(range.buffed()) {
			rr=rr*2;
		}
		if(range.buffed()) {
			sr=sr*2;
		}
		return mr+rr+sr;
	}
	public void playCard(int lane,Card c) {
		if(lane==1) {
			melee.playCard(c);
		}
		if(lane==2) {
			range.playCard(c);
		}
		if(lane==3) {
			siege.playCard(c);
		}
	}
	@Override
	public String toString() {
		
		return melee+"\n"+range+"\n"+siege;
	}
	public void empty() {
		melee.empty();
		range.empty();
		siege.empty();
	}
}
