import java.io.IOException;

public class ConsoleMode {
	public static boolean NotInConsole() {
		try {
			System.in.available();
			return false;
		} catch (IOException e) {
		    return true;
		}
	}
	public static void SetConsoleTitle(String title) throws InterruptedException, IOException {
		if (System.getProperty("os.name").contains("Windows")) {
			new ProcessBuilder("cmd.exe", "/c", "title " + title).inheritIO().start().waitFor();
		} else {
			System.out.print("\033]0;" + title + "\007");
		}
	}
	public static void ClearScreen() throws InterruptedException, IOException {
		if (System.getProperty("os.name").contains("Windows")) {
			new ProcessBuilder("cmd.exe", "/c", "cls").inheritIO().start().waitFor();
		} else {
			new ProcessBuilder("bash", "-c", "clear").inheritIO().start().waitFor();
		}
	}
}
