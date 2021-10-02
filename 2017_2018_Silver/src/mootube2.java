//January 2
import java.util.*;
import java.io.*;

class Node2 {
	int video;
	Map<Integer, Integer> edge; // key:neighbor video  value:relevance
	int min_rel; // from current src node
	public Node2(int video_) {
		video = video_;
		edge = new HashMap<>();
	}
}
public class mootube2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("mootube.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mootube.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		Node2[] nodes = new Node2[n+1]; // n videos
		for (int k = 1; k <= n; k++) {
			nodes[k] = new Node2(k);
		}
		
		int q = Integer.parseInt(st.nextToken());
		int[] query_k = new int[q];
		Map<Integer, TreeSet<Integer>> src_idx = new HashMap<>();
		
		for(int i = 1; i <= n-1; i++)	{
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int level = Integer.parseInt(st.nextToken());
			nodes[v1].edge.put(v2, level);
			nodes[v2].edge.put(v1, level);
		}
		
		for(int i = 0; i < q; i++)	{
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			query_k[i] = k;
			if (!src_idx.containsKey(start))	{
				src_idx.put(start, new TreeSet<>());
			}
			src_idx.get(start).add(i);
		}
		
		for (int src: src_idx.keySet()) {
			for (int i = 1; i <= n; i++) nodes[i].min_rel = Integer.MAX_VALUE;
			
			boolean[] visited = new boolean[n+1];
			/*
			p.addLast(src);
			visited[src] = true;
			while(p.size() > 0)	{
				int current = p.removeFirst();
				for (int j: nodes[current].edge.keySet()) {
					if (visited[j]) continue;
					visited[j] = true;
					int level = nodes[current].edge.get(j);
					if(level < k) continue;
					
					p.addLast(j);
					c++;
				}
			}
			*/
			out.println();
		}
		out.close();
	}

}
