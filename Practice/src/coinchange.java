import java.io.*;
import java.util.*;

public class coinchange {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("coinchange.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("coinchange.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		for(int i = 0; i < n; i++)	{
			st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int[] coins = new int[h];
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < h; j++)	{
				coins[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(coins);
			st = new StringTokenizer(br.readLine());
			int total = Integer.parseInt(st.nextToken());
		}
		out.close();
	}
	
	public static int dp(int total, int[] coins)	{
		int[] a = new int[total+coins[coins.length-1]];
		a[0] = 1;
		
		
		return a[total];
	}

}
