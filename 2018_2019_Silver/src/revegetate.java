//February 2
import java.util.*;
import java.io.*;
class Node	{
	List<Character> t;
	List<Integer> neighbor;
	int color;
	public Node()	{
		t = new ArrayList<>();
		neighbor = new ArrayList<>();
		color = -1;
	}
	public void addEdge(char type, int n)	{
		t.add(type);
		neighbor.add(n);
	}
}
public class revegetate {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("revegetate.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("revegetate.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Node[] nodes = new Node[n+1];
		for(int i = 1; i < n+1; i++)	{
			nodes[i] = new Node();
		}
		for(int i = 0; i < m; i++)	{
			st = new StringTokenizer(br.readLine());
			char t = st.nextToken().charAt(0);
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			nodes[n1].addEdge(t, n2);
			nodes[n2].addEdge(t, n1);
		}
		boolean[] visited = new boolean[n+1];
		Set<Integer> start = new HashSet<>();
		for(int i = 1; i < n+1; i++)	{
			if(!visited[i])	{
				visited[i] = true;
				start.add(i);
				dfs(nodes, visited, i);
			}
		}
		StringBuilder sb = new StringBuilder("");
		for(int i: start)	{
			boolean valid = check(nodes, i, 0);
			if(!valid)	{
				out.println(0);
				out.close();
				return;
			}
			sb.append("0");
		}
		out.println("1" + sb.toString());
		out.close();
	}
	
	public static void dfs(Node[] nodes, boolean[] visited, int i)	{
		for(int j = 0; j < nodes[i].neighbor.size(); j++)	{
			int k = nodes[i].neighbor.get(j);
			if(!visited[k])	{
				visited[k] = true;
				dfs(nodes, visited, k);
			}
		}
	}
	
	public static boolean check(Node[] nodes, int i, int color)	{
		nodes[i].color = color;
		for(int j = 0; j < nodes[i].neighbor.size(); j++)	{
			int k = nodes[i].neighbor.get(j);
			if(nodes[i].t.get(j) == 'S')	{
				if(nodes[k].color == -1)	{
					boolean f = check(nodes, k, color);
					if(!f) return false;
				} else	{
					if(nodes[k].color == color)	{
						continue;
					}
					return false;
				}
			} else	{ // edge type D
				if(nodes[k].color == -1)	{
					boolean f = check(nodes, k, 1-color);
					if(!f) return false;
				} else	{
					if(nodes[k].color == 1-color)	{
						continue;
					}
					return false;
				}
			}
		}
		return true;
	}
}
