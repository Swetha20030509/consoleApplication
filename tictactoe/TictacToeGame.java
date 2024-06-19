package tictactoe;

import java.util.Scanner;

public class TictacToeGame {
	String board[][]=new String[3][3];
	String player="X";
	String computer="O";
	String currentPlayer="X";
	Scanner sc=new Scanner(System.in);
	public void intializeBoard()
	{
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board.length;j++)
			{
				board[i][j]="-";
				
			}
		}
	}
	public void changePlayer()
	{
		if(currentPlayer=="X")
			currentPlayer="O";
		else
			currentPlayer="X";
	}
	public void print()
	{
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board.length;j++)
			{
				System.out.print(board[i][j]+"       ");
			}
			System.out.println();
			System.out.println();
			System.out.println();
		}
	}
	public boolean isWin(String player)
	{
		for(int i=0;i<3;i++)
		{
			if(board[i][0]==player&&board[i][1]==player&&board[i][2]==player)
			{
				return true;
			}
			else if(board[0][i]==player&&board[1][i]==player&&board[2][i]==player)
				return true;
		}
		for(int i=0;i<3;i++)
		{
			if(board[0][i]==player&&board[1][i]==player&&board[2][i]==player)
				return true;
		}
		 if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
	            return true;
	        }
	        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
	            return true;
	        }
		return false;
		
	}
	public int[] computerPlay()
	{
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(board[i][j]=="-")
				{
					board[i][j]=computer;
					if(isWin(computer))
					{
						board[i][j]="-";
						return new int[] {i,j};
					}
					else 
					{
						board[i][j]="-";
					}
				}
			}
		}
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(board[i][j]=="-")
				{
					board[i][j]=player;
					if(isWin(player))
					{
						board[i][j]="-";
						return new int[] {i,j};
					}
					else
					{
						board[i][j]="-";
					}
				}
			}
		}
		if(board[0][0]=="-")
		{
			return new int[] {0,0};
		}
		else if(board[0][2]=="-")
		{
			return new int[] {0,2};
		}
		else if(board[2][0]=="-")
		{
			return new int[] {2,0};
		}
		else if(board[2][2]=="-")
		{
			return new int[] {2,2};
		}
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(board[i][j]=="-")
				{
					return new int[] {i,j};
				}
			}
		}
		return new int[] {};
	}
	public boolean isFull()
	{
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(board[i][j]=="-")
				{
					return false;
				}
			}
		}
		return true;
	}
	public void start()
	{
		while(true)
		{
			if(currentPlayer=="O")
			{
				System.out.println("computer"+currentPlayer+",enter your move (row and column): ");
				int postion[]=computerPlay();
				int row=postion[0];
				int column=postion[1];
				System.out.println(row);
				System.out.println(column);
				board[row][column]=currentPlayer;
			}
			else
			{
				System.out.println("Player"+currentPlayer+",enter your move (row and column): ");
				int row=sc.nextInt();
				int column=sc.nextInt();
				if(board[row][column]=="-")
				board[row][column]=currentPlayer;
				else
				{
					System.out.println("Enter the correct value");
					continue;
				}
			}
		print();
		if(isWin(currentPlayer))
		{
			if(currentPlayer=="O")
				System.out.println("computer is win");
			else
				System.out.println("Player is win the game");
			break;
		}
		if(isFull())
		{
			System.out.println("Tie the game");
			break;
		}
		changePlayer();
		}
	}
	public static void main(String[] args) {
		TictacToeGame tictactoegame=new TictacToeGame();
		tictactoegame.intializeBoard();
		tictactoegame.print();
		tictactoegame.start();

	}

}
