//February 2
import java.util.*;
import java.io.*;

public class paintbarn2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("paintbarn.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("paintbarn.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] grid = new int[1000][1001];
		
		for(int i = 0; i < n; i++)	{
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for(int j = y1; j < y2; j++)	{
				grid[j][x1]++;
				grid[j][x2]--;
			}
		}
		int count = 0;
		for(int i = 0; i < 1000; i++)	{
			int b = 0;
			for(int j = 0; j < 1001; j++)	{
				b += grid[i][j];
				if(b == k) count++;
			}
		}
		out.println(count);
		out.close();
	}

}
