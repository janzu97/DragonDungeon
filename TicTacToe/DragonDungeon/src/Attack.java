
public interface Attack {


	public void activate( Targetable target, Targetable target2);
	public void GiveDescription();
	public String getName();
	//Palauttaa hyokkayksen nimen
}
class PoisonCloud implements Attack{

	@Override
	public void activate(Targetable target, Targetable target2) {
		SReader.read("You create some poisonous mist.\n");
		if(RNG.roll(64)) {
			target2.takemagicDamage(210);
			target2.poisoned();
			SReader.read("Dragon was poisoned");
		}else {
			target2.takemagicDamage(80);
		}
		target.useMana(120);
		
	}

	@Override
	public void GiveDescription() {
		
	}

	@Override
	public String getName() {
		return "Poison cloud";
	}
	
}
class Stoneskin implements Attack{

	@Override
	public void activate(Targetable target, Targetable target2) {
		SReader.read("You focus and tense your entire body. Your skin becomes hard as stone.\n");
		target.ArmorUp();
	}

	@Override
	public void GiveDescription() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Stone skin";
	}
}
class BurningAcid implements Attack{

	@Override
	public void activate(Targetable target, Targetable target2) {
			SReader.read("You used burning acid\n");
			target2.takemagicDamage(200);
			target2.LowerArmor();
	}

	@Override
	public void GiveDescription() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Burning acid";
	}
}
class HealthtoMana implements Attack{

	@Override
	public void activate(Targetable target, Targetable target2){
		SReader.read("You concentrate and turn your life energy into magic power.\n");
		if(target.getmaxMp()<target.getMp()+200) {
			int a = target.getmaxMp()-target.getMp();
			target.takemagicDamage(a);
			target.setMP(target.getMp()+a);
			SReader.read("You turn "+a+" hp into mana.\n");
		}else {
			target.takemagicDamage(200);
			target.setMP(target.getMp()+200);
			SReader.read("You turn 200 hp into mana.\n");
		}
		
	}

	@Override
	public void GiveDescription() {
		
	}

	@Override
	public String getName() {
		return "Blood Pact";
	}
	
}
class Blizzard implements Attack{
	String name="Blizzard";
	@Override
	public void activate( Targetable target, Targetable target2) {
		SReader.read("You try to summon a icy storm around the dragon\n");
		if(RNG.roll(50)) {
			target2.takemagicDamage(400);
			target2.setFrozen(new Freeze(2));
		}else {	
			SReader.read("but you failed the spell\n");
		}
		target.useMana(200);

	}
	@Override
	public void GiveDescription() {
	}
	@Override
	public String getName() {
		return name;
	}


}
class Inferno implements Attack {

	@Override
	public void activate(Targetable target, Targetable target2) {
		SReader.read("You cast blaze of fire at dragon\n");
		if(RNG.roll(40)) {
			target2.takemagicDamage(350);
		}else {
			SReader.read("but you missed\n");
		}
		target.useMana(100);
		
	}

	@Override
	public void GiveDescription() {
		
	}

	@Override
	public String getName() {
		return "Inferno";
	}
	
}

class Invigorating_Shout implements Attack {

	@Override
	public void activate(Targetable target, Targetable target2) {
		SReader.read("You feel adrenalin rushing through your veins,\n");
		if(target.getmaxhp()>=990+target.get_HP()) {
			target.takemagicDamage(-990);
			SReader.read(990+" Hp recovered\n");
		}else {
			SReader.read(1000-target.get_HP()+" Hp recovered\n");

			target.takemagicDamage(-(1000-target.get_HP()));
		}
		target.useMana(100);
	}

	@Override
	public void GiveDescription() {

	}

	@Override
	public String getName() {
		
		return "Invigorating shout";
	}

}
