import java.util.*;
import java.io.*;

public class frogjump {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("frogjump.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("frogjump.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < n; i++)	{
			st = new StringTokenizer(br.readLine());
			int current = Integer.parseInt(st.nextToken());
			out.println(jump(current));
		}
		out.close();
	}
	
	public static int jump(int n)	{
		int[] steps = new int[n+3];
		steps[0] = 1;
		steps[1] = 1;
		steps[2] = 2;
		for(int i = 3; i <= n; i++)	{
			steps[i] = steps[i-1] + steps[i-2] + steps[i-3];
		}
		return steps[n];
	}

}
