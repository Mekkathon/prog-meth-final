package board;

import java.util.Arrays;

import card.base.Card;
import card.base.MonsterCard;
import deck.InsertCardFailedException;
import player.Player;

public class Board {
	public static int MaxBoardSize = 8;
	private int boardSize;
	CardColumn [] gameBoard;
	
	public Board() {
		this.gameBoard = new CardColumn[0];
		boardSize = 0;
	}
	public void insertCard(MonsterCard card,int column) {
		if(boardSize == MaxBoardSize) {
			
			return;
		}
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
	
	public void updateBoard(Player player) {
		int index = 0;
		while(index < boardSize) {
			gameBoard[index].getFirstRowCard().updateLifePoint();
			try {
				gameBoard[index].getSecondRowCard().updateLifePoint();
			}catch(Exception e) {}
			if(gameBoard[index].getFirstRowCard().getLifePoint()==0) {
				gameBoard[index].getFirstRowCard().deathTrigger(player);
				if(gameBoard[index].getSecondRowCard()==null) removeCardColumn(index);
				else {
					MonsterCard temp = gameBoard[index].getSecondRowCard();
					gameBoard[index] = new CardColumn(temp);
				}
			}
		}
	}
	
	public void removeCardColumn(int column) {
		CardColumn[] newBoard = Arrays.copyOf(gameBoard,  boardSize-1);
		for(int i=0;i<column;i++) {
			newBoard[i] = this.gameBoard[i];
		}
		for(int i=column+1;i<boardSize-1;i++) {
			newBoard[i] = this.gameBoard[i+1];
			newBoard[i].addColumn(-1);
		}
		gameBoard = newBoard;
		boardSize--;
	}
	
	public void removeCard(int column,int row) {
		if(row==1) gameBoard[column].secondRowCard = null;
		else if(gameBoard[column].secondRowCard == null) removeCardColumn(column);
		else gameBoard[column] = new CardColumn(gameBoard[column].getSecondRowCard());
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
	
	/*public void decreaseLifePointCard(int column,int row,int damage) {
		if(row==0) {
			gameBoard[column].firstRowCard.decreaseLifePoint(damage);
		}
	}*/
}
