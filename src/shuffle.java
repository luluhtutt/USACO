//December 2
import java.util.*;
import java.io.*;

public class shuffle {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("shuffle.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		int[] order = new int[n+1];
		int[] nums = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++)	{
			order[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++)	{
			nums[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < 3; i++)	{
			int[] temp = new int[n+1];
			for(int j = 1; j <= n; j++)	{
				temp[j] = nums[order[j]];
			}
			copy(nums, temp);
		}
		for(int i = 1; i <= n; i++)	{
			out.println(nums[i]);
		}
		out.close();
	}
	
	public static void copy(int[] arr1, int[] arr2)	{
		for(int i = 0; i < arr1.length; i++)	{
			arr1[i] = arr2[i];
		}
	}
}
