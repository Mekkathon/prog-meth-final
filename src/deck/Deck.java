package deck;

import java.util.Arrays;
import card.base.Card;

public class Deck {
	private String name;
	private int deckSize;
	Card [] deckList;
	
	public Deck(String name, Card[] deckList) {
		this.name = name;
		this.deckSize = deckList.length;
		this.deckList = new Card[deckSize];
		for(int i=0;i< (int)this.deckSize;i++) {
			this.deckList[i] = deckList[i];
		}
	}

	public int insertCard(Card card) throws InsertCardFailedException{
		int count = 0;
		for(int i = 0; i < this.deckSize ; i++) {
			if(card == this.deckList[i]) {
				count++;
			}
		}
		if(count >= card.getCardLimit()){
			throw new InsertCardFailedException("Exceeding the limit of the same cards in the deck");
		}
		Card[] newDeck = Arrays.copyOf(this.deckList,  this.deckSize+1);
		newDeck[this.deckSize] = card;
		this.deckList = newDeck;
		this.deckSize++;
		return deckSize;
		
	}

	public Card removeCard(int slotNumber) throws RemoveCardFailedException {
		if(slotNumber>=deckSize) {
			throw new RemoveCardFailedException("Number you insert exceed deck size");
		}
		Card[] newDeck = Arrays.copyOf(this.deckList,  this.deckSize-1);
		for(int i=0;i<slotNumber;i++) {
			newDeck[i] = this.deckList[i];
		}
		for(int i=slotNumber+1;i<deckSize-1;i++) {
			newDeck[i] = this.deckList[i+1];
		}
		Card res= this.deckList[slotNumber];
		this.deckList = newDeck;
		deckSize--;
		return res;
		
	}

	public String getName() {
		return this.name;
	}
	public int getDeckSize() {
		return this.deckSize;
	}
	public Card[] getDeckList() {
		return this.deckList;
	}
	public void setDeckSize(int deckSize) {
		this.deckSize = deckSize;
	}

	
}
