import java.util.ArrayList;
import java.util.Random;

public class PenneysGame {
	
	public static int game(ArrayList<Character> playerOne, ArrayList<Character> playerTwo) {

		boolean won = false;
		int winner = 0;
		int flips = 0;
		ArrayList<Character> generated = new ArrayList<Character>();
		while (!won) {
			if(Math.random() < 0.5) {
				generated.add('H');
			} else {
				generated.add('T');
			}
			flips++;
			if (flips >= 3) {
				int lastIndex = generated.size() - 1;
				if (playerOne.get(2) == generated.get(lastIndex) && playerOne.get(1) == generated.get(lastIndex - 1) && playerOne.get(0) == generated.get(lastIndex - 2)) {
					won = true;
					winner = 1;
				} else if (playerTwo.get(2) == generated.get(lastIndex) && playerTwo.get(1) == generated.get(lastIndex - 1) && playerTwo.get(0) == generated.get(lastIndex - 2)) {
					won = true;
					winner = 2;
				}
			}
		}
		return winner;
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Character>> possibleInputs = new ArrayList<ArrayList<Character>>();
		ArrayList<Character> temp = new ArrayList<Character>();
		temp.add('H');
		temp.add('H');
		temp.add('H');
		possibleInputs.add(temp);
		temp = new ArrayList<Character>();
		temp.add('H');
		temp.add('H');
		temp.add('T');
		possibleInputs.add(temp);
		temp = new ArrayList<Character>();
		temp.add('H');
		temp.add('T');
		temp.add('H');
		possibleInputs.add(temp);
		temp = new ArrayList<Character>();
		temp.add('T');
		temp.add('H');
		temp.add('H');
		possibleInputs.add(temp);
		temp = new ArrayList<Character>();
		temp.add('H');
		temp.add('T');
		temp.add('T');
		possibleInputs.add(temp);
		temp = new ArrayList<Character>();
		temp.add('T');
		temp.add('T');
		temp.add('H');
		possibleInputs.add(temp);
		temp = new ArrayList<Character>();
		temp.add('T');
		temp.add('H');
		temp.add('T');
		possibleInputs.add(temp);
		temp = new ArrayList<Character>();
		temp.add('T');
		temp.add('T');
		temp.add('T');
		possibleInputs.add(temp);
		temp = new ArrayList<Character>();
		
		for (ArrayList<Character> p1 : possibleInputs) {
			int bestOptionCount = 0;
			ArrayList<Character> bestOption = null;
			for (ArrayList<Character> p2 : possibleInputs) {
				ArrayList<Integer> winners = new ArrayList<Integer>();
				if (p1 != p2) {
					System.out.print("Player One: ");
					for (int i = 0; i < 3; i++) {
						System.out.print(p1.get(i));
					}
					System.out.print("\nPlayer Two: ");
					for (int i = 0; i < 3; i++) {
						System.out.print(p2.get(i));
					}
					for (int i = 0; i < 100; i++) {
						winners.add(game(p1, p2));
					}
					int oneCount = 0;
					int twoCount = 0;
					for(int i = 0; i < winners.size(); i++) {
						if (winners.get(i) == 1) {
							oneCount++;
						} else {
							twoCount++;
						}
					}
					System.out.printf("\nProbability of Player One Win : 0.%d\n", oneCount);
					System.out.printf("Probability of Player Two Win : 0.%d\n"
							+ "", twoCount);
					if (twoCount > bestOptionCount) {
						bestOptionCount = twoCount;
						bestOption = p2;
					}
				}
			}
			System.out.println("-----------------------");
			System.out.print("If player One picks ");
			for (int i = 0; i < 3; i++) {
				System.out.print(p1.get(i));
			}
			System.out.print("\nPlayer two should pick ");
			for (int i = 0; i < 3; i++) {
				System.out.print(bestOption.get(i));
			}
			System.out.println("\n-----------------------");
		}
	}

}
