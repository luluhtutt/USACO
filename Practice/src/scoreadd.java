import java.util.*;
import java.io.*;

public class scoreadd {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("scoreadd.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("scoreadd.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		for(int i = 0; i < n; i++)	{
			st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			out.println(dp(h));
		}
		out.close();
	}
	
	public static int dp(int n)	{
		int[] a = new int[n+10];
		a[0] = 1;
		a[1] = 0;
		a[2] = 0;
		for(int i = 3; i <= n; i++)	{
			a[i] += a[i-3];
		}
		for(int i = 5; i <= n; i++)	{
			a[i] += a[i-5];
		}
		for(int i = 10; i <= n; i++)	{
			a[i] += a[i-10];
		}
		return a[n];
	}

}
