
public class Main{

	public static void main(String[] args) {
		R r=new R();
		Thread t=new Thread(r);
		t.start();
	}

	

	

}
class R implements Runnable{

	@Override
	public void run() {
		System.out.println("c'mon mothafuckas c'mon");
	}
	
}