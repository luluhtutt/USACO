//December #2
import java.util.*;
import java.io.*;

public class blist2 {

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
		
		for(int i = 0; i < n; i++)	{
			StringTokenizer b = new StringTokenizer(br.readLine());
			
			start[i] = Integer.parseInt(b.nextToken());
			finish[i] = Integer.parseInt(b.nextToken());
			buckets[i] = Integer.parseInt(b.nextToken());
		}
		for(int j = 0; j < 1000; j++)	{
			sum = 0;
			for(int h = 0; h < n; h++)	{
				if(j >= start[h] && j <= finish[h])	{
					sum += buckets[h];
				}
			}
			if(sum > max)	{
				max = sum;
			}
		}
		out.println(max);
		out.close();
		br.close();
	}

}
