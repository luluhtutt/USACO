//December 3
import java.util.*;
import java.io.*;

public class mooyomooyo {
	
	static int n;
	static int k;
	static char[][] board;
	static boolean changed = true;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("mooyomooyo.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mooyomooyo.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] grid = new int[n][10];
		
		for(int i = 0; i < n; i++)	{
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 10; j++)	{
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
	}
}
