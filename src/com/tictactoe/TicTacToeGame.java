package com.tictactoe;

import java.util.Scanner;

public class TicTacToeGame {
	static Scanner sc=new Scanner(System.in);
	public static char[] board;
	public static char player;
	public static char computer;
	
	public static char[] createBoard() {
		char[] ch=new char[10];
		for(int i=1;i<ch.length;i++) {
			ch[i]=' ';
		}
		return ch;
	}
	public static char takeInput() {
		System.out.println("enter the input X or O");
		char user=sc.next().charAt(0);
		return user;
		
	}
	public static void showBoard() {
			System.out.println(" ( " +board[1]+ " | "+board[2]+" | "+board[3]+" )");
			System.out.println(" --------------");
			System.out.println(" ( " +board[4]+ " | "+board[5]+" | "+board[6]+" )");
			System.out.println(" --------------");
			System.out.println(" ( " +board[7]+ " | "+board[8]+" | "+board[9]+" )");
			System.out.println(" ");
		
	}
	public static void selectIndexByUser() {
		System.out.println("User Select the index for move between 1-9");
		int index=sc.nextInt();
		if(index>0 && index<=9 ) {
			if(board[index]==' ') {
			   System.out.println("index is free to move");
			   makeMove(index);
			}
		  else {
			   System.out.println("already occupied select other index");
			   selectIndexByUser();
		  }
		}
		else {
			System.out.println("Invalid input ");
			selectIndexByUser();
		}
			
		
	}
	public static void makeMove(int index) {
		System.out.println("want to move here Y/N");
		char say=sc.next().charAt(0);
		if(say=='Y')
			board[index]=player;
		else
			selectIndexByUser();
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
	selectIndexByUser();
	showBoard();
}
}
