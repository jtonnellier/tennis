import java.util.ArrayList;

public class Match {
	
	private  MatchStatus status;
	
	public void setStatus(MatchStatus status) {
		this.status = status;
	}

	Player firstPlayer;
	Player secondPlayer;
	
	
	private ArrayList<TennisSet> sets;
	
	public Match(Player firstPlayer, Player secondPlayer) {
		this.firstPlayer = firstPlayer;
		this.secondPlayer = secondPlayer;
		sets = new ArrayList<TennisSet>();
		addNewSet();
		setStatus(MatchStatus.IN_PROGRESS);
	}
	
	
	
	public Match() {
		sets = new ArrayList<TennisSet>();
		addNewSet();
		setStatus(MatchStatus.IN_PROGRESS);
	}



	public String toString() {
		String s = "Player 1 : "+firstPlayer.toString()+"\n";
		s += "Player 2 : "+secondPlayer.toString()+"\n";
		s += "Score : ";
		for(TennisSet tennisSet : getSets()) {
			s += "("+tennisSet.toString()+")";
		}
		s += "\nCurrent game status : " + getLastTennisSetNotTerminated().getLastGame().toString()+'\n';
		s += "Match Status : "+status.name()+'\n';
		return s;
	}
	
	public TennisSet getLastTennisSetNotTerminated() {
		TennisSet currentTennisSet = sets.get(sets.size() - 1);
		
		if(currentTennisSet.isTerminated()) {
			sets.add(new TennisSet());
		}
		
		return sets.get(sets.size() - 1);
	}
	
	public void scoreOnePointForFirstPlayerForNotTerminatedMatch() {
		if(isNotTerminated() && ! isFinished()) {
			TennisSet currentTennisSet = getLastTennisSetNotTerminated();
			currentTennisSet.scoreOnePointForFirstPlayer();
		}
	}
	
	public boolean isNotTerminated() {
		if(status == MatchStatus.CANCELED) return false;
		if(status == MatchStatus.FINISHED) return false;
		return true;
	}
	
	public void scoreOnePointForSecondPlayerForNotTerminatedMatch() {
		if(isNotTerminated() && ! isFinished()) {
			TennisSet currentTennisSet = getLastTennisSetNotTerminated();
			currentTennisSet.scoreOnePointForSecondPlayer();
		}
	}

	public void cancel() {
		status = MatchStatus.CANCELED;
	}

	public MatchStatus getStatus() {		
		return status;
	}

	public void suspend() {
		status = MatchStatus.SUSPENDED;
	}

	public void addNewSet() {
		sets.add(new TennisSet());		
	}
	
	public ArrayList<TennisSet> getSets() {
		return sets;
	}



	public boolean isFirstPlayerWonMatch() {
		
		int wonSets = 0;
		for(TennisSet tennisSet : getSets()) {
			if(tennisSet.isFirstPlayerWon()) {
				wonSets++;
			}
		}
		return wonSets == 3;
	}



	public boolean isSecondPlayerWonMatch() {
		int wonSets = 0;
		for(TennisSet tennisSet : getSets()) {
			if(tennisSet.isSecondPlayerWon()) {
				wonSets++;
			}
		}
		return wonSets == 3;
	}
	
	public boolean isFinished() {
		if( isFirstPlayerWonMatch() || isSecondPlayerWonMatch()) {
			setStatus(MatchStatus.FINISHED);
			return true;
		}
		return false;
	}
	
}
