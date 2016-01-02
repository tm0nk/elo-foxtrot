package com.jtmonk.elo.foxtrot;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class EloRatingTest extends TestCase {

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public EloRatingTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( EloRatingTest.class );
    }

    private Match match;
    
    @Override
    protected void setUp() {
    	Player playerA = new Player("Player A");
    	playerA.setRating(2400d);
    	Player playerB = new Player("Player B");
    	playerB.setRating(2000d);
    	Match freshMatch = new Match();
    	freshMatch.setPlayerA(playerA);
    	freshMatch.setPlayerB(playerB);
    	match = freshMatch;
    }
    
	public void testUpdateRatingsPlayerAWins() {
		match.setWinner(match.getPlayerA());
		EloRating.updateRatings(match);
		assertEquals(2403L, Math.round(match.getPlayerA().getRating()));
		assertEquals(1997L, Math.round(match.getPlayerB().getRating()));
	}
	
	public void testUpdateRatingsPlayerBWins() {
		match.setWinner(match.getPlayerB());
		EloRating.updateRatings(match);
		assertEquals(2371L, Math.round(match.getPlayerA().getRating()));
		assertEquals(2029L, Math.round(match.getPlayerB().getRating()));
	}
	
}
