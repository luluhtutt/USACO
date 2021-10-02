//December 3
import java.util.*;
import java.io.*;

public class lineup2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("lineup.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lineup.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		String names = "BessieButtercupBelindaBeatriceBellaBlueBetsySue";
		
		String[] order = {"Bessie", "Buttercup", "Belinda", "Beatrice", "Bella", "Blue", "Betsy", "Sue"};
		Arrays.sort(order);
		String[][] pairs = new String[n][2];
		
		for(int i = 0; i < n; i++)	{
			st = new StringTokenizer(br.readLine());
			pairs[i][0] = st.nextToken();
			st.nextToken();
			st.nextToken();
			st.nextToken();
			st.nextToken();
			pairs[i][1] = st.nextToken();
		}
		Set<String> line = new HashSet<>();
		String last = "";
		for(int i = 0; i < 8; i++)	{
			for(int k = 0; k < 8; k++)	{
				if(can_go_first(order[k], pairs, last, line))	{
					last = order[k];
					line.add(order[k]);
					out.println(order[k]);
					break;
				}
			}
		}
		out.close();
		br.close();
	}
	
	public static boolean can_go_first(String c, String[][] pairs, String last, Set<String> line)	{
		if(line.contains(c))	{
			return false;
		}
		int nbrs = 0;
		for(int i = 0; i < pairs.length; i++)	{
			if(pairs[i][0].equals(c) && !line.contains(pairs[i][1]))	{
				nbrs++;
			}
			if(pairs[i][1].equals(c) && !line.contains(pairs[i][0]))	{
				nbrs++;
			}
		}
		if(nbrs == 2)	{
			return false;
		}
		
		for(int i = 0; i < pairs.length; i++)	{
			if(pairs[i][0].equals(last) && !c.equals(pairs[i][1]) && !line.contains(pairs[i][1]))	{
				return false;
			}
			if(pairs[i][1].equals(last) && !c.equals(pairs[i][0]) && !line.contains(pairs[i][0]))	{
				return false;
			}
		}
		return true;
	}
	
}
