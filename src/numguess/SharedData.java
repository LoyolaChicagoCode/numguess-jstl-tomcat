package numguess;

/**
 * This interface specifies what data is shared at the application level.
 */

public interface SharedData {
	public boolean setIfBestScore(int bestScore);
	public int getBestScore();
}