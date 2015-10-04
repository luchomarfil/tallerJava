package practica4.app;

import org.jfugue.player.Player;

public class FogueService {

	private static FogueService instance;

	private FogueService() {
	}

	public static FogueService instancia() {
		if (instance == null) {
			instance = new FogueService();
		}
		return instance;
	}

	public void ejecutarMelodia(String melodia) {
		Player player = new Player();
		player.play(melodia);
	}


}
