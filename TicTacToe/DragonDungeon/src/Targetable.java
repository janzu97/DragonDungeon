
abstract interface Targetable {
	//Kayttaa kohteen manaa
	public void useMana(int a);
	//tekee kohteelle vahinkoa
	public void takeDamage(int amount);
	//palauttaa kohteen maksimi HP:n
	public int getmaxhp();
	//palauttaa kohteen nykyisen HP:n
	public int get_HP();
	//Alentaa kohteen armoria
	public void LowerArmor();
	//nostaa kohteen armoria
	public void ArmorUp();
	//asettaa kohteen armorin
	public void setArmor(double armor);
	//palauttaa kohteen armorin
	public double getArmor();
	//tekee kohteeseen armorista riippumatonta vahinkoa
	public void takemagicDamage(int i);
	//asettaa kohteen jaahan
	public void setFrozen(Freeze f);
	//palauttaa kohteen MP:n
	public int getMp();
	//palauttaa kohteen maksimi MP:n
	public int getmaxMp();
	//Asettaa kohteen MP:n
	public void setMP(int mp);
	//Myrkyttaa kohteen
	public void poisoned();
}
