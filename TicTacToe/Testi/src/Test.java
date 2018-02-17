import java.util.*;

public class Test {

	public static void main(String[] args) {
		final Random r = new Random();


		ArrayList<Tahdattava> kohteet = new ArrayList<>();

		for(int i=0; i<10; i++){
			int random = r.nextInt(3);
			switch(random){
			case 0: kohteet.add(new Noita("Morgana", 20, 30.0));
			case 1: kohteet.add(new Talonpoika("Pete", 20, 30.0));
			case 2: kohteet.add(new Illuusio());
			}
		}

		Ihminen taikuri = new Taikuri("Merlin", 530, 200.9);

		((Taikova)(Taikuri)taikuri).taio(kohteet);
	}

}

/**
 * -------------------- RAJAPINNAT -------------------------  
 */

/**
 * Rajapinta olioille, joita voidaan t‰hd‰t‰.
 */
interface Tahdattava{
	void vastaanota(Loitsu spell);
}

/**
 * Rajapinnan toteuttavat oliot ovat vahingoittavia.
 */
interface Vahingoittava{
	double getDamage();
}


/**
 * Rajapinnan toteuttavat oliot ovat parantavia.
 */
interface Parantava{
	int ELAMA = 0;
	int VOIMA = 1;

	/**
	 * Palauttaa voimakkuuden annetulle piirteelle
	 * @param stat piirre, johon parannus kohdistuu; kts. Parantava-rajapinnan luokkavakiot
	 * @return
	 */
	double getBuffStength(int stat);
}

/**
 * Taikova-rajapinnan toteuttavat oliot osaavat taikoa.
 */
interface Taikova{
	void taio(ArrayList<Tahdattava> kohteet);
}

/**
 * -------------------- IHMISET -------------------------  
 */

/**
 * Abstrakti luokka perusihmiselle. Jokaista ihmist‰ voidaan t‰hd‰t‰.
 */
abstract class Ihminen implements Tahdattava{
	protected String nimi;
	protected int ika;
	protected double elama;
	protected int voima = 10;

	public Ihminen(String nimi, int ika, double elama) {
		super();
		this.nimi = nimi;
		this.ika = ika;
		this.elama = elama;
	}

	public abstract void vastaanota(Loitsu spell);
}

/**
 * Ilke‰ noita. Kaikki noidat tulee sytytt‰‰ tuleen k‰ytt‰en tulipallo-taikaa. 
 */
class Noita extends Ihminen implements Taikova{

	public Noita(String nimi, int ika, double elama) {
		super(nimi, ika, elama);
	}

	@Override
	public void vastaanota(Loitsu spell) {
		if(spell instanceof Tulipallo){
			System.out.println("Sytytit ilke‰n noidan tuleen!");
			return;
		}

		if(spell instanceof Parantava){
			System.out.println("Autoit ilke‰‰ noitaa! =(");
		}
	}

	@Override
	public void taio(ArrayList<Tahdattava> kohteet) {
		for(Tahdattava t : kohteet)
			t.vastaanota(new Tulipallo(3));
	}
}

/**
 * Mukava talonpoika. Kaikkia talonpoikia tulee auttaa parantavilla taioilla.
 */
class Talonpoika extends Ihminen{

	public Talonpoika(String nimi, int ika, double elama) {
		super(nimi, ika, elama);
	}

	@Override
	public void vastaanota(Loitsu spell) {
		if(spell instanceof Vahingoittava){
			System.out.println("Vahingoitit Talonpoikaa! =(");
			return;
		}

		if(spell instanceof Parantava){
			System.out.println("Autoit talonpoikaa!");
			return;
		}
	}

}

/**
 * Illuusio. Illuusiot voidaan tuhota vain taioilla, jotka paitsi vahingoittavat, myˆs parantavat.
 */
class Illuusio implements Tahdattava{

	@Override
	public void vastaanota(Loitsu spell) {
		if(spell instanceof Parantava && spell instanceof Vahingoittava){
			if(((Vahingoittava)spell).getDamage() > 10){
				System.out.println("Mursit illuusion!");
			}else{
				System.out.println("Taikasi ei ollut tarpeeksi vahva murtaakseen illuusiota!");
			}
			return;
		}

		if(spell instanceof Parantava){
			System.out.println("Illuusio vahvistui vain parantavasta taiasta!");
			return;
		}

		if(spell instanceof Vahingoittava){
			System.out.println("Illuusio vahvistui vain vahingoittavasta taiasta!");
			return;
		}
	}

}
/**
 * -------------------- LOITSUT -------------------------  
 */

/**
 * Abstrakti luokka jokaiselle loitsulle.
 */
abstract class Loitsu{
	int vaadittavaTaika;

	public Loitsu(int vaadittavaTaika) {
		super();
		this.vaadittavaTaika = vaadittavaTaika;
	}

	public void loitsi(Tahdattava target){
		target.vastaanota(this);
	};

	public int annaVaadittavaTaika(){
		return vaadittavaTaika;
	}
}

/**
 * -------------------- OMA TOTEUTUKSESI -------------------------  
 */

class Taikuri extends Ihminen implements Taikova{
	Taikuri(String nimi, int ika, double elama){
		super(nimi,ika,elama);
	}
	@Override
	public void taio(ArrayList<Tahdattava> kohteet) {
		for(Tahdattava t : kohteet){
			if(t instanceof Noita){
				t.vastaanota(new Tulipallo(3));
			}else if(t instanceof Talonpoika) {
				t.vastaanota(new DivineBlessing(3));
			}else if(t instanceof Illuusio) {
				t.vastaanota(new BreakIllusion(3));
			}

		}

	}




	@Override
	public void vastaanota(Loitsu spell) {
		// TODO Auto-generated method stub

	}


}
class Tulipallo extends Loitsu implements Vahingoittava{

	public Tulipallo(int vaadittavaTaika) {
		super(vaadittavaTaika);

	}

	@Override
	public double getDamage() {
		// TODO Auto-generated method stub
		return 12;
	}
}
class DivineBlessing extends Loitsu implements Parantava{

	public DivineBlessing(int vaadittavaTaika) {
		super(vaadittavaTaika);

	}





	@Override
	public double getBuffStength(int stat) {
		// TODO Auto-generated method stub
		return 0;
	}
}
class BreakIllusion extends Loitsu implements Vahingoittava, Parantava{

	public BreakIllusion(int vaadittavaTaika) {
		super(vaadittavaTaika);

	}

	@Override
	public double getDamage() {
		// TODO Auto-generated method stub
		return 12;
	}

	@Override
	public double getBuffStength(int stat) {
		// TODO Auto-generated method stub
		return 12;
	}

}
