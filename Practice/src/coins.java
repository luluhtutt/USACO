//dynamic programming 1
import java.util.*;
import java.io.*;

public class coins {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("coins.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("coins.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		out.println(bottom_up(n));
		out.close();
	}
	
	public static int bottom_up(int n)	{
		int[] a = new int[n+1];
		a[1] = 1;
		a[2] = 2;
		a[3] = 3;
		a[4] = 4;
		a[5] = 5;
		a[6] = 1;
		a[7] = 2;
		a[8] = 3;
		a[9] = 4;
		a[10] = 1;
		a[11] = 2;
		for(int t = 12; t <= n; t++)	{
			int min = a[t-1];
			min = Math.min(min, a[t-6]);
			min = Math.min(min, a[t-10]);
			a[t] = min+1;
		}
		return a[n];
	}

}
