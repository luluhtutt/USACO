//December 3
import java.util.*;
import java.io.*;

public class lineup {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("lineup.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lineup.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		String names = "BessieButtercupBelindaBeatriceBellaBlueBetsySue";
		
		String[] order = {"Bessie", "Buttercup", "Belinda", "Beatrice", "Bella", "Blue", "Betsy", "Sue"};
		Arrays.sort(order);
		
		for(int i = 0; i < 8; i++)	{
			System.out.println(order[i]);
		}
		String[][] pairs = new String[n][2];
		
		for(int i = 0; i < n; i++)	{
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			pairs[i][0] = st2.nextToken();
			st2.nextToken();
			st2.nextToken();
			st2.nextToken();
			st2.nextToken();
			pairs[i][1] = st2.nextToken();
		}
		
		Set<String> used = new HashSet<>();
		String last = null;
		for (int i = 0; i < 8; i++) {
			for (int h = 0; h < order.length; h++) {
				String c = order[h];
				boolean f = can_go_first(c, used, last, pairs);
				if(f)	{
					out.println(c);
					used.add(c);
					last = c;
					break;
				}
			}
		}
		
		out.close();
		br.close();
	}
	
	public static boolean can_go_first(String c, Set<String> used, String last, String[][] pairs) {
		if(used.contains(c))	{
			return false;
		}
		int nbrs = 0;
		for (int j = 0; j < pairs.length; j++)	{
			if(pairs[j][0].equals(c) && !(used.contains(pairs[j][1])))	{
				nbrs++;
			}
			if(pairs[j][1].equals(c) && !(used.contains(pairs[j][0])))	{
				nbrs++;
			}
		}
		if(nbrs == 2)	{
			return false;
		}
		for(int i = 0; i < pairs.length; i++)	{
			if(pairs[i][0].equals(last) && !pairs[i][1].equals(c) && !used.contains(pairs[i][1]))	{
				return false;
			}
			if(pairs[i][1].equals(last) && !pairs[i][0].equals(c) && !used.contains(pairs[i][0]))	{
				return false;
			}
		}
		return true;
	}

}
