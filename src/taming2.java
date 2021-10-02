//February 3
import java.util.*;
import java.io.*;
public class taming2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("taming.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("taming.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		int[] counter = new int[n];
		boolean[] brek = new boolean[n];
		brek[0] = true;
		int min = 0;
		int max = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i ++)	{
			counter[i] = Integer.parseInt(st.nextToken());
		}
		
		if(!(counter[0] == -1 || counter[0] == 0))	{
			out.println(-1);
			out.close();
			return;
		}
		
		for(int i = 1; i < n; i++)	{
			if(counter[i] != -1)	{
				if(counter[i] == 0)	{
					brek[i] = true;
					brek[i] = true;
				}
				else if(counter[i-1] != -1)	{
					if(counter[i-1] != counter[i] - 1)	{
						out.println(-1);
						out.close();
						return;
					}
				}
				else if(counter[i-1] == -1)	{
					for(int j = 1; j <= counter[i]; j++)	{
						counter[i-j] = counter[i] - j;
					}
				}
			}
		}
		
		for(int i = 0; i < n; i++)	{
			if(counter[i] == 0)	{
				min++;
				max++;
			}
			else if(brek[i])	{
				min++;
				max++;
			}
			else if(counter[i] == -1)	{
				max++;
			}
		}
		out.println(min + " " + max);
		out.close();
	}

}
