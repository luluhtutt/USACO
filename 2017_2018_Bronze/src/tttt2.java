//Open 1
import java.io.*;
import java.util.*;

public class tttt2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("tttt.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("tttt.out")));
		
		char[][] board = new char[3][3];
		ArrayList<Character> winners = new ArrayList<Character>();
		int indiv = 0;
		for(int i = 0; i < 3; i++)	{
			StringTokenizer st = new StringTokenizer(br.readLine());
			String current = st.nextToken();
			board[i][0] = current.charAt(0);
			board[i][1] = current.charAt(1);
			board[i][2] = current.charAt(2);
			if(board[i][0] == board[i][1] && board[i][1] == board[i][2])	{
				if(!winners.contains(board[i][0]))	{
					indiv++;
					winners.add(board[i][0]);
				}
			}
		}
		
		for(int i = 0; i < 3; i++)	{
			if(board[0][i] == board[1][i] && board[0][i] == board[2][i])	{
				if(!winners.contains(board[0][i]))	{
					indiv++;
					winners.add(board[0][i]);
				}
			}
		}
		
		if(board[0][0] == board[1][1] && board[1][1] == board[2][2])	{
			if(!winners.contains(board[0][0]))	{
				indiv++;
				winners.add(board[0][0]);
			}
		}
		if(board[2][0] == board[1][1] && board[1][1] == board[2][0])	{
			if(!winners.contains(board[2][0]))	{
				indiv++;
				winners.add(board[2][0]);
			}
		}
		out.println(indiv);
		out.println(num_pairs(board));
		out.close();
		br.close();
		
	}
	
	public static int num_pairs(char[][] arr)	{
		int total = 0;
		ArrayList<ArrayList<Character>> winners = new ArrayList<ArrayList<Character>>();
		for(int i = 0; i < 3; i++)	{
			char one = arr[i][0];
			if(arr[i][1] == one && arr[i][2] != one)	{
				if(check_duplicates(winners, one, arr[i][2]))	{
					total++;
				}
			}
			else if(arr[i][2] == one && arr[i][1] != one)	{
				if(check_duplicates(winners, one, arr[i][1]))	{
					total++;
				}
			}
		}
		for(int i = 0; i < 3; i++)	{
			char one = arr[0][i];
			if(arr[1][i] == one && arr[2][i] != one)	{
				if(check_duplicates(winners, one, arr[2][i]))	{
					total++;
				}
			}
			else if(arr[2][i] == one && arr[1][i] != one)	{
				if(check_duplicates(winners, one, arr[1][i]))	{
					total++;
				}
			}
		}
		char one = arr[1][1];
		if(arr[0][0] == one && arr[2][2] != one)	{
			if(check_duplicates(winners, one, arr[2][2]))	{
				total++;
			}
		}
		if(arr[2][2] == one && arr[0][0] != one)	{
			if(check_duplicates(winners, one, arr[0][0]))	{
				total++;
			}
		}
		if(arr[2][2] == arr[0][0] && arr[2][2] != one)	{
			if(check_duplicates(winners, one, arr[2][2]))	{
				total++;
			}
		}
		
		if(arr[2][0] == one && arr[0][2] != one)	{
			if(check_duplicates(winners, one, arr[0][2]))	{
				total++;
			}
		}
		if(arr[0][2] == one && arr[2][0] != one)	{
			if(check_duplicates(winners, one, arr[2][0]))	{
				total++;
			}
		}
		if(arr[0][2] == arr[2][0] && arr[0][2] != one)	{
			if(check_duplicates(winners, one, arr[0][2]))	{
				total++;
			}
		}
		return total;
	}
	
	public static boolean check_duplicates(ArrayList<ArrayList<Character>> winners, char first, char second)	{
		ArrayList<Character> temp = new ArrayList<Character>();
		temp.add(first);
		temp.add(second);
		ArrayList<Character> temp2 = new ArrayList<Character>();
		temp2.add(second);
		temp2.add(first);
		if(!winners.contains(temp) && !winners.contains(temp2))	{
			winners.add(temp);
			winners.add(temp2);
			return true;
		}
		return false;
	}
}