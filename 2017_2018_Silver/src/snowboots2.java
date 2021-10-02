//February 2
import java.util.*;
import java.io.*;

public class snowboots2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("snowboots.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("snowboots.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int[] depth = new int[n];
		int[][] boots = new int[b][2];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)	{
			depth[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < b; i++)	{
			st = new StringTokenizer(br.readLine());
			boots[i][0] = Integer.parseInt(st.nextToken());
			boots[i][1] = Integer.parseInt(st.nextToken());
		}
		int res = dfs(0, 0, boots, depth);
		out.println(res);
		out.close();
		br.close();
	}
	
	public static int dfs(int l, int index, int[][] boots, int[] depth)	{
		//System.out.println("L : " + l + " index: " + index);
		if(l == depth.length-1) return index-1;
		int latest = l;
		while(l < depth.length && l <= latest + boots[index][1])	{
			//System.out.println("cStep: " + cStep + " cDepth: " + depths[cStep] + " latest: " + latest + " end: " + (latest + s));
			if(depth[l] <= boots[index][0])	{
				latest = l;
			}
			l++;
		}
		l = latest;
		return dfs(l, index+1, boots, depth);
	}
}
