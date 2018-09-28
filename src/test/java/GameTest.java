
import org.junit.Assert;
import org.junit.Test;


public class GameTest {
	
	@Test
	public void should_return_true_if_first_player_won_game() {
		
		boolean expected = true;
		
		Game game = new Game();
		game.setFirstPlayerScore(ScoreGame.GAME);
		boolean actual = game.isTerminated();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void should_return_true_if_second_player_won_game() {
		
		boolean expected = true;
		
		Game game = new Game();
		game.setSecondPlayerScore(ScoreGame.GAME);
		boolean actual = game.isTerminated();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void should_return_false_if_nobody_won_game() {
		
		boolean expected = false;		
		Game game = new Game();
		
		boolean actual = game.isTerminated();
		
		Assert.assertEquals(expected, actual);
	}
	

	// Test qui a gagné
	
	@Test
	public void should_return_fifhteen_when_scored_one_point_from_zero_() {
		
		int expected = ScoreGame.FIFHTEEN;
		
		Game game = new Game();
		try {
			game.scoreOnePointFirstPlayerIfGameNotTerminated();
		} catch (GameAlreadyWonException e) {
			e.printStackTrace();
		}
		int actual = game.getFirstPlayerScore();
		
		Assert.assertEquals(expected, actual);
		
	}
	
	@Test
	public void should_score_one_point_first_player_if_game_not_terminated() {
		
		int expected = ScoreGame.FIFHTEEN;
		
		Game game = new Game();
		try {
			game.scoreOnePointFirstPlayerIfGameNotTerminated();
		} catch (GameAlreadyWonException e) {
			e.printStackTrace();
		}
		int actual = game.getFirstPlayerScore();
		
		Assert.assertEquals(expected, actual);
		
	}
	
	@Test
	public void should_score_one_point_second_player_if_game_not_terminated() {
		
		int expected = ScoreGame.FIFHTEEN;
		
		Game game = new Game();
		try {
			game.scoreOnePointSecondPlayerIfGameNotTerminated();
		} catch (GameAlreadyWonException e) {
			e.printStackTrace();
		}
		int actual = game.getSecondPlayerScore();
		
		Assert.assertEquals(expected, actual);
		
	}
	
	@Test
	public void shloud_return_first_player_won_game() {
		
		int expected = ScoreGame.GAME;
		
		Game game = new Game();
		for(int i = 0; i < 4; i++) {
			try {
				game.scoreOnePointFirstPlayerIfGameNotTerminated();
			} catch (GameAlreadyWonException e) {
				Assert.fail(e.getMessage());
			}
		}
		int actual = game.getFirstPlayerScore();
		
		Assert.assertEquals(expected, actual);
	}
	
	
	
	
}
