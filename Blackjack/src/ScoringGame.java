
public class ScoringGame {

	/*
	 * This class will enable us to score our game.
	 */

	Card cards;
	BoardMain boards;

	/*
	 * The score method will assign a score to each card, regardless of its type
	 * (hearts, clubs, diamonds, or spades).
	 */

	int score(String card) {

		int score;

		// We will assign cards 2-10 with a score of 2-10 respectively, cards above 10
		// with a score of 10, and all Aces with a score of 1.

		if (card.charAt(0) != 'A') { // specifies that the card is not an A

			char value = card.charAt(0);

			switch (value) {

			case '2':
				score = 2;
				break;
			case '3':
				score = 3;
				break;
			case '4':
				score = 4;
				break;
			case '5':
				score = 5;
				break;
			case '6':
				score = 6;
				break;
			case '7':
				score = 7;
				break;
			case '8':
				score = 8;
				break;
			case '9':
				score = 9;
				break;
			default:
				score = 10;
				break;
			}
		} else {
			score = 1;
		}
		return score;
	}

	/*
	 * The calculateScoreFirstTwoRows method calculates the score for the first or
	 * second row of our board (calculates spots 1-5, or 6-10).
	 */

	int calculateScoreFirstTwoRows(String cardOne, String cardTwo, String cardThree, String cardFour, String cardFive) {

		ScoringGame scores = new ScoringGame();

		int sum = 0;

		String[] cardsArray = { cardOne, cardTwo, cardThree, cardFour, cardFive };

		// We use the score method in our CardScores class to score our cards for the
		// first and second row of our 5-element array.

		for (int i = 0; i < 5; i++) {

			sum += scores.score(cardsArray[i]);
		}
		return sum;
	}

	/*
	 * The calculateScoreLastTwoRows method calculates the raw score for the first
	 * or second row of our board (calculates spots 11-13, or 14-16).
	 */

	int calculateScoreLastTwoRows(String cardOne, String cardTwo, String cardThree) {

		ScoringGame scores = new ScoringGame();

		int sum = 0;

		String[] cardsArray = { cardOne, cardTwo, cardThree };

		// We use the score method in our CardScores class to score our cards for the
		// first and second row of our 3-element array.

		for (int i = 0; i < 3; i++) {

			sum += scores.score(cardsArray[i]);
		}
		return sum;
	}

	/*
	 * The calculateScoreFirstAndLastColumn method calculates the raw score for the
	 * first or last column of our board (calculates spots 1 & 6, or 5 & 10).
	 */

	int calculateScoreFirstAndLastColumn(String cardOne, String cardTwo) {

		ScoringGame scores = new ScoringGame();

		int sum = 0;

		String[][] cardsArray = { { cardOne }, { cardTwo } };

		// We use the score method in our CardScores class to score our cards for the
		// first and last column of our 2-element array.

		for (int i = 0; i < 2; i++) {

			sum += scores.score(cardsArray[i][0]);
		}
		return sum;
	}

	/*
	 * The calculateScoreMiddleColumns method calculates the raw score for the
	 * third, fourth, or fifth column of our board -- calculates spots (2, 7, 11,
	 * 14), or (3, 8, 12, 15), or (4, 9, 13, 16).
	 */

	int calculateScoreMiddleColumns(String cardOne, String cardTwo, String cardThree, String cardFour) {

		ScoringGame scores = new ScoringGame();

		int sum = 0;

		String[][] cardsArray = { { cardOne }, { cardTwo }, { cardThree }, { cardFour } };

		// We use the score method in our CardScores class to score our cards for the
		// middle columns of our 3-element array.

		for (int i = 0; i < 4; i++) {

			sum += scores.score(cardsArray[i][0]);
		}
		return sum;
	}

	/*
	 * The scoreConversionForColumns method converts the raw score (i.e. 20) for the
	 * columns that we got from previous methods into the game scores following the
	 * rules (i.e. the sum of 20 is 5 points)
	 */

	int scoreConversionForColumns(int columnScore, int columnNumber) {

		int scoreColumn = 0;

		// Here we specify that if the score is in column 1 or 5, we make the score of
		// 21 into 10 points. Else, if the score is in another column, we make make the
		// score of 21 a standard 7 points.

		if (columnNumber == 1 || columnNumber == 5) {

			switch (columnScore) {

			case 21:
				scoreColumn = 10;
				break;
			case 20:
				scoreColumn = 5;
				break;
			case 19:
				scoreColumn = 4;
				break;
			case 18:
				scoreColumn = 3;
				break;
			case 17:
				scoreColumn = 2;
				break;
			case 16:
				scoreColumn = 1;
				break;
			case 15:
				scoreColumn = 1;
				break;
			case 14:
				scoreColumn = 1;
				break;
			case 13:
				scoreColumn = 1;
				break;
			case 12:
				scoreColumn = 1;
				break;
			case 11:
				scoreColumn = 1;
				break;
			case 10:
				scoreColumn = 1;
				break;
			case 9:
				scoreColumn = 1;
				break;
			case 8:
				scoreColumn = 1;
				break;
			case 7:
				scoreColumn = 1;
				break;
			case 6:
				scoreColumn = 1;
				break;
			case 5:
				scoreColumn = 1;
				break;
			case 4:
				scoreColumn = 1;
				break;
			case 3:
				scoreColumn = 0;
				break;
			case 2:
				scoreColumn = 0;
				break;
			case 1:
				scoreColumn = 0;
				break;
			case 0:
				scoreColumn = 0;
				break;
			default:
				scoreColumn = 0;
				break;
			}

		} else {

			switch (columnScore) {

			case 21:
				scoreColumn = 7;
				break;
			case 20:
				scoreColumn = 5;
				break;
			case 19:
				scoreColumn = 4;
				break;
			case 18:
				scoreColumn = 3;
				break;
			case 17:
				scoreColumn = 2;
				break;
			case 16:
				scoreColumn = 1;
				break;
			case 15:
				scoreColumn = 1;
				break;
			case 14:
				scoreColumn = 1;
				break;
			case 13:
				scoreColumn = 1;
				break;
			case 12:
				scoreColumn = 1;
				break;
			case 11:
				scoreColumn = 1;
				break;
			case 10:
				scoreColumn = 1;
				break;
			case 9:
				scoreColumn = 1;
				break;
			case 8:
				scoreColumn = 1;
				break;
			case 7:
				scoreColumn = 1;
				break;
			case 6:
				scoreColumn = 1;
				break;
			case 5:
				scoreColumn = 1;
				break;
			case 4:
				scoreColumn = 0;
				break;
			case 3:
				scoreColumn = 0;
				break;
			case 2:
				scoreColumn = 0;
				break;
			case 1:
				scoreColumn = 0;
				break;
			case 0:
				scoreColumn = 0;
				break;
			default:
				scoreColumn = 0;
				break;
			}
		}

		return scoreColumn;
	}

	/*
	 * The scoreConversionForRows method converts the raw score (i.e. 20) for the
	 * rows that we got from previous methods into the game scores following the
	 * rules (i.e. the sum of 20 is 5 points)
	 */

	int scoreConversionForRows(int rowScore) {

		int scoreRow = 0;

		// Here we specify that if the score is in any row gets scored the same, i.e. a
		// raw score of 20 is converted to 5 points in any row.

		switch (rowScore) {

		case 21:
			scoreRow = 7;
			break;
		case 20:
			scoreRow = 5;
			break;
		case 19:
			scoreRow = 4;
			break;
		case 18:
			scoreRow = 3;
			break;
		case 17:
			scoreRow = 2;
			break;
		case 16:
			scoreRow = 1;
			break;
		case 15:
			scoreRow = 1;
			break;
		case 14:
			scoreRow = 1;
			break;
		case 13:
			scoreRow = 1;
			break;
		case 12:
			scoreRow = 1;
			break;
		case 11:
			scoreRow = 1;
			break;
		case 10:
			scoreRow = 1;
			break;
		case 9:
			scoreRow = 1;
			break;
		case 8:
			scoreRow = 1;
			break;
		case 7:
			scoreRow = 1;
			break;
		case 6:
			scoreRow = 1;
			break;
		case 5:
			scoreRow = 1;
			break;
		case 4:
			scoreRow = 1;
			break;
		case 3:
			scoreRow = 1;
			break;
		case 2:
			scoreRow = 0;
			break;
		case 1:
			scoreRow = 0;
			break;
		case 0:
			scoreRow = 0;
			break;
		default:
			scoreRow = 0;
			break;
		}

		return scoreRow;
	}

	/*
	 * The scoreColumns method helps sum up the score for each column and determines
	 * whether to change an Ace to 11 or leave it at 1.
	 */

	int scoreColumns(int columnOne, int columnTwo, int columnThree, int columnFour, int columnFive, String[][] topRows,
			String[][] bottomRows) {

		// helps us determine column one

		if (columnOne <= 11) {

			if (topRows[0][0].charAt(0) == 'A') {

				columnOne += 10;
			}

			if (topRows[1][0].charAt(0) == 'A') {
				columnOne += 10;
			}
		}

		// helps us determine column five

		if (columnFive <= 11) {

			if (topRows[0][4].charAt(0) == 'A') {

				columnFive += 10;
			}

			if (topRows[1][4].charAt(0) == 'A') {
				columnFive += 10;
			}
		}

		// helps us determine column two

		if (columnTwo <= 11) {

			if (topRows[0][1].charAt(0) == 'A') {

				columnTwo += 10;
			}

			if (topRows[1][1].charAt(0) == 'A' && columnTwo <= 11) {
				columnTwo += 10;
			}

			if (bottomRows[0][0].charAt(0) == 'A' && columnTwo <= 11) {

				columnTwo += 10;
			}

			if (bottomRows[1][0].charAt(0) == 'A' && columnTwo <= 11) {
				columnTwo += 10;
			}
		}

		// helps us determine column three

		if (columnThree <= 11) {

			if (topRows[0][2].charAt(0) == 'A') {

				columnThree += 10;
			}

			if (topRows[1][2].charAt(0) == 'A' && columnThree <= 11) {
				columnThree += 10;
			}

			if (bottomRows[0][1].charAt(0) == 'A' && columnThree <= 11) {

				columnThree += 10;
			}

			if (bottomRows[1][1].charAt(0) == 'A' && columnThree <= 11) {
				columnThree += 10;
			}
		}

		// helps us determine column four

		if (columnFour <= 11) {

			if (topRows[0][3].charAt(0) == 'A') {

				columnFour += 10;
			}

			if (topRows[1][3].charAt(0) == 'A' && columnFour <= 11) {
				columnFour += 10;
			}

			if (bottomRows[0][2].charAt(0) == 'A' && columnFour <= 11) {

				columnFour += 10;
			}

			if (bottomRows[1][2].charAt(0) == 'A' && columnFour <= 11) {
				columnFour += 10;
			}
		}

		// Below we sum up scores for each column.

		ScoringGame scoreConverter = new ScoringGame();

		int columnOneScore = scoreConverter.scoreConversionForColumns(columnOne, 1);
		int columnTwoScore = scoreConverter.scoreConversionForColumns(columnTwo, 2);
		int columnThreeScore = scoreConverter.scoreConversionForColumns(columnThree, 3);
		int columnFourScore = scoreConverter.scoreConversionForColumns(columnFour, 4);
		int columnFiveScore = scoreConverter.scoreConversionForColumns(columnFive, 5);

		return columnOneScore + columnTwoScore + columnThreeScore + columnFourScore + columnFiveScore;

	}

	/*
	 * The scoreRows method helps sum up the score for each row and determines
	 * whether to change an Ace to 11 or leave it at 1.
	 */

	int scoreRows(int rowOne, int rowTwo, int rowThree, int rowFour, String[][] topRows, String[][] bottomRows) {

		// helps us determine row one

		if (rowOne < 12) {

			if (topRows[0][0].indexOf('A') == 0 && rowOne < 12) {

				rowOne += 10;
			}

			if (topRows[0][1].indexOf('A') == 0 && rowOne < 12) {

				rowOne += 10;
			}

			if (topRows[0][2].indexOf('A') == 0 && rowOne < 12) {

				rowOne += 10;
			}

			if (topRows[0][3].indexOf('A') == 0 && rowOne < 12) {

				rowOne += 10;
			}

			if (topRows[0][4].indexOf('A') == 0 && rowOne < 12) {

				rowOne += 10;
			}
		}

		// helps us determine row two

		if (rowTwo < 12) {

			if (topRows[1][0].indexOf('A') == 0 && rowTwo < 12) {

				rowTwo += 10;
			}

			if (topRows[1][1].indexOf('A') == 0 && rowTwo < 12) {

				rowTwo += 10;
			}

			if (topRows[1][2].indexOf('A') == 0 && rowTwo < 12) {

				rowTwo += 10;
			}

			if (topRows[1][3].indexOf('A') == 0 && rowTwo < 12) {

				rowTwo += 10;
			}

			if (topRows[1][4].indexOf('A') == 0 && rowTwo < 12) {

				rowTwo += 10;
			}
		}

		// helps us determine row three

		if (rowThree < 12) {

			if (bottomRows[0][0].indexOf('A') == 0 && rowThree < 12) {

				rowThree += 10;
			}

			if (bottomRows[0][1].indexOf('A') == 0 && rowThree < 12) {

				rowThree += 10;
			}

			if (bottomRows[0][2].indexOf('A') == 0 && rowThree < 12) {

				rowThree += 10;
			}

		}

		// helps us determine row four

		if (rowFour < 12) {

			if (bottomRows[1][0].indexOf('A') == 0 && rowFour < 12) {

				rowFour += 10;
			}

			if (bottomRows[1][1].indexOf('A') == 0 && rowFour < 12) {

				rowFour += 10;
			}

			if (bottomRows[1][2].indexOf('A') == 0 && rowFour < 12) {

				rowFour += 10;
			}

		}

		// Below we sum up scores for each column.
		

		ScoringGame scoreConverter = new ScoringGame();
		
		int rowOneScore = scoreConverter.scoreConversionForRows(rowOne);
		int rowTwoScore = scoreConverter.scoreConversionForRows(rowTwo);
		int rowThreeScore = scoreConverter.scoreConversionForRows(rowThree);
		int rowFourScore = scoreConverter.scoreConversionForRows(rowFour);
					
		return rowOneScore + rowTwoScore + rowThreeScore + rowFourScore;
		

	}

	/*
	 * The totalScore method helps sum up the score for each row and column of our
	 * board.
	 */

	int totalScore(int scoreColumns, int scoreRows) {

		// I have cast it to ensure that I get a valid number, as the program kept
		// adding incorrectly.

		int totalScore = (int) scoreColumns + (int) scoreRows;

		return totalScore;
	}
}
