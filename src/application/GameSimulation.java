package application;

import java.util.Random;

import card.base.Card;
import card.base.MonsterCard;
import card.base.SpellCard;
import player.Player;

public class GameSimulation {
	
	private Player player;
	private Player opponent;
	private static int turnStatus=0,turn=0;
	private int startingSide;

	public GameSimulation(Player player,Player opponent,int startingSide) {
		this.player = player;
		this.opponent = opponent;
		this.startingSide = startingSide;
	}
	
	public static void setTurnStatus(int tS) {
		turnStatus = tS;
	}
	
	public void run() {
		player.shuffleDeck();
		opponent.shuffleDeck();
		player.drawCard(3);
		opponent.drawCard(3);
		if(startingSide == 0) {
			opponent.drawCard(1);
			opponentSimulate();
		}
		while(true) {
			player.drawCard(1);
			player.setMana(player.getMaxMana());
			
			//attacker phase
			if(turnStatus==0) player.attack(opponent);
			else turnStatus--;
			if(opponent.getLifePoint() == 0) {
				//attacker win
				break;
			}
			player.addMaxMana();
			opponent.getBoard().updateBoard(opponent);
			
			//defender phase
			opponent.drawCard(1);
			opponent.setMana(opponent.getMaxMana());
			opponentSimulate();
			if(turnStatus==0) opponent.attack(player);
			else turnStatus--;
			opponent.attack(player);
			if(player.getLifePoint() == 0) {
				//attacker win
				break;
			}
			opponent.addMaxMana();
			player.getBoard().updateBoard(player);
			
			turn++;
			
		}
	}
	
	public void opponentSimulate() {
		Random rand = new Random();
		int handCard = opponent.getInventory().length;
		while(true) {
			int n = rand.nextInt(handCard);
			if(opponent.getInventory()[n].getManaCost()<=opponent.getMana()) {
				Card temp = opponent.removeCard(n);
				opponent.setMana(opponent.getMana()-temp.getManaCost());
				if(temp instanceof MonsterCard) {
					int m = rand.nextInt(opponent.getBoard().getBoardSize()+1);
					opponent.getBoard().insertCard((MonsterCard) temp, m);
				}
				if(temp instanceof SpellCard) {
					((SpellCard) temp).equip(opponent, player);
				}
			}
		}
	}
}
