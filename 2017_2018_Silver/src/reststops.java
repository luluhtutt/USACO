//February 1
import java.util.*;
import java.io.*;

public class reststops {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("reststops.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("reststops.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long l = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		long rf = Integer.parseInt(st.nextToken()); //seconds per meter
		long rb = Integer.parseInt(st.nextToken()); //seconds per meter
		long[][] rest = new long[n+1][2];
		
		for(int i = 1; i <= n; i++)	{
			st = new StringTokenizer(br.readLine());
			int loc = Integer.parseInt(st.nextToken());
			int tastiness = Integer.parseInt(st.nextToken());
			rest[i][0] = loc;
			rest[i][1] = tastiness;
		}
		
		//greedy --> find largest, eat until farmer comes and continue
		long taste = 0;
		int index = 0;
		while(index < n)	{
			//System.out.println(Arrays.toString(res));
			int max = greedy(rest, index);
			long posb = rest[index][0];
			long posf = rest[max][0];
			
			long t = ((posf-posb)*rf) - ((posf-posb)*rb);
			taste += (rest[max][1] * t);
			index = max;
		}
		out.println(taste);
		out.close();
	}
	
	public static int greedy(long[][] rest, int start)	{
		int max = 0;
		for(int i = start+1; i < rest.length; i++)	{
			if(rest[i][1] >= rest[max][1])	{
				max = i;
			}
		}
		return max;
	}

}
