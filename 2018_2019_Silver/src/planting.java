//January 1
import java.util.*;
import java.io.*;
public class planting {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("planting.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("planting.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int[] count = new int[n+1];
		for(int i = 0; i < n-1; i++)	{
			st = new StringTokenizer(br.readLine());
			int c1 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			count[c1]++;
			count[c2]++;
		}
		int max = 0;
		for(int i = 1; i < n+1; i++)	{
			if(count[i] > max) max = count[i];
		}
		out.println(max+1);
		out.close();
	}

}
