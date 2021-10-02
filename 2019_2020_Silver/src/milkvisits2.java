//December 3
import java.util.*;
import java.io.*;

class Node2 {
	int farm;
	char milk;
	int level;
	int component;
	Node2 parent;
	ArrayList<Integer> connect;
	public Node2(int farm_, char milk_) {
		farm = farm_;
		milk = milk_;
		level = -1;
		parent = null;
		connect = new ArrayList<>();
	}
}
public class milkvisits2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("milkvisits.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Node2[] farms = new Node2[n+1];
		st = new StringTokenizer(br.readLine());
		String type = st.nextToken();
		for(int i = 1; i <= type.length(); i++)	{
			farms[i] = new Node2(i, type.charAt(i-1));
		}
		
		for(int i = 0; i < n-1; i++)	{
			st = new StringTokenizer(br.readLine());
			int f1 = Integer.parseInt(st.nextToken());
			int f2 = Integer.parseInt(st.nextToken());
			farms[f1].connect.add(f2);
			farms[f2].connect.add(f1);
		}
		// boolean[] visited = new boolean[n+1];
		// visited[1] = true;
		// dfs(farms, 1, 0, visited, null);
		// visited = new boolean[n+1];
		component(farms, 1, farms[1]);
		StringBuilder res = new StringBuilder("");
		for(int i = 0; i < m; i++)	{
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			char c_milk = st.nextToken().charAt(0);
			if(farms[start].component == farms[end].component && c_milk != farms[start].milk)	{
				res.append('0');
			} else	{
				res.append('1');
			}
		}
		
		out.println(res);
		out.close();
	}
	
	public static void component(Node2[] farms, int current, Node2 parent)	{
		if(farms[current].milk == parent.milk)	{
			farms[current].component = parent.component;
		} else	{
			farms[current].component = farms[current].farm;
		}
		
		for(int c2: farms[current].connect)	{
			if(c2 == parent.farm) continue;
			component(farms, c2, farms[current]);
		}
	}
	/*
	public static void dfs(Node2[] farms, int c, int level, boolean[] visited, Node2 parent)	{
		farms[c].level = level;
		farms[c].parent = parent;
		for(int c2: farms[c].connect) { // nbr
			if (visited[c2]) continue;
			visited[c2] = true;
			dfs(farms, c2, level+1, visited, farms[c]);
		}
	}
	*/
}
