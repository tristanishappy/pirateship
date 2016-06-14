package org.vashonsd.pirateship.io;

import java.io.IOException;
import java.util.*;

import org.vashonsd.pirateship.PlayerRegistry;
import org.vashonsd.pirateship.Queue;
import org.vashonsd.pirateship.interactions.Player;

import rocks.xmpp.core.XmppException;
import rocks.xmpp.core.session.TcpConnectionConfiguration;
import rocks.xmpp.core.session.XmppClient;
import rocks.xmpp.core.session.XmppSessionConfiguration;
import rocks.xmpp.core.session.debug.ConsoleDebugger;
import rocks.xmpp.core.stanza.model.Message;
import rocks.xmpp.core.stanza.model.Presence;
import rocks.xmpp.im.chat.Chat;
import rocks.xmpp.addr.*;

public class XMPPio implements StringRead, StringWrite {

	private XmppClient client;
	private String userMessage = " ";
	private Queue Q;
	Message me;
	private Message currentMessage = null;
	private PlayerRegistry register;
	
	public XMPPio() {
		super();
		TcpConnectionConfiguration tcpConfiguration = TcpConnectionConfiguration.builder()
			    .hostname("xmpp.pirateship.vashonsd.org")
			    .port(5222)
			    .build();
		
		XmppSessionConfiguration config = XmppSessionConfiguration.builder()
			    .debugger(ConsoleDebugger.class)
			    .authenticationMechanisms("PLAIN")
			    .build();

		client = XmppClient.create("xmpp.pirateship.vashonsd.org", config, tcpConfiguration);

		client.addInboundMessageListener(e -> {
			Message message = e.getMessage();
			Q.addInMessage(message);
		});
		
	}
	
	
	public void Run() throws IOException {
		Thread t1 = new Thread(new Runnable() {
			
			public void run()
			{
				try {
					runThread();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		t1.start();
		
	}
	
	public void runThread() throws IOException
	{
		register = Q.getPlayerRegistry();
		try {
			   client.connect();
			} catch (XmppException e) {
			   System.out.println("Here's the error: " + e);
			}
		
		try {
			   client.login("pirateship", "mauvian59", "");
			} catch (XmppException e) {
			   System.out.println("Failure of type " + e);
			}
		System.out.println("test");
		while(true)
		{
			while(Q.outIsEmpty())
			{
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(read() != null)
			{
				write(currentMessage);
			}
		}
	}
	
	public void write(Message m) throws IOException {
		//Jid recipient = currentMessage.getFrom();
		//Message message1 = new Message(recipient, Message.Type.CHAT,"CPU: " + s);
		client.send(m);
	}

	public Message read() throws IOException {
		if (Q.outIsEmpty())
			return null;
		
		Message toReturn = Q.getOutMessage();
		currentMessage = toReturn;
		return toReturn;
	}
	
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}

	public void addQueue(Queue start) 
	{
		Q = start;
	}


	@Override
	public void write(String s) throws IOException {
		// TODO Auto-generated method stub
		
	}

}
