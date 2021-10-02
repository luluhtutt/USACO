//February 3
import java.util.*;
import java.io.*;

class Node3 {
	int time;
	int temp;
	ArrayList<Integer> connect;
	public Node3(int time_) {
		time = time_;
		temp = time_;
		connect = new ArrayList<>();
	}
}
public class clocktree {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("clocktree.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("clocktree.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		Node3[] nodes = new Node3[n+1];
		for(int i = 1; i <= n; i++)	{
			nodes[i] = new Node3(Integer.parseInt(st.nextToken()));
		}
		for(int i = 0; i < n-1; i++)	{
			st = new StringTokenizer(br.readLine());
			int c1 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			nodes[c1].connect.add(c2);
			nodes[c2].connect.add(c1);
		}
		int total = 0;
		for(int i = 1; i <= n; i++)	{
			int full = 0;
			System.out.println("i: " + i);
			for(int b = 1; b <= n; b++)	nodes[b].time = nodes[b].temp;
			if(dfs(nodes, i, full) == nodes.length-1) total++;
		}
		out.println(total);
		out.close();
	}
	
	public static int dfs(Node3[] nodes, int c, int full)	{
		System.out.println("c: " + c + " time: " + nodes[c].time + " full: " + full);
		if(full == nodes.length-1 || nodes[c].time == 12) return full;
		nodes[c].time++;
		if(nodes[c].time == 12) full++;
		for(int c2: nodes[c].connect)	{
			dfs(nodes, c2, full);
		}
		return full;
	}

}
