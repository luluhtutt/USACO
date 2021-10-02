//January 2
import java.io.*;
import java.util.*;

public class photo {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("photo.in"));

		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("photo.out")));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());

		int[] b = new int[n-1];
		int[] a = new int[n];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n-1; i++)	{
			b[i] = Integer.parseInt(st.nextToken());
		}

		for(int i = 1; i <= b[0]; i++)	{
			fill(a, b, i);
			if(checknegative(a) && checkrepeat(a))	{
				for(int h = 0; h < a.length-1; h++)	{
					out.print(a[h] + " ");
				}
				out.println(a[a.length-1]);
				break;
			}
		}
		out.close();
	}

	public static void fill(int[] a, int[] b, int n)	{
		a[0] = n;
		for(int i = 0; i < b.length; i++)	{
			a[i+1] = b[i] - a[i];
		}
	}

	public static boolean checknegative(int[] a)	{
		for(int i = 0; i < a.length; i++)	{
			if(a[i] <= 0)	{
				return false;
			}
		}
		return true;
	}
	public static boolean checkrepeat(int[] a)	{
		ArrayList<Integer> past = new ArrayList<Integer>();
		for(int i = 0; i < a.length; i++)	{
			if(past.contains(a[i]))	{
				return false;
			}
			past.add(a[i]);
		}
		return true;
	}

}
