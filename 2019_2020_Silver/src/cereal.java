//Open 2
import java.util.*;
import java.io.*;

public class cereal {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("cereal.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cereal.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] fav = new int[n][2];
		for(int i = 0; i < n; i++)	{
			st = new StringTokenizer(br.readLine());
			fav[i][0] = Integer.parseInt(st.nextToken());
			fav[i][1] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < n; i++)	{
			out.println(number(fav, i, n, m));
		}
		out.close();
	}
	
	public static int number(int[][] fav, int i, int n, int m)	{
		int count = 0;
		ArrayList<Integer> removed = new ArrayList<Integer>();
		for(int j = i; j < n; j++)	{
			if(count == m) return m;
			if(!removed.contains(fav[j][0]))	{
				removed.add(fav[j][0]);
				count++;
			} else if(!removed.contains(fav[j][1]))	{
				removed.add(fav[j][1]);
				count++;
			}
		}
		return count;
	}

}
