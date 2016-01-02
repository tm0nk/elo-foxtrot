package com.jtmonk.elo.foxtrot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class PlayerFactory {

	private final ConcurrentMap<String, Player> playerCache = new ConcurrentHashMap<String, Player>();

	private static final PlayerFactory INSTANCE = new PlayerFactory();
	
	// Make default constructor private
	private PlayerFactory() {
		
	}
	
	public static PlayerFactory getInstance() {
		return INSTANCE;
	}
	
	public Player lookupPlayer(String name, String draw) {
		String key = name.toLowerCase();

		if (!playerCache.containsKey(key)) {
			Player player = new Player(name);
			player.setDraw(draw);
			playerCache.putIfAbsent(key, player);
		}
		
		Player p = playerCache.get(key);
		if (!p.getDraw().equals(draw)) {
			System.err.println("Updating draw for " + p.toString() + " to " + draw);
			p.setDraw(draw);
		}
		return p;
	}
	
	public void printCurrentStandings() {
		// Insert all players into a List, and sort it by player rating in
		// ascending order
		Collection<Player> values = playerCache.values();
		List<Player> list = new ArrayList<Player>(values.size());
		for (Player player : values) {
			list.add(player);
		}
		Collections.sort(list);
		for (Player player : list) {
			System.out.println(player.toString());
		}
	}
	
	public int countPlayers() {
		return playerCache.size();
	}
}
