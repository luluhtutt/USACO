//December 3
import java.util.*;
import java.io.*;

class Node {
	int farm;
	char milk;
	int level;
	Node parent;
	ArrayList<Integer> connect;
	public Node(int farm_, char milk_) {
		farm = farm_;
		milk = milk_;
		level = -1;
		parent = null;
		connect = new ArrayList<>();
	}
}
public class milkvisits {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("milkvisits.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Node[] farms = new Node[n+1];
		st = new StringTokenizer(br.readLine());
		String type = st.nextToken();
		for(int i = 1; i <= type.length(); i++)	{
			farms[i] = new Node(i, type.charAt(i-1));
		}
		
		for(int i = 0; i < n-1; i++)	{
			st = new StringTokenizer(br.readLine());
			int f1 = Integer.parseInt(st.nextToken());
			int f2 = Integer.parseInt(st.nextToken());
			farms[f1].connect.add(f2);
			farms[f2].connect.add(f1);
		}
		boolean[] visited = new boolean[n+1];
		visited[1] = true;
		dfs(farms, 1, 0, visited, null);
		
		StringBuilder res = new StringBuilder("");
		for(int i = 0; i < m; i++)	{
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			char c_milk = st.nextToken().charAt(0);
			//System.out.println("start= " + start + " end= " + end + " cmilk= " + c_milk);
			res.append(check_path(farms[start], farms[end], c_milk));
		}
		
		out.println(res);
		out.close();
	}
	public static char check_path(Node p, Node q, char milk) {
		if(p.milk == milk) return '1';
		if(q.milk == milk) return '1';
		if(p.level > q.level)	{
			while(p.level > q.level)	{
				//System.out.println("p=" + p.farm + " p.level=" + p.level);
				//System.out.println("q=" + q.farm + " q.level=" + q.level);
				p = p.parent;
				if(p.milk == milk) return '1';
			}
		} else if(q.level > p.level)	{
			while(q.level > p.level)	{
				q = q.parent;
				if(q.milk == milk) return '1';
			}
		}
		while (p != q) {
			p = p.parent;
			if(p.milk == milk) return '1';
			q = q.parent;
			if(q.milk == milk) return '1';
		}
		return '0';
	}
	public static void dfs(Node[] farms, int c, int level, boolean[] visited, Node parent)	{
		farms[c].level = level;
		farms[c].parent = parent;
		for(int c2: farms[c].connect) { // nbr
			if (visited[c2]) continue;
			visited[c2] = true;
			dfs(farms, c2, level+1, visited, farms[c]);
		}
	}
	
}
