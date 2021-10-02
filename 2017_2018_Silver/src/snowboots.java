//February 2
import java.util.*;
import java.io.*;

public class snowboots {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("snowboots.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("snowboots.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int[] depths = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)	{
			depths[i] = Integer.parseInt(st.nextToken());
		}
		
		int count = 0;
		int cStep = 0;
		int latest = 0;
		for(int i = 0; i < b; i++)	{
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			System.out.println("d: " + d + " s: " + s);
			while(cStep <= latest + s && cStep < n)	{
				System.out.println("cStep: " + cStep + " cDepth: " + depths[cStep] + " latest: " + latest + " end: " + (latest + s));
				if(depths[cStep] <= d)	{
					latest = cStep;
				}
				cStep++;
			}
			cStep = latest;
			if(cStep == n-1)	{
				break;
			}
			count++;
			System.out.println("cStep: " + cStep + " count: " + count);
		}
		out.println(count);
		out.close();
		br.close();
	}

}
