//January 2
import java.util.*;
import java.io.*;

public class lifeguards2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("lifeguards.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		int[][] intervals = new int[n][2];
		int[] line = new int[1001];
		for(int i = 0; i < n; i++)	{
			st = new StringTokenizer(br.readLine());
			intervals[i][0] = Integer.parseInt(st.nextToken());
			intervals[i][1] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < n; i++)	{
			for(int k = intervals[i][0]; k < intervals[i][1]; k++)	{
				line[k]++;
			}
		}
		int minMissing = 99999999;
		int missIndex = 0;
		for(int i = 0; i < n; i++)	{
			int tempMissing = 0;
			for(int k = intervals[i][0]; k < intervals[i][1]; k++)	{
				line[k]--;
				if(line[k] == 0)	{
					tempMissing++;
				}
				line[k]++;
			}
			if(tempMissing < minMissing)	{
				minMissing = tempMissing;
				missIndex = i;
			}
		}
		
		int total = 0;
		for(int k = intervals[missIndex][0]; k < intervals[missIndex][1]; k++)	{
			line[k]--;
		}
		for(int i = 0; i < line.length; i++)	{
			if(line[i] > 0)	{
				total++;
			}
		}
		out.println(total);
		out.close();
	}

}
