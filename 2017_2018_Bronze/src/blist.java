//December #2
import java.util.*;
import java.io.*;

public class blist {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("blist.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("blist.out")));
		
		StringTokenizer a = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(a.nextToken());
		
		int[] start = new int[n];
		int[] finish = new int[n];
		int[] buckets = new int[n];
		int sum = 0;
		int max = 0;
		
		int[] b_req = new int[1000];
		for(int i = 0; i < n; i++)	{
			StringTokenizer b = new StringTokenizer(br.readLine());
			
			start[i] = Integer.parseInt(b.nextToken());
			finish[i] = Integer.parseInt(b.nextToken());
			buckets[i] = Integer.parseInt(b.nextToken());
		}
		for(int i = 0; i < n; i++)	{ // cow i
			for(int k = start[i]; k < finish[i]; k++)	{
				b_req[k] += buckets[i];
			}
		}
		for(int i = 0; i < 1000; i++)	{
			if(b_req[i] > max)	{
				max = b_req[i];
			}
		}
		out.println(max);
		out.close();
		br.close();
	}

}
