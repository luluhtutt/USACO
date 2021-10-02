//Open 1
import java.util.*;
import java.io.*;

public class buckets {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("buckets.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("buckets.out")));
		
		int bx = 0, by = 0, lx = 0, ly = 0, rx = 0, ry = 0;
		for (int i = 0; i < 10; i++)	{
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
		int distance = 0;
		if (bx == rx && rx == lx) {
			if((by < ry && ry < ly) || (by > ry && ry > ly))	{
				distance = Math.abs(by - ly) + 1;
			}
			else	{
				distance = Math.abs(by-ly) - 1;
			}
		}
		else if (by == ry && ry == ly)	{
			if((bx < rx && rx < lx) || (bx > rx && rx > lx))	{
				distance = Math.abs(bx - lx) + 1;
			}
			else	{
				distance = Math.abs(bx-lx) - 1;
			}
		}
		else	{
			distance = Math.abs(bx - lx) + Math.abs(by - ly) - 1;
		}
		
		out.println(distance);
		br.close();
		out.close();
	}

}