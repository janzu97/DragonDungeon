import java.util.ArrayList;

public class Cardlist {
	ArrayList<Integer> CardIdList=new ArrayList<Integer>();
	public Cardlist() {}
	public Cardlist(int x) {
		DefList();
	}
	public void addtolist(int card) {
		CardIdList.add(card);
	}
	public void DefList() {
		for(int i=0; i<30; i++) {
			CardIdList.add(0);
		}
	}
	public ArrayList<Integer> getList(){
		return CardIdList;
	}
}

