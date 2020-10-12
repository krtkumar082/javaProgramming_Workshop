package com.tictactoe;

import java.util.Scanner;

public class TicTacToeGame {
	static Scanner sc=new Scanner(System.in);
	public static char[] board;
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
	public static void showBoard(char[] ch) {
			System.out.println("( " +ch[1]+ "| "+ch[2]+"| "+ch[3]+")");
			System.out.println("( " +ch[4]+ "| "+ch[5]+"| "+ch[6]+")");
			System.out.println("( " +ch[7]+ "| "+ch[8]+"| "+ch[9]+")");
			System.out.println(" ");
		
	}
	public static void selectIndexByUser() {
		System.out.println("User Select the index for move between 1-9");
		int index=sc.nextInt();
		if(index>0 && index<=9 ) {
			if(board[index]==' ')
			   System.out.println("index is free to move");
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
 public static void main(String[] args) {
	System.out.println("Welcome to tic tac toe game");
	board=createBoard();
	char player=takeInput();
	char computer=' ';
	if(player=='X')
		computer='O';
	else
		computer='X';
	showBoard(board);
	selectIndexByUser();
	
}
}
