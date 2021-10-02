//January 2
import java.util.*;
import java.io.*;

public class sleepy {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("sleepy.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sleepy.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int[] nums = new int[n];
		for(int i = 0; i < n; i++)	{
			nums[i] = Integer.parseInt(st2.nextToken());
		}
		for(int i = n-1; i > 0; i--)	{
			int cur = nums[i];
			if(nums[i-1] > cur)	{
				out.println(i);
				out.close();
				break;
			}
		}
		out.println(0);
		out.close();
		

	}

}
