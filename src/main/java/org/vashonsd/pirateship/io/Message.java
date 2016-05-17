package org.vashonsd.pirateship.io;

public class Message {
	private String text;
	private String playerID;
	
	public Message(String text, String playerID) {
		super();
		this.text = text;
		this.playerID = playerID;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getPlayerID() {
		return playerID;
	}

	public void setPlayerID(String playerID) {
		this.playerID = playerID;
	}
}
