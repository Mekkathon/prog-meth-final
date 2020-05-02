package board;

import java.util.Arrays;

import card.base.Card;
import card.base.MonsterCard;
import deck.InsertCardFailedException;
import player.Player;

public class Board {
	public static int boardMaxSize = 8;
	private int boardSize;
	CardColumn [] gameBoard;
	
	public Board() {
		this.gameBoard = new CardColumn[0];
		boardSize = 0;
	}
	
	public int getBoardSize() {
		return boardSize;
	}

	public void setBoardSize(int boardSize) {
		this.boardSize = boardSize;
	}

	public CardColumn[] getGameBoard() {
		return gameBoard;
	}

	public void setGameBoard(CardColumn[] gameBoard) {
		this.gameBoard = gameBoard;
	}

	public void insertCard(MonsterCard card,int column) {
		card.setTurn(0);
		card.setColumn(column);
		CardColumn[] newBoard = Arrays.copyOf(gameBoard,  boardSize+1);
		for(int i=0;i<column;i++) {
			newBoard[i] = gameBoard[i];
		}
		for(int i=column+1;i<boardSize+1;i++) {
			newBoard[i] = gameBoard[i-1];
			newBoard[i].addColumn(1);
		}
		CardColumn cardColumn = new CardColumn(card);
		newBoard[column] = cardColumn;
		this.gameBoard = newBoard;
		this.boardSize++;
	}
	
	public void insertSecondRowCard(MonsterCard card,int column) {
		card.setColumn(column);
		gameBoard[column].addSecondColumn(card);
	}
	
	/*public void decreaseLifePointCard(int column,int row,int damage) {
		if(row==0) {
			gameBoard[column].firstRowCard.decreaseLifePoint(damage);
		}
	}*/
}
