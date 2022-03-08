
public class BoardMain {
	
	/*
	 * This class helps us create a board numbered 1-16 that we can place cards on.
	 */

	String[][] boardTop;
	String[][] boardBottom;
	String[] discardSpots;

	public BoardMain() {

		/*
		 * We create 3 arrays to represent our board. The boardTop signifies our first
		 * and second row of our board, bottomBoard signifies the third and fourth row
		 * of our board, and discardSpots signifies our discarded cards.
		 */

		boardTop = new String[2][5];

		boardBottom = new String[2][3];

		discardSpots = new String[4];

		int sum = 1;

		// We number the boardTop from 1-10

		for (int i = 0; i < 2; i++) {

			for (int j = 0; j < 5; j++) {

				boardTop[i][j] = String.valueOf(sum++); // converts the string into a number
			}
		}

		// We number the boardBottom from 11-16

		for (int i = 0; i < 2; i++) {

			for (int j = 0; j < 3; j++) {

				boardBottom[i][j] = String.valueOf(sum++);
			}
		}

		// We number the discardSpots from 17-20

		for (int i = 0; i < 4; i++) {

			discardSpots[i] = String.valueOf(sum++);
		}
	}

	/*
	 * The spots method helps us place a card in a specific place on the board.
	 */

	void spots(int number, String cardType) {

		// The number represents the spot where an individual wants to place the card.

		switch (number) {

		case 1:
			boardTop[0][0] = cardType;
			break;
		case 2:
			boardTop[0][1] = cardType;
			break;
		case 3:
			boardTop[0][2] = cardType;
			break;
		case 4:
			boardTop[0][3] = cardType;
			break;
		case 5:
			boardTop[0][4] = cardType;
			break;
		case 6:
			boardTop[1][0] = cardType;
			break;
		case 7:
			boardTop[1][1] = cardType;
			break;
		case 8:
			boardTop[1][2] = cardType;
			break;
		case 9:
			boardTop[1][3] = cardType;
			break;
		case 10:
			boardTop[1][4] = cardType;
			break;
		case 11:
			boardBottom[0][0] = cardType;
			break;
		case 12:
			boardBottom[0][1] = cardType;
			break;
		case 13:
			boardBottom[0][2] = cardType;
			break;
		case 14:
			boardBottom[1][0] = cardType;
			break;
		case 15:
			boardBottom[1][1] = cardType;
			break;
		case 16:
			boardBottom[1][2] = cardType;
			break;
		case 17:
			discardSpots[0] = cardType;
			break;
		case 18:
			discardSpots[1] = cardType;
			break;
		case 19:
			discardSpots[2] = cardType;
			break;
		case 20:
			discardSpots[3] = cardType;
			break;
		}

	}

	/*
	 * The spotsReturnedArray is a placeholder so we can track which card we put
	 * into which spot and we can use it in our play class.
	 */

	String spotsReturnedArray(int number, String cardType) {

		String[] array = new String[1];

		switch (number) {

		case 1:
			boardTop[0][0] = cardType;
			array[0] = boardTop[0][0];
			break;
		case 2:
			boardTop[0][1] = cardType;
			array[0] = boardTop[0][1];
			break;
		case 3:
			boardTop[0][2] = cardType;
			array[0] = boardTop[0][2];
			break;
		case 4:
			boardTop[0][3] = cardType;
			array[0] = boardTop[0][3];
			break;
		case 5:
			boardTop[0][4] = cardType;
			array[0] = boardTop[0][4];
			break;
		case 6:
			boardTop[1][0] = cardType;
			array[0] = boardTop[1][0];
			break;
		case 7:
			boardTop[1][1] = cardType;
			array[0] = boardTop[1][1];
			break;
		case 8:
			boardTop[1][2] = cardType;
			array[0] = boardTop[1][2];
			break;
		case 9:
			boardTop[1][3] = cardType;
			array[0] = boardTop[1][3];
			break;
		case 10:
			boardTop[1][4] = cardType;
			array[0] = boardTop[1][4];
			break;
		case 11:
			boardBottom[0][0] = cardType;
			array[0] = boardBottom[0][0];
			break;
		case 12:
			boardBottom[0][1] = cardType;
			array[0] = boardBottom[0][1];
			break;
		case 13:
			boardBottom[0][2] = cardType;
			array[0] = boardBottom[0][2];
			break;
		case 14:
			boardBottom[1][0] = cardType;
			array[0] = boardBottom[1][0];
			break;
		case 15:
			boardBottom[1][1] = cardType;
			array[0] = boardBottom[1][1];
			break;
		case 16:
			boardBottom[1][2] = cardType;
			array[0] = boardBottom[1][2];
			break;
		case 17:
			discardSpots[0] = cardType;
			array[0] = discardSpots[0];
			break;
		case 18:
			discardSpots[1] = cardType;
			array[0] = discardSpots[1];
			break;
		case 19:
			discardSpots[2] = cardType;
			array[0] = discardSpots[2];
			break;
		case 20:
			discardSpots[3] = cardType;
			array[0] = discardSpots[3];
			break;
		}

		String returnedString = array[0];

		return returnedString;

	}

	/*
	 * The display method helps us display our board.
	 */

	void display() {

		for (int i = 0; i < 2; i++) {

			for (int j = 0; j < 5; j++) {

				System.out.format("%5s", boardTop[i][j]);
			}
			System.out.println();
		}

		for (int i = 0; i < 2; i++) {

			System.out.format("%5s", " ");

			for (int j = 0; j < 3; j++) {

				System.out.format("%5s", boardBottom[i][j]);
			}
			System.out.println();
		}

		System.out.println();
		System.out.println("The discard spots are " + discardSpots[0] + ", " + discardSpots[1] + ", "
				+ discardSpots[2] + ", and " + discardSpots[3] + ".");
	}

	/*
	 * The containsCard method helps us determine whether a specific spot has a card
	 * or not.
	 */

	boolean containsCard(int cardPosition, String[][] boardArrayOne, String[][] boardArrayTwo,
			String[] disgardedCards) {

		String spotFilled = "";

		switch (cardPosition) {

		case 1:
			spotFilled = boardArrayOne[0][0];
			break;

		case 2:
			spotFilled = boardArrayOne[0][1];
			break;

		case 3:
			spotFilled = boardArrayOne[0][2];
			break;

		case 4:
			spotFilled = boardArrayOne[0][3];
			break;

		case 5:
			spotFilled = boardArrayOne[0][4];
			break;

		case 6:
			spotFilled = boardArrayOne[1][0];
			break;

		case 7:
			spotFilled = boardArrayOne[1][1];
			break;

		case 8:
			spotFilled = boardArrayOne[1][2];
			break;

		case 9:
			spotFilled = boardArrayOne[1][3];
			break;

		case 10:
			spotFilled = boardArrayOne[1][4];
			break;

		case 11:
			spotFilled = boardArrayTwo[0][0];
			break;

		case 12:
			spotFilled = boardArrayTwo[0][1];
			break;

		case 13:
			spotFilled = boardArrayTwo[0][2];
			break;

		case 14:
			spotFilled = boardArrayTwo[1][0];
			break;

		case 15:
			spotFilled = boardArrayTwo[1][1];
			break;

		case 16:
			spotFilled = boardArrayTwo[1][2];
			break;

		case 17:
			spotFilled = disgardedCards[0];
			break;

		case 18:
			spotFilled = disgardedCards[1];
			break;

		case 19:
			spotFilled = disgardedCards[2];
			break;

		case 20:
			spotFilled = disgardedCards[3];
			break;

		}

		// If there is a card in a specific spot, then the method will return the true
		// value.

		if (spotFilled.contains("H") || spotFilled.contains("D") || spotFilled.contains("C")
				|| spotFilled.contains("S")) {

			return true;
		}

		else {
			return false;
		}
	}

	/*
	 * The allSpotsFilled method helps us determine whether all 16 spots on the
	 * board have been filled with a card or not.
	 */

	boolean allSpotsFilled(String[][] boardArrayOne, String[][] boardArrayTwo) {

		String[] spotCheckerOne = new String[16];

		int sum = 0;

		// The for loop below creates the first and second row on our board into one
		// array.

		for (int i = 0; i < 2; i++) {

			for (int j = 0; j < 5; j++) {

				spotCheckerOne[sum] = boardArrayOne[i][j];
				sum++;
			}
		}

		// The for loop below creates the third and fourth row on our board into one
		// array.

		for (int i = 0; i < 2; i++) {

			for (int j = 0; j < 3; j++) {

				spotCheckerOne[sum] = boardArrayTwo[i][j];
				sum++;
			}
		}

		int counter = 0;

		// The for loop below checks whether all the spots on our board are filled with
		// a card.

		for (int i = 0; i < 16; i++) {

			if (spotCheckerOne[i].contains("H") || spotCheckerOne[i].contains("D") || spotCheckerOne[i].contains("S")
					|| spotCheckerOne[i].contains("C")) {

				counter++;
			}
		}

		// The if statement below checks whether we have 16 spots filled with a card or
		// not.

		if (counter < 16) {
			return false;
		} else {
			return true;
		}
	}
}
