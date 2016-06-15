package org.vashonsd.pirateship;

import java.io.IOException;
import java.util.ArrayList;

import org.vashonsd.pirateship.interactions.Player;
import org.vashonsd.pirateship.io.XMPPio;

import rocks.xmpp.addr.Jid;
import rocks.xmpp.core.stanza.model.Message;

public class Queue 
{
	private ArrayList<Message> OutMessageQueue = new ArrayList<Message>();
	private ArrayList<Message> InMessageQueue = new ArrayList<Message>();
	private PlayerRegistry register = new PlayerRegistry();
	
	public Queue()
	{
    	
		
	}
	
	public void Run() throws IOException
	{
		
	}
	
	public PlayerRegistry getPlayerRegistry()
	{
		return register;
	}
	
	public void addInMessage(Message m)
	{
		System.out.println("HI!" + m);
		InMessageQueue.add(m);
	}
	
	public boolean inIsEmpty()
	{
		if(InMessageQueue.isEmpty())
		System.out.println("True: " + InMessageQueue.size());
		else
		System.out.println("False: " + InMessageQueue.size());
		
		return InMessageQueue.isEmpty();
	}
	
	public Message getInMessage()
	{
		Message m = InMessageQueue.get(0);
		return m;
	}
	
	public void removeInMessage()
	{
		InMessageQueue.remove(0);
	}
	
	public void addOutMessage(Message m)
	{
		OutMessageQueue.add(m);
	}
	public void addOutMessage(String s, Player p)
	{
		
		Message m = new Message(p.getJid(), Message.Type.CHAT, "CPU:" + s);
		OutMessageQueue.add(m);
		
	}
	public void addOutMessage(String s, Jid j)
	{
		Message m = new Message(j, Message.Type.CHAT, "CPU:" + s);
		OutMessageQueue.add(m);
	}
	public boolean outIsEmpty()
	{
		return OutMessageQueue.isEmpty();
	}
	
	public Message getOutMessage()
	{
		Message m = OutMessageQueue.get(0);
		OutMessageQueue.remove(0);
		return m;
	}
}
