

public class Game {
	private int firstPlayerScore = ScoreGame.ZERO;
	public int getFirstPlayerScore() {
		return firstPlayerScore;
	}

	public void setFirstPlayerScore(int firstPlayerScore) {
		this.firstPlayerScore = firstPlayerScore;
	}

	public int getSecondPlayerScore() {
		return secondPlayerScore;
	}

	public void setSecondPlayerScore(int secondPlayerScore) {
		this.secondPlayerScore = secondPlayerScore;
	}

	private int secondPlayerScore = ScoreGame.ZERO;
	
	public Game() {
	}

	public boolean isTerminated() {
		
		if(firstPlayerScore == ScoreGame.GAME) {
			return true;
		}
		
		if(secondPlayerScore == ScoreGame.GAME) {
			return true;
		}
		
		return false;
	}

	public void scoreOnePointFirstPlayerIfGameNotTerminated() throws GameAlreadyWonException {
		if( ! isTerminated() ) {
			scoreOnePointfirstPlayer();
		}
	}

	private void scoreOnePointfirstPlayer() throws GameAlreadyWonException {
		//  With N <= 40 ; Cases : 0-N -> 15-N ; 15-N -> 30-N ; 30-N -> 40-N
		if(firstPlayerScore < ScoreGame.FORTY) {
			firstPlayerScore++;
			return;
		}
		// Cases : 40-0 -> GAME-0 ; 40-15 -> GAME-15 ; 40-30 -> GAME-30
		if(firstPlayerScore == ScoreGame.FORTY && secondPlayerScore < ScoreGame.FORTY) {
			firstPlayerScore = ScoreGame.GAME;
			return;
		}
		// Case Deuce : 40-40 -> ADV-40
		if(firstPlayerScore == ScoreGame.FORTY && secondPlayerScore == ScoreGame.FORTY) {
			firstPlayerScore ++;
			return;
		}
		// Case : 40-ADV -> 40-40
		if(firstPlayerScore == ScoreGame.FORTY && secondPlayerScore == ScoreGame.ADVANTAGE) {
			secondPlayerScore = ScoreGame.FORTY;
			return;
		}
		// Case : ADV-40 -> GAME-40
		if(firstPlayerScore == ScoreGame.ADVANTAGE) {
			firstPlayerScore ++;
			return;
		}
		throw new GameAlreadyWonException();			
	}
	
	public void scoreOnePointSecondPlayerIfGameNotTerminated() throws GameAlreadyWonException {
		if( ! isTerminated() ) {
			scoreOnePointSecondPlayer();
		}
	}
	
	private void scoreOnePointSecondPlayer() throws GameAlreadyWonException {
		//  With N <= 40 ; Cases : N-0 -> N-15 ; N-15 -> N-30 ; N-30 -> N-40 ;
		if(secondPlayerScore < ScoreGame.FORTY) {
			secondPlayerScore++;
			return;
		}
		// Cases : 0-40 -> 0-GAME ; 15-40 -> 15-GAME ; 30-40 -> 30-GAME ;
		if(secondPlayerScore == ScoreGame.FORTY && firstPlayerScore < ScoreGame.FORTY) {
			secondPlayerScore = ScoreGame.GAME;
			return;
		}
		// Case Deuce : 40-40 -> 40-ADV
		if(secondPlayerScore == ScoreGame.FORTY && firstPlayerScore == ScoreGame.FORTY) {
			secondPlayerScore ++;
			return;
		}
		// Case : ADV-40 -> 40-40
		if(secondPlayerScore == ScoreGame.FORTY && firstPlayerScore == ScoreGame.ADVANTAGE) {
			firstPlayerScore = ScoreGame.FORTY;
			return;
		}
		// Case : 40-ADV -> 40-GAME
		if(secondPlayerScore == ScoreGame.ADVANTAGE) {
			secondPlayerScore ++;
			return;
		}
		throw new GameAlreadyWonException();
	}
	
	public String toString() {
		if(firstPlayerScore == ScoreGame.FORTY && secondPlayerScore == ScoreGame.FORTY ) {
			return "deuce";
		}
		if(firstPlayerScore == ScoreGame.GAME) {
			return "GAME Player 1";
		}
		if(secondPlayerScore == ScoreGame.GAME) {
			return "GAME Player 2";
		}
		return ScoreGame.scoreLabels[firstPlayerScore] + " - " + ScoreGame.scoreLabels[secondPlayerScore];
	}
	
}
