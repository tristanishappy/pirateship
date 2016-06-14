package org.vashonsd.pirateship;

import java.io.IOException;

import org.vashonsd.pirateship.io.XMPPio;

/**
 * We keep the App very sparse. It's just the trigger.
 *
 */
public class App 
{	
    public static void main( String[] args ) throws IOException
    {
    	Queue start = new Queue();
    	start.Run();
    	Game g = new Game("Busytown");
		XMPPio io = new XMPPio();
		io.addQueue(start);
		g.addQueue(start);
		io.Run();
    	g.Run();
    }
    
    
}
