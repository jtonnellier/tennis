import java.util.ArrayList;

public class TennisSet {

	private ArrayList<Game> games;
	

	public TennisSet() {
		games = new ArrayList<Game>();
		addNewGame();
	}
	
	public ArrayList<Game> getGames() {
		return games;
	}
	private void addNewGame() {
		games.add(new Game());
	}
	
	private Game getLastGameNotTerminated(){
		// TODO SRP non respecté
		Game lastGame = getLastGame();
		if(lastGame.isTerminated()) {
			addNewGame();
		}
		return games.get(games.size() - 1);
	}
	
	public void scoreOnePointForFirstPlayer() {
		try {
			getLastGameNotTerminated().scoreOnePointFirstPlayerIfGameNotTerminated();
		} catch (GameAlreadyWonException e) {
			System.out.println(e.getMessage());
		}
	}
		
	public boolean isTerminated() {
		return isFirstPlayerWon() || isSecondPlayerWon();
	}

	public Game getLastGame() {
		return getGames().get(getGames().size() - 1);
	}

	public void scoreOnePointForSecondPlayer() {
		// TODO score only a parameter player 
		try {
			getLastGameNotTerminated().scoreOnePointSecondPlayerIfGameNotTerminated();
		} catch (GameAlreadyWonException e) {
			System.out.println(e.getMessage());
		}		
	}

	public int getNumberWonGameForFirstPlayer() {
		
		int gamesWon = 0;
		for (Game game : getGames()) {
			if(game.getFirstPlayerScore() == ScoreGame.GAME) {
				gamesWon ++;
			}
		}
		return gamesWon;
	}

	public int getNumberWonGameForSecondPlayer() {
		int gamesWon = 0;
		
		for (Game game : getGames()) {
			if(game.getSecondPlayerScore() == ScoreGame.GAME) {
				gamesWon ++;
			}
		}
		
		return gamesWon;
	}

	public String toString() {
		String s = "";
		s += getNumberWonGameForFirstPlayer() + " - " +getNumberWonGameForSecondPlayer();
		return s ;
	}

	public boolean isFirstPlayerWon() {
		
		int gamesWonByFirstPlayer = getNumberWonGameForFirstPlayer();
		int gamesWonBySecondPlayer = getNumberWonGameForSecondPlayer();		
		
		if(gamesWonByFirstPlayer >= 6 && (gamesWonByFirstPlayer - gamesWonBySecondPlayer) >= 2 ) {
			return true;
		}
		return false;
	}
	
	public boolean isSecondPlayerWon() {
		
		int gamesWonByFirstPlayer = getNumberWonGameForFirstPlayer();
		int gamesWonBySecondPlayer = getNumberWonGameForSecondPlayer();
		
		if(gamesWonBySecondPlayer >= 6 && (gamesWonBySecondPlayer - gamesWonByFirstPlayer) >= 2 ) {
			return true;
		}
		
		return false;
	}
	
}
