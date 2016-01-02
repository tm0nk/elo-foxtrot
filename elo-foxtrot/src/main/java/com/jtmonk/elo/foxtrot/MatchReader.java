package com.jtmonk.elo.foxtrot;

import java.io.FileReader;
import java.util.Arrays;
import java.util.Date;

import com.univocity.parsers.tsv.TsvParser;
import com.univocity.parsers.tsv.TsvParserSettings;

public class MatchReader {

	public void readMatches(String fileName) throws Exception {
		// The settings object provides many configuration options
		TsvParserSettings parserSettings = new TsvParserSettings();

		// creates a TSV parser
		TsvParser parser = new TsvParser(parserSettings);

		// call beginParsing to read records one by one, iterator-style.
		parser.beginParsing(new FileReader(fileName));

		String[] row;
		while ((row = parser.parseNext()) != null) {
			Match match = buildMatch(row);
			if (match != null) {
				System.out.println(Arrays.toString(row));
				EloRating.updateRatings(match);
			}
		}
	}

	private Match buildMatch(String[] row) {
		String timeString = row[1];
		String draw = row[2];
		String playerAName = row[3];
		if (playerAName == null) {
			System.err.println("Player A is null!");
			return null;
		}
		Player playerA = PlayerFactory.getInstance().lookupPlayer(playerAName);
		String playerBName = row[5];
		if (playerBName == null) {
			System.err.println("Player B is null!");
			return null;
		}
		Player playerB = PlayerFactory.getInstance().lookupPlayer(playerBName);
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
