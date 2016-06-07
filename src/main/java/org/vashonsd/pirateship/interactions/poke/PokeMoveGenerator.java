package org.vashonsd.pirateship.interactions.poke;

public class PokeMoveGenerator {

	public PokeMoveGenerator(){}
	
	// moves need (name, type, power, accuracy, healthChange, myAttackChang, attackChange, myDefenseChange, defenseChange, mySpeedChange, speedChange, myAccuracyChange, accuracyChange)
	public PokeMove batPunch() {
		 return new PokeMove("Bat-Punch", "punch your opponent with the power of justice", "normal", 50, 100, 0, 0, 0, -10, 0, 0, 0, 0, 0);
	}
	
	public PokeMove intimidate() {
		 return new PokeMove("Intimidate", "scare your opponent with the power of justice", "normal", 0, 100, 0, 0, 8, 0, 8, 0, -5, 0, 5);
	}
	
	public PokeMove smokePellet() {
		 return new PokeMove("Smoke Pellet", "small explosive that releases alot of smoke", "normal", 0, 100, 0, 5, 3, 5, 3, 5, 0, 0, 0);
	}
	
	public PokeMove batBat() {
		 return new PokeMove("Bat-Bat", "Smack them with a Bat-Bat", "normal", 40, 85, 0, 0, 0, -5, 0, 0, 0, 0, 0);
	}
	
	public PokeMove batarang() {
		 return new PokeMove("Bat-a-rang", "Throw a Batarang", "normal", 15, 85, 0, 0, 0, 8, 0, 10, 0, 0, 0);
	}
	
	public PokeMove tackle() {
		 return new PokeMove("Tackle", "A full-body charge attack.", "normal", 35, 90, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	}
	
	public PokeMove growl() {
		return new PokeMove("Growl", "A menacing growl that lowers your opponent's attack.", "normal", 0, 100, 0, 0, 6, 0, 0, 0, 0, 0, 0);
	}
	
	public PokeMove vineWhip() {
		return new PokeMove("Vine Whip", "Whips the foe with slender vines.", "grass", 45, 90, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	}
	
	public PokeMove razorLeaf() {
		return new PokeMove("Razor Leaf", "The foe is hit with a cutting leaf.", "grass", 55, 80, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	}
	
	public PokeMove growth() {
		return new PokeMove("Growth", "The userâ€™s body is forced to grow, raising its attack.", "normal", 0, 100, 0, 6, 0, 0, 0, 0, 0, 0, 0);
	}
	
	public PokeMove tailWhip() {
		return new PokeMove("Tail Whip", "A strategic tail swipe that lowers your opponent's defense.", "normal", 0, 100, 0, 0, 0, 0, 6, 0, 0, 0, 0);
	}
	
	public PokeMove bubble() {
		return new PokeMove("Bubble", "A spray of bubbles hits the foe, lowering its speed.", "water", 20, 90, 0, 0, 0, 0, 0, 0, 6, 0, 0);
	}
	
	public PokeMove waterGun() {
		return new PokeMove("Water Gun", "The foe is blasted with a forceful shot of water.", "water", 40, 90, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	}
	
	public PokeMove withdraw() {
		return new PokeMove("Withdraw", "Withdraws the body into its hard shell to raise defense.", "normal", 0, 100, 0, 0, 0, 6, 0, 0, 0, 0, 0);
	}
	
	public PokeMove scratch() {
		return new PokeMove("Scratch", "Scratches the foe with sharp claws.", "normal", 40, 90, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	}
	
	public PokeMove ember() {
		return new PokeMove("Ember", "The foe is attacked with small flames.", "fire", 40, 90, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	}
	
	public PokeMove rage() {
		return new PokeMove("Rage", "Deals damage and raises user's attack.", "normal", 20, 90, 0, 6, 0, 0, 0, 0, 0, 0, 0);
	}
}
