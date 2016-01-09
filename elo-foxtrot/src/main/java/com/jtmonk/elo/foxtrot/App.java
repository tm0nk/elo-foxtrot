package com.jtmonk.elo.foxtrot;

/**
 * Read all matches.
 *
 */
public class App 
{
	public static void main(String[] args) throws Exception {
		MatchReader matchReader = new MatchReader();
		matchReader.readMatches("data/tournamentsoftware/"
				+ "Badminton2015SuperRegionals - 2015-12-27.tsv");
		matchReader.readMatches("data/tournamentsoftware/"
				+ "Badminton2015SuperRegionals - 2015-12-28.tsv");
		matchReader.readMatches("data/tournamentsoftware/"
				+ "Badminton2015SuperRegionals - 2015-12-29.tsv");
		PlayerFactory.getInstance().printCurrentStandings();
	}
}
