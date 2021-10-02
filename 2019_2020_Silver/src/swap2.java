//February 1
import java.util.*;
import java.io.*;

public class swap2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("swap.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("swap.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] swaps = new int[m][2];
		for(int i = 0; i < m; i++)	{
			st = new StringTokenizer(br.readLine());
			swaps[i][0] = Integer.parseInt(st.nextToken());
			swaps[i][1] = Integer.parseInt(st.nextToken());
		}
		int[] pos = new int[n+1];
		for(int i = 1; i < n+1; i++)	{
			pos[i] = i;
		}
		int index = 0;
		for(int i = 0; i < k; i++)	{
			for(int b = 0; b < m; b++)	{
				s(pos, swaps[b][0], swaps[b][1]);
			}
			if(compare(pos))	{
				index = i+1;
				//System.out.println(index);
				break;
			}
		}
		if(index == 0)	{
			for(int i = 1; i < pos.length; i++)	{
				out.println(pos[i]);
			}
			out.close();
			return;
		}
		
		for(int i = 0; i < k % index; i++)	{
			for(int b = 0; b < m; b++)	{
				s(pos, swaps[b][0], swaps[b][1]);
			}
		}
		for(int i = 1; i < pos.length; i++)	{
			out.println(pos[i]);
		}
		
		out.close();
	}
	public static void s(int[] num, int a, int b)	{
		for(int i = 0; i < (b-a)/2 + ((b-a)%2); i++)	{
			int temp = num[b-i];
			num[b-i] = num[a+i];
			num[a+i] = temp;
		}
	}
	
	public static boolean compare(int[] a1)	{
		for(int i = 1; i < a1.length; i++)	{
			if(a1[i] < a1[i-1]) return false;
		}
		return true;
	}
}
