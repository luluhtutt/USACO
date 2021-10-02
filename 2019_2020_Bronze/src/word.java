//January 1
import java.util.*;
import java.io.*;

public class word {

	public static void main(String[] args) throws IOException {
BufferedReader br = new BufferedReader(new FileReader("word.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("word.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		String[] words = new String[n];
		for(int i = 0; i < n; i++)	{
			words[i] = st.nextToken();
		}
		
		int counter = 0;
		while(counter < n)	{
			int curline = 0;
			for(int i = counter; i < n; i++)	{
				if(curline+words[i].length() > k)	{
					out.println();
					break;
				} else	{
					curline += words[i].length();
					if(counter == n-1 || curline + words[i+1].length() > k)	{
						out.print(words[i]);
					} else	{
						out.print(words[i] + " ");
					}
					counter++;
				}
			}
		}
		out.close();
	}

}
