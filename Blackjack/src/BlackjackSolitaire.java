import java.util.ArrayList;
import java.util.Scanner;

public class BlackjackSolitaire {
	/*
	 * This class will help us play the game.
	 */

	BoardMain boards;
	Deck cards;
	ScoringGame scores;

	/*
	 * the playCard method allows us to play and score the game.
	 */
	void play() {

		// Initialize board.

		BoardMain spotsForCard = new BoardMain();

		// Create a random deck of cards.

		Deck randomDeck = new Deck();

		ArrayList<String> randomDeckToPlay = randomDeck.randomDeck();

		// Create a for loop with 20 iterations to play the game.

		for (int i = 0; i < 20; i++) {

			// Get card to play from random deck.

			String cardToPlay = randomDeckToPlay.get(i);

			// Ask user for input.

			System.out.println("From spot 1 to 20, where do you want to place the card " + cardToPlay + "?");

			Scanner placeCard = new Scanner(System.in);

			// Make sure the user inputs an integer or else error and they will need to
			// replay the card.

			if (placeCard.hasNextInt()) {

				int cardPosition = placeCard.nextInt();

				// Make sure the user inputs an integer between 1 and 20 or they will get an
				// error and be prompted to replay the card.

				if (cardPosition <= 20 && cardPosition > 0) {

					// Make sure the user cannot input a number where another card is already played
					// or else they will get an error and be prompted to replay the card.

					if (spotsForCard.containsCard(cardPosition, spotsForCard.boardTop, spotsForCard.boardBottom,
							spotsForCard.discardSpots)) {

						System.out.println(
								"Error, you attempted to place the card in a spot which is already taken by another card. Please select a different spot.");

						i = i - 1;
					}

					// If a user plays an integer between 1 and 20 on a spot which doesn't already
					// have a card then play game.

					else {

						spotsForCard.spotsReturnedArray(cardPosition, cardToPlay);

						spotsForCard.display();

						randomDeckToPlay.remove(i);

					}

					// If all 16 spots on the board are filled then end game.

					if (spotsForCard.allSpotsFilled(spotsForCard.boardTop, spotsForCard.boardBottom)) {

						break;
					}
				}

				else {

					System.out.println(
							"Error, you either selected a number greater than 20 or less than 1. Please play again.");

					i = i - 1;
				}
			}

			else {

				System.out.println("Error, you selected a non-integer. Please play again.");

				i = i - 1;
			}
		}
			
		System.out.println();
		
		// Calculate the score for the game.
		

		System.out.print("The score for your game is: ");

		String[] cardInput = cards(spotsForCard);

		System.out.println(calculationTime(cardInput, spotsForCard));
		
		System.out.println();

		System.out.println("The game is done.");
	}

	/*
	 * The cards method will allow us to store a card in the spot where our user
	 * plays. We use a single array to store all the cards in all the spots a user
	 * plays.
	 */

	String[] cards(BoardMain boardInput) {

		String[] cardArray = new String[16];

		cardArray[0] = boardInput.boardTop[0][0]; // card 1
		cardArray[1] = boardInput.boardTop[0][1];
		cardArray[2] = boardInput.boardTop[0][2];
		cardArray[3] = boardInput.boardTop[0][3];
		cardArray[4] = boardInput.boardTop[0][4];
		cardArray[5] = boardInput.boardTop[1][0];
		cardArray[6] = boardInput.boardTop[1][1];
		cardArray[7] = boardInput.boardTop[1][2];
		cardArray[8] = boardInput.boardTop[1][3];
		cardArray[9] = boardInput.boardTop[1][4];

		cardArray[10] = boardInput.boardBottom[0][0];
		cardArray[11] = boardInput.boardBottom[0][1];
		cardArray[12] = boardInput.boardBottom[0][2];
		cardArray[13] = boardInput.boardBottom[1][0];
		cardArray[14] = boardInput.boardBottom[1][1];
		cardArray[15] = boardInput.boardBottom[1][2];

		return cardArray;
	}

	/*
	 * The calculationTime method will allow us to calculate the final score of the
	 * game.
	 */

	int calculationTime(String[] cardsInput, BoardMain boardObjectInput) {

		ScoringGame newGameScore = new ScoringGame();

		// Below we calculate the score for the first, second, third, and fourth row on
		// the board.

		int scoreForRowOneGame = newGameScore.calculateScoreFirstTwoRows(cardsInput[0], cardsInput[1], cardsInput[2],
				cardsInput[3], cardsInput[4]);

		int scoreForRowTwoGame = newGameScore.calculateScoreFirstTwoRows(cardsInput[5], cardsInput[6], cardsInput[7],
				cardsInput[8], cardsInput[9]);

		int scoreForRowThreeGame = newGameScore.calculateScoreLastTwoRows(cardsInput[10], cardsInput[11],
				cardsInput[12]);
		
		int scoreForRowFourGame = newGameScore.calculateScoreLastTwoRows(cardsInput[13], cardsInput[14],
				cardsInput[15]);

		
		
		// Below was the only way I could make A's get calculated correctly.
		
		BlackjackSolitaire checker = new BlackjackSolitaire();
		
		scoreForRowOneGame=checker.checkForAceInRowOneAndTwo(scoreForRowOneGame, boardObjectInput.boardTop, 1);
		scoreForRowTwoGame=checker.checkForAceInRowOneAndTwo(scoreForRowTwoGame, boardObjectInput.boardTop, 2);
		scoreForRowThreeGame=checker.checkForAceInRowThreeAndFour(scoreForRowThreeGame, boardObjectInput.boardBottom, 3);
		scoreForRowFourGame=checker.checkForAceInRowThreeAndFour(scoreForRowFourGame, boardObjectInput.boardBottom, 4);
		
		
		
		// Below we calculate the score for the first, second, third, fourth, and fifth
		// column on the board.

		int scoreForFirstColumn = newGameScore.calculateScoreFirstAndLastColumn(cardsInput[0], cardsInput[5]);

		int scoreForLastColumn = newGameScore.calculateScoreFirstAndLastColumn(cardsInput[4], cardsInput[9]);

		int scoreForSecondColumn = newGameScore.calculateScoreMiddleColumns(cardsInput[1], cardsInput[6],
				cardsInput[10], cardsInput[13]);

		int scoreForThirdColumn = newGameScore.calculateScoreMiddleColumns(cardsInput[2], cardsInput[7], cardsInput[11],
				cardsInput[14]);

		int scoreForFourthColumn = newGameScore.calculateScoreMiddleColumns(cardsInput[3], cardsInput[8],
				cardsInput[12], cardsInput[15]);

		// Below we calculate the score for all the columns on the board.

		int scoreForAllColumns = newGameScore.scoreColumns(scoreForFirstColumn, scoreForSecondColumn,
				scoreForThirdColumn, scoreForFourthColumn, scoreForLastColumn, boardObjectInput.boardTop,
				boardObjectInput.boardBottom);

		// Below we calculate the score for all the rows on the board.

		int scoreForAllRows = newGameScore.scoreRows(scoreForRowOneGame, scoreForRowTwoGame, scoreForRowThreeGame,
				scoreForRowFourGame, boardObjectInput.boardTop, boardObjectInput.boardTop);

		// Below we calculate the total score for all the columns and rows on the board.

		int total = newGameScore.totalScore(scoreForAllColumns, scoreForAllRows);

		return total;
	}

	/*
	 * The checkForAce methods below help us change an Ace to 11 if the sum of the row is less than 12. 
	 */
	
	int checkForAceInRowThreeAndFour(int sum, String [][] board, int rowNumber) {
		
		if (rowNumber == 3) {

			if (board[0][0].indexOf('A') == 0 && sum < 12) {

				sum += 10;
			}

			if (board[0][1].indexOf('A') == 0 && sum < 12) {

				sum += 10;
			}

			if (board[0][2].indexOf('A') == 0 && sum < 12) {

				sum += 10;
			}

		}

		// helps us determine row four

		if (rowNumber == 4) {

			if (board[1][0].indexOf('A') == 0 && sum < 12) {

				sum += 10;
			}

			if (board[1][1].indexOf('A') == 0 && sum < 12) {

				sum += 10;
			}

			if (board[1][2].indexOf('A') == 0 && sum < 12) {

				sum += 10;
			}

		}
		return sum;
	} 

	int checkForAceInRowOneAndTwo(int sum, String [][] board, int rowNumber) {
		
		if (rowNumber == 1) {

			if (board[0][0].indexOf('A') == 0 && sum < 12) {

				sum += 10;
			}

			if (board[0][1].indexOf('A') == 0 && sum < 12) {

				sum += 10;
			}

			if (board[0][2].indexOf('A') == 0 && sum < 12) {

				sum += 10;
			}
			
			if (board[0][3].indexOf('A') == 0 && sum < 12) {

				sum += 10;
			}
			
			if (board[0][4].indexOf('A') == 0 && sum < 12) {

				sum += 10;
			}

		}

		// helps us determine row four

		if (rowNumber == 2) {

			if (board[1][0].indexOf('A') == 0 && sum < 12) {

				sum += 10;
			}

			if (board[1][1].indexOf('A') == 0 && sum < 12) {

				sum += 10;
			}

			if (board[1][2].indexOf('A') == 0 && sum < 12) {

				sum += 10;
			}
			
			if (board[1][3].indexOf('A') == 0 && sum < 12) {

				sum += 10;
			}
			
			if (board[1][4].indexOf('A') == 0 && sum < 12) {

				sum += 10;
			}

		}
		return sum;
	} 
}
