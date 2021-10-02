//February 1
import java.util.*;
import java.io.*;
public class herding2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("herding.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("herding.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] location = new int[3];
		location[0] = Integer.parseInt(st.nextToken());
		location[1] = Integer.parseInt(st.nextToken());
		location[2] = Integer.parseInt(st.nextToken());
		Arrays.sort(location);
		int a = location[0];
		int b = location[1];
		int c = location[2];
		
		if(c-a == 2)	{
			out.println(0);
		} else if(c-a == 3)	{
			out.println(1);
		}
		else	{
			out.println(2);
		}
		
		out.println(Math.max(c-b, b-a)+1);
		out.close();
	}

}
