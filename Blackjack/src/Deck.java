
import java.util.ArrayList;
import java.util.Random;

public class Deck {

	/*
	 * This class helps us create and randomize our deck. It uses the card class.
	 */

	Card card;

	/*
	 * The deckOfCards method helps us create an array called deck with 52 different
	 * cards within it.
	 */

	ArrayList<String> deckOfCards() {

		ArrayList<String> deck = new ArrayList<String>(); // code to myself: check the 52 to make sure its correct

		// Below we create new objects with the different card types.

		Card clubs = new Card("clubs");
		Card hearts = new Card("hearts");
		Card diamonds = new Card("diamonds");
		Card spades = new Card("spades");

		// Below we use the objects we just created to access the cardGenerator for each
		// card type and store it in an array.

		String[] arrayClubs = clubs.cardGenerator();
		String[] arrayHearts = hearts.cardGenerator();
		String[] arrayDiamonds = diamonds.cardGenerator();
		String[] arraySpades = spades.cardGenerator();

		// Below we create a counter variable to use in our for loop to add values to
		// our deck array.

		int counter1 = 0;
		int counter2 = 0;
		int counter3 = 0;

		// below we add cards to our deck array, starting with all the clubs then hearts
		// then diamonds then finally spades.

		for (int i = 0; i < 52; i++) {

			if (i <= 12) {

				deck.add(arrayClubs[i]);
			}

			else if (i >= 13 && i <= 25) {

				deck.add(arrayHearts[counter1]);

				counter1++;
			}

			else if (i >= 26 && i <= 38) {

				deck.add(arrayDiamonds[counter2]);

				counter2++;
			}

			else {

				deck.add(arraySpades[counter3]);

				counter3++;
			}
		}

		return deck;

	}

	/*
	 * The randomDeck method helps us randomize the deck we just created.
	 */

	ArrayList<String> randomDeck() {

		// We add all the elements of the deck we created in the deckOfCards method to
		// an array called decks.

		ArrayList<String> decks = new ArrayList<String>();
		decks.addAll(deckOfCards());

		// We create a new random deck.

		ArrayList<String> randomDeck1 = new ArrayList<String>();

		// We create a for loop which uses a random index to select an element from our
		// deck array and stores it into our random array, thus creating a random deck.

		for (int i = 0; i < 52; i++) {

			Random randomSelection = new Random();

			int myInt = randomSelection.nextInt(decks.size());// look at length

			randomDeck1.add(decks.get(myInt));

			decks.remove(myInt);

		}

		return randomDeck1;

	}

}
