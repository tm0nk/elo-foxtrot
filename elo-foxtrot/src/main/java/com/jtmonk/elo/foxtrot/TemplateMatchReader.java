package com.jtmonk.elo.foxtrot;

import java.util.Date;

public class TemplateMatchReader extends MatchReader {

	@Override
	protected Match buildMatch(String[] row) {
		String timeString = row[0] + " " + row[1];
		String playerAName = row[2];
		String draw = row[6];
		if (playerAName.equals("Player A")) {
			System.err.println("Skipping header row");
			return null;
		}
		Player playerA = PlayerFactory.getInstance().lookupPlayer(playerAName, draw);
		String playerBName = row[3];
		if (playerBName == null) {
			System.err.println("Player B name is null!");
			return null;
		}
		Player playerB = PlayerFactory.getInstance().lookupPlayer(playerBName, draw);
		String winnerName = row[4];
		if (winnerName == null) {
			System.err.println("Winner name is null!");
		}
		Player winner = PlayerFactory.getInstance().lookupPlayer(winnerName, draw);
		
		Match match = new Match();
		match.setTime(parseTime(timeString));
		match.setDraw(draw);
		match.setPlayerA(playerA);
		match.setPlayerB(playerB);
		match.setWinner(winner);

		return match;
	}

	private Date parseTime(String timeString) {
		return new Date(System.currentTimeMillis());
	}
}
