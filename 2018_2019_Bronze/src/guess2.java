//January 3
import java.util.*;
import java.io.*;

public class guess2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("guess.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("guess.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int max = 0;
		Set<String>[] chara = new HashSet[n];
		for(int i = 0; i < n; i++)	{
			chara[i] = new HashSet<>();
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			st2.nextElement();
			int j = Integer.parseInt(st2.nextToken());
			for(int h = 0; h < j; h++)	{
				String current = st2.nextToken();
				chara[i].add(current);
			}
		}
		for(int i = 0; i < n-1; i++)	{
			for(int j = i+1; j < n; j++)	{
				Set<String> sa = new HashSet<>(chara[i]);
				sa.retainAll(chara[j]);
				int current = sa.size();
				if(current > max)	{
					max = current;
				}
			}
		}
		out.println(max+1);
		out.close();
		br.close();

	}

}
