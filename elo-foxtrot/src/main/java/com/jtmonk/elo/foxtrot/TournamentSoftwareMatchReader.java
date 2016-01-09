package com.jtmonk.elo.foxtrot;

import java.util.Date;

public class TournamentSoftwareMatchReader extends MatchReader {

	@Override
	protected Match buildMatch(String[] row) {
		String timeString = row[1];
		String draw = row[2];
		String playerAName = row[3];
		if (playerAName == null) {
			System.err.println("Player A is null!");
			return null;
		}
		Player playerA = PlayerFactory.getInstance().lookupPlayer(playerAName, draw);
		String playerBName = row[5];
		if (playerBName == null) {
			System.err.println("Player B is null!");
			return null;
		}
		Player playerB = PlayerFactory.getInstance().lookupPlayer(playerBName, draw);
		String score = row[6];
		String duration = row[9];
		String court = row[10];
		
		Match match = new Match();
		match.setTime(parseTime(timeString));
		match.setDraw(draw);
		match.setPlayerA(playerA);
		match.setPlayerB(playerB);
		match.setScore(score);
		match.setDuration(duration);
		match.setCourt(court);
		match.setWinner(playerA);
		
		return match;
	}
	
	private Date parseTime(String timeString) {
		return new Date(System.currentTimeMillis());
	}
	
}
