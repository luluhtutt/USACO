//February 2
import java.util.*;
import java.io.*;

public class triangles2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("triangles.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("triangles.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		Hashtable<Integer, Integer> x_y = new Hashtable<>();
		Hashtable<Integer, Integer> y_x = new Hashtable<>();
		for(int i = 0; i < n; i++)	{
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			x_y.put(x, y);
			y_x.put(y, x);
		}
	}

}
