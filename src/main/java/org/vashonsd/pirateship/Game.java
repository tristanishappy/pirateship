package org.vashonsd.pirateship;

import java.io.IOException;
import java.util.HashMap;

import org.vashonsd.pirateship.interactions.Player;
import org.vashonsd.pirateship.interactions.Request;
import org.vashonsd.pirateship.io.*;
import org.vashonsd.pirateship.item.*;
import org.vashonsd.pirateship.structure.*;

import rocks.xmpp.core.stanza.model.Message;

import org.vashonsd.pirateship.minigame.*;

public class Game {
	//private StringRead reader;
	//private StringWrite writer;
	private Queue Q;
	private World thisWorld;
	private DatabaseWriter db = new DatabaseWriter();
	
	//This is our register of current Players, each with a unique ID.
	private PlayerRegistry players;
	
	//private HashMap<String, Player> players;
	
	private String quitWord;
	
	public Game(String world) throws IOException {
		super();
		quitWord = "exit";
		
    	//thisWorld = WorldBuilder.makeWorldByFile(world);
		thisWorld = WorldBuilder.makeWorld(world);
		
		
		//Player p = new Player("Demo", "Just a player");
		//p.setLocation(thisWorld.getStartingLocation());
		//String pid = players.EnrollPlayer(p);
		
    	//reader = new UserInput();
    	//writer = new ConsoleOut();
	}
	
	public void Run() throws IOException {
		//For now we are just going to take the first Player off the registry.
		//Later we will want to be able to enroll players on the fly.
		//Q.addOutMessage(p.handle("look").getText() + "\n", p);
		this.players = Q.getPlayerRegistry();
		Player p;
		while(true) {
			
			while(Q.inIsEmpty())
			{
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(!newPlayer())
			{
				p = players.playerChecker(Q.getInMessage().getFrom());
	        	String command = Q.getInMessage().getBody();
	        	Q.removeInMessage();
	        	if (p.getTarget() == null && command.equals(quitWord)) {
	        		break;
	        	}
	        	Q.addOutMessage(p.handle(command).getText() + "\n", p);
			}
		}
		Q.addOutMessage("Have a great day!", p);
	}
	
	private boolean newPlayer()
	{
		Player newPlayer = players.playerChecker(Q.getInMessage().getFrom());//turns Jid into a new player, unless it already exists
		
		if(newPlayer == null)
		{
			newPlayer = players.playerChecker(Q.getInMessage().getFrom());
			Q.addOutMessage("I don't remember seeing you before, what's your name?", newPlayer);
			Q.removeInMessage();
			return true;
			
		}
		else if(newPlayer.getName().equalsIgnoreCase("User:" + Q.getInMessage().getFrom()))
		{
			boolean name = players.setPlayerName(Q.getInMessage().getBody(), newPlayer);
			if(name)
			{
				Q.addOutMessage(newPlayer.getName() + ", thats a nice name", newPlayer);
				newPlayer.setLocation(thisWorld.getStartingLocation());
				Q.removeInMessage();
				players.addPlayer(newPlayer);
				Q.addOutMessage(newPlayer.handle("look").getText() + "\n", newPlayer);
				return true;
			}
			else
			{
				//me = new Message(currentMessage.getFrom(), Message.Type.CHAT,"CPU: I'm sorry, I already know someone by that name, could you change your name so I won't get confused please?");
				Q.addOutMessage("I'm sorry, I already know someone by that name, could you change your name so I won't get confused please?", newPlayer);
				Q.removeInMessage();
				return true;
			}
		}
		else
		{
			//me = new Message(currentMessage.getFrom(), Message.Type.CHAT,"CPU: " + currentMessage.getBody() + "... thats an interesting thing to say " + newPlayer.getName());
			//write(currentMessage.getBody() + "... thats an interesting thing to say " + newPlayer.getName());
			return false;
		}
	}
	
	public void addQueue(Queue start) 
	{
		// TODO Auto-generated method stub
		Q = start;
	}
}
