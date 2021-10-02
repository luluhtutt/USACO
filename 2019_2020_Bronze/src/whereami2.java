//December 2
import java.util.*;
import java.io.*;

public class whereami2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("whereami.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("whereami.out")));
		
		StringTokenizer a = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(a.nextToken());
		
		StringTokenizer b = new StringTokenizer(br.readLine());
		String mailbox = b.nextToken();
		
		
		for(int i = 0; i < mailbox.length(); i++)	{
			boolean c = check_available(mailbox, i);
			if(!c)	{
				out.println(i);
				break;
			}
		}
		out.close();
		br.close();
	}
	
	public static boolean check_available(String s, int length)	{
		for(int i = 0; i < s.length()-length; i++)	{
			String cur = s.substring(i, i+length);
			String rest = s.substring(i+1);
			if(rest.indexOf(cur) != -1)	{
				return true;
			}
		}
		return false;
	}
}
