//December 3
import java.util.*;
import java.io.*;

public class backforth_1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("backforth.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("backforth.out")));
		int[] first  = new int[31];
		int[] second = new int[31];
		int n1 = 10;
		int n2 = 10;
		int stor1 = 1000;
		int stor2 = 1000;
		int[] check = new int[2000];
		int counter = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 10; i++)	{
			first[i] = Integer.parseInt(st.nextToken());
		}
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int i = 0; i < 10; i++)	{
			second[i] = Integer.parseInt(st2.nextToken());
		}
		
		for(int i = 0; i < n1; i++)	{ //Tue
			int b = first[i];
			if (b == 0) continue;
			first[i] = 0;
			stor1 -= b;
			stor2 += b;
			second[n2] = b;
			n2++;
			for(int k = 0; k < n2; k++)	{ //Wed
				int b3 = second[k];
				if(b3 == 0) continue;
				second[k] = 0;
				stor1 += b3;
				stor2 -= b3;
				int n3 = n1;
				first[n3] = b3;
				n3++;
				for(int h = 0; h < n3; h++)	{ //Thurs
					int b4 = first[h];
					if(b4 == 0) continue;
					first[h] = 0;
					stor1 -= b4;
					stor2 += b4;
					int n4 = n2;
					second[n4] = b4;
					n4++;
					for(int v = 0; v < n4; v++)	{//Fri
						int b5 = second[v];
						if(b5 == 0) continue;
						second[v] = 0;
						stor1 += b5;
						stor2 -= b5;
						check[stor1] = 1;
						stor2 += b5;
						stor1 -= b5;
					}
					stor1 += b4;
					stor2 -= b4;
				}
				stor1 -= b3;
				stor2 += b3;
			}
			stor1 += b;
			stor2 -= b;
		}
		
		for(int i = 0; i < 2000; i++)	{
			if(check[i] == 1)	{
				System.out.println(i);
				counter++;
			}
		}
		out.println(counter);
		out.close();
		br.close();
	}

}
