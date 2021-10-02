//Open 3
import java.util.*;
import java.io.*;

public class evolution2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("evolution.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("evolution.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		Set<String>[] popu = new HashSet[n];
		TreeSet<String> traits = new TreeSet<String>();
		
		for(int i = 0; i < n; i++)	{
			st = new StringTokenizer(br.readLine()); 
			popu[i] = new HashSet<>();
			int d = Integer.parseInt(st.nextToken());
			for(int j = 0; j < d; j++)	{
				String next = st.nextToken();
				popu[i].add(next);
				traits.add(next);
			}
		}
		int m = traits.size();
		String[] all = new String[m];
		for(int i = 0; i < m; i++)	{
			all[i] = traits.first();
			traits.remove(traits.first());
		}
		
		for(int i = 0; i < m-1; i++)	{
			for(int k = i+1; k < m; k++)	{
				String first = all[i];
				String second = all[k];
				boolean a = false;
				boolean b = false;
				boolean ab = false;
				for(int h = 0; h < n; h++)	{
					if(popu[h].contains(first) && popu[h].contains(second))	{
						ab = true;
					}
					if(popu[h].contains(first) && !popu[h].contains(second))	{
						a = true;
					}
					if(popu[h].contains(second) && !popu[h].contains(first))	{
						b = true;
					}
				}
				if(ab && a && b)	{
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
