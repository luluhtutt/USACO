//Open 1
import java.util.*;
import java.io.*;

public class buckets2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("buckets.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("buckets.out")));
		
		int bx = 0, by = 0, lx = 0, ly = 0, rx = 0, ry = 0;
		for(int i = 0; i < 10; i++)	{
			StringTokenizer st = new StringTokenizer(br.readLine());
			String line = st.nextToken();
			for (int j = 0; j < 10; j++) {
				if(line.charAt(j) == 'B')	{
					bx = j;
					by = i;
				}
				if(line.charAt(j) == 'R')	{
					rx = j;
					ry = i;
				}
				if(line.charAt(j) == 'L')	{
					lx = j;
					ly = i;
				}
			}
		}
		
		if(bx == rx && rx == lx)	{
			if((ry < by && ry > ly) || (ry > by && ry < ly))	{
				out.println(Math.abs(ly-by) + 1);
				out.close();
			} else	{
				out.println(Math.abs(ly-by)-1);
				out.close();
			}
		} else if(by == ry && ry == ly)	{
			if((rx < bx && rx > lx) || (rx > bx && rx < lx))	{
				out.println(Math.abs(lx-bx) + 1);
				out.close();
			} else	{
				out.println(Math.abs(lx-bx)-1);
				out.close();
			}
		} else	{
			out.println(Math.abs(lx-bx) + Math.abs(ly-by)-1);
		}
		br.close();
		out.close();
	}

}