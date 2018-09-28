
public class Main {

	public static void main(String[] args) throws GameAlreadyWonException {
		
		Match match = new Match(new Player("Roger", "Federer"), new Player("Rafael", "Nadal"));
		
		System.out.println(match.toString());		
	
		match.scoreOnePointForFirstPlayerForNotTerminatedMatch();
		match.scoreOnePointForFirstPlayerForNotTerminatedMatch();
		match.scoreOnePointForFirstPlayerForNotTerminatedMatch();		
		
		System.out.println(match.toString());
		
		match.scoreOnePointForFirstPlayerForNotTerminatedMatch();		
		
		System.out.println(match.toString());
	}

}
