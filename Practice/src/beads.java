/*
ID: luluhtu1
LANG: JAVA
TASK: beads
*/
import java.util.*;
import java.io.*;

public class beads {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("beads.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		String necklace = st2.nextToken();
		
		int max = 0;
		for(int i = 0; i < n; i++)	{
			String s1 = necklace.substring(0, i);
			String s2 = necklace.substring(i);
			String fin = s2 + s1;
			int temp = checkForwards(fin);
			if(temp > max)	{
				max = temp;
			}
		}
		out.println(max);
		out.close();
		br.close();

	}
	
	public static int checkForwards(String s)	{
		int index = 0;
		char set = s.charAt(0);
		for(int i = 0; i < s.length(); i++)	{
			if(s.charAt(i) == 'b')	{
				set = 'b';
				break;
			}
			else if(s.charAt(i) == 'r')	{
				set = 'r';
				break;
			}
		}
		int count = 0;
		boolean check = true;
		for(int i = 0; i < s.length(); i++)	{
			if(s.charAt(i) == set || s.charAt(i) == 'w')	{
				count++;
			}
			else	{
				index = i;
				check = false;
				break;
			}
		}
		if(check)	{
			return s.length();
		}
		
		char set2 = s.charAt(s.length()-1);
		for(int i = s.length()-1; i >= 0; i--)	{
			if(s.charAt(i) == 'b')	{
				set2 = 'b';
				break;
			}
			else if(s.charAt(i) == 'r')	{
				set2 = 'r';
				break;
			}
		}
		int count2 = 0;
		for(int i = s.length()-1; i >= index; i--)	{
			if(s.charAt(i) == set2 || s.charAt(i) == 'w')	{
				count2++;
			}
			else	{
				break;
			}
		}
		return count + count2;
	}

}
