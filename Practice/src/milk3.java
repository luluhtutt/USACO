/*
 ID: luluhtu1
 LANG: JAVA
 TASK: milk2
 */
import java.io.*;
/*
import java.util.*;
class Intv implements Comparable<Intv> {
	int a;
	int b;
	public Intv(int a_, int b_)	{
		a = a_;
		b = b_;
	}
	public int compareTo(Intv other)	{
		return this.a - other.a;
		//- : <, 0 : =, + : >
		//small to big
	}
}
public class milk3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("milk2.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		int[][] intervals = new int[n][2];
		for(int i = 0; i < n; i++)	{
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			intervals[i][0] = Integer.parseInt(st2.nextToken());
			intervals[i][1] = Integer.parseInt(st2.nextToken());
		}
		PriorityQueue<Intv> q = new PriorityQueue<>();
		for(int i = 0; i < n; i++)	{
			q.add(new Intv(intervals[i][0], intervals[i][1]));
		}
		
		PriorityQueue<Intv> p = new PriorityQueue<>();
		
		while(q.size() > 0)	{
			Intv current = q.remove();
			System.out.println("q: " + current.a + " " + current.b);
			if(p.size() == 0)	{
				p.add(current);
			}
			else	{
				System.out.println("peek interval: " + p.peek().a + " " + p.peek().b);
				while(p.size() > 0 && p.peek().b >= current.a && p.peek().a <= current.b)	{
					current.a = Math.min(p.peek().a, current.a);
					current.b = Math.max(p.peek().b, current.b);
					System.out.println("inside loop: " + current.a + " " + current.b);
					p.remove();
				}
				p.add(current);
			}
			//System.out.println(current.a + " " + current.b);
			
		}
		int max_len = -1;
		int max_gap = 0;
		int end = p.peek().a;
		while(p.size() > 0)	{
			Intv current = p.remove();
			max_len = Math.max(max_len, current.b-current.a);
			max_gap = Math.max(max_gap, current.a-end);
			end = current.b;
			System.out.println(current.a + " " + current.b + " max length: " + max_len + " max gap: " + max_gap);
		}
		out.println(max_len + " " + max_gap);
		out.close();
	}

}*/
