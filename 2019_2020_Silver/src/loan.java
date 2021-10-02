//January 2
import java.util.*;
import java.io.*;

public class loan {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("loan.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("loan.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n = Long.parseLong(st.nextToken());
		long k = Long.parseLong(st.nextToken());
		long m = Long.parseLong(st.nextToken());
		
		long maxX = n/m+1;
		long minX = 1;
		
		// invariant condition: minX is always possible; maxX is not possible
		long x = 1L;
		while(minX < maxX)	{
			if (minX + 1L == maxX) {
				x = minX;
				break;
			}
			long testX = (maxX+minX)/2;
			long curDay = days(testX, k, n, m);
			if(curDay > k)	{
				maxX = testX;
			} else if(curDay <= k)	{
				minX = testX;
			}
		}
		out.println(x);
		out.close();
	}
	
	public static long days(long x, long k, long n, long m)	{
		long g = 0;
		long day = 0;
		while(g < n)	{
			long y = (n-g)/x;
			if (y <= m) {
				long d2 = ((n-g)%m == 0)? (n-g)/m: (n-g)/m+1;
				//System.out.println("x= " + x + " days= " + days);
				return d2+day;
			}
			
			if (y < x) {
				long p = y;
				long base = p*x;
				if (n-g-y < base) { // crossing base line, multiple x
					day++;
					g += y;
				} else {
					long d3 = (n-g-base)/y;
					day += d3;
					g += (y*d3);
				}
			} else {
				day++;
				g += y;
			}
			
			if(day >= k && n-g > 0)	{
				return k+1;
			}
		}
		return day;
	}

}
