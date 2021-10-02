//Open 3
import java.util.*;
import java.io.*;

public class evolution3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("evolution.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("evolution.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		Set<String>[] subpopulations = new HashSet[n];
		TreeSet<String> traits = new TreeSet<String>();
		for(int i = 0; i < n; i++)	{
			subpopulations[i] = new HashSet<>();
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			for(int j = 0; j < m; j++)	{
				String d = st.nextToken();
				subpopulations[i].add(d);
				traits.add(d);
			}
		}
		
		int l = traits.size();
		String[] all = new String[l];
		for(int i = 0; i < l; i++)	{
			all[i] = traits.first();
			traits.remove(traits.first());
		}
		
		for(int i = 0; i < l-1; i++)	{
			for(int j = i+1; j < l; j++)	{
				boolean a = false;
				boolean b = false;
				boolean ab = false;
				String first = all[i];
				String second = all[j];
				for(int h = 0; h < n; h++)	{
					if(subpopulations[h].contains(first) && subpopulations[h].contains(second))	{
						ab = true;
					}
					if(subpopulations[h].contains(first) && !subpopulations[h].contains(second))	{
						a = true;
					}
					if(!subpopulations[h].contains(first) && subpopulations[h].contains(second))	{
						b = true;
					}
				}
				if(a && b && ab)	{
					out.println("no");
					out.close();
					return;
				}
			}
		}
		out.println("yes");
		out.close();
	}
}
