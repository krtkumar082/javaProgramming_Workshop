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
 public static void main(String[] args) {
	System.out.println("Welcome to tic tac toe game");
	char[] board=createBoard();
	char player=takeInput();
	char computer=' ';
	if(player=='X')
		computer='O';
	else
		computer='X';
	
}
}
