//February 1
import java.util.*;
import java.io.*;

public class swap {

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
		int[] original = new int[n+1];
		for(int i = 1; i < n+1; i++)	{
			pos[i] = i;
			original[i] = i;
		}
		int index = 0;
		for(int i = 0; i < k; i++)	{
			for(int b = 0; b < m; b++)	{
				s(pos, swaps[b][0], swaps[b][1]);
			}
			if(compare(pos, original))	{
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
				s(original, swaps[b][0], swaps[b][1]);
			}
		}
		for(int i = 1; i < original.length; i++)	{
			out.println(original[i]);
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
	
	public static boolean compare(int[] a1, int[] a2)	{
		if(Arrays.toString(a1).equals(Arrays.toString(a2))) return true;
		return false;
	}
}
