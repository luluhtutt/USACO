//February 3
import java.util.*;
import java.io.*;

public class traffic2 {

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

		out.println(backwards(ramps, first, second));
		out.println(forwards(ramps, first, second));
		out.close();
		
	}
	
	public static String forwards(String[] ramps, int[] first, int[] second)	{
		int r1 = -99999999;
		int r2 = 99999999;
		for(int i = 0; i < ramps.length; i++)	{
			if(ramps[i].equals("none"))	{
				r1 = Math.max(r1, first[i]);
				r2 = Math.min(r2, second[i]);
			} else if(ramps[i].equals("on"))	{
				r1 += first[i];
				r2 += second[i];
			} else {
				r2 -= first[i];
				r1 -= second[i];
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
	
	public static String backwards(String[] ramps, int[] first, int[] second)	{
		int r1 = -99999999;
		int r2 = 99999999;
		for(int i = ramps.length-1; i >= 0; i--)	{
			if(ramps[i].equals("none"))	{
				r1 = Math.max(r1, first[i]);
				r2 = Math.min(r2, second[i]);
			} else if (ramps[i].equals("off"))	{
				r1 += first[i];
				r2 += second[i];
			} else {
				r1 -= second[i];
				r2 -= first[i];
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
