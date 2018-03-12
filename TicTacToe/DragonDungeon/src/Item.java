public interface Item {
	public void activateEffect(Targetable target,Targetable target2);
	@Override
	public String toString();
	
}
class ItemCreator{
	//Luo Item olion sen nimen mukaan
	public static Item getItemByID(String ID) {
		switch(ID) {
		case "Bag_Of_Salt": return new BagOfSalt();
		case "Potion_Of_Fortification": return new PotionOfFortification();
		case "Potion_Of_Invigoration": return new PotionOfInvigoration();
		case "MagicalEssence": return new MagicalEssence();
		default: return new BagOfSalt();
		}
	}
}
class PotionOfInvigoration implements Item{
	@Override
	//Antaa lisää HP:tä
	public void activateEffect(Targetable target,Targetable target2) {
		SReader.read("You drink the potion\n");
		if(target.getmaxhp()>=300+target.get_HP()) {
			target.takemagicDamage(-300);
			SReader.read(300+" Hp recovered\n");
		}else {
			SReader.read(1000-target.get_HP()+" Hp recovered\n");

			target.takemagicDamage(-(1000-target.get_HP()));
		}
	
		
	}
	//Palauttaa olion nimen
	public String toString() {
		return "Potion_Of_Invigoration";
	}
	
}
class MagicalEssence implements Item{

	@Override
	//Antaa lisää manaa
	public void activateEffect(Targetable target,Targetable target2) {
		SReader.read("You drink a vial of MagicalEssence.\n");
		if(target.getmaxMp()<target.getMp()+200) {
			target.setMP(target.getmaxhp());
			SReader.read("Your mana is now full.\n");
		}else {
			target.setMP(target.getMp()+200);
			SReader.read("You get 200 more mana.\n");
		}
		SReader.read("\n");
		
	}
	//Palauttaa olion nimen
	public String toString() {
		return "MagicalEssence";
	}
	
}
class PotionOfFortification implements Item{
	// Parantaa pelaajan armoria
	public void activateEffect(Targetable target,Targetable target2) {
		SReader.read("You drink bottle of mysterious liquid.\n");
		if(target.getArmor()>0.00) {
			target.setArmor(target.getArmor()-0.75);
		}
		SReader.read("Your armor is now "+ target.getArmor()+"\n");
	}
	//Palauttaa olion nimen
	public String toString() {
		return"Potion_Of_Fortification";
	}
}
class BagOfSalt implements Item{ 
	@Override
	//Huonontaa lohikäärmeen tai pelaajan armoria
	public void activateEffect(Targetable target,Targetable target2) {
		SReader.read("You throw a bag of salt at the dragon\n");
			if(RNG.roll(70)){
				SReader.read("Dragon eats the bag and it's bloodpressure rises\n");
				target2.setArmor(target2.getArmor()/2);
				SReader.read("Dragons armor is now "+ target2.getArmor()+"\n");
			}
			else{
				SReader.read("Dragon throws the bag bact at you\n");
				target.setArmor(target.getArmor()+0.5);
				SReader.read("Your armor is now "+ target.getArmor()+"\n");
			}
		
	}
	//Palauttaa olion nimen
	public String toString() {
		return "Bag_Of_Salt";
	}
	
}
