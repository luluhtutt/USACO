//February 2
import java.util.*;
import java.io.*;

class Node4 {
	int x;
	ArrayList<Integer> y;
	public Node4(int x_) {
		x = x_;
		y = new ArrayList<>();
	}
}
class Node5 {
	int y;
	ArrayList<Integer> x;
	public Node5(int y_) {
		y = y_;
		x = new ArrayList<>();
	}
}
public class triangles {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("triangles.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("triangles.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		Node4[] xNeg = new Node4[1000];
		Node4[] xPos = new Node4[1000];
		Node5[] yNeg = new Node5[1000];
		Node5[] yPos = new Node5[1000];
		
		double total;
		for(int i = 0; i < n; i++)	{
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if(x < 0)	{
				if(xNeg[x] == null)	{
					xNeg[x] = new Node4(x);
				}
				if(xNeg[y].y.size() > 1 && xNeg[x].y.contains(x))	{
					
					for(int y2: xNeg[x].y)	{
						
					}
				}
				xNeg[x].y.add(y);
			}
			if(x >= 0)	{
				if(xPos[x] == null)	{
					xPos[x] = new Node4(x);
				}
				xPos[x].y.add(y);
			}
			if(y < 0)	{
				if(yNeg[y] == null)	{
					yNeg[y] = new Node5(y);
				}
				yNeg[y].x.add(x);
			}
			if(y >= 0)	{
				if(yPos[y] == null)	{
					yPos[y] = new Node5(y);
				}
				yPos[y].x.add(x);
			}
		}
	}

}
