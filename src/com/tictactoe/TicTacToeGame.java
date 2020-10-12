package com.tictactoe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {
	static Scanner sc = new Scanner(System.in);
	public static char[] board;
	public static char player;
	public static char computer;

	public static char[] createBoard() {
		char[] ch = new char[10];
		for (int i = 1; i < ch.length; i++) {
			ch[i] = ' ';
		}
		return ch;
	}

	public static char takeInput() {
		System.out.println("enter the input X or O");
		char user = sc.next().charAt(0);
		return user;

	}

	public static void showBoard() {
		System.out.println(" ( " + board[1] + " | " + board[2] + " | " + board[3] + " )");
		System.out.println(" --------------");
		System.out.println(" ( " + board[4] + " | " + board[5] + " | " + board[6] + " )");
		System.out.println(" --------------");
		System.out.println(" ( " + board[7] + " | " + board[8] + " | " + board[9] + " )");
		System.out.println(" ");

	}

	public static void selectIndexByUser(char turn) {
		System.out.println(" Select the index for move between 1-9");
		int index = sc.nextInt();
		if (index > 0 && index <= 9) {
			if (board[index] == ' ') {
				System.out.println("index is free to move");
				makeMove(index, turn);
			} else {
				System.out.println("already occupied select other index");
				selectIndexByUser(turn);
			}
		} else {
			System.out.println("Invalid input ");
			selectIndexByUser(turn);
		}

	}

	public static void makeMove(int index, char turn) {
		System.out.println("want to move here Y/N");
		char say = sc.next().charAt(0);
		if (say == 'Y')
			board[index] = turn;
		else
			selectIndexByUser(turn);
	}

	public static int toss() {
		Random R = new Random();
		System.out.println("Defining 0 for user and 1 for computer\n");
		int player = 0;
		int value = R.nextInt(2);
		switch (value) {
		case 0:
			System.out.println("user will move first \n");
			return 0;

		case 1:
			System.out.println("computer will move first\n");
			return 1;
		}
		return 0;

	}

	public static boolean checkWin() {
		if (((board[1] == board[2] && board[1] == board[3]) && board[1] != ' ')
				|| ((board[4] == board[5] && board[4] == board[6]) && board[4] != ' ')
				|| ((board[7] == board[8] && board[7] == board[9]) && board[7] != ' ')
				|| ((board[1] == board[4] && board[1] == board[7]) && board[1] != ' ')
				|| ((board[2] == board[5] && board[2] == board[8]) && board[2] != ' ')
				|| ((board[3] == board[6] && board[3] == board[9]) && board[3] != ' ')
				|| ((board[1] == board[5] && board[1] == board[9]) && board[1] != ' ')
				|| ((board[3] == board[5] && board[3] == board[7]) && board[3] != ' '))

			return true;
		else
			return false;
	}
	
	public static void computerMove() {
		boolean take=false;
		for (int i = 1; i < board.length; i++) {
			if(board[i]==' ') {
				board[i] = computer;
				if(!checkWin())
				{
					board[i] = ' '; 
				}
				else {
					take = true;
					break;
				}
			}
		}
		if(!take) {
			take=toBlockOpponent();
		}
		if(!take) {
			take=cornerMove();
		}
		if(!take) {
			for(int i=1;i < board.length;i++) {
				if(board[i]==' ') {
					board[i]=computer;
					break;
				}
			}
		}
		
		
	}
	public static boolean toBlockOpponent() {
		boolean take=false;
		for (int i = 1; i < board.length; i++) {
			if(board[i]==' ') {
				board[i] = player;
				if(!checkWin())
				{
					board[i] = ' '; 
				}
				else {
					board[i]=computer;
					take = true;
					break;
				}
			}
		}
		return take;
	}

	
	public static boolean cornerMove() {
		if(board[1]==' ') {
			board[1]=computer;
			return true;
		}
		else if(board[3]==' ') {
			board[3]=computer;
			return true;
		}
		else if(board[7]==' ') {
			board[7]=computer;
			return true;
		}
		else if(board[9]==' ') {
			board[9]=computer;
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
	System.out.println("Welcome to tic tac toe game");
	board=createBoard();
	 player=takeInput();
     computer=' ';
	if(player=='X')
		computer='O';
	else
		computer='X';
	showBoard();
	int turn= toss();
	boolean win=false;
	for(int i=1;i<board.length;i++) {
	       if(turn==0) {
	        	 			selectIndexByUser(player);
	        	 			showBoard();
	        	 			win=checkWin();
				     if(win) {
							System.out.println("player won the game\n");
							break;
					    }
				            turn=1;
	           }
	       else {
	    				computerMove();
	 					showBoard();
	 					win=checkWin();
	     if(win) {
						System.out.println("computer won the game\n");
						break;
	     			}
	     				turn=0;
	       	}
		}
	if(!win)
		System.out.println("game tie\n");
	  }
	}
