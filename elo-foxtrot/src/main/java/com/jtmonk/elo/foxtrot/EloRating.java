package com.jtmonk.elo.foxtrot;

public class EloRating {

	private static final Double K = 32d;
	private static final Double TRANS_DENOM = 400d;
	
	public static void updateRatings(Match match) {
		Double rA = match.getPlayerA().getRating();
		Double rB = match.getPlayerB().getRating();
		
		Double transRatingA = Math.pow(10d, (rA / TRANS_DENOM));
		Double transRatingB = Math.pow(10d, (rB / TRANS_DENOM));

		Double expectedA = (transRatingA / (transRatingA + transRatingB));
		Double expectedB = (transRatingB / (transRatingA + transRatingB));

		Player winner = match.getWinner();
		Double actualA = match.getPlayerA().equals(winner) ? 1d : 0d;
		Double actualB = match.getPlayerA().equals(winner) ? 0d : 1d;

		Double rPrimeA = rA + K * (actualA - expectedA);
		Double rPrimeB = rB + K * (actualB - expectedB);
		
		match.getPlayerA().setRating(rPrimeA);
		match.getPlayerB().setRating(rPrimeB);
	}

}
