package com.jtmonk.elo.foxtrot;

import java.io.FileReader;

import com.univocity.parsers.tsv.TsvParser;
import com.univocity.parsers.tsv.TsvParserSettings;

public abstract class MatchReader {

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
				EloRating.updateRatings(match);
			}
		}
	}

	protected abstract Match buildMatch(String[] row);

}
