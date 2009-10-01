package numguess;

/**
 * This bean is used to represent guess results going back from the game to the user. 
 * It is an example of the ValueObject (TransferObject) pattern. 
 */

public class GuessResult implements Constants {

	private int guess;
	private int comparison;
	private int guesses;
	private int bestScore;
	private boolean newBestScore;

	public int getGuess() {
		return guess;
	}
	public void setGuess(int guess) {
		this.guess = guess;
	}
	public int getComparison() {
		return comparison;
	}
	public void setComparison(int comparison) {
		this.comparison = comparison;
	}
	public int getNumGuesses() {
		return guesses;
	}
	public void setNumGuesses(int guesses) {
		this.guesses = guesses;
	}
	public int getBestScore() {
		return bestScore;
	}
	public void setBestScore(int bestScore) {
		this.bestScore = bestScore;
	}
	public boolean isNewBestScore() {
		return newBestScore;
	}
	public void setNewBestScore(boolean newBestScore) {
		this.newBestScore = newBestScore;
	}
}