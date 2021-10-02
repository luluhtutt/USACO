//Open 2
import java.util.*;
import java.io.*;

class factory2 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("factory.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("factory.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		boolean[] list = new boolean[n+1];
		ArrayList<Integer> solutions = new ArrayList<Integer>();
		
		for (int h = 1; h <= n; h++)	{
			list[h] = true;
		}
		for (int i = 1; i <= n-1; i++)	{
			StringTokenizer str = new StringTokenizer(br.readLine());
			int index = Integer.parseInt(str.nextToken());
			int element = Integer.parseInt(str.nextToken());
			list[index] = false;
		}
		for (int k = 1; k <= n; k++)	{
			if(list[k] == true)	{
				solutions.add(k);
			}
		}
		
		if(solutions.size() == 1)	{
			out.println(solutions.get(0));
		}
		else	{
			out.println(-1);
		}
		
		out.close();
	}

}
