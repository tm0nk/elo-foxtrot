package com.jtmonk.elo.foxtrot;

public class Player implements Comparable<Player> {

	private static final Double INITIAL_PLAYER_RATING = 1200d;
	
	private final String name;
	private Double rating;

	public Player(String name) {
		this.name = name;
		this.rating = INITIAL_PLAYER_RATING;
		System.out.println("New player " + this.toString());
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{");
		builder.append("name: '" + name + "'");
		builder.append(", ");
		builder.append("rating: " + rating);
		builder.append("}");
		return builder.toString();
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Player) {
			return (this.compareTo((Player)o) == 0);
		}
		return false;
	}

	@Override
	public int compareTo(Player p) {
		if (this.getName().compareToIgnoreCase(p.getName()) == 0) {
			// The two parameters refer to the exact same player
			return 0;
		} else {
			// These are different players and we want to compare them by their rating
			if (this.getRating().compareTo(p.getRating()) == 0) {
				// If the two players have the same rating, fall back to sort by name
				return this.getName().compareToIgnoreCase(p.getName());
			} else {
				// The two players have different ratings, compare them
				return this.getRating().compareTo(p.getRating());
			}
		}
	}
}
