//February 2
import java.util.*;
import java.io.*;
public class hoofball_1 {

	public static void main(String[] args) throws IOException	{
		BufferedReader br = new BufferedReader(new FileReader("hoofball.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hoofball.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int[] x = new int[n+1];
		boolean[] b = new boolean[n+1];

		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++)	{
			x[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(x);
		int starter = 0;
		for(int i = 1; i <= n-1; i++)	{
			int dl2 = (i <= 2)? Integer.MAX_VALUE: x[i-1] - x[i-2];
			int dl = (i == 1)? Integer.MAX_VALUE: x[i] - x[i-1];
			int dm = x[i+1] - x[i];
			int dr2 = (i >= n-2)? Integer.MAX_VALUE: x[i+3] - x[i+2];
			int dr = (i == n-1)? Integer.MAX_VALUE: x[i+2] - x[i+1];
			if (i == 2 || i == n-2) continue;
			//System.out.println("i: " + i + " dl2: " + dl2 + " dl: " + dl + " dm: " + dm + " dr: " + dr + " dr2: " + dr2);
			if((i == 1 || (dl2 <= dl && dl > dm)) && (i+1 == n || (dm <= dr && dr > dr2)))	{
				starter++;
				b[i] = true;
				b[i+1] = true;
				i++;
			}
		}
		//System.out.println("Starter: " + starter);
		//System.out.println("Boolean: " + Arrays.toString(b));
		
		for(int i = 1; i <= n; i++)	{
			pass(x, b, i, n, 0);
			//System.out.println("i=" + i + " boolean array=" + Arrays.toString(b));
		}
		for(int i = 1; i <= n; i++)	{
			if(!b[i])	{
				starter++;
				//System.out.println("i=" + i + "Starter=" + starter);
			}
		}
		//System.out.println("Final starter: " + starter);
		out.println(starter);
		out.close();
	}
	
	public static void pass(int[] x, boolean[] b, int c, int n, int ctr)	{
		if(b[c])	{
			return;
		}
		if(ctr > 0)	{
			b[c] = true;
		}
		int dr = (c == n)? Integer.MAX_VALUE: x[c+1] - x[c];
		int dl = (c == 1)? Integer.MAX_VALUE: x[c] - x[c-1];
		int k = (dl <= dr)? c-1: c+1;
		pass(x, b, k, n, ctr+1);
	}

}
