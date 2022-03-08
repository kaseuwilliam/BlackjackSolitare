
public class Card {

	/*
	 * This class creates a card which can be found in a standard 52-card deck. Our
	 * cards will be represented as a number/letter followed by a card type such as
	 * hearts etc. For example, a King of Hearts would be represented as KH.
	 */

	String cardName;
	String cardType;

	public Card(String cardName) {

		this.cardName = cardName;

	}
	/*
	 * The upperCardTypes method allows us to create the A, J, Q, and K cards in our
	 * Card Class. The index is the position of a specific card and the cardType
	 * determines whether a card is a Diamond, Spade, Heart, or Club.
	 */

	String upperCardTypes(int index, String cardType) {

		// Index only has the values 0, 10, 11, and 12

		String cardToDisplay = "None";

		if (index == 0) {

			cardToDisplay = "A";

		} else if (index == 10) {

			cardToDisplay = "J";

		} else if (index == 11) {

			cardToDisplay = "Q";

		} else if (index == 12) {

			cardToDisplay = "K";

		} else {

			System.out.println("You didn't put in a valid card"); // a fail safe mechanism
		}

		// Now that we know whether our card is an A, J, Q, or K, now we need to
		// determine what class type it is (i.e. clubs etc.)

		cardType = cardType.toLowerCase(); // a fail safe mechanism

		String card;

		// we use a switch statement to assign our card types to specific letters, i.e.
		// clubs equals the letter C.

		switch (cardType) {

		case "clubs":
			card = "C";
			break;
		case "diamonds":
			card = "D";
			break;
		case "hearts":
			card = "H";
			break;
		case "spades":
			card = "S";
			break;
		default:
			card = "You entered an invalid card, please remember the s at the end"; // a fail safe mechanism
			break;

		}
		return cardToDisplay + card;
	}

	/*
	 * The cardGenerator method allows us to create an array of cards.
	 */

	String[] cardGenerator() {

		cardName = cardName.toUpperCase();

		if (cardName.contentEquals("HEARTS") || cardName.contentEquals("CLUBS") || cardName.contentEquals("SPADES")
				|| cardName.contentEquals("DIAMONDS")) {

			// The cardType below will produce either H, C, S, or D.

			char cardType = cardName.charAt(0);

			String[] cards = new String[13];

			// The number below will help us keep track of the card number

			int number = 1;

			// The for loop below creates cards from 1 to 10, i.e. 10D

			for (int i = 1; i < 10; i++) {

				number = number + 1;
				cards[i] = String.valueOf(number) + cardType; // converts the number to a string
			}

			// The for loop below creates cards J, Q, and K, i.e. KH.

			for (int i = 10; i < 13; i++) {

				cards[i] = upperCardTypes(i, cardName);

			}

			// The code below creates our Ace cards, i.e. AH.

			cards[0] = upperCardTypes(0, cardName);

			return cards;

		} else {

			// This is a fail safe mechanism

			System.out.println(
					"You didn't type in a correct card type. Please remeber to place an s at the end, ex. hearts, instead of heart.");
			return null;
		}
	}

}
