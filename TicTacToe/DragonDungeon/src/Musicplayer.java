import java.io.File;
import javafx.concurrent.*;
import java.nio.file.Paths;

import javafx.scene.media.*;
public class Musicplayer {



	public static void playSong() {
	//soittaa musiikkia
		Runnable r = new Runnable() {
			public void run() {
				AudioClip sc = new AudioClip(Paths.get("res\\bgm\\suspense.wav").toUri().toString());
				sc.setCycleCount(100);
				sc.play();
			}
		};			
		Thread thread = new Thread(r);
		thread.start();

	}


}
