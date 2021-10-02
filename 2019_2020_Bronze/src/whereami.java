//December 2
import java.util.*;
import java.io.*;

public class whereami {

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
			String rest = s.substring(i+length);
			if(rest.indexOf(cur) != -1 || repeat(s, cur))	{
				return true;
			}
		}
		return false;
	}
	
	public static boolean repeat(String input, String sub)	{
		int index = input.indexOf(sub);
		int count = 0;
		while (index != -1) {
		    count++;
		    input = input.substring(index + 1);
		    index = input.indexOf(sub);
		}
		if(count > 1)	{
			return true;
		}
		return false;
	}

}
