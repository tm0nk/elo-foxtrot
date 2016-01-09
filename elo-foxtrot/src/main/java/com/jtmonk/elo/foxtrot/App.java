package com.jtmonk.elo.foxtrot;

/**
 * Read all matches.
 *
 */
public class App 
{
	public static void main(String[] args) throws Exception {
		readTemplateMatches();
//		readTournamentSoftwareMatches();
	}

	private static void readTournamentSoftwareMatches() throws Exception {
		MatchReader matchReader = new TournamentSoftwareMatchReader();
		matchReader.readMatches("data/tournamentsoftware/"
				+ "Badminton2015SuperRegionals - 2015-12-27.tsv");
		matchReader.readMatches("data/tournamentsoftware/"
				+ "Badminton2015SuperRegionals - 2015-12-28.tsv");
		matchReader.readMatches("data/tournamentsoftware/"
				+ "Badminton2015SuperRegionals - 2015-12-29.tsv");
		PlayerFactory.getInstance().printCurrentStandings();
	}

	private static void readTemplateMatches() throws Exception {
		MatchReader matchReader = new TemplateMatchReader();
		matchReader.readMatches("data/template/"
				+ "Badminton Match Template - League Matches with Ladder.tsv");
		PlayerFactory.getInstance().printCurrentStandings();
	}
}
