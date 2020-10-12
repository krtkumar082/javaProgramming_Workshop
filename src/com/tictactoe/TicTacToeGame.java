package com.tictactoe;

import java.util.Scanner;

public class TicTacToeGame {
	static Scanner sc=new Scanner(System.in);
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
 public static void main(String[] args) {
	System.out.println("Welcome to tic tac toe game");
	char[] board=createBoard();
	char player=takeInput();
	char computer=' ';
	if(player=='X')
		computer='O';
	else
		computer='X';
	showBoard(board);
	
}
}
