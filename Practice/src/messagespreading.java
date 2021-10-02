import java.util.*;
import java.io.*;

public class messagespreading {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("messagespreading.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("messagespreading.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		for(int i = 0; i < n; i++)	{
			st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			out.println(2*h-2);
		}
		out.close();
	}
}
