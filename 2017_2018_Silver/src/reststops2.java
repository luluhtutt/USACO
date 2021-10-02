//February 1
import java.util.*;
import java.io.*;

public class reststops2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("reststops.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("reststops.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int l = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int rf = Integer.parseInt(st.nextToken());
		int rb = Integer.parseInt(st.nextToken());
		int[] rest = new int[l];
		
		for(int i = 0; i < n; i++)	{
			st = new StringTokenizer(br.readLine());
			int loc = Integer.parseInt(st.nextToken());
			rest[loc] = Integer.parseInt(st.nextToken());
		}
	}
	
}
