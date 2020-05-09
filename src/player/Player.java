package player;

import java.util.Arrays;
import java.util.Random;

import board.Board;
import board.Position;
import card.base.*;

import deck.Deck;


public class Player {
	private String name;
	private int maxLifePoint;
	private int lifePoint;
	private int maxMana;
	private int mana;
	private Board board;
	private Deck deck;
	private Card[] inventory;
	private int poison;

	public Player(String name, int lifePoint, int maxMana, Deck deck) {
		this.name = name;
		this.deck = deck;
		this.maxMana = maxMana;
		this.mana = maxMana;
		this.setMaxLifePoint(lifePoint);
		this.setLifePoint(lifePoint);
		this.inventory = new Card[0];
		this.board = new Board();
	}
	
	public void updateLifePoint() {
		if(poison!=0) {
			poison--;
			changeLifePoint(1);
		}
	}
	public void changeLifePoint(int damage) {
		lifePoint -= damage;
		if(lifePoint <= 0) {
			//this player loses
		}
		if(lifePoint > maxLifePoint) lifePoint = maxLifePoint;
	}
	
	public MonsterCard getMonsterCard(Position p) {
		int column = p.getColumn();
		int row = p.getRow();
		if(row==0) return board.getGameBoard()[column].getFirstRowCard();
		else return board.getGameBoard()[column].getSecondRowCard();
	}
	
	public void setMonsterCard(MonsterCard monsterCard,Position p) {
		int column = p.getColumn();
		int row = p.getRow();
		if(row==0) board.getGameBoard()[column].setFirstRowCard(monsterCard);
		else board.getGameBoard()[column].setSecondRowCard(monsterCard);
	}
	
	public void addCard(Card card) {
		inventory = Arrays.copyOf(inventory, inventory.length +1);
		inventory[inventory.length-1] = card;
	}
	
	public void useCard(int index) {
		
	}
	
	public Card removeCard(int index) {
		if(index>=inventory.length) {
			//error
		}
		Card[] newInventory = Arrays.copyOf(inventory, inventory.length-1);
		for(int i=0;i<index;i++) {
			newInventory[i] = this.inventory[i];
		}
		for(int i=index+1;i<inventory.length-1;i++) {
			newInventory[i] = this.inventory[i+1];
		}
		Card res = this.inventory[index];
		inventory = newInventory;
		return res;
		
	}
	
	public void attack(Player opponent) {
		for(int i=0;i<board.getBoardSize();i++) {
			board.getGameBoard()[i].getFirstRowCard().action(this,opponent);
			if(board.getGameBoard()[i].getSecondRowCard()!=null) {
				board.getGameBoard()[i].getSecondRowCard().action(this,opponent);
			}
		}
	}
	
	public void drawCard(int amount) {
		for(int i=0;i<amount;i++) {
			addCard(deck.getDeckList()[0]);
			try{
				deck.removeCard(0);
			}
			catch(Exception e) {
				
			};
		}
	}
	
	public void shuffleDeck() {
		Card[] ar = deck.getDeckList();
		Random rand = new Random();
	    for (int i = ar.length - 1; i > 0; i--)
	    {
	      int index = rand.nextInt(i + 1);
	      Card a = ar[index];
	      ar[index] = ar[i];
	      ar[i] = a;
	    }
	}
	
	public void addMaxMana() {
		maxMana++;
		if(maxMana>10) maxMana=10;
	}
	
	//getter-setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoison() {
		return poison;
	}
	public void setPoison(int poison) {
		this.poison = poison;
	}
	public int getMana() {
		return mana;
	}
	public void setMana(int mana) {
		this.mana = mana;
	}
	public int getMaxLifePoint() {
		return maxLifePoint;
	}
	public void setMaxLifePoint(int maxLifePoint) {
		this.maxLifePoint = maxLifePoint;
	}
	public int getLifePoint() {
		return lifePoint;
	}
	public void setLifePoint(int lifePoint) {
		this.lifePoint = lifePoint;
	}
	public Deck getDeck() {
		return deck;
	}
	public void setDeck(Deck deck) {
		this.deck = deck;
	}
	public int getMaxMana() {
		return maxMana;
	}
	public void setMaxMana(int startingMana) {
		this.maxMana = startingMana;
	}
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	public Card[] getInventory() {
		return inventory;
	}
	public void setInventory(Card[] inventory) {
		this.inventory = inventory;
	}
}
