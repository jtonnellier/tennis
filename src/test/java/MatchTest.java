import org.junit.Assert;
import org.junit.Test;

public class MatchTest {
	
	@Test
	public void should_return_canceled_match() {
		
		MatchStatus expected = MatchStatus.CANCELED;
		
		Match match = new Match();
		match.cancel();
		MatchStatus actual = match.getStatus();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void should_return_suspended_match() {
				
		MatchStatus expected = MatchStatus.SUSPENDED;
		
		Match match = new Match();
		match.suspend();
		MatchStatus actual = match.getStatus();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void should_return_one_point_more_for_first_player () {
		
		int expected = ScoreGame.FIFHTEEN;
		
		Match match = new Match();
		match.scoreOnePointForFirstPlayerForNotTerminatedMatch();
		int actual = match.getLastTennisSetNotTerminated().getLastGame().getFirstPlayerScore();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void should_return_one_set_more () {
		
		Match match = new Match();
		int expected = match.getSets().size() + 1;
		
		match.addNewSet();
		int actual = match.getSets().size();
		
		Assert.assertEquals(expected, actual);		
	}
	
	@Test
	public void should_return_first_player_won_match () {
		
		boolean expected = true;
		
		Match match = new Match();
		for(int set = 0; set < 3; set ++) {
			for(int game = 0; game < 6; game ++) {
				for(int point = 0; point < 4; point ++) {
					match.scoreOnePointForFirstPlayerForNotTerminatedMatch();
				}
			}
		}
		boolean actual = match.isFirstPlayerWonMatch();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void should_return_second_player_won_match () {
		
		boolean expected = true;
		
		Match match = new Match();
		for(int set = 0; set < 3; set ++) {
			for(int game = 0; game < 6; game ++) {
				for(int point = 0; point < 4; point ++) {
					match.scoreOnePointForSecondPlayerForNotTerminatedMatch();
				}
			}
		}
		boolean actual = match.isSecondPlayerWonMatch();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void should_return_match_is_finished () {
		
		boolean expected = true;
		
		Match match = new Match();
		for(int set = 0; set < 3; set ++) {
			for(int game = 0; game < 6; game ++) {
				for(int point = 0; point < 4; point ++) {
					match.scoreOnePointForFirstPlayerForNotTerminatedMatch();
				}
			}
		}
		boolean actual = match.isFinished();
		
		Assert.assertEquals(expected, actual);
	}
	
}
