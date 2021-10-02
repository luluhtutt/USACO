//January 2
import java.util.*;
import java.io.*;

public class lifeguards {

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
		
		int minMissing = 9999999;
		int indexMissing = 0;
		for(int i = 0; i < n; i++)	{
			int tempMissing = 0;
			for(int k = intervals[i][0]; k < intervals[i][1]; k++)	{
				if(line[k] < 1)	tempMissing++;
				line[k]++;
				//System.out.println("i=" + i + " missing=" + tempMissing);
			}
			if(tempMissing < minMissing) {
				minMissing = tempMissing;
				indexMissing = i;
			}
		}
		//System.out.println(minMissing + " " + indexMissing);
		//System.out.println(Arrays.toString(line));
		for(int k = intervals[indexMissing][0]; k < intervals[indexMissing][1]; k++)	{
			line[k]--;
		}
		//System.out.println(Arrays.toString(line));
		int total = 0;
		for(int i = 0; i < line.length; i++)	{
			if(line[i] > 0) total++;
		}
		out.println(total);
		out.close();
	}

}
