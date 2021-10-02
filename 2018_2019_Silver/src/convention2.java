//December 2
import java.util.*;
import java.io.*;

class Cow {
	int sr; // 1:senior
	int at;
	int len;
	public Cow(int sr_, int at_, int len_) {
		sr = sr_;
		at = at_;
		len = len_;
	}
}
public class convention2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("convention2.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("convention2.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Cow> p = new PriorityQueue<>(new Comparator<Cow>() {
			public int compare(Cow c1, Cow c2) {
				if (c1.at != c2.at) {
					return c1.at - c2.at;
				}
				// c1.at == c2.at
				return c1.sr - c2.sr;
			}
		});
		PriorityQueue<Cow> waiting = new PriorityQueue<>(new Comparator<Cow>() {
			public int compare(Cow c1, Cow c2) {
				return c1.sr - c2.sr;
			}
		});
		
		for(int i = 1; i <= n; i++)	{
			st = new StringTokenizer(br.readLine());
			int cs = Integer.parseInt(st.nextToken());
			int ct = Integer.parseInt(st.nextToken());
			p.add(new Cow(i, cs, ct));
		}
		
		int waitTime = 0;
		int current = p.peek().at;
		int end = -1;
		while(p.size() != 0)	{
			Cow c;
			if(waiting.size() == 0)	{
				c = p.poll();
			} else	{
				c = waiting.poll();
				waitTime = Math.max(waitTime, end-c.at);
			}
			
			current = Math.max(end, c.at);
			end = current + c.len;
			//System.out.println("current: " + current + " cow sr: " + c.sr + " wait:" + waitTime);
			
			while(p.size() > 0 && p.peek().at < end)	{
				waiting.add(p.poll());
			}
		}
		out.println(waitTime);
		out.close();
	}

}
