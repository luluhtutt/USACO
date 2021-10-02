//Open #3
import java.util.*;
import java.io.*;

public class evolution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("evolution.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("evolution.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		int[] subPopulations = new int[n];
		String[] characteristics = new String[n];
		ArrayList<String> ones = new ArrayList<String>();
		
		for (int i = 0; i < n; i++)	{
			StringTokenizer str = new StringTokenizer(br.readLine());
			subPopulations[i] = Integer.parseInt(str.nextToken());
			if(subPopulations[i] == 1)	{
				ones.add(str.nextToken());
				characteristics[i] = " ";
			}
			else if(subPopulations[i] == 0)	{
				characteristics[i] = " ";
			}
			else	{
				characteristics[i] = "";
				while(str.hasMoreElements())	{
					characteristics[i] += str.nextToken() + " ";
				}
			}
		}
		
		boolean answer = true;
		for(int i = 0; i < ones.size(); i++)	{
			int check = 0;
			for (int j = 0; j < n; j++)	{
				if(characteristics[j].contains(ones.get(i)))	{
					check ++;
				}
			}
			if(check > 2)	{
				answer = false;
			}
		}
		
		if(answer)	{
			out.println("yes");
		}
		else	{
			out.println("no");
		}
		out.close();
	}
}
