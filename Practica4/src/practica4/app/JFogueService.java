package practica4.app;

import org.jfugue.player.Player;

public class JFogueService {

	public void ejecutarMelodia(String melodia) {
		Player player = new Player();
		player.play("C D E F G A B");
	}
	
	public static void main(String[] args) {
		new JFogueService().ejecutarMelodia("");
	}

}
