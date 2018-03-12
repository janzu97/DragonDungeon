import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Controller extends JPanel implements KeyListener{
	private int location=1;
	private int loc_MAX=10;


	JFrame frame=new JFrame();
	public void launch() {
		//Aloittaa Controllerin toiminnan
		frame.setSize(200, 200);
		frame.addKeyListener(this);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setTitle("GameController");
		frame.setVisible(true);


	}
	public void setMAX_loc(int val) {
		//Asettaa maksimin locationin koolle
		//lisaksi asettaa locationin yhteen
		loc_MAX=val;
		location=1;
	}

//muuttaa nappain syotteen liikkeeksi listassa
	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode()==KeyEvent.VK_UP) {

			if(location>1) {
				location--;
			}else {
				location=loc_MAX;
			}
			
		}else if(e.getKeyCode()==KeyEvent.VK_DOWN) {

			if(location<loc_MAX) {
				location++;
			}else {
				location=1;
			}
			
		}else if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			Main.selectionmade=true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}
	public int get_Location() {
		//palauttaa sijainnin controllerissa
		return location;
	}
}
