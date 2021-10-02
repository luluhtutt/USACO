//February 2
import java.util.*;
import java.io.*;

public class paintbarn {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("paintbarn.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("paintbarn.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] grid = new int[1000][1001];
		int[][] plus = new int[n][2];
		int[][] minus = new int[n][2];
		
		for(int i = 0; i < n; i++)	{
			st = new StringTokenizer(br.readLine());
			plus[i][0] = Integer.parseInt(st.nextToken());
			plus[i][1] = Integer.parseInt(st.nextToken());
			minus[i][0] = Integer.parseInt(st.nextToken());
			minus[i][1] = Integer.parseInt(st.nextToken());
			//System.out.println(plus[i][0] + " " + plus[i][1] + " " + minus[i][0] + " " + minus[i][1]);
			for(int j = plus[i][1]; j < minus[i][1]; j++)	{
				for(int h = plus[i][0]; h < minus[i][0]; h++)	{
					//System.out.println(j + " " + h);
					grid[j][h]++;
				}
			}
			//System.out.println(Arrays.deepToString(grid));
		}
		int count = 0;
		for(int i = 0; i < 1000; i++)	{
			for(int j = 0; j < 1001; j++)	{
				if(grid[i][j] == k) count++;
			}
		}
		out.println(count);
		out.close();
	}

}
