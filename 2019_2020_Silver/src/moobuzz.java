//December #1
import java.util.*;
import java.io.*;

public class moobuzz {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("moobuzz.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moobuzz.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[] {1, 2, 4, 7, 8, 11, 13, 14};
		int res;
		if(n%8 == 0)	{
			res = 15*(n/8);
		}
		else	{
			res = 15*(n/8) + arr[n%8-1];
		}
		out.println(res);
		out.close();
		br.close();
	}

}
