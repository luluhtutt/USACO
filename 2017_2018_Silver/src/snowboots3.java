//February 2
import java.util.*;
import java.io.*;

public class snowboots3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("snowboots.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("snowboots.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int[] depth = new int[n];
		int[][] boots = new int[b][2];
		boolean[][] states = new boolean[n][b];
		int[][] statesI = new int[n][b];
		for(int i = 0; i < n; i++)	{
			for(int j = 0; j < b; j++)	{
				statesI[i][j] = -1;
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)	{
			depth[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int j = 0; j < b; j++)	{
			st = new StringTokenizer(br.readLine());
			boots[j][0] = Integer.parseInt(st.nextToken()); // depth
			boots[j][1] = Integer.parseInt(st.nextToken()); // step size
		}
		br.close();
		
		for (int j = 0; j < b; j++) { // col j
			states[0][j] = true;
			statesI[0][j] = 0;
		}
		
		int result = -1;
		for (int k = 1; k <= n-2; k++) { // row k, tile k
			int last_k = statesI[k-1][0];
			if (depth[k] <= boots[0][0]) {
				if (k - last_k <= boots[0][1]) { // can reach here by boot 0
					states[k][0] = true;
					statesI[k][0] = k;
					if (k + boots[0][1] >= n-1) {
						result = 0;
						break;
					}
				} else { // cannot reach here
					statesI[k][0] = last_k;
				}
			} else { //cannot change boot here
				statesI[k][0] = last_k;
			}
		}
		if(result == 0)	{
			out.println(0);
			out.close();
			return;
		}
		
		for (int j = 1; j < b; j++) { // col j
			for (int k = 1; k <= n-2; k++) { // row k, tile k
				int last_k = statesI[k-1][j];
				if(depth[k] > boots[j][0])	{
					statesI[k][j] = last_k;
					continue;
				}
				// can change boot
				if(k - last_k <= boots[j][1])	{ // can reach here by boot j
					states[k][j] = true;
					statesI[k][j] = k;
					if(k + boots[j][1] >= n-1)	{
						result = j;
						out.println(result);
						out.close();
						return;
					}
					continue;
				} else	{ // cannot reach here by previous cells in column j
					statesI[k][j] = last_k;
				}
				
				// check the same row from left cells
				for(int i = 0; i < j; i++)	{ // boot i, column i
					if(states[k][i] ||
							(depth[statesI[k][i]] <= boots[j][0] &&
							k-statesI[k][i] <= boots[j][1]))	{ // can make it
						states[k][j] = true;
						statesI[k][j] = k;
						if(k + boots[j][1] >= n-1)	{
							result = j;
							out.println(result);
							out.close();
							return;
						}
					}
				}
			}
		}
	}
}