import java.util.HashSet;
import java.util.Scanner;

public class TicTacToeGame {
	static HashSet<Integer> user_set=new HashSet<Integer>();
	static HashSet<Integer> computer_set=new HashSet<Integer>();
	
	static void p_holder(char[][] game_board,int pos,String user)
	{
		char symbol='X';
		if(user.equals("YOU"))
		{
			symbol = 'X';
			user_set.add(pos);
		}
		else if (user.equals("COMPUTER"))
		{
			symbol = 'O';
			computer_set.add(pos);
		}
		
		switch(pos)
		{
			case 1:
				game_board[0][0]=symbol;
				break;
			case 2:
				game_board[0][2]=symbol;
				break;
			case 3:
				game_board[0][4]=symbol;
				break;
			case 4:
				game_board[2][0]=symbol;
				break;
			case 5:
				game_board[2][2]=symbol;
				break;
			case 6:
				game_board[2][4]=symbol;
				break;
			case 7:
				game_board[4][0]=symbol;
				break;
			case 8:
				game_board[4][2]=symbol;
				break;
			case 9:
				game_board[4][4]=symbol;
				break;
			default:
				System.out.println("Invalid position!");
				
		}
		print_board(game_board);
	}
	static void print_board(char[][] game_board)
	{
		System.out.println();
		for(int i=0;i<game_board.length;i++)
		{
			for(int j=0;j<game_board[0].length;j++)
			{
				System.out.print(game_board[i][j]);
			}
			System.out.println();
			
		}
	}
	static int generate_random() {
		int min=1;
		int max=9;
		int range=max-min+1;
		int res=(int)(Math.random()*range)+min;
		return res;
	}
	
	static String checkWinner() {
		HashSet<Integer>r1=new HashSet<Integer>();
		r1.add(1);r1.add(2);r1.add(3);
		
		HashSet<Integer>r2=new HashSet<Integer>();
		r2.add(4);r2.add(5);r2.add(6);
		
		HashSet<Integer>r3=new HashSet<Integer>();
		r3.add(7);r3.add(8);r3.add(9);
		
		HashSet<Integer>c1=new HashSet<Integer>();
		c1.add(1);c1.add(4);c1.add(7);
		
		HashSet<Integer>c2=new HashSet<Integer>();
		c2.add(2);c2.add(5);c2.add(8);
		
		HashSet<Integer>c3=new HashSet<Integer>();
		c3.add(3);c3.add(6);c3.add(9);
		
		HashSet<Integer>d1=new HashSet<Integer>();
		d1.add(1);d1.add(5);d1.add(9);
		
		HashSet<Integer>d2=new HashSet<Integer>();
		d2.add(3);d2.add(5);d2.add(7);
		
		HashSet<HashSet> set=new HashSet<HashSet>();
		set.add(r1);set.add(r2);set.add(r3);
		set.add(c1);set.add(c2);set.add(c3);
		set.add(d1);set.add(d2);
		for(HashSet c:set)
		{
			if(user_set.containsAll(c))
				return "You Won!";
			else if(computer_set.containsAll(c))
				return "You Lost!";
		}
		if(user_set.size()+computer_set.size()==9)
		{
			return "DRAW";
		}
		return "";
	}
	public static void main(String[] args) {
		char[][] game_board ={
				{ ' ','|',' ','|',' '},
				{ '-','-','-','-','-'},
				{ ' ','|',' ','|',' '},
				{ '-','-','-','-','-'},
				{ ' ','|',' ','|',' '}
				}; 
		print_board(game_board);
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			System.out.println("Enter position from 1-9");
			int user_pos=sc.nextInt();
			while(user_set.contains(user_pos) || computer_set.contains(user_pos))
			{
				System.out.println();
				System.out.println("Please retry! Enter position from 1-9");
				user_pos=sc.nextInt();
			}
			p_holder(game_board,user_pos,"YOU");
			
			String result=checkWinner();
			if(result.length()>0)
			{
				System.out.println(result);
				break;
			}
			int comp_pos=generate_random();
			while(user_set.contains(comp_pos) || computer_set.contains(comp_pos))
			{
					comp_pos=generate_random();
			}
			p_holder(game_board,comp_pos,"COMPUTER");
			result=checkWinner();
			if(result.length()>0)
			{
				System.out.println(result);
				break;
			}
		}
		

	}
	
	

}
