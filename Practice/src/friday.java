/*
ID: luluhtu1
LANG: JAVA
TASK: friday
*/
import java.util.*;
import java.io.*;

public class friday {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("friday.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		int year = 1900;
		int day = 1;
		int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int[] days = {0, 0, 0, 0, 0, 0, 0};
		for(int i = year; i < year + n; i++)	{
			if(i % 4 == 0)	{
				if(i % 100 == 0)	{
					if(i % 400 == 0)	{
						months[2] = 29;
					}
					else	{
						months[2] = 28;
					}
				}
				else	{
					months[2] = 29;
				}
			}
			else	{
				months[2] = 28;
			}
			for(int j = 1; j <= 12; j++)	{
				days[(5+day)%7]++;
				day = (months[j] + day)%7;
			}
		}
		out.print(days[6]);
		for(int i = 0; i < 6; i++)	{
			out.print(" " + days[i]);
		}
		out.println("");
		out.close();
		br.close();
	}

}
