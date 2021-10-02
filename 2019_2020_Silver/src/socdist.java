//Open 1
import java.util.*;
import java.io.*;

public class socdist {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("socdist.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("socdist.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		boolean[] farm = new boolean[100001];
		
		for(int i = 0; i < m; i++)	{
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			for(int j = f; j <= e; j++)	{
				farm[j] = true;
			}
		}
		br.close();
		//System.out.println(Arrays.toString(farm));
		int low = 0;
		int high = farm.length/n + 2;
		while(low < high)	{
			if(low + 1 == high)	{
				break;
			}
			int mid = (low+high)/2;
			//System.out.println(mid + " " + possible(farm, n, mid));
			if(possible(farm, n, mid))	{
				low = mid;
			} else	{
				high = mid;
			}
		}
		//System.out.println(possible(farm, n, 3));
		out.println(low);
		out.close();
	}
	
	public static boolean possible(boolean[] farm, int n, int c)	{
		int cow = 0;
		int index = 0;
		int prev = -999999;
		while(cow < n && index < farm.length)	{
			if(farm[index] && index - prev >= c)	{
				//System.out.println(index + " " + prev);
				prev = index;
				cow++;
				index += c - 1;
			}
			index++;
			//System.out.println(index + " " + cow);
		}
		if(index >= farm.length && cow < n)	{
			return false;
		} else	{
			return true;
		}
	}
}
