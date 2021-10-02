//February 2
import java.util.*;
import java.io.*;

public class revegetate {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("revegetate.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("revegetate.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] pairs = new int[m][2];
		
		for(int i = 0; i < m; i++)	{
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			pairs[i][0] = Integer.parseInt(st2.nextToken());
			pairs[i][1] = Integer.parseInt(st2.nextToken());
		}
		int[] order = new int[n+1];
		for(int i = 0; i < n+1; i++)	{
			order[i] = 0;
		}
		
		for(int i = 1; i <= n; i++)	{
			for(int h = 1; h <= n; h++)	{
				if(available(pairs, order, h, i))	{
					order[i] = h;
					out.print(h);
					break;
				}
			}
		}
		out.close();
		br.close();
		
	}
	
	public static boolean available(int[][] pairs, int[] order, int typePlant, int currentPasture)	{
		for(int i = 0; i < pairs.length; i++)	{
			if(pairs[i][0] == currentPasture && order[pairs[i][1]] == typePlant)	{
				return false;
			}
			else if(pairs[i][1] == currentPasture && order[pairs[i][0]] == typePlant)	{
				return false;
			}
		}
		return true;
	}

}
