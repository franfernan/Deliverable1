import java.io.IOException;
import java.util.*;

public class War {

	public static void main(String[] args) {
		GroupOfCards deck = new GroupOfCards();
		deck.shuffle();
		String userInput;
		int flagMainLoop = 1;
		int flagNameChange = 1;
		int warFlag = 0;
		int p1Points = 0;
		int p2Points = 0;
		int p1History = 0;
		int p2History = 0;
		Scanner scanner = new Scanner(System.in);

		System.out.print("Welcome to War!\nBegin by entering player 1's name: ");
		Player playerOne = new Player(scanner.nextLine());
		System.out.print("Now what is player 2's name? ");
		Player playerTwo = new Player(scanner.nextLine());

		do {
			System.out.println("Instructions:");
			System.out.print("Press 'enter' to continue with the game. Type '1'"
					+ "to see the rules of War. Type '2' to change your player " + "name. Type '3' to see\n"
					+ "the win record for both players. Type '4' to exit. ");
			userInput = scanner.nextLine();
			if (userInput.equals("2")) {
				do {
					System.out.print("Which player wants to change their name? Player 1 or 2? ");
					userInput = scanner.nextLine();
					if (userInput.equals("1")) {
						System.out.print("What is player 1's new name? ");
						playerOne.setPlayerID(scanner.nextLine());
						flagNameChange = 0;
					} else if (userInput.equals("2")) {
						System.out.print("What is player 2's new name? ");
						playerTwo.setPlayerID(scanner.nextLine());
						flagNameChange = 0;
					}

					else {
						System.out.println("Input should be either 1 for player 1 or 2 for player 2.");
					}
					System.out.println("Player name has been changed. Going back to the main menu.\n");
				} while (flagNameChange == 1);
			}

			else if (userInput.equals("1")) {
				System.out.println("\nThe game of War starts by each player recieving half of the "
						+ "52 card deck. Both players simultaneously draws a card\nand compares them."
						+ " The player that drew the higher valued card (aces are the highest) will "
						+ "recieve a point. If\nboth players draw cards with the same value, war "
						+ "is declared! The next set of cards that the players draw will be\nworth "
						+ "6 points instead of just 1. When the decks of cards run out, the player "
						+ "with the most points is the winner!\n\nGoing back to the main menu.\n\n");

			} else if (userInput.equals("")) {
				System.out.println("\nA game of War has begun between " + playerOne.getPlayerID() + " and "
						+ playerTwo.getPlayerID() + "!\n");
				for (int i = 26; i > 0; i--) {
					System.out.print(playerOne.getPlayerID() + " has " + (i) + " cards left with " + p1Points
							+ " points.\n" + playerTwo.getPlayerID() + " has " + (i) + " cards left with " + p2Points
							+ " points.\nPress enter to draw your next cards.");

					userInput = scanner.nextLine();

					System.out.println("\n" + playerOne.getPlayerID() + " has drawn the " + deck.getCard(i - 1)
							+ " and " + playerTwo.getPlayerID() + " has drawn the " + deck.getCard((i * 2) - 1) + ".");

					if (warFlag == 1) {
						warFlag = 0;
						if (deck.getValue(i - 1) > deck.getValue((i * 2) - 1)) {
							System.out.println(playerOne.getPlayerID() + " has won the War!");
							p1Points += 6;
						} else if (deck.getValue(i - 1) < deck.getValue((i * 2) - 1)) {
							System.out.println(playerTwo.getPlayerID() + " has won the War!");
							p2Points += 6;
						} else {
							System.out.println("Both players tied again! Nobody wins the war.");
						}
					} else if (deck.getValue(i - 1) > deck.getValue((i * 2) - 1)) {
						System.out.println(playerOne.getPlayerID() + " has won this round!\n");
						p1Points += 1;
					} else if (deck.getValue(i - 1) < deck.getValue((i * 2) - 1)) {
						System.out.println(playerTwo.getPlayerID() + " has won this round!\n");
						p2Points += 1;
					} else {
						System.out.println("Both players drew cards of the same value, this means War!\n"
								+ "The next round will be worth 6 points!\n");
						warFlag = 1;
					}

				}
				System.out.println("The War is over!");
				System.out.println(playerOne.getPlayerID() + " has " + p1Points + " points while "
						+ playerTwo.getPlayerID() + " has " + p2Points + " points.");
				if (p1Points > p2Points) {
					System.out.println("The winner is " + playerOne.getPlayerID() + "! Congrats!");
					p1History += 1;
				}
				if (p2Points > p1Points) {
					System.out.println("The winner is " + playerTwo.getPlayerID() + "! Congrats!");
					p2History += 1;
				} else {
					System.out.println("There is no winner, it is a draw!");
				}
				System.out.println(playerOne.getPlayerID() + " has won " + p1History + " time(s) while "
						+ playerTwo.getPlayerID() + " has won " + p2History + " time(s).");
				System.out.println("Going back to the main menu.\n");
			}

			else if (userInput.equals("3")) {
				System.out.println("\n" + playerOne.getPlayerID() + " has won " + p1History + " time(s) while "
						+ playerTwo.getPlayerID() + " has won " + p2History + " time(s).");
				System.out.println("Going back to the main menu.\n");
			}
			else if (userInput.equals("4")) {
				System.out.println("\nThanks for playing!");
				flagMainLoop = 0;
			}

		} while (flagMainLoop == 1);

	}

}
