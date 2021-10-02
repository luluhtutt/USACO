//December 2
import java.util.*;
import java.io.*;

public class meetings {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("meetings.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("meetings.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int tweight = 0;
		int[] w0 = new int[n+1];
		TreeSet<Integer> xl = new TreeSet<Integer>();
		TreeSet<Integer> xr = new TreeSet<Integer>();
		int[] x_mv_l;
		int[] x_mv_r;
		TreeMap<Integer, Integer> x_idx = new TreeMap<Integer, Integer>();
		
		for(int i = 1; i <= n; i++)	{
			st = new StringTokenizer(br.readLine());
			w0[i] = Integer.parseInt(st.nextToken());
			tweight += w0[i];
			int x = Integer.parseInt(st.nextToken());
			x_idx.put(x, i);
			int d = Integer.parseInt(st.nextToken());
			if(d == -1)	xl.add(x);
			if(d == 1) xr.add(x);
		}
		int[] weight = new int[n+1];
		int k = 1;
		for(int x: x_idx.keySet())	{
			int index = x_idx.get(x);
			weight[k] = w0[index];
			k++;
		}
		// System.out.println("weight: " + Arrays.toString(weight));
		x_mv_l = new int[xl.size()];
		x_mv_r = new int[xr.size()];
		int v = 0;
		for (int x: xl) {
			x_mv_l[v] = x;
			v++;
		}
		v = 0;
		for (int x: xr) {
			x_mv_r[v] = x;
			v++;
		}
		// System.out.println("x left: " + Arrays.toString(x_mv_l));
		// System.out.println("x right: " + Arrays.toString(x_mv_r));
		int cl = 1;
		int cr = n;
		int T = 0;
		int cweight = 0;
		int xri = x_mv_r.length-1;
		int xli = 0;
		int halfweight = (tweight%2==0)? tweight/2: tweight/2+1;
		while(cweight < halfweight && xli < x_mv_l.length && xri >= 0)	{
			if(l-x_mv_r[xri] < x_mv_l[xli])	{
				T = l-x_mv_r[xri];
				xri--;
				cweight += weight[cr];
				cr --;
			} else if(l-x_mv_r[xri] > x_mv_l[xli])	{
				T = x_mv_l[xli];
				xli++;
				cweight += weight[cl];
				cl ++;
				
			} else	{
				T = l-x_mv_r[xri];
				xri--;
				cweight += weight[cr];
				cr --;
				
				xli++;
				cweight += weight[cl];
				cl ++;
			}
			// System.out.println("time " + T + ", weight " + cweight + ", xli " + xli + ", xri " + xri);
		}
		while(cweight < halfweight && xli < x_mv_l.length)	{
			T = x_mv_l[xli];
			xli++;
			cweight += weight[cl];
			cl ++;
		}
		while(cweight < halfweight && xri >= 0)	{
			T = l-x_mv_r[xri];
			xri--;
			cweight += weight[cr];
			cr --;
		}
		Deque<Integer> p = new LinkedList<>();
		xli = 0;
		int counter = 0;
		
		for(int i: x_mv_r)	{
			int end = Math.min(i+2*T, l); // current interval: [i, end]
			while(p.size() > 0 && p.getFirst() < i) p.removeFirst();
			while(xli < x_mv_l.length && x_mv_l[xli] < i) xli++;
			while (xli < x_mv_l.length && i <= x_mv_l[xli] && x_mv_l[xli] <= end) {
				p.addLast(x_mv_l[xli]);
				xli++;
			}
			counter += p.size();
		}
		// System.out.println("cweight: " + cweight + "\nxri: " + xri + "\nxli: " + xli);
		// System.out.println("halfweight: " + halfweight + "\ntotalweight: " + tweight);
		// System.out.println(T);
		out.println(counter);
		out.close();
	}

}
