//January #1
import java.util.*;
import java.io.*;

class shell {
	
	public static void main(String args[]) throws IOException	{

		BufferedReader br = new BufferedReader(new FileReader("shell.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shell.out")));
		
		StringTokenizer a = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(a.nextToken());
		int actual = 0;
		int[] guess = new int[n];
		int current = 0;
		int max = 0;
		int[][] swaps = new int[n][2];
		
		for (int i = 0; i < n; i++)	{
			StringTokenizer b = new StringTokenizer(br.readLine());
			
			swaps[i][0] = Integer.parseInt(b.nextToken());
			swaps[i][1] = Integer.parseInt(b.nextToken());
			guess[i] = Integer.parseInt(b.nextToken());
		}
		
		for (int i = 1; i <= 3; i++)	{
			actual = i;
			current = 0;
			for(int j = 0; j < n; j++)	{
				if(swaps[j][0] == actual)	{
					actual = swaps[j][1];
				}
				else if(swaps[j][1] == actual)	{
					actual = swaps[j][0];
				}
				if(guess[j] == actual)	{
					current++;
				}
			}
			if(current > max)	{
				max = current;
			}
		}
		br.close();
		out.print(max);
		out.close();
	}
}