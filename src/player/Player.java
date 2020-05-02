package player;

import java.util.Arrays;
import java.util.Random;

import board.Board;
import board.CardColumn;
import card.*;
import card.base.*;

import deck.Deck;


public class Player {
	private String name;
	private int maxLifePoint;
	private int lifePoint;
	private int startingMana;
	private int mana;
	private Board board;
	private Deck deck;
	private Card[] inventory;

	public Player(String name, int lifePoint, int startingMana, Deck deck) {
		this.name = name;
		this.deck = deck;
		this.startingMana = startingMana;
		this.setMaxLifePoint(lifePoint);
		this.setLifePoint(lifePoint);
		this.inventory = new Card[0];
		this.board = new Board();
	}

	public String getName() {
		return name;
	}
	public void healPlayer(int lifePoint) {
		int totalHP = getLifePoint() + lifePoint;
		setLifePoint(Math.max(getMaxLifePoint(),totalHP));
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
	public void changeLifePoint(int damage) {
		lifePoint -= damage;
		if(lifePoint <= 0) {
			//this player loses
		}
	}
	public MonsterCard getMonsterCard(int column,int row) {
		if(row==0) {
			return board.getGameBoard()[column].getFirstRowCard();
		}
		else {
			return board.getGameBoard()[column].getSecondRowCard();
		}
	}
	public void setMonsterCard(MonsterCard monsterCard,int column, int row) {
		if(row==0) {
			board.getGameBoard()[column].setFirstRowCard(monsterCard);
		}
		else {
			board.getGameBoard()[column].setSecondRowCard(monsterCard);
		}
	}
	public Deck getDeck() {
		return deck;
	}
	public void setDeck(Deck deck) {
		this.deck = deck;
	}
	public void addCard(Card card) {
		inventory = Arrays.copyOf(inventory, inventory.length +1);
		inventory[inventory.length-1] = card;
	}
	public int getStartingMana() {
		return startingMana;
	}
	public void setStartingMana(int startingMana) {
		this.startingMana = startingMana;
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
	public void setName(String name) {
		this.name = name;
	}
	public void attack(Player opponent) {
		for(int i=0;i<board.getBoardSize();i++) {
			board.getGameBoard()[i].getFirstRowCard().action(this,opponent);
			if(board.getGameBoard()[i].getSecondRowCard()!=null) {
				board.getGameBoard()[i].getSecondRowCard().secondRowAction(this,opponent);
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
}
