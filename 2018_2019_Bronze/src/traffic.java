//February 3
import java.util.*;
import java.io.*;

public class traffic {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("traffic.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("traffic.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		String[] ramps = new String[n];
		int[] first = new int[n];
		int[] second = new int[n];
		
		for(int i = 0; i < n; i++)	{
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			ramps[i] = st2.nextToken();
			first[i] = Integer.parseInt(st2.nextToken());
			second[i] = Integer.parseInt(st2.nextToken());
		}
		
		String before_result = before(0, ramps, first, second, -99999999, 99999999);
		out.println(before_result);
		String after_result = after(0, ramps, first, second);
		out.println(after_result);
		out.close();
		br.close();
	}
	
	public static String after(int index, String[] ramp, int[] arr1, int[] arr2)	{
		int r1 = -99999999;
		int r2 = 99999999;
		for(int i = index; i < ramp.length; i++)	{
			if(ramp[i].equals("none"))	{
				r1 = Math.max(r1, arr1[i]);
				r2 = Math.min(r2, arr2[i]);
			}
			else if(ramp[i].equals("on"))	{
				r1 += arr1[i];
				r2 += arr2[i];
			}
			else	{
				r1 -= arr2[i];
				r2 -= arr1[i];
				if(r1 < 0)	{
					r1 = 0;
				}
				if(r2 < 0)	{
					r2 = 0;
				}
			}
		}
		
		return r1 + " " + r2;
	}
	
	public static String before(int index, String[] ramp, int[] arr1, int[] arr2, int r1, int r2)	{
		for(int i = ramp.length-1; i >= 0; i--)	{
			if(ramp[i].equals("none"))	{
				r1 = Math.max(r1, arr1[i]);
				r2 = Math.min(r2, arr2[i]);
			}
			else if(ramp[i].equals("off"))	{
				r1 += arr1[i];
				r2 += arr2[i];
			}
			else	{
				r1 -= arr2[i];
				r2 -= arr1[i];
				if(r1 < 0)	{
					r1 = 0;
				}
				if(r2 < 0)	{
					r2 = 0;
				}
			}
		}
		
		return r1 + " " + r2;
	}

}
