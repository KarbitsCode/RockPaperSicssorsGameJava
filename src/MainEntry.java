import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

public class MainEntry {
	public static void main(String[] args) {
		String self_path = null;
		try {
			self_path = new File(MainEntry.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getPath();
		} catch (URISyntaxException | IllegalArgumentException e) {
			e.printStackTrace();
		}
		if (ConsoleMode.NotInConsole()) {
			try {
				Runtime.getRuntime().exec("cmd.exe /c start /w cmd.exe /c java -jar \"" + self_path + "\"");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				ConsoleMode.SetConsoleTitle("Rock Paper Sicssors Game in Java");
				new GameEngine();
				System.out.println("Thank you for playing!");
			} catch (InterruptedException | IOException e) {
				e.printStackTrace();
			}
		}
		try {
			TimeUnit.MILLISECONDS.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(0);
	}
}
