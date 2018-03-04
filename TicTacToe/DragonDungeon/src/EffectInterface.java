public class EffectInterface {
	public void Activate_effect(int A_ID) {}
	public void Activate_effect(int A_ID, Targetable target) {

	}
	public void Activate_effect(int A_ID,Targetable target,Targetable target2) {

	}
}
class Poison extends EffectInterface{
	public Poison() {
		}
}
class Freeze extends EffectInterface{
	int rounds;
	public Freeze(int r) {
		rounds=r;
	}
	public int getRounds() {
		return rounds;
	}
	public void setRounds(int r) {
		this.rounds=r;
	}

}