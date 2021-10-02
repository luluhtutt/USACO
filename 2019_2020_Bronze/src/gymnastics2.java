//December 1
import java.util.*;
import java.io.*;

public class gymnastics2 {
	public static int winner(int i, int h, int[][] arr, int j)	{
		int tracker = 0;
		for(int index = 0; index < arr[0].length; index++)	{
			if(arr[j][index] == i)	{
				tracker = 1;
				return tracker;
			}
			else if(arr[j][index] == h)	{
				tracker = 2;
				return tracker;
			}
		}
		return tracker;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("gymnastics.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gymnastics.out")));
		
		StringTokenizer a = new StringTokenizer(br.readLine());
		
		int k = Integer.parseInt(a.nextToken());
		int n = Integer.parseInt(a.nextToken());
		int total = 0;
	
		
		int[][] pair = new int[n+1][n+1];
		int[][] order = new int[k][n];
		for(int i = 0; i < k; i++)	{
			a = new StringTokenizer(br.readLine());
			for(int h = 0; h < n; h++)	{
				order[i][h] = Integer.parseInt(a.nextToken());
			}
		}
		
		for(int i = 1; i <= n-1; i++)	{
			for(int h = i+1; h <= n; h++)	{
				for (int j = 0; j < k; j++) {
					int w = winner(i, h, order, j);
					if(pair[i][h] == 0)	{
						pair[i][h] = w;
					}
					else if(pair[i][h] != w)	{
						pair[i][h] = 3;
					}
					else	{
						pair[i][h] = w;
					}
				}
			}
		}
		for(int i = 1; i <= n-1; i++)	{
			for(int h = i + 1; h <= n; h++)	{
				if(pair[i][h] != 3)	{
					total++;
				}
			}
		}
		
		out.println(total);
		out.close();
		br.close();
	}
	

}
