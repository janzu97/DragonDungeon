import java.util.Random;

public class RNG {
	public static boolean roll(int chance) {
		Random r=new Random();
		
		if(r.nextInt(100)<100-chance) {
			return true;
		}else {
			return false;
		}
		
		
	}
}
