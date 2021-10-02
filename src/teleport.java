//February 1
import java.io.*;
import java.util.*;

public class teleport {
	
	public static void main(String args[]) throws IOException	{
		BufferedReader br = new BufferedReader(new FileReader("teleport.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("teleport.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a, b, x, y;
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		int min;
		min = (Math.abs(a-x) + Math.abs(b-y));
		int current = (Math.abs(a-y) + Math.abs(b-x));
		int none = Math.abs(a-b);
		if (none < min && none < current)	{
			out.println(none);
		}
		if (current < none && current < min)	{
			out.println(current);
		}
		if (min < current && min < none)	{
			out.println(min);
		}
		out.close();
		
	}
}
