//January 1
import java.util.*;
import java.io.*;

public class berries {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("berries.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("berries.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] berries = new int[n];
		int end = Math.min(n, k);
		PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++)	{
			p.add(Integer.parseInt(st.nextToken()));
		}
		
		int c = 0;
		while(p.size() > 0)	{
			int d = p.remove();
			berries[c] = d;
			c++;
		}
		
		int sum = 0;
		for(int i = k/2; i < end; i++)	{
			sum+= berries[i];
		}
		
		//System.out.println(sum);
		for(int b = 1; b < berries[0]; b++)	{
			int f = 0;
			int tempsum = 0;
			for(int i = 0; i < end; i++)	{
				f += berries[i]/b;
			}
			if(f <= k/2)	{
				break;
			} else if(f >= k)	{
				tempsum = b*(k/2);
			} else	{
				PriorityQueue<Integer> p2 = new PriorityQueue<>(Collections.reverseOrder());
				for(int g = 0; g < end; g++)	{
					p2.add(berries[g]%b);
				}
				if(p2.size() < k-f) break;
				for(int v = f; v < k; v++)	{
					tempsum += p2.remove();
				}
				tempsum += (b*(f-(k/2)));
			}
			//System.out.println(b + " " + f + " " + tempsum);
			if(tempsum > sum)	{
				sum = tempsum;
			}
		}
		out.println(sum);
		out.close();
	}

}
