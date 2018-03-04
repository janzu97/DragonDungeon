public interface Item {
	public void activateEffect(Targetable target,Targetable target2);
	@Override
	public String toString();
	
}
class PotionOfInvigoration implements Item{
	@Override
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
	public String toString() {
		return "Potion Of Invigiration";
	}
	
}
class MagicalEssence implements Item{

	@Override
	public void activateEffect(Targetable target,Targetable target2) {
		SReader.read("You drink a vial of MagicalEssence.\n");
		if(target.getmaxMp()<target.getMp()+200) {
			target.setMP(target.getmaxMp());
			SReader.read("Your mana is now full.\n");
		}else {
			target.setMP(target.getMp()+200);
			SReader.read("You get 200 more mana.\n");
		}
		SReader.read("\n");
		
	}
	public String toString() {
		return "MagicalEssence";
	}
	
}
class PotionOfFortification implements Item{
	public void activateEffect(Targetable target,Targetable target2) {
		
		
	}
	public String toString() {
		return"Potion Of Fortification";
	}
}
class BagOfSalt implements Item{ 
	@Override
	public void activateEffect(Targetable target,Targetable target2) {
		SReader.read("You throw a bag of salt at the dragon\n");
			if(RNG.roll(70)){
				SReader.read("Dragon eats the bag and it's bloodpressure rises\n");
				target2.setArmor(target2.getArmor()/2);
				SReader.read("Dragons armor is now"+ target2.getArmor());
			}
			else{
				SReader.read("Dragon throws the bag bact at you\n");
				target.setArmor(target.getArmor()*0.70);
				SReader.read("Your armor is now"+ target.getArmor()+"\n");
			}
		
	}
	public String toString() {
		return "Bag Of Salt";
	}
	
}
