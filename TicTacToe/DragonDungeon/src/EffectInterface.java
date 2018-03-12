public class EffectInterface {
	public void Activate_effect(int A_ID) {}
	public void Activate_effect(int A_ID, Targetable target) {

	}
	public void Activate_effect(int A_ID,Targetable target,Targetable target2) {

	}
}

class Freeze extends EffectInterface{
	int rounds;
	public Freeze(int r) {
	//luo jaatymisen instanssin
		rounds=r;
	}
	public int getRounds() {
		//palauttaa kuinka monta vuoroa kohde on jaassa
		return rounds;
	}
	public void setRounds(int r) {
		//asettaa kuika monta vuoroa kohde on jaassa
		this.rounds=r;
	}

}
