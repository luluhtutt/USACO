import java.util.*;
import java.io.*;

public class positionline {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("positionline.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("positionline.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		int[] b = new int[n-1];
		int[] a = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n-1; i++)	{
			b[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 9; i >= 1; i--)	{
			fill(a, b, i);
			if(checknegative(a))	{
				out.println(Arrays.toString(a));
				break;
			}
		}
		out.close();
	}
	
	public static void fill(int[] a, int[] b, int n)	{
		a[0] = n;
		for(int i = 0; i < b.length; i++)	{
			a[i+1] = b[i] - a[i];
		}
	}
	
	public static boolean checknegative(int[] a)	{
		for(int i = 0; i < a.length; i++)	{
			if(a[i] <= 0)	{
				return false;
			}
		}
		return true;
	}

}
