
public interface Attack {


	public void activate( Targetable target, Targetable target2);
	public void GiveDescription();
	public String getName();

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
		
	}

	@Override
	public void GiveDescription() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Poison cloud";
	}
	
}
class Blizzard implements Attack{
	String name="Blizzard";
	@Override
	public void activate( Targetable target, Targetable target2) {
		SReader.read("You try to summon a icy storm around the dragon\n");
		if(RNG.roll(50)) {
			target2.takemagicDamage(990);
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
			target2.takemagicDamage(650);
		}else {
			SReader.read("but you missed\n");
		}
		target.useMana(90);
		
	}

	@Override
	public void GiveDescription() {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub

	}

	@Override
	public String getName() {
		return "Invigorating shout";
	}

}
