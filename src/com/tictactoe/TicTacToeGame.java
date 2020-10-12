package com.tictactoe;

public class TicTacToeGame {
	public static char[] createBoard() {
		char[] ch=new char[10];
		for(int i=1;i<=ch.length;i++) {
			ch[i]=' ';
		}
		return ch;
	}
 public static void main(String[] args) {
	System.out.println("Welcome to tic tac toe game");
	char[] board=createBoard();
}
}
