package numguess;

/**
 * This class implements the shared data for this application.  It
 * is intended to be stored as an attribute in the application scope
 * (shared between all sessions).
 */
public class GlobalData implements SharedData {

	int bestScore = Integer.MAX_VALUE;

	public synchronized int getBestScore() { return bestScore; }

	public synchronized boolean setIfBestScore(int bestScore) {
		boolean result = bestScore < this.bestScore;
		if (result) { 
			this.bestScore = bestScore;
		}
		return result;
	}
}