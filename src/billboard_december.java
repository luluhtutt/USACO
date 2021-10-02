//December 1
import java.util.*;
import java.io.*;

public class billboard_december {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("billboard.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("billboard.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int firstx1 = Integer.parseInt(st.nextToken()) + 1000;
		int firsty1 = Integer.parseInt(st.nextToken()) + 1000;
		int firstx2 = Integer.parseInt(st.nextToken()) + 1000;
		int firsty2 = Integer.parseInt(st.nextToken()) + 1000;
		st = new StringTokenizer(br.readLine());
		int secondx1 = Integer.parseInt(st.nextToken()) + 1000;
		int secondy1 =Integer.parseInt(st.nextToken()) + 1000;
		int secondx2 = Integer.parseInt(st.nextToken()) + 1000;
		int secondy2 = Integer.parseInt(st.nextToken()) + 1000;
		st = new StringTokenizer(br.readLine());
		int frontx1 = Integer.parseInt(st.nextToken()) + 1000;
		int fronty1 =Integer.parseInt(st.nextToken()) + 1000;
		int frontx2 = Integer.parseInt(st.nextToken()) + 1000;
		int fronty2 = Integer.parseInt(st.nextToken()) + 1000;
		
		int area = Math.abs(firstx1-firstx2) * Math.abs(firsty1-firsty2) + Math.abs(secondx1-secondx2) * Math.abs(secondy1-secondy2);
		int[][] arr = new int[2000][2000];
		int counter = 0;
		//System.out.println("first: ");
		for(int i = firstx1; i < firstx2; i++)	{
			for(int j = firsty1; j < firsty2; j++)	{
				arr[i][j] = 1;
				//System.out.println(i + " " + j);
			}
		}
		//System.out.println("second: ");
		for(int i = secondx1; i < secondx2; i++)	{
			for(int j = secondy1; j < secondy2; j++)	{
				arr[i][j] = 1;
				//System.out.println(i + " " + j);
			}
		}
		//System.out.println("end: ");
		for(int i = frontx1; i < frontx2; i++)	{
			for(int j = fronty1; j < fronty2; j++)	{
				//System.out.println(i + " " + j);
				if(arr[i][j] == 1)	{
					//System.out.print("both: " + i + " " + j);
					counter++;
				}
			}
		}
		out.println(area-counter);
		out.close();
		
	}

}
