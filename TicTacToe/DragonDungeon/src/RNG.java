import java.util.Random;

public class RNG {
	static Random r=new Random();
	public static int rint(int range) {
		//palauttaa numeron valilta 0-parametri
		return r.nextInt(range);
	}
	public static boolean roll(int chance) {
		//Tekee testin joka onnistuu tietylla todennakoisyydella
		if(r.nextInt(100)<100-chance) {
			return true;
		}else {
			return false;
		}


	}
}
