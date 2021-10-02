//January 1
import java.util.*;
import java.io.*;

public class billboard {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("billboard.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("billboard.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int lx1 = Integer.parseInt(st.nextToken());
		int ly1 = Integer.parseInt(st.nextToken());
		int lx2 = Integer.parseInt(st.nextToken());
		int ly2 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int fx1 = Integer.parseInt(st.nextToken());
		int fy1 = Integer.parseInt(st.nextToken());
		int fx2 = Integer.parseInt(st.nextToken());
		int fy2 = Integer.parseInt(st.nextToken());
		
		int overlapCount = 0;
		if(overlap(lx1, ly1, fx1, fx2, fy1, fy2)) overlapCount++;
		if(overlap(lx1, ly2, fx1, fx2, fy1, fy2)) overlapCount++;
		if(overlap(lx2, ly1, fx1, fx2, fy1, fy2)) overlapCount++;
		if(overlap(lx2, ly2, fx1, fx2, fy1, fy2)) overlapCount++;
		
		if(overlapCount == 1 || overlapCount == 0)	{
			out.println(Math.abs(lx1-lx2) * Math.abs(ly1-ly2));
			out.close();
		}
		else if(overlapCount == 4) {
			out.println(0);
			out.close();
		}
		else	{
			if(overlap(lx1, ly1, fx1, fx2, fy1, fy2) && overlap(lx1, ly2, fx1, fx2, fy1, fy2))	{
				out.println(Math.abs(lx2-fx2) * Math.abs(ly1-ly2));
				out.close();
			}
			if(overlap(lx1, ly1, fx1, fx2, fy1, fy2) && overlap(lx2, ly1, fx1, fx2, fy1, fy2))	{
				out.println(Math.abs(lx1-lx2) * Math.abs(ly2-fy2));
				out.close();
			}
			if(overlap(lx1, ly2, fx1, fx2, fy1, fy2) && overlap(lx2, ly2, fx1, fx2, fy1, fy2))	{
				out.println(Math.abs(lx1-lx2) * Math.abs(fy1-ly1));
				out.close();
			}
			if(overlap(lx2, ly2, fx1, fx2, fy1, fy2) && overlap(lx2, ly1, fx1, fx2, fy1, fy2))	{
				out.println(Math.abs(lx1-fx1) * Math.abs(ly1-ly2));
				out.close();
			}
		}
	}
	
	public static boolean overlap(int x, int y, int x1, int x2, int y1, int y2)	{
		if((x <= x1 && x >= x2) || (x >= x1 && x <= x2))	{
			if((y <= y1 && y >= y2) || (y >= y1 && y <= y2))	{
				return true;
			}
		}
		return false;
	}

}
