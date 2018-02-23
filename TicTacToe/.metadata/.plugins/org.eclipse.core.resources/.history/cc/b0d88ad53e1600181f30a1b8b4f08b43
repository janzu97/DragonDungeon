
public class MyTimer {
	public static void slow(int amountInNs) {
		long ntime1=System.nanoTime();
		long ntime2=System.nanoTime();
		while(ntime1-ntime2<amountInNs) {
			ntime2=System.nanoTime();
			try {
				Thread.sleep(amountInNs/3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}
