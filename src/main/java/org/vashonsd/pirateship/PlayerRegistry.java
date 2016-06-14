package org.vashonsd.pirateship;

import java.util.ArrayList;
import java.util.HashMap;

import org.vashonsd.pirateship.interactions.Player;
import org.vashonsd.pirateship.structure.Location;

import rocks.xmpp.addr.Jid;
import rocks.xmpp.core.stanza.model.Message;

public class PlayerRegistry {
	private HashMap<String, Player> registry;
	
	private ArrayList<Player> playerList = new ArrayList<Player>();

	public PlayerRegistry() {
		super();
		this.registry = new HashMap<String, Player>();
	}
	
	/**
	 * Use this 
	 * @param id -- the id of the player
	 * @param p -- the player object created for this player.
	 */
	public void add(String id, Player p) {
		this.registry.put(id, p);
	}
	
	public boolean has(String id) {
		return registry.containsKey(id);
	}
	
	public Player get(String id) {
		return registry.get(id);
	}
	
	public void addPlayer(Player p)
	{
		playerList.add(p);
	}
	/**
	 * Checks to see if the name is enrolled in the PlayerRegistry with its unique ID.
	 * If the given name does not represent a unique ID, it auto-generated a new unique ID by adding an integer
	 * value to the end of the name.
	 * @param name
	 * @return the id by which the player is registered.
	 */
	public String EnrollPlayer(Player p) {
		String id = p.getName();
		int incr = 0;
		while (this.has(id)) {
			incr++;
			id = p.getName() + String.valueOf(incr);
		}
		add(id, p);
		return id;
	}
	
	public Player EnrollPlayer(String name, Jid jid) 
	{
		Player x = new Player(name, "They look like " + name);
		x.setJid(jid);
		this.registry.put(name, x);
		return x;
	}
	
	public Player playerChecker(Jid jid) {
		for(Player key: registry.values())
		{
			if(jid == key.getJid())
			{
				return key;
			}
		}
		EnrollPlayer("User:" + jid.toString(), jid);
		return null;
	}
	
	public boolean setPlayerName(String s, Player p)
	{
		for(int i = 0; playerList.size() > i; i++)
		{
			if(s == playerList.get(i).getName())
			{
				return false;
			}
		}
		p.setName(s);
		return true;
	}
}
