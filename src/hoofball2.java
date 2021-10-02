//February 2
import java.util.*;
import java.io.*;
public class hoofball2 {
	
	public static int[] x;
	
	public static void main(String[] args) throws IOException	{
		BufferedReader br = new BufferedReader(new FileReader("hoofball.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hoofball.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		x = new int[n];
		boolean[] receiver = new boolean[n];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)	{
			x[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(x);
		int starter = 0;
		
		for(int k = 0; k <= n-2; k++)	{
			if(next(k) == k+1 && next(k+1) == k && (k == 0 || next(k-1) != k) && (k+2 == n || next(k+2) != k+1))	{
				starter++;
			}
		}
		
		for(int i = 0; i < n; i++)	{
			receiver[next(i)] = true;
		}
		for(int i = 0; i < n; i++)	{
			if(!receiver[i])	{
				starter++;
			}
		}
		
		out.println(starter);
		out.close();
	}
	
	public static int next(int c) {
		if (c == 0) return 1;
		if(c == x.length-1) return x.length-2;
		if(x[c] - x[c-1] <= x[c+1] - x[c])	{
			return c-1;
		}
		return c+1;
	}
	

}
