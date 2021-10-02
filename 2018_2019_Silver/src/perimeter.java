//January 2
import java.util.*;
import java.io.*;

public class perimeter {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("perimeter.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("perimeter.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		char[][] ice = new char[n][n];
		boolean[][] visited = new boolean[n][n];
		List<int[]> component = new ArrayList<>();
		
		for(int i = 0; i < n; i++)	{
			st = new StringTokenizer(br.readLine());
			String current = st.nextToken();
			for(int j = 0; j < n; j++)	{
				ice[i][j] = current.charAt(j);
			}
		}
		
		int[] dx = new int[] {-1, 1, 0, 0};
		int[] dy = new int[] {0, 0, -1, 1};
		for (int k = 0; k < n; k++) { // row k
			for (int j = 0; j < n; j++) { // col j
				if (ice[k][j] == '#' && !visited[k][j]) { // to explore a connected component by BFS
					Deque<int[]> p = new LinkedList<>();
					int area = 0;
					int perimeter = 0;
					p.addLast(new int[] {k,j});
					visited[k][j] = true;
					while(p.size() > 0) {
						int[] loc = p.removeFirst();
						int y = loc[0]; // row
						int x = loc[1]; // col
						area++;
						perimeter += calc_peri(ice, n, y, x, dy, dx);
						for (int i = 0; i < 4; i++) {
							int k2 = y + dy[i];
							int j2 = x + dx[i];
							if (is_valid(n, k2, j2) && ice[k2][j2] == '#' && !visited[k2][j2])	{
								visited[k2][j2] = true;
								p.addLast(new int[] {k2, j2});
							}
						}
					}
					component.add(new int[] {area, perimeter});
				}
			}
		}
		
		int maxArea = 0;
		int minPerimeter = 0;
		for(int i = 0; i < component.size(); i++)	{
			int[] current = component.get(i);
			if(current[0] > maxArea) {
				maxArea = current[0];
				minPerimeter = current[1];
			} else if(current[0] == maxArea)	{
				minPerimeter = Math.min(current[1], minPerimeter);
			}
		}
		
		out.println(maxArea + " " + minPerimeter);
		out.close();
	}
	
	public static int calc_peri(char[][] ice, int n, int y, int x, int[] dy, int[] dx)	{
		int p = 0;
		for(int i = 0; i < 4; i++)	{
			int y2 = y + dy[i];
			int x2 = x + dx[i];
			if(!is_valid(n, y2, x2)) p++;
			else if(ice[y2][x2] == '.') p++;
		}
		return p;
	}
	
	public static boolean is_valid(int n, int y, int x)	{
		if(x < 0 || x > n-1 || y < 0 || y > n-1) return false;
		return true;
	}

}
