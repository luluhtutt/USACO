import java.util.*;
import java.io.*;

public class race {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("race2.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("race2.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		for(int h = 1; h <= m; h++)	{
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			out.println(build(k, x));
			//System.out.println(build(k, x));
		}
		out.close();
	}
	
	public static int build(int k, int x)	{
		int b = 0;
		int j = 1;
		while(j <= x-1)	{
			b += j;
			if (b >= k) return j;
			j++;
		}
		int tgt = k - b;
		//System.out.println(b);
		//System.out.println(tgt);
		j = x;
		//System.out.println(j);
		int d = 0;
		while(d < tgt)	{
			d += j*2;
			j++;
		}
		j--;
		//System.out.println(j);
		boolean twin = false;
		if(d-j < tgt)	{
			twin = true;
		}
		//System.out.println(twin);
		int i = (j-(x-1));
		if(twin)	{
			return (i*2 + (x-1));
		} else	{
			return (i*2 - 1 + (x-1));
		}
	}
}
