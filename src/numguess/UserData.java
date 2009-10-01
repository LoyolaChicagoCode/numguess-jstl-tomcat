package numguess;

import java.util.Random;

/**
 * This class encapsulates the business logic of the game in a stateless form.
 */

public class UserData implements Constants {
	
	private int answer = -1;
	private int numGuesses = 0;
	private SharedData sharedData;
	
	public synchronized void setSharedData(SharedData sharedData) {
		this.sharedData = sharedData;
	}

	public synchronized GuessResult guess(int guess) {
		boolean isNewBestScore = false;
		int bestScore = Integer.MAX_VALUE;
		// update data model
		numGuesses++;
		// update best score in shared data model if available
		if (guess == answer && sharedData != null) {
			isNewBestScore = sharedData.setIfBestScore(numGuesses);
			bestScore = sharedData.getBestScore();
		}
		// populate resulting ValueObject
		GuessResult result = new GuessResult();
		result.setGuess(guess);
		result.setNumGuesses(numGuesses);
		result.setComparison(guess - answer);
		result.setBestScore(bestScore);
		result.setNewBestScore(isNewBestScore);
		return result;
	}

	public synchronized void reset(int min, int max) {
		answer = min + Math.abs(new Random().nextInt() % (max - min + 1));
		numGuesses = 0;
		System.out.println("The answer is " + answer);
	}
}