import org.junit.Assert;
import org.junit.Test;

public class TennisSetTest {
	
	@Test
	public void should_return_last_game() {
		
		TennisSet tennisSet = new TennisSet();
		Game expected = tennisSet.getGames().get(tennisSet.getGames().size() - 1);
		
		Game actual = tennisSet.getLastGame();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void should_score_one_point_for_first_player() {
		
		TennisSet tennisSet = new TennisSet();
		int expected = tennisSet.getLastGame().getFirstPlayerScore() + 1;
		
		tennisSet.scoreOnePointForFirstPlayer();
		int actual = tennisSet.getLastGame().getFirstPlayerScore();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void should_score_one_point_for_second_player() {
		
		TennisSet tennisSet = new TennisSet();
		int expected = tennisSet.getLastGame().getSecondPlayerScore() + 1;
		
		tennisSet.scoreOnePointForSecondPlayer();
		int actual = tennisSet.getLastGame().getSecondPlayerScore();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void should_return_number_games_won_for_first_player() {
		
		int expected = 2;
		
		TennisSet tennisSet = new TennisSet();
		for(int i = 0; i < 8; i++) {
			tennisSet.scoreOnePointForFirstPlayer();			
		}
		int actual = tennisSet.getNumberWonGameForFirstPlayer();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void should_return_number_games_won_for_second_player() {
		
		int expected = 1;
		
		TennisSet tennisSet = new TennisSet();
		Game currentGame = tennisSet.getLastGame();
		for(int i = 0; i < 4; i++) {
			try {
				currentGame.scoreOnePointSecondPlayerIfGameNotTerminated();
			} catch (GameAlreadyWonException e) {
				Assert.fail(e.getMessage());
			}
		}
		int actual = tennisSet.getNumberWonGameForSecondPlayer();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void should_return_first_player_won_set() {
		
		boolean expected = true;
		
		TennisSet tennisSet = new TennisSet();
		for(int i = 0; i < 24; i++) {
			tennisSet.scoreOnePointForFirstPlayer();
		}
		boolean actual = tennisSet.isFirstPlayerWon();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void should_return_second_player_won_set() {
		
		boolean expected = true;
		
		TennisSet tennisSet = new TennisSet();
		for(int i = 0; i < 24; i++) {
			tennisSet.scoreOnePointForSecondPlayer();
		}
		boolean actual = tennisSet.isSecondPlayerWon();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void should_return_set_not_terminated() {
		
		boolean expected = false;
		TennisSet tennisSet = new TennisSet();		
		
		boolean actual = tennisSet.isTerminated();
		
		Assert.assertEquals(expected, actual);		
	}
	
	@Test
	public void should_return_set_terminated() {
		
		boolean expected = true;
		TennisSet tennisSet = new TennisSet();
		
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 4; j++) {
				tennisSet.scoreOnePointForFirstPlayer();
			}
		}
		boolean actual = tennisSet.isTerminated();
		
		Assert.assertEquals(expected, actual);
		
	}
	
	
	
	
}
