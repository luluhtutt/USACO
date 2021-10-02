//January 3
import java.util.*;
import java.io.*;

public class guess {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("guess.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("guess.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int max = 0;
		String[][] chara= new String[n][100];
		for(int i = 0; i < n; i++)	{
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			st2.nextElement();
			int j = Integer.parseInt(st2.nextToken());
			for(int h = 0; h < j; h++)	{
				String current = st2.nextToken();
				chara[i][h] = current;
			}
		}
		for(int i = 0; i < n-1; i++)	{
			for(int j = i+1; j < n; j++)	{
				int current = 0;
				for(int h = 0; h < chara[i].length; h++)	{
					for(int m = 0; m < chara[j].length; m++)	{
						if(chara[i][h]!= null && chara[j][m] != null)	{
							if(chara[i][h].equals(chara[j][m]))	{
								current++;
							}
						}
					}
				}
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
