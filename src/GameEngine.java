import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class GameEngine {
	public GameEngine() throws InterruptedException, IOException {
		Scanner scanner = new Scanner(System.in);
		boolean quitting = false;
		while (true) {
			if (quitting == true) {
				break;
			}
			ConsoleMode.ClearScreen();
			String[] choiceList = {"rock", "paper", "sicssors"};
			String botMove = choiceList[new Random().nextInt(choiceList.length)];
			String humMove;
			while(true) {
				System.out.println("Enter your move (r = rock, p = paper, s = sicssors, x = exit)");
				humMove = scanner.nextLine();
				if (humMove.equals("r")) {
					humMove = "rock";
					break;
				} else if (humMove.equals("p")) {
					humMove = "paper";
					break;
				} else if (humMove.equals("s")) {
					humMove = "sicssors";
					break;
				} else if (humMove.equals("rock")) {
					break;
				} else if (humMove.equals("paper")) {
					break;
				} else if (humMove.equals("sicssors")) {
					break;
				} else if (humMove.equals("x")) {
					quitting = true;
					break;
				} else if (humMove.equals("exit")) {
					quitting = true;
					break;
				}
				ConsoleMode.ClearScreen();
				System.out.println("Invalid move was entered: " + humMove);
			}
			if (quitting == false) {
				System.out.println();
				System.out.println("You played: " + humMove);
				System.out.println("Computer played: " + botMove);
				System.out.println();
				if (humMove.equals(botMove)) {
					System.out.println("TIE");
				} else if (humMove.equals("rock")) {
					if (botMove.equals("paper")) {
						System.out.println("Computer win!");
					} else if (botMove.equals("sicssors")) {
						System.out.println("You win!");
					}
				} else if (humMove.equals("paper")) {
					if (botMove.equals("rock")) {
						System.out.println("Computer win!");
					} else if (botMove.equals("sicssors")) {
						System.out.println("You win!");
					}
				} else if (humMove.equals("sicssors")) {
					if (botMove.equals("paper")) {
						System.out.println("Computer win!");
					} else if (botMove.equals("rock")) {
						System.out.println("You win!");
					}
				}
				System.out.println("Play again? (y/n)");
				while (true) {
					String playAgain = scanner.nextLine();
					if (playAgain.equals("y")) {
						quitting = false;
						break;
					} else if (playAgain.equals("n")) {
						quitting = true;
						break;						
					}
				}
			} else {
				break;
			}
		}
		scanner.close();
		System.out.println();
	}
}
