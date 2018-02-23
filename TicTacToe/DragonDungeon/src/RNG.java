import java.util.Random;

public class RNG {
	static Random r=new Random();
	public static int rint(int range) {
		
		return r.nextInt(range);
	}
	public static boolean roll(int chance) {
		if(r.nextInt(100)<100-chance) {
			return true;
		}else {
			return false;
		}


	}
}
