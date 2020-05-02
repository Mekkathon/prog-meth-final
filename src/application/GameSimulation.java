package application;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import card.base.Card;
import deck.Deck;
import player.Player;

public class GameSimulation {
	
	private Player player;
	private Player opponent;
	private int turn,startingSide;

	public GameSimulation(Player player,Player opponent,int startingSide) {
		this.player = player;
		this.opponent = opponent;
		this.startingSide = startingSide;
		this.turn = 1;
	}
	
	public void run() {
		player.shuffleDeck();
		opponent.shuffleDeck();
		Player attacker, defender;
		if(startingSide == 0) {
			attacker = player;
			defender = opponent;
		}
		else {
			attacker = opponent;
			defender = player;
		}
		while(true) {
			attacker.drawCard(1);
			attacker.setMana(Math.min(10,attacker.getStartingMana() + turn - 1));
			//attacker phase
			attacker.attack(defender);
			if(defender.getLifePoint() == 0) {
				//attacker win
				break;
			}
			//defender phase
			defender.attack(attacker);
			if(attacker.getLifePoint() == 0) {
				//attacker win
				break;
			}
			turn++;
			
		}
	}
	
	static Deck shuffleArray(Deck deck) {
	{
		Card[] ar = deck.getDeckList();
		Random rand = new Random();
	    for (int i = ar.length - 1; i > 0; i--)
	    {
	      int index = rand.nextInt(i + 1);
	      // Simple swap
	      Card a = ar[index];
	      ar[index] = ar[i];
	      ar[i] = a;
	    }
	    Deck shuffle = new Deck(deck.getName(), ar);
	    return shuffle;
	}


}
