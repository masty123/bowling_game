package bowling;
/**
 * 
 * @author Theeruth Borisuth
 *
 */
public class Game {
	
	private int itsCurrentFrame = 1;
	private boolean firstThrowInFrame = true;
	private Scorer itsScorer = new Scorer();

	public int score() {
		return scoreForFrame(itsCurrentFrame);
	}
	
	public void add(int pins) {
		itsScorer.addThrow(pins);
		adjustCurrentFrame(pins);
	}
	
	public int getCurrentFrame() {
		return itsCurrentFrame;
	}
	
	private void adjustCurrentFrame(int pins) {
		if((strike(pins)) || !firstThrowInFrame) {
			advanceFrame();
			firstThrowInFrame = true;
		}
		else {
			firstThrowInFrame = false;
		}
	}
	
	private boolean strike(int pins) {
		return (firstThrowInFrame && pins == 10);
	}
	
	private boolean adjustFrameForStrike(int pins) {
		if( lastBallInFrame(pins)) {
			advanceFrame();
			return true;
		}
		return false;
	}
	
	private boolean lastBallInFrame(int pins) {
		return strike(pins) || !firstThrowInFrame;
	}

	private void advanceFrame() {
		itsCurrentFrame = Math.min(10,  itsCurrentFrame + 1);
	}

	public int scoreForFrame(int theFrame) {
		return itsScorer.scoreForFrame(theFrame);
	}
}
