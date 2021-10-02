//Open 2
import java.util.*;
import java.io.*;

public class cereal2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("cereal.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cereal.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		HashSet<Integer> che = new HashSet<Integer>();
		int[] count = new int[m+1];
		int[] turn = new int[m];
		int[][] fav = new int[n][2];
		for(int i = 0; i < n; i++)	{
			st = new StringTokenizer(br.readLine());
			fav[i][0] = Integer.parseInt(st.nextToken());
			fav[i][1] = Integer.parseInt(st.nextToken());
			count[fav[i][0]]++;
			count[fav[i][1]]++;
			che.add(fav[i][0]);
			che.add(fav[i][1]);
		}
		int track = m-che.size();
		for(int i = 0; i < n; i++)	{
			if(i == 0)	{
				out.println(Math.min(che.size(), Math.min(n-i, m)));
				continue;
			}
			count[fav[i-1][0]]--;
			count[fav[i-1][1]]--;
			if(count[fav[i-1][0]] == 0) track++;
			if(count[fav[i-1][1]] == 0) track++;
			//System.out.println(m-track + " " + Math.min(n-i, m));
			out.println(Math.min(m-track, Math.min(n-i, m)));
		}
		out.close();
	}

}
