//February 1
import java.io.*;
import java.util.*;

public class teleport2 {
	
	public static void main(String args[]) throws IOException	{
		BufferedReader br = new BufferedReader(new FileReader("teleport.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("teleport.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a, b, x, y;
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		int noTeleport = Math.abs(a-b);
		int teleport = Math.min(Math.abs(a-x) + Math.abs(b-y), Math.abs(a-y) + Math.abs(b-x));
		
		out.println(Math.min(noTeleport, teleport));
		out.close();
	}
}
