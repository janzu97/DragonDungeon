
abstract interface Targetable {

	public void useMana(int a);
	public void takeDamage(int amount);
	
	public int getmaxhp();
	public int get_HP();
	public void LowerArmor();
	public void ArmorUp();
	public void setArmor(double armor);
	public double getArmor();

	public void takemagicDamage(int i);
	public void setFrozen(Freeze f);
	public int getMp();
	public int getmaxMp();
	public void setMP(int mp);
	public void poisoned();
}
