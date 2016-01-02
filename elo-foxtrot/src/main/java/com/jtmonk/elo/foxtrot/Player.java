package com.jtmonk.elo.foxtrot;

public class Player implements Comparable<Player> {

	private static final Double INITIAL_PLAYER_RATING = 1200d;
	
	private final String name;
	private String draw;
	private Double rating;

	public Player(String name) {
		this.name = name;
		this.draw = null;
		this.rating = INITIAL_PLAYER_RATING;
//		System.out.println("New player " + this.toString());
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

	public String getDraw() {
		return draw;
	}

	public void setDraw(String draw) {
		this.draw = draw;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{");
		builder.append("draw: " + draw);
		builder.append(", ");
		builder.append("rating: " + Math.round(rating));
		builder.append(", ");
		builder.append("name: '" + name + "'");
		builder.append("}");
		return builder.toString();
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Player) {
			return (this.getName().equalsIgnoreCase(((Player) o).getName()));
		}
		return false;
	}

	/**
	 * Goal is to achieve an ordering like SQL ORDER BY clause:
	 * 
	 * ORDER BY draw, rating, name
	 * 
	 */
	@Override
	public int compareTo(Player p) {
		if (this.getDraw().compareToIgnoreCase(p.getDraw()) == 0) {
			if (this.getRating().compareTo(p.getRating()) == 0) {
				return this.getName().compareToIgnoreCase(p.getName());
			} else {
				return this.getRating().compareTo(p.getRating());
			}
		} else {
			return this.getDraw().compareToIgnoreCase(p.getDraw());
		}
	}
}
